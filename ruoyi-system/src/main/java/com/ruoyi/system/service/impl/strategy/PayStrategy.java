package com.ruoyi.system.service.impl.strategy;

public interface PayStrategy<R,T> {

    /**
     * 支付策略抽象
     * @param t
     * @return
     */
    R operate(T t);
}
