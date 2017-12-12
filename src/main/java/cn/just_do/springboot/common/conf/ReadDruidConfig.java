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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;

//多数据源配置 http://blog.csdn.net/maoyeqiu/article/details/74011626
//http://www.jianshu.com/p/8813ec02926a
//http://www.cnblogs.com/java-zhao/p/5413845.html
//@Configuration
//@MapperScan(basePackages=ReadDruidConfig.READ_PACKAGE)
public class ReadDruidConfig {
	static final String READ_PACKAGE = "cn.just_do.springboot.dal.read";
	static final String MAPPER_LOACTION = "classpath:mapper/*.xml";

	@Bean(name = "readDataSource")
	@Primary
	@ConfigurationProperties("spring.datasource.druid.read")
	public DataSource readDatasource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Primary
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
		//默认为false;该参数对使用 RowBounds 作为分页参数时有效;设置为true时，会进行 count 查询
//		p.setProperty("rowBoundsWithCount", "true");

		//支持： List<Country> selectByPageNumSize(@Param("user") User user,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
		p.setProperty("supportMethodsArguments","true");
		//默认false;为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
//		p.setProperty("reasonable", "true");
		//默认：false;运行时根据多数据源自动识别对应方言的分页
		p.setProperty("autoRuntimeDialect","true");
		pageHelper.setProperties(p);
		return pageHelper;
	}

}
