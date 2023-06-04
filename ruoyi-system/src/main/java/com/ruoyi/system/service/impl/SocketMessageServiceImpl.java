package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.ISocketMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
@Slf4j
@Service
public class SocketMessageServiceImpl implements ISocketMessageService {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendBroadcast(String room, String destination, Object payload) {
        log.info("发送广播消息: dest-[{}], payload-[{}]", destination, payload);
        this.simpMessagingTemplate.convertAndSend(destination, payload);
    }

    @Override
    public void sendToUser(String userId, String destination, Object payload) {
        log.info("发送私有消息: userId-[{}], dest-[{}], payload-[{}]",  userId, destination, payload);
        this.simpMessagingTemplate.convertAndSendToUser(userId, destination, payload);
    }
}
