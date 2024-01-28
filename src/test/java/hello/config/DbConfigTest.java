package hello.config;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DbConfigTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void checkBean() {
        log.info("data source = {}", dataSource);
        log.info("transaction manager = {}", transactionManager);
        log.info("jdbc template = {}", jdbcTemplate);

        Assertions.assertThat(dataSource).isNotNull();
        Assertions.assertThat(transactionManager).isNotNull();
        Assertions.assertThat(jdbcTemplate).isNotNull();
    }

}