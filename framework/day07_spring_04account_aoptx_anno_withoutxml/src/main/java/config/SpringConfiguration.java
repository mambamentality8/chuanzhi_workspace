package config;

import org.springframework.context.annotation.*;

/**
 * Spring的配置类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Configuration
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
