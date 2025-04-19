package hello.advanced;

import hello.advanced.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import({DynamicProxyBasicConfig.class, ConcreteProxyConfig.class})
//@Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy")
public class KimyounghanSpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(KimyounghanSpringAdvancedApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
