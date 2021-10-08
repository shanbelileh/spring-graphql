package com.qraphql.imdb;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : mohammad
 * @since : 10/6/2021 5:57 PM , Wed
 * imdb
 **/

@SpringBootApplication
public class ImdbApplication
{

    private static final Logger log = LoggerFactory.getLogger(ImdbApplication.class);

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(ImdbApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env)
    {
        String protocol = "http";
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) contextPath = "/";
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        String path = contextPath.equals("/") ? contextPath : contextPath + "/";
        log.info("\n----------------------------------------------------------\n\t" +
                         "Application '{}' is running! Access URLs:\n\t" +
                         "Local:            {}://localhost:{}{}\n\t" +
                         "GraphiQL Console: {}://localhost:{}{}graphiql\n\t" +
                         "Schema          : {}://localhost:{}{}graphql/schema\n\t" +
                         "H2 Console:       {}://localhost:{}{}h2-console\n\t" +
                         "\n----------------------------------------------------------",
                 env.getProperty("spring.application.name"),
                 protocol, serverPort, contextPath,
                 protocol, serverPort, path,
                 protocol, serverPort, path,
                 protocol, serverPort, path
                );


    }

}
