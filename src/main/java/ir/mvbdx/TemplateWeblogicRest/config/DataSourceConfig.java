package ir.mvbdx.TemplateWeblogicRest.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"ir.mvbdx"})
public class DataSourceConfig {

    @Bean(destroyMethod = "")
    @Profile("prod")
    public DataSource dataSource() {
        try {
            return (DataSource) new JndiTemplate().lookup("GlobalDS");
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean("dataSource")
    @Profile("dev")
    public DataSource devDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername("pl");
        hikariDataSource.setPassword("pass");
        hikariDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariDataSource.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:free");
        return hikariDataSource;
    }

    @Bean(destroyMethod = "")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("ir");
        entityManagerFactoryBean.setPersistenceUnitName("GlobalPU");
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(properties());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    @Bean(destroyMethod = "")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean(destroyMethod = "")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.ORACLE);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        return jpaVendorAdapter;
    }

    @Bean(destroyMethod = "")
    public Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }
}