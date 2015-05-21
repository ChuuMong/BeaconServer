package com.mostra.beaconserver;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application extends AbstractMongoConfiguration implements EmbeddedServletContainerCustomizer, AsyncConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return "BeaconData";
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential = MongoCredential.createMongoCRCredential("test", getDatabaseName(), "1234".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1"), Arrays.asList(credential));
        return mongoClient;
    }

    /**
     * 서버 스레드 세팅
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    /**
     * Jetty 서버의 포트변경, 타임아웃 설정 <br>
     * 쓰레드 풀 설정
     *
     * @param container
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(50505);
        container.setSessionTimeout(10000);
        if (container instanceof JettyEmbeddedServletContainerFactory) {
            customizeJetty((JettyEmbeddedServletContainerFactory) container);
        }
    }

    private void customizeJetty(JettyEmbeddedServletContainerFactory container) {
        container.addServerCustomizers(new JettyServerCustomizer() {
            @Override
            public void customize(Server server) {
                final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
                threadPool.setMaxThreads(200);
                threadPool.setMinThreads(5);
                threadPool.setIdleTimeout(10000);
            }
        });
    }


    public
    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        //remove _class
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
        return mongoTemplate;
    }
}
