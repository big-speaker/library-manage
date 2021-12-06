package com.guocanjie.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guocanjie.domain.Book;
import com.guocanjie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

//    查询全部，GetMapping表示GET请求
    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

//    根据id查询数据 ，PathVariable表示参数id为路径参数
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

//    PostMapping表示post请求，RequestBody表示请求体参数，json格式
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

//    PutMapping表示PUT请求
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.update(book);
    }

//    DeleteMapping表示DELETE请求
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

//    分页查询
    @GetMapping("/{current}/{size}")
    public IPage<Book> getPage(@PathVariable int current, @PathVariable int size){
        return bookService.getPage(current, size);
    }

}
