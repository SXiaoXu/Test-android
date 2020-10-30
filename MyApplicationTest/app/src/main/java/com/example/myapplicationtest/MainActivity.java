package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);

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
//                AVIMClient jerry = AVIMClient.getInstance("jerry");
//                jerry.open(new AVIMClientCallback() {
//                             @Override
//                             public void done(AVIMClient client, AVIMException e) {
//                                 if (e == null) {
//                                     // 成功打开连接
//                                 }
//                             }
//                         });

                final AVIMClient tom = AVIMClient.getInstance("jerry");
                tom.open(new AVIMClientCallback() {
                    @Override
                    public void done(AVIMClient client, AVIMException e) {
                        if (e == null) {
                            // 成功打开连接
                            AVIMConversation conversation = tom.getConversation("5f9a716820c42a0bc68f946a");
                            conversation.setName("111");
                            conversation.updateInfoInBackground(new AVIMConversationCallback(){
                                @Override
                                public void done(AVIMException e){
                                    if(e==null){
                                        // 更新成功
                                    }
                                }
                            });
                        }
                    }
                });


//                Lee,123,objectId：5f979ce7fee52727c3db5fb0
//               Mcc,123, objectId：5f979db0fee52727c3db6065，Mcc关注了Lee



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
