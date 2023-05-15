package com.miujoke;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 21:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8001.class, args);
    }

    /**
     * desc:此配置是为了服务监控而配置，与服务容错无关，springcloud升级后的坑
     *ServletRegistrationBean因为springcloud的默认路径不是“/hystrix.stream",
     *只要在项目里配置上此servlet就可以了
     * @param
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
