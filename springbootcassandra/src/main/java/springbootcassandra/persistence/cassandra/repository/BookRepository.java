package springbootcassandra.persistence.cassandra.repository;

import springbootcassandra.persistence.cassandra.model.Book;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MapIdCassandraRepository<Book> {

}
