package com.grateful.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

/**
 * springboot的入口配置类，该配置类会自动扫描并注
 * 册该类包路径以及以下子包路径下的被@Configuration注解注解的类中的@bean注解的bean对象；
 *
 * 切记：入口配置类放在所有java类包的最上面
 */
@MapperScan("com.grateful.demo.content.mapper")//扫描指定包下被@Mapper注解注解的mapper接口，并注入到spring上下文中
@RestController //这里是多余的
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 输入http://locaohost:8083/a/index就能跳转到index.html页面
     * 输入http://locaohost:8083/a/也能跳转到index.html页面，这是springboot默认的欢迎页访问方式
     * @return
     */
    @GetMapping("/index")
    public String home(){
        return "index";
    }


    // 指定使用Druid数据源,否则使用默认的jdbc的HikariCP connection pool
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    // 指定数据源的前缀,在application.properties文件中指定
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
