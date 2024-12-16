package com.libmanage.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.libmanage.repo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Override
    protected String getDatabaseName() {
        return "library";  // Changed from librarydb to library
    }

    @Override
    public MongoClient mongoClient() {
        try {
            System.setProperty("jdk.tls.trustNameService", "true");
            System.setProperty("javax.net.ssl.trustStore", System.getProperty("java.home") + "/lib/security/cacerts");
            System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            
            MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUri))
                .applyToSslSettings(builder -> {
                    builder.enabled(true)
                           .invalidHostNameAllowed(true);
                })
                .build();
            
            return MongoClients.create(settings);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create MongoClient", e);
        }
    }
}