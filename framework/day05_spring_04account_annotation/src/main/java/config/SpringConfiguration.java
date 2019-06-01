package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring的配置类，它的作用就相当于bean.xml
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *===============================================================================
 * @Bean:
 *    作用：把当前方法的返回值放入spring的ioc容器
 *    属性：
 *      name：用于指定bean的id。默认值是当前方法名称。它和value属性的作用是一样的
 * @ComponentScan
 *     作用：用于指定要扫描的包
 *     属性：
 *      value：用于指定要扫描的包。和basePackages的作用相同。
 * @Configuration
 *     作用：表明当前类是spring的一个配置类。
 *          如果该类作为字节码参数传给了AnnotationConfigApplicationContext，则不用写此注解
 * @Import
 *     作用：导入其他的配置类
 *     属性：
 *      value：用于指定要导入类的字节码
 * @PropertyResource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：用于指定properties文件的位置
 */
@Configuration
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
