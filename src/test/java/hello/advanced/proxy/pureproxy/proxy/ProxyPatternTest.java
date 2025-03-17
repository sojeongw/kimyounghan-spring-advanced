package hello.advanced.proxy.pureproxy.proxy;

import hello.advanced.proxy.pureproxy.proxy.code.CacheProxy;
import hello.advanced.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.advanced.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        CacheProxy cacheProxy = new CacheProxy(new RealSubject());
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();
    }
}
