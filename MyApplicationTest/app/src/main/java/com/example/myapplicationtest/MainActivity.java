package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
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
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
  private Button btn1, btn2;
  public static void ViewModel() {
    AVQuery<AVObject> query = new AVQuery<>("Student");
    query.whereEqualTo("lastName", "Smith");
    query.findInBackground().subscribe(new Observer<List<AVObject>>() {
      public void onSubscribe(Disposable disposable) {}
      public void onNext(List<AVObject> students) {
        // students 是包含满足条件的 Student 对象的数组
      }
      public void onError(Throwable throwable) {}
      public void onComplete() {}
    });
  }
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
              jerry.createConversation(Arrays.asList("Tom20200508"), null, null, false, new AVIMConversationCreatedCallback() {
                @Override
                public void done(AVIMConversation conversation, AVIMException e) {
                  conversation.updateMemberRole("Tom20200508", ConversationMemberRole.MANAGER, new AVIMConversationCallback() {
                    @Override
                    public void done(AVIMException e) {
                      if (e != null) {
                        System.out.println("---设置失败---" + e.getCode());
                        return;
                      }

                      conversation.getMemberInfo("Tom20200508", new AVIMConversationMemberQueryCallback() {
                        @Override
                        public void done(List<AVIMConversationMemberInfo> memberInfoList, AVIMException e) {
                          if (memberInfoList != null) {
                            for (AVIMConversationMemberInfo info : memberInfoList) {
                              System.out.println("结果：" + info.getRole() + info.getMemberId());
                            }
                          }
                        }
                      });
                    }
                  });
                }
              });
            }
          }
        });
      }


//
//              jerry.createConversation(Arrays.asList("Tom"), null, null, false, new AVIMConversationCreatedCallback() {
//                @Override
//                public void done(AVIMConversation conversation, AVIMException e) {
//
//                    });
//                    conversation.getAllMemberInfo(0, 10, new AVIMConversationMemberQueryCallback() {
//                      @Override
//                      public void done(List<AVIMConversationMemberInfo> memberInfoList, AVIMException e) {
//
//                      }
//                    });
//                    conversation.updateMemberRole("Tom2020414", ConversationMemberRole.MANAGER, new AVIMConversationCallback() {
//                      @Override
//                      public void done(AVIMException e) {
//                        if(e!=null){
//                          System.out.println("---加入失败---"+e.getMessage().toString());
//                          return;
//                        }
//                        System.out.println("---updateMemberRole 成功---");

//                        conversation.blockMembers(Arrays.asList("Tom2020414"), new AVIMOperationPartiallySucceededCallback() {
//                          @Override
//                          public void done(AVIMException e, List<String> successfulClientIds, List<AVIMOperationFailure> failures) {
//                            System.out.println("---blockMembers 成功---");
//                            conversation.queryBlockedMembers(0, 10, new AVIMConversationSimpleResultCallback() {
//                              @Override
//                              public void done(List<String> memberIdList, AVIMException e) {
//                                System.out.println("memberIdList------->"+memberIdList.toString());
//
//                              }
//                            });
//                          }
//                        });

//                        conversation.getAllMemberInfo(0, 10, new AVIMConversationMemberQueryCallback() {
//                          @Override
//                          public void done(List<AVIMConversationMemberInfo> memberInfoList, AVIMException e) {
//                            if (memberInfoList != null) {
//                              System.out.println("memberInfoList------->"+memberInfoList.toString());
//
//                              for (AVIMConversationMemberInfo info : memberInfoList) {
//                                System.out.println(info.getRole() + info.getMemberId());
//                              }
//                            }
//                          }
//                        });

//                      }
//                    });
//                  }
//                }
//              });


    });
    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ViewModel();

//        AVObject todo = new AVObject("test");
//        todo.put("android", "123");
//
//        todo.saveInBackground().subscribe(new Observer<AVObject>() {
//          public void onSubscribe(Disposable disposable) {}
//          public void onNext(AVObject todo) {
//
//            System.out.println("保存成功。objectId：" + todo.getObjectId());
//          }
//          public void onError(Throwable throwable) {
//            System.out.println("保存失败-Error：" + throwable.getMessage());
//
//            try {
//              todo.saveEventually();
//            } catch (AVException e) {
//              e.printStackTrace();
//              System.out.println("Error：" + e.getMessage());
//            }
//          }
//          public void onComplete() {}
//        });


      }
    });

  }
}