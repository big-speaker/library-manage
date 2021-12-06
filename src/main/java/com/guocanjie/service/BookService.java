package com.guocanjie.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guocanjie.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
//    分页查询
    IPage<Book> getPage(Integer current, Integer size);
//    条件查询
    IPage<Book> getPage(Integer current, Integer size, Book book);
}
