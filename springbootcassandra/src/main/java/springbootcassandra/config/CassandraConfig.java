package springbootcassandra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;


@Configuration
@EnableCassandraRepositories
public class CassandraConfig  extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "qiusuo_dev";
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = super.cluster();

        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.qiusuo.springbootcassandra.springbootcassandra.persistence"};
    }

    @Override
    protected List<String> getStartupScripts() {
        final String script =
                "CREATE KEYSPACE IF NOT EXISTS "
                        + "qiusuo_dev_test"
                        + " WITH durable_writes = true"
                        + " AND replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};";
        return List.of(script);
    }

}
