package com.qraphql.imdb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:11:23 AM<br/>
 * project : graphql-imdb <br/>
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer
{
    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment env;

    public WebConfigurer(Environment env)
    {
        this.env = env;

    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }

//        if (env.acceptsProfiles(Profiles.of(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT))) {
        initH2Console(servletContext);
//        }
        log.info("Web application fully configured");
    }

    private void initH2Console(ServletContext servletContext)
    {
        log.info("Initialize H2 console");
        DatabaseConfiguration.initH2Console(servletContext);
    }
}
