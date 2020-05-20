package springbootcassandra.persistence.cassandra.repository;

import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;
import springbootcassandra.persistence.cassandra.model.Book;

@Repository
public interface BookRepository extends MapIdCassandraRepository<Book> {

}
