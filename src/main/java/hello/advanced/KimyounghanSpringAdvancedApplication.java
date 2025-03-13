package hello.advanced;

import hello.advanced.config.AppV1Config;
import hello.advanced.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy")
public class KimyounghanSpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(KimyounghanSpringAdvancedApplication.class, args);
    }

}
