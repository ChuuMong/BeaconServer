package com.mostra.beaconserver;


import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by yoontaesup on 2015. 2. 11..
 */
@Configuration
@ConditionalOnClass({ Mongo.class, MongoTemplate.class })
@EnableConfigurationProperties(MongoProperties.class)
@AutoConfigureAfter(MongoAutoConfiguration.class)
public class MongoDataAutoConfiguration {

    @Autowired
    private MongoProperties properties;

//    @Autowired
//    private Environment environment;

//    @Autowired
//    private ResourceLoader resourceLoader;

//    @Bean
//    @ConditionalOnMissingBean
//    public MongoDbFactory mongoDbFactory(Mongo mongo) throws Exception {
//        String database = this.properties.getMongoClientDatabase();
//        String authDatabase = this.properties.getAuthenticationDatabase();
//        if (StringUtils.hasLength(authDatabase)) {
//            String username = this.properties.getUsername();
//            String password = new String(this.properties.getPassword());
//            UserCredentials credentials = new UserCredentials(username, password);
//            return new SimpleMongoDbFactory(mongo, database, credentials, authDatabase);
//        }
//        return new SimpleMongoDbFactory(mongo, database);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
//                                       MongoConverter converter) throws UnknownHostException {
//        return new MongoTemplate(mongoDbFactory, converter);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(MongoConverter.class)
//    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
//                                                       MongoMappingContext context, BeanFactory beanFactory) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver,
//                context);
//        try {
//            mappingConverter.setCustomConversions(beanFactory
//                    .getBean(CustomConversions.class));
//        }
//        catch (NoSuchBeanDefinitionException ex) {
//            // Ignore
//        }
//        return mappingConverter;
//    }

//    @Bean
//    @ConditionalOnMissingBean
//    public MongoMappingContext mongoMappingContext(BeanFactory beanFactory)
//            throws ClassNotFoundException {
//        MongoMappingContext context = new MongoMappingContext();
//        context.setInitialEntitySet(getInitialEntitySet(beanFactory));
//        return context;
//    }
//
//    private Set<Class<?>> getInitialEntitySet(BeanFactory beanFactory)
//            throws ClassNotFoundException {
//        Set<Class<?>> entitySet = new HashSet<Class<?>>();
//        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
//                false);
//        scanner.setEnvironment(this.environment);
//        scanner.setResourceLoader(this.resourceLoader);
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Document.class));
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Persistent.class));
//        for (String basePackage : getMappingBasePackages(beanFactory)) {
//            if (StringUtils.hasText(basePackage)) {
//                for (BeanDefinition candidate : scanner
//                        .findCandidateComponents(basePackage)) {
//                    entitySet.add(ClassUtils.forName(candidate.getBeanClassName(),
//                            MongoDataAutoConfiguration.class.getClassLoader()));
//                }
//            }
//        }
//        return entitySet;
//    }
//
//    private static Collection<String> getMappingBasePackages(BeanFactory beanFactory) {
//        try {
//            return AutoConfigurationPackages.get(beanFactory);
//        }
//        catch (IllegalStateException ex) {
//            // no auto-configuration package registered yet
//            return Collections.emptyList();
//        }
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public GridFsTemplate gridFsTemplate(MongoDbFactory mongoDbFactory,
//                                         MongoTemplate mongoTemplate) {
//        return new GridFsTemplate(new GridFsMongoDbFactory(mongoDbFactory,
//                this.properties), mongoTemplate.getConverter());
//    }
//
//    /**
//     * {@link MongoDbFactory} decorator to respect
//     * {@link MongoProperties#getGridFsDatabase()} if set.
//     */
//    private static class GridFsMongoDbFactory implements MongoDbFactory {
//
//        private final MongoDbFactory mongoDbFactory;
//
//        private final MongoProperties properties;
//
//        public GridFsMongoDbFactory(MongoDbFactory mongoDbFactory,
//                                    MongoProperties properties) {
//            Assert.notNull(mongoDbFactory, "MongoDbFactory must not be null");
//            Assert.notNull(properties, "Properties must not be null");
//            this.mongoDbFactory = mongoDbFactory;
//            this.properties = properties;
//        }
//
//        @Override
//        public DB getDb() throws DataAccessException {
//            String gridFsDatabase = this.properties.getGridFsDatabase();
//            if (StringUtils.hasText(gridFsDatabase)) {
//                return this.mongoDbFactory.getDb(gridFsDatabase);
//            }
//            return this.mongoDbFactory.getDb();
//        }
//
//        @Override
//        public DB getDb(String dbName) throws DataAccessException {
//            return this.mongoDbFactory.getDb(dbName);
//        }
//
//        @Override
//        public PersistenceExceptionTranslator getExceptionTranslator() {
//            return this.mongoDbFactory.getExceptionTranslator();
//        }
//
//    }

}