package com.guocanjie;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guocanjie.dao.BookDao;
import com.guocanjie.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave(){
        Book book1 = new Book();
        book1.setName("测试123");
        book1.setType("测试123");
        book1.setDescirption("测试123");
        bookDao.insert(book1);

    }

    @Test
    void testUpdate(){
        Book book1 = new Book();
        book1.setId(15);
        book1.setName("测试123");
        book1.setType("测试123");
        book1.setDescirption("测试123");
        bookDao.updateById(book1);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(41);
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

//    分页查询
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page, null);
//        这是第几页
        System.out.println(page.getCurrent());
//        一共有几页
        System.out.println(page.getPages());
//        这一页的数据
        System.out.println(page.getSize());
//        数据总数
        System.out.println(page.getTotal());
//        查询结果
        System.out.println(page.getRecords());
    }

//    条件查询
    @Test
    void testGetBy(){
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }
}
