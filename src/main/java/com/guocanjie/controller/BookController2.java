package com.guocanjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guocanjie.domain.Book;
import com.guocanjie.service.BookService;
import com.guocanjie.utils.Result;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private BookService bookService;

    //    查询全部，GetMapping表示GET请求
    @GetMapping
    public Result getAll(){
        return new Result(true,bookService.getAll());
    }

    //    根据id查询数据 ，PathVariable表示参数id为路径参数
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true, bookService.getById(id));
    }

    //    PostMapping表示post请求，RequestBody表示请求体参数，json格式
    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {

//        如果name=123抛出异常，执行ProjectExceptionAdvicw类中的异常方法
        if(book.getName().equals("123")) throw new IOException();
        Boolean flag = bookService.save(book);
        return new Result(flag, "添加成功^_^");
    }

    //    PutMapping表示PUT请求
    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(true,bookService.update(book));
    }

    //    DeleteMapping表示DELETE请求
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(true,bookService.delete(id));
    }

    //    分页查询+条件查询
//    传入参数时，不需要注解，路径参数和请求体参数需要注解，get参数不需要注解
    @GetMapping("/{current}/{size}")
    public Result getPage(@PathVariable int current, @PathVariable int size, Book book){
        System.out.println("参数"+book);
        IPage<Book> page = bookService.getPage(current, size, book);
//        如果查询的当前页码值大于最大页码值，重新查询，并将当前页码值改为最大页码值
        if(current > page.getPages()){
            page = bookService.getPage((int) page.getPages(), size, book);
        }
        return new Result(true, page);
    }

}
