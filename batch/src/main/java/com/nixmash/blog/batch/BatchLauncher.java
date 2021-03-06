package com.nixmash.blog.batch;

import com.nixmash.blog.batch.config.ApplicationConfiguration;
import com.nixmash.blog.jpa.config.ApplicationConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
@Import({ApplicationConfig.class})
public class BatchLauncher {

    public static void main(String[] args) throws Exception {

        PropertySource commandLineProperties = new
                SimpleCommandLinePropertySource(args);

        AnnotationConfigApplicationContext context= new
                AnnotationConfigApplicationContext();

        context.getEnvironment().getPropertySources().addFirst(commandLineProperties);
        context.register(ApplicationConfiguration.class);
        context.refresh();
    }

}

