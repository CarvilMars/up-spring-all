package com.up.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.up.jdbc.bean.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author songdaxin
 * Filter和Servlet可以
 */
@Configuration
@ServletComponentScan
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:druid.yml")
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

//    /**
//     * 加载YML格式自定义配置文件
//     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        //File引入
//        yaml.setResources(new ClassPathResource("druid.yml"));
//        configurer.setProperties(Objects.requireNonNull(yaml.getObject()));
//        return configurer;
//    }

//    @Bean
//    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
//        //创建servlet注册实体
//        ServletRegistrationBean<StatViewServlet> servletRegistrationBean =
//                new ServletRegistrationBean<>(new StatViewServlet(), "/druid" +
//                        "/*");
//        //设置ip白名单,多个用逗号分隔
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        //设置ip黑名单，黑名单优于白名单
//        servletRegistrationBean.addInitParameter("deny", "192.168.0.2");
//        //设置控制台管理用户__登录用户名和密码
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//
//    @Bean
//    public FilterRegistrationBean<WebStatFilter> statFilter() {
//        //创建过滤器
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
