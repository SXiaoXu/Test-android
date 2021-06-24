package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;

import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import cn.leancloud.im.v2.callback.AVIMConversationSimpleResultCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOperationFailure;
import cn.leancloud.im.v2.callback.AVIMOperationPartiallySucceededCallback;
import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.im.v2.conversation.ConversationMemberRole;
import cn.leancloud.im.v2.messages.AVIMAudioMessage;
import cn.leancloud.im.v2.messages.AVIMImageMessage;
import cn.leancloud.im.v2.messages.AVIMTextMessage;
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
              jerry.createConversation(Arrays.asList("Tom20200622"), null, null, false, new AVIMConversationCreatedCallback() {
                @Override
                public void done(AVIMConversation conversation, AVIMException e) {
                  Log.d("Tom&Jerry", "会话创建成功！");
                  try {
                    InputStream inputStream = getResources().openRawResource(R.raw.testv);
                    byte[] mMediaBytes = readBytes(inputStream);

                    AVFile file = new AVFile("测试.mp3", mMediaBytes);
                    AVIMAudioMessage msg = new AVIMAudioMessage(file);
                    conversation.sendMessage(msg, new AVIMConversationCallback() {
                      @Override
                      public void done(AVIMException e) {
                        if (e == null) {
                          Log.d("发送成功", "发送成功！");
                        }
                      }
                    });


                  } catch (Exception err) {
                    Log.d("错误信息", "ddd");
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
        try {
          InputStream inputStream = getResources().openRawResource(R.raw.testv);
          byte[] mMediaBytes = readBytes(inputStream);
          AVFile file = new AVFile("测试.mp3", mMediaBytes);
          file.saveInBackground(new ProgressCallback() {
            @Override
            public void done(Integer percentDone) {
              Log.d("Progress----", percentDone.toString());
            }
          });


        }catch (Exception e){

        }
      }
    });

  }

  //读取文件内容
  private byte[] readBytes(InputStream inputStream) throws IOException {
    ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
    int bufferSize = 1024;
    byte[] buffer = new byte[bufferSize];
    int len;
    while ((len = inputStream.read(buffer)) != -1) {
      byteBuffer.write(buffer, 0, len);
    }
    return byteBuffer.toByteArray();
  }
}