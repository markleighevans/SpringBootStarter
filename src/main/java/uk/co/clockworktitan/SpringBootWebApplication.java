package uk.co.clockworktitan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringBootWebApplication    {
    public static void main(String[] args) throws Exception {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "{}");

        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
