package todolist.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionUtil {
    private static HikariDataSource hikariDataSource;


    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");
        config.setJdbcUrl("jdbc:myslq//localhost:3306/todolist_db?serverTimezone=Asia/Jakarta");

        // setup database pooling
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}
