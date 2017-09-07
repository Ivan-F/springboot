package cn.just_do.springboot.common.conf;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;

//@Configuration
//@MapperScan(basePackages=ReadDruidConfig.READ_PACKAGE)
public class ReadDruidConfig {
	static final String READ_PACKAGE = "cn.just_do.springboot.dal.read";
	static final String MAPPER_LOACTION = "classpath:mapper/*.xml";

	@Bean(name = "readDataSource")
	@ConfigurationProperties("spring.datasource.druid.read")
	public DataSource readDatasource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "readSqlSessionFactory")
	public SqlSessionFactoryBean readSqlSessionFactory(@Qualifier("readDataSource") DataSource ds)
			throws IOException {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		Interceptor[] interceptors = new Interceptor[] { PageHelper() };
		sessionFactory.setPlugins(interceptors);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver()
				.getResources(ReadDruidConfig.MAPPER_LOACTION));
		return sessionFactory;
	}

	public PageHelper PageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("dialect", "mysql");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
