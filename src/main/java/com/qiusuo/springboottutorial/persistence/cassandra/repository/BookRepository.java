package com.qiusuo.springboottutorial.persistence.cassandra.repository;

import com.qiusuo.springboottutorial.persistence.cassandra.model.Book;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MapIdCassandraRepository<Book> {

}
