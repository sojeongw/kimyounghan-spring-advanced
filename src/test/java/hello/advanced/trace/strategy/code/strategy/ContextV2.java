package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

// 파라미터에 전략을 보관하는 방식
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTIme = {}", resultTIme);
    }
}
