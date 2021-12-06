package com.guocanjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guocanjie.dao.BookDao;
import com.guocanjie.domain.Book;
import com.guocanjie.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }


    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size) {
        IPage page = new Page(current,size);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
//        lqw.like(false, Book::getId,book.getId());
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescirption()), Book::getDescirption,book.getDescirption());
        IPage page = new Page(current,size);
        bookDao.selectPage(page,lqw);
        return page;
    }
}
