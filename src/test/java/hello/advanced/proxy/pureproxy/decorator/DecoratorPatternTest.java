package hello.advanced.proxy.pureproxy.decorator;

import hello.advanced.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.advanced.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.advanced.proxy.pureproxy.decorator.code.RealComponent;
import hello.advanced.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2() {
        RealComponent realComponent = new RealComponent();
        TimeDecorator timeDecorator = new TimeDecorator(realComponent);
        MessageDecorator messageDecorator = new MessageDecorator(timeDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }
}
