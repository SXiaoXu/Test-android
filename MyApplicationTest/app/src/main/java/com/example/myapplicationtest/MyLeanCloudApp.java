package com.example.myapplicationtest;

import android.app.Application;

import java.util.List;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessageManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyLeanCloudApp extends Application {

    private static final String APPID = "2S3eFs2gbLVcDKBtXTM0e5KX-gzGzoHsz";
    private static final String APPKEY = "CY6NPCRRLpPGKLCe8372924N";
    private static final String APP_SERVER_HOST = "https://ip-np10.iwxnews.com";
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        AVOSCloud.initialize(this, APPID, APPKEY, APP_SERVER_HOST);
        AVIMMessageManager.setConversationEventHandler(new CustomConversationEventHandler());
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
