package com.cristina.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description druid数据源相关配置
 * @author: Yu.Guo
 * @create: 2020-07-25 16:31
 **/
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Description("创建一个数据源绑定在容器中")
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控
     * 1.配置一个管理后台的servlet,处理进入管理后台的请求。
     */
    @Bean
    public ServletRegistrationBean staViewServlet() {

        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");    /*登录后台时用的用户名*/
        initParams.put("loginPassword", "admin");    /*登录后台时用的密码*/
        initParams.put("allow", "localhost");        /*允许谁登录,不写则允许所有ip访问*/
        initParams.put("deny", "192.168.0.75");      /*拒绝谁登录*/
        initParams.put("resetEnable", "false");     /*是否可以重置数据源*/
        bean.setInitParameters(initParams);         /*初始化参数*/
        return bean;
    }

    /**
     * 配置Druid的监控
     * 2.配置一个监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        Map<String, String> initParams = new HashMap<>();
        /*排除静态资源请求不被拦截*/
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,/druid/*");
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));   /*对所有请求进行监控处理*/
        bean.setInitParameters(initParams);
        return bean;
    }

}
