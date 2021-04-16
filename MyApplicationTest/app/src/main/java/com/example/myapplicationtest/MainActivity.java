package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;

import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
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
              System.out.println("---登陆成功---");

              jerry.createConversation(Arrays.asList("Tom"), null, null, false, new AVIMConversationCreatedCallback() {
                @Override
                public void done(AVIMConversation conversation, AVIMException e) {
                  if (e == null) {
                    System.out.println("---创建成功---");
                    int limit = 3;
                    conversation.queryMessages(limit, new AVIMMessagesQueryCallback() {
                      @Override
                      public void done(List<AVIMMessage> messages, AVIMException e) {
                        if (e == null) {
                          // 成功获取最新 10 条消息记录
                         System.out.println("messagesList------->"+messages.toString());

                        }
                      }
                    });
                    conversation.getAllMemberInfo(0, 10, new AVIMConversationMemberQueryCallback() {
                      @Override
                      public void done(List<AVIMConversationMemberInfo> memberInfoList, AVIMException e) {

                      }
                    });
//                    conversation.updateMemberRole("Tom2020414", ConversationMemberRole.MANAGER, new AVIMConversationCallback() {
//                      @Override
//                      public void done(AVIMException e) {
//                        if(e!=null){
//                          System.out.println("---加入失败---"+e.getMessage().toString());
//                          return;
//                        }
//                        System.out.println("---updateMemberRole 成功---");

                        conversation.blockMembers(Arrays.asList("Tom2020414"), new AVIMOperationPartiallySucceededCallback() {
                          @Override
                          public void done(AVIMException e, List<String> successfulClientIds, List<AVIMOperationFailure> failures) {
                            System.out.println("---blockMembers 成功---");
                            conversation.queryBlockedMembers(0, 10, new AVIMConversationSimpleResultCallback() {
                              @Override
                              public void done(List<String> memberIdList, AVIMException e) {
                                System.out.println("memberIdList------->"+memberIdList.toString());

                              }
                            });
                          }
                        });

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
////                        conversation.getMemberInfo("Tom20200408", new AVIMConversationMemberQueryCallback() {
////                          @Override
////                          public void done(List<AVIMConversationMemberInfo> memberInfoList, AVIMException e) {
////                            if (memberInfoList != null) {
////                              for (AVIMConversationMemberInfo info : memberInfoList) {
////                                System.out.println(info.getRole() + info.getMemberId());
////                              }
////                            }
////                          }
////                        });
//                      }
//                    });
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


//AVQuery<AVObject> query = new AVQuery<>("Test");
//        query.setCachePolicy(AVQuery.CachePolicy.NETWORK_ELSE_CACHE);
//// 单位毫秒
//query.setMaxCacheAge(1000 * 60 * 60); // 一小时
//if (query.hasCachedResult()) {
//  System.out.println("---有本地缓存，无网络时将从本地获取---");
//} else {
//  System.out.println("--无本地缓存，将从服务器获取---");
//}
//query.countInBackground().subscribe(new Observer<Integer>() {
//  public void onSubscribe(Disposable disposable) {}
//  public void onNext(Integer count) {
//    System.out.println(count + " 个结果。");
//  }
//  public void onError(Throwable throwable) {}
//  public void onComplete() {}
//});
        // 创建实例
//        AVUser user = new AVUser();
//// 等同于 user.put("username", "Tom")
//        user.setUsername("Tom20210406");
//        user.setPassword("123");
//        user.setMobilePhoneNumber("+8618200001234 ");
//
//
//        user.signUpInBackground().subscribe(new Observer<AVUser>() {
//          public void onSubscribe(Disposable disposable) {}
//          public void onNext(AVUser user) {
//            // 注册成功
//            System.out.println("注册成功。objectId：" + user.getObjectId());
//          }
//          public void onError(Throwable throwable) {
//            // 注册失败（通常是因为用户名已被使用）
//          }
//          public void onComplete() {}
//        });


        AVQuery<AVObject> query = new AVQuery<>("Test");
// 获取最新发布的
        query.limit(10);
        query.whereEqualTo("address", "Smith");
//        query.findInBackground().subscribe(new Observer<List<AVObject>>() {

        query.getFirstInBackground().subscribe(new Observer<AVObject>() {
                                                 @Override
                                                 public void onSubscribe(Disposable d) {
                                                   System.out.println("onSubscribe");

                                                 }

                                                 @Override
                                                 public void onNext(AVObject avObject) {
                                                   System.out.println("onNext");
                                                   if(avObject == null){
                                                     System.out.println("null成功");
                                                   }
                                                 }

                                                 @Override
                                                 public void onError(Throwable e) {
                                                   System.out.println("onError"+ e.getMessage());
                                                 }
                                                 @Override
                                                 public void onComplete() {
                                                   System.out.println("onComplete");
                                                 }
//
//          public void onSubscribe(Disposable disposable) {
//            System.out.println("onSubscribe");
//
//          }          public void onNext(List<AVObject> todo) {
//            // todo 是第一个满足条件的 Todo 对象
//            System.out.println("onNext");
//            if(todo.size() == 0){
//              System.out.println("onNext==0");
//            }
//          }
//          public void onError(Throwable throwable) {
//           System.out.println("onError");
//          }
//          public void onComplete() {
//          System.out.println("onComplete");
//          }

      });
      }
    });
  }
}
