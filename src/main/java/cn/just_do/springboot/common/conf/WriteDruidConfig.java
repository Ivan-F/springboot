package cn.just_do.springboot.common.conf;



import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;



//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages=WriteDruidConfig.WRITE_PACKAGE)
public class WriteDruidConfig {
	static final String WRITE_PACKAGE = "cn.just_do.springboot.dal.write";
	static final String MAPPER_LOACTION = "classpath:mapper/*.xml";
	

	
	@Bean(name="writeDataSource")
	@ConfigurationProperties("spring.datasource.druid.write")
	public DataSource writeDatasource(){
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name="writeTransactionManager")
	public DataSourceTransactionManager writedDTM(@Qualifier("writeDataSource")DataSource ds){
		return new DataSourceTransactionManager(ds);
	}
	
	@Bean(name = "writeSqlSessionFactory")
	public SqlSessionFactoryBean writeSqlSessionFactory(@Qualifier("writeDataSource") DataSource ds)
			throws IOException {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver()
				.getResources(ReadDruidConfig.MAPPER_LOACTION));
		return sessionFactory;
	}

}
