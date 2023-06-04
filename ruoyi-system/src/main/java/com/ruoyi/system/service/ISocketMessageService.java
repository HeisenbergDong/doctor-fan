package com.ruoyi.system.service;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
public interface ISocketMessageService {

    void sendBroadcast(String room, String destination, Object payload);

    void sendToUser(String userId, String destination, Object payload);

}
