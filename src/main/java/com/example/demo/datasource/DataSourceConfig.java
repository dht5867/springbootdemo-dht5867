package com.example.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author
 * @description 多数据配置
 * @create 2017-11-21 上午10:08
 **/

@Configuration
public class DataSourceConfig {


/**
     * 配置数据库连接池,通过Javaconfig的配置类,这样springboot在启动时就会帮我们管理
     * @return
     */
    //
    @Bean(destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource()throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

}

