package com.ruoyi.websocket.utils;

import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
public class HeaderUtils {

    public static String getNativeHeader(StompHeaderAccessor stompHeaderAccessor, String header) {
        final List<String> values = stompHeaderAccessor.getNativeHeader(header);
        if (!CollectionUtils.isEmpty(values)) {
            return values.get(0);
        }
        return null;
    }

}
