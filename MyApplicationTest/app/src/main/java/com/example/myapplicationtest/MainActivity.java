package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import cn.leancloud.AVUser;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;
import cn.leancloud.im.v2.callback.AVIMOperationFailure;
import cn.leancloud.im.v2.callback.AVIMOperationPartiallySucceededCallback;
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
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVIMClient jerry = AVIMClient.getInstance("Jerry");
                jerry.open(new AVIMClientCallback() {
                    @Override
                    public void done(AVIMClient client, AVIMException e) {
                        if (e == null) {
                            // 成功打开连接
                            jerry.createConversation(Arrays.asList("GGG"), "测试", null, false, true,
                                    new AVIMConversationCreatedCallback() {
                                        @Override
                                        public void done(AVIMConversation conversation, AVIMException e) {
                                            if(e == null) {
                                                // 创建成功
                                                conversation.blockMembers(Arrays.asList("GGG"), new AVIMOperationPartiallySucceededCallback() {
                                                    @Override
                                                    public void done(AVIMException e, List<String> successfulClientIds, List<AVIMOperationFailure> failures) {
                                                        if(e == null){
                                                            System.out.println("block成功!!!!!!!!" );
                                                            System.out.println("block成功!!!!!!!!" + successfulClientIds);
                                                            System.out.println("block成功!!!!!!!!" + failures);
                                                        }else{
                                                            System.out.println("block失败!!!!!!!!"+e.getCode() +e.getMessage() );
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    });
                        }
                    }
                });
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVIMClient jerry = AVIMClient.getInstance("Tom");
                jerry.open(new AVIMClientCallback() {
                    @Override
                    public void done(AVIMClient client, AVIMException e) {
                        if (e == null) {
                            // 成功打开连接
                        }
                    }
                });
            }
        });
    }
}
