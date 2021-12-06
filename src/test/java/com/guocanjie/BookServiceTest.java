package com.guocanjie;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guocanjie.dao.BookDao;
import com.guocanjie.domain.Book;
import com.guocanjie.service.BookService;
import com.guocanjie.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;


    @Test
    void testGetById(){
        System.out.println("查询结果" +bookService.getById(2));
    }

    @Test
    void testSave(){
        Book book1 = new Book();
        book1.setName("测试123");
        book1.setType("测试123");
        book1.setDescirption("测试123");
        System.out.println("保存测试" + bookService.save(book1));

    }

    @Test
    void testUpdate(){
        Book book1 = new Book();
        book1.setId(15);
        book1.setName("测试123");
        book1.setType("测试123");
        book1.setDescirption("测试123");
        System.out.println("更新结果"+bookService.update(book1));
    }

    @Test
    void testDelete(){
        System.out.println("删除结果" + bookService.delete(15));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }

    //    分页查询
//    @Test
//    void testGetPage(){
//        IPage page = bookService.getPage(1, 5);
//        System.out.println(page);
////        这是第几页
//        System.out.println(page.getCurrent());
////        一共有几页
//        System.out.println(page.getPages());
////        这一页的数据
//        System.out.println(page.getSize());
////        数据总数
//        System.out.println(page.getTotal());
////        查询结果
//        System.out.println(page.getRecords());
//    }

    //    条件查询
    @Test
    void testGetBy(){
    }
}
