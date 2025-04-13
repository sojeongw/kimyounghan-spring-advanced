package hello.advanced.config.v1_proxy.concrete_proxy;

import hello.advanced.proxy.v2.OrderServiceV2;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        // 자식 클래스를 생성할 때는 부모 클래스의 생성자를 호출해야 한다.
        // 부모 기능을 안 쓸 것이기 때문에 문법적으로 맞추기 위해 null을 대입한다.
        // 인터페이스 기반이었다면 고민하지 않아도 된다.
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
