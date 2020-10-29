package com.example.myapplicationtest;

import android.app.Application;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMMessageManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyLeanCloudApp extends Application {

    private static final String APPID = "JMBPc7y4SUPRDrOSHXjXVMN7-gzGzoHsz";
    private static final String APPKEY = "Wib2dECd48h1FzivFrH628ju";
    private static final String APP_SERVER_HOST = "https://jmbpc7y4.lc-cn-n1-shared.com";
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        AVOSCloud.initialize(this, APPID, APPKEY, APP_SERVER_HOST);
        AVIMMessageManager.setConversationEventHandler(LCIMConversationHandler.getInstance());
//        AVInstallation.getCurrentInstallation().saveInBackground().subscribe(new Observer<AVObject>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//            @Override
//            public void onNext(AVObject avObject) {
//                String installationId = AVInstallation.getCurrentInstallation().getInstallationId();
//                System.out.println("保存成功：" + installationId);
//            }
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("保存失败，错误信息：" + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        });
    }

}
//        //未读消息数量更新
//        AVIMOptions.getGlobalOptions().setUnreadNotificationEnabled(true);
//        // 和 Conversation 相关的事件的 handler

//        AVUser.logIn("Tom201912", "123").subscribe(new Observer<AVUser>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(AVUser avUser) {
//                // 登录成功
//                System.out.println("登录成功");
//AVInstallation avInstallation = AVInstallation.getCurrentInstallation();
//avInstallation.put("owner", AVUser.getCurrentUser());
//avInstallation.put("date", new Date());
//avInstallation.put("version", "456");
//avInstallation.saveInBackground().subscribe(new Observer<AVObject>() {
//    @Override
//    public void onSubscribe(Disposable d) {
//    }
//
//    @Override
//    public void onNext(AVObject avObject) {
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
// 将签名工厂类的实例绑定到 AVIMClient


//华东节点：DongTest
//        AVOSCloud.setRegion(AVOSCloud.REGION.EastChina);
//        AVOSCloud.initialize(this,"uwWkfssEBRtrxVpQWEnFtqfr-9Nh9j0Va","9OaLpoW21lIQtRYzJya4WHUR");

//ChatKitDemo
//        AVOSCloud.initialize(this,"JMBPc7y4SUPRDrOSHXjXVMN7-gzGzoHsz","Wib2dECd48h1FzivFrH628ju");

