package com.example.myapplicationtest;


import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMClientEventHandler;

public class MyClientEventHandler extends AVIMClientEventHandler {

    private static MyClientEventHandler eventHandler;

    public static synchronized MyClientEventHandler getInstance() {
        if (null == eventHandler) {
            eventHandler = new MyClientEventHandler();
        }
        return eventHandler;
    }

    private MyClientEventHandler() {
    }


    private volatile boolean connect = false;

    /**
     * 是否连上聊天服务
     *
     * @return
     */
    public boolean isConnect() {
        return connect;
    }

    public void setConnectAndNotify(boolean isConnect) {
        connect = isConnect;
//        EventBus.getDefault().post(new LCIMConnectionChangeEvent(connect));
    }

    @Override
    public void onConnectionPaused(AVIMClient avimClient) {
        System.out.println("---onConnectionPaused!!!!!!!!" );
    }
    @Override
    public void onConnectionResume(AVIMClient avimClient) {
        System.out.println("---onConnectionResume!!!!!!!!" );
    }
    @Override
    public void onClientOffline(AVIMClient avimClient, int i) {
        System.out.println("---onClientOffline!!!!!!!!" );
    }
}


