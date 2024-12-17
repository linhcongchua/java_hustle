package java_core.io.filehandle;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static HikariDataSource ds;

    static {
        final HikariConfig config = new HikariConfig();

        config.setJdbcUrl( "jdbc:postgresql://localhost:5432/hallo" );
        config.setUsername( "admin" );
        config.setPassword( "admin" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );

        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
