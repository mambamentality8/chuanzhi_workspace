package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SPRING的配置类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,TransactionManagerConfig.class})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement//开启注解支持
public class SpringConfiguration {
}
