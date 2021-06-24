//package com.example.myapplicationtest;
//
//
//import cn.leancloud.im.v2.LCIMClient;
//import cn.leancloud.im.v2.LCIMClientEventHandler;
//
//public class MyClientEventHandler extends LCIMClientEventHandler {
//
//    private static MyClientEventHandler eventHandler;
//
//    public static synchronized MyClientEventHandler getInstance() {
//        if (null == eventHandler) {
//            eventHandler = new MyClientEventHandler();
//        }
//        return eventHandler;
//    }
//
//    private MyClientEventHandler() {
//    }
//
//
//    private volatile boolean connect = false;
//
//    /**
//     * 是否连上聊天服务
//     *
//     * @return
//     */
//    public boolean isConnect() {
//        return connect;
//    }
//
//    public void setConnectAndNotify(boolean isConnect) {
//        connect = isConnect;
////        EventBus.getDefault().post(new LCIMConnectionChangeEvent(connect));
//    }
//
//    @Override
//    public void onConnectionPaused(LCIMClient avimClient) {
//        System.out.println("---onConnectionPaused!!!!!!!!" );
//    }
//    @Override
//    public void onConnectionResume(LCIMClient avimClient) {
//        System.out.println("---onConnectionResume!!!!!!!!" );
//    }
//    @Override
//    public void onClientOffline(LCIMClient avimClient, int i) {
//        System.out.println("---onClientOffline!!!!!!!!" );
//    }
//}
//
//
