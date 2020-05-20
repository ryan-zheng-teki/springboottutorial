package springbootcassandra.persistence.cassandra.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table
public class Book {

    @CassandraType(type = DataType.Name.TIMEUUID)
    @PrimaryKeyColumn(
            name = "isbn",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,

            ordering = Ordering.DESCENDING)
    private UUID id;

    @PrimaryKeyColumn(name = "title", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String publisher;

    @Column
    private Set<String> tags;

    public  Book(UUID id, String publisher, Set<String> tags) {
        this.id = id;
        this.publisher = publisher;
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
