package com.fursys.demo.service;

import com.fursys.demo.domain.item.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        // given
//        Book book = em.find(Book.class, 1l);

        // 변경 감지 == dirty checking
//        book.setName("asdfewf");
        // when
        String goodName = "FABRIC STORAGE BOX ,(2ea) 외 3개";
        String goodsName = "FABRIC STORAGE BOX ,(2ea) 외 3개jkljlk";

        String substr = goodsName.substring(0, 30);

        // then
        assertEquals(30, substr.length());
        assertEquals(goodName, substr);
    }
}
