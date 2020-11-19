package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOperationFailure;
import cn.leancloud.im.v2.callback.AVIMOperationPartiallySucceededCallback;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
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
//                AVFile file = new AVFile(
//                        "logo.png",
//                        "https://leancloud.cn/assets/imgs/press/Logo%20-%20Blue%20Padding.a60eb2fa.png",
//                        new HashMap<String, Object>()
//                );
//
//                file.saveInBackground().subscribe(new Observer<AVFile>() {
//                    public void onSubscribe(Disposable disposable) {}
//                    public void onNext(AVFile file) {
//                        System.out.println("文件保存完成。objectId：" + file.getObjectId());
//                    }
//                    public void onError(Throwable throwable) {
//                        // 保存失败，可能是文件无法被读取，或者上传过程中出现问题
//
//                    }
//                    public void onComplete() {}
//                });
                final AVIMClient tom = AVIMClient.getInstance("Bobp");
                tom.open(new AVIMClientCallback() {
                    @Override
                    public void done(AVIMClient client, AVIMException e) {
                        if (e == null) {
                            // 成功打开连接
                            final AVIMConversation conversation = tom.getConversation("5f9a716820c42a0bc68f946a");
// limit 取值范围 1~100，如调用 queryMessages 时不带 limit 参数，默认获取 20 条消息记录
// Tom 登录
                            conversation.join(new AVIMConversationCallback(){
                                @Override
                                public void done(AVIMException e){
                                    if(e==null){
                                        // 加入成功
                                    }
                                }
                            });

                        }

                    }
                });
//                Lee,123,objectId：5f979ce7fee52727c3db5fb0
//               Mcc,123, objectId：5f979db0fee52727c3db6065，Mcc关注了Lee
            }
        });
    }
}
