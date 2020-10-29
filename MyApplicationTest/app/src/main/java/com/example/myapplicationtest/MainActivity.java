package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.AVPush;
import cn.leancloud.AVQuery;

import cn.leancloud.AVUser;
import cn.leancloud.callback.FollowersAndFolloweesCallback;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import cn.leancloud.im.v2.messages.AVIMAudioMessage;
import cn.leancloud.im.v2.messages.AVIMTextMessage;

import cn.leancloud.sms.AVSMS;
import cn.leancloud.sms.AVSMSOption;
import cn.leancloud.types.AVNull;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        AVUser user = new AVUser();

// 等同于 user.put("username", "Tom")
//        user.setUsername("Mcc");
//        user.setPassword("123");
//
//        user.signUpInBackground().subscribe(new Observer<AVUser>() {
//            public void onSubscribe(Disposable disposable) {}
//            public void onNext(AVUser user) {
//                // 注册成功
//                System.out.println("注册成功。objectId：" + user.getObjectId());
//            }
//            public void onError(Throwable throwable) {
//                // 注册失败（通常是因为用户名已被使用）
//            }
//            public void onComplete() {}
//        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Lee,123,objectId：5f979ce7fee52727c3db5fb0
//               Mcc,123, objectId：5f979db0fee52727c3db6065，Mcc关注了Lee

Map<String, Object> thirdPartyData = new HashMap<String, Object>();
thirdPartyData.put("expires_in", 7200);
thirdPartyData.put("openid", "OPENID");
thirdPartyData.put("access_token", "ACCESS_TOKEN111");
thirdPartyData.put("refresh_token", "REFRESH_TOKEN111");
thirdPartyData.put("scope", "SCOP1111");
AVUser avUser = new AVUser();
avUser.setUsername("12Tom");
avUser.setMobilePhoneNumber("+8618842650000");
avUser.loginWithAuthData(thirdPartyData, "weixin111",false).subscribe(new Observer<AVUser>() {
    @Override
    public void onSubscribe(Disposable d) {
    }
    @Override
    public void onNext(AVUser avUser) {
        System.out.println("登录成功");
    }
    @Override
    public void onError(Throwable e) {
        System.out.println("登录失败：" + e.getMessage());
    }
    @Override
    public void onComplete() {
    }
});



//                AVQuery pushQuery = AVInstallation "public");
//                AVPush push = new AVPush();
//
//                push.setQuery(pushQuery);
//                push.setMessage("Push to channel.");
////                push.setPushToAndroid(true);
//                push.sendInBackground().subscribe(new Observer<JSONObject>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d("onSubscribe","onSubscribe");
//
//                    }
//
//                    @Override
//                    public void onNext(JSONObject jsonObject) {
//                        System.out.println("推送成功" + jsonObject);
//                        Log.d("成功","推送成功");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        AVException avException = new AVException(e);
//                        Log.d("ErrorCode:",String.valueOf(avException.getCode()));
//                        Log.d("ErrorMessage:",avException.getMessage());
//                        Log.d("Throwable:",e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("onComplete","onComplete");
//
//                    }
//                });
//                push.sendInBackground().subscribe(new Observer<JSONObject>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//                    @Override
//                    public void onNext(JSONObject jsonObject) {
//                        System.out.println("推送成功" + jsonObject);
//                        Log.d("成功","推送成功");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("推送失败，错误信息：" + e.getMessage());
//                        Log.d("成功","推送失败");
//
//                    }
//                    @Override
//                    public void onComplete() {
//                    }
//                });


            }
        });
    }
}
