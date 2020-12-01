package com.up.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author songdaxin
 */
@Configuration
@PropertySource(value={"classpath:druid.yml"})
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控
     *
     * @return {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statServletRegistration() {
        ServletRegistrationBean<StatViewServlet> statViewServletBean = new ServletRegistrationBean<>(new StatViewServlet());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("loginUserName", "admin");
        initParam.put("loginPassword", "123456");
        // 白名单
        initParam.put("allow", "172.17.1.28");
        // IP黑名单 (存在共同时，deny优先于allow)
        initParam.put("deny", "172.17.1.29");
        initParam.put("resetEnable", "172.17.1.29");
        statViewServletBean.setInitParameters(initParam);
        return statViewServletBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParam);
        return filterRegistrationBean;
    }
}
