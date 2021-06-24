package com.example.myapplicationtest;
import android.app.Application;

import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;

public class MyLeanCloudApp extends Application {

    private static final String APPID = "JMBPc7y4SUPRDrOSHXjXVMN7-gzGzoHsz";
    private static final String APPKEY = "Wib2dECd48h1FzivFrH628ju";
    private static final String APP_SERVER_HOST = "https://jmbpc7y4.lc-cn-n1-shared.com";
//
//    private static final String APPID = "ptznboIvkaCkQKRW5v5EaXMf-MdYXbMMI";
//    private static final String APPKEY = "VuCgGrwB7VE3Wz17IwUYgTJP";
////    private static final String APP_SERVER_HOST = "https://1euivazf.lc-cn-n1-shared.com";
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        AVOSCloud.initialize(this, APPID, APPKEY,APP_SERVER_HOST);
//        LCIMMessageManager.setConversationEventHandler(new CustomConversationEventHandler());
//        LCIMClient.setClientEventHandler(MyClientEventHandler.getInstance());
    }
}
//        //未读消息数量更新
//        LCIMOptions.getGlobalOptions().setUnreadNotificationEnabled(true);
//        // 和 Conversation 相关的事件的 handler

//        LCUser.logIn("Tom201912", "123").subscribe(new Observer<LCUser>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(LCUser avUser) {
//                // 登录成功
//                System.out.println("登录成功");
//LCInstallation avInstallation = LCInstallation.getCurrentInstallation();
//avInstallation.put("owner", LCUser.getCurrentUser());
//avInstallation.put("date", new Date());
//avInstallation.put("version", "456");
//avInstallation.saveInBackground().subscribe(new Observer<LCObject>() {
//    @Override
//    public void onSubscribe(Disposable d) {
//    }
//
//    @Override
//    public void onNext(LCObject avObject) {
//        System.out.println("succeed to save Installation. result: " + avObject);
//    }
//
//    public void onError(Throwable throwable) {
//        System.out.println("保存失败：" + throwable.getMessage());
//    }
//    public void onComplete() {
//    }
//});
//
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


//
//        } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
//                }

//        PushService.setDefaultPushCallback(this, MainActivity.class);
