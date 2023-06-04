package com.ruoyi.websocket.interceptor;

import com.ruoyi.framework.security.auth.SocketUser;
import com.ruoyi.websocket.utils.HeaderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.StringUtils;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
@Slf4j
public class StompSessionInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.trace("message info: {}", message);
        final StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(message);
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT.equals(stompHeaderAccessor.getCommand())) {
            final String userType = HeaderUtils.getNativeHeader(stompHeaderAccessor, "user-type");
            final String userId = HeaderUtils.getNativeHeader(stompHeaderAccessor, "user-id");
            if (StringUtils.hasText(userType) && StringUtils.hasText(userId) && accessor != null) {
                accessor.setUser(new SocketUser(userType + "-" + userId));
                log.debug("socket连接创建: {}-{}", userType, userId);
                return message;
            }
            log.warn("socket 连接 - 未知用户");
        }
        return message;
    }

}
