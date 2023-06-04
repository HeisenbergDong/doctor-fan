package com.ruoyi.websocket.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
@Slf4j
public class SocketUserHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        final HttpHeaders headers = request.getHeaders();
        HttpServletRequest req = null;
        log.info("handshake getLocalAddress: {}", request.getLocalAddress());
        log.info("handshake getRemoteAddress: {}", request.getRemoteAddress());
        log.info("handshake method: {}, url: {}", request.getMethod(), request.getURI());
        log.info("handshake headers: {}", headers);
        log.info("handshake attributes: {}", attributes);

        return super.determineUser(request, wsHandler, attributes);
    }
}
