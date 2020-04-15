package com.qiusuo.springboottutorial;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;
import com.qiusuo.springboottutorial.persistence.cassandra.model.Book;
import com.qiusuo.springboottutorial.persistence.cassandra.repository.BookRepository;
import com.qiusuo.springboottutorial.persistence.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.mapping.BasicMapId;
import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class SpringboottutorialApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecord() {

        Book javaBook = new Book(
                UUIDs.timeBased(), "Head First Java",
                ImmutableSet.of("Computer", "Software"));


        bookRepository.insert(javaBook);

        List<Book> books = bookService.getBooks();
        assertEquals(books.size(), 4);
    }

    @Test
    public void findBookReturnsOneWhenIdCorrect(){
        MapId mapId = BasicMapId.id("id","d6ac5e50-7e77-11ea-a5bb-a59b5734f87d").with("publisher","Head First Java");
        MapId[] ids = new MapId[]{mapId};

        Optional<Book> javaBook = bookRepository.findById(mapId);

        assertTrue(javaBook.isPresent());
    }
    @Test
    void contextLoads() {
    }

}
