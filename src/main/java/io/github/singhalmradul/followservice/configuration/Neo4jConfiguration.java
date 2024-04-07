package io.github.singhalmradul.followservice.configuration;

import static org.neo4j.cypherdsl.core.renderer.Configuration.newConfig;
import static org.neo4j.cypherdsl.core.renderer.Dialect.NEO4J_5;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Neo4jConfiguration {

    @Bean
    Configuration cypherDslConfiguration() {
        return newConfig()
            .withDialect(NEO4J_5).build();
    }
}
