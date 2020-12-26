package springbootcassandra.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig  extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "qiusuo_dev_test";
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    /**
     * On Production System, we need at least two nodes for the running of cassandra
     * server.
     * server.
     * @return
     */
    @Override
    public String getLocalDataCenter() {
        return "datacenter1";
    }

    @Override
    protected List<String> getStartupScripts() {
        final String script =
                "CREATE KEYSPACE IF NOT EXISTS "
                        + "qiusuo_dev_test"
                        + " WITH durable_writes = true"
                        + " AND replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};";
        ArrayList<String> str = new ArrayList<>();
        str.add(script);
        return str;
    }

}
