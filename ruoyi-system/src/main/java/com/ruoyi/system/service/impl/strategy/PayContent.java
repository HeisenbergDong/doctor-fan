package com.ruoyi.system.service.impl.strategy;

public class PayContent<R, T> {

    private PayStrategy<R, T> payStrategy;

    public PayContent(PayStrategy<R, T> payStrategy) {
        this.payStrategy = payStrategy;
    }

    public R execute(T t) {

        return payStrategy.operate(t);
    }
}
