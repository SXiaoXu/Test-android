package com.example.myapplicationtest;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;

public class LCIMConversationHandler extends AVIMConversationEventHandler {

    /**
     * Created by wli on 15/12/1.
     * 和 Conversation 相关的事件的 handler
     * 需要应用主动调用  AVIMMessageManager.setConversationEventHandler
     * 关于回调会何时执行可以参见 https://leancloud.cn/docs/realtime_guide-android.html#添加其他成员
     */
        private static LCIMConversationHandler eventHandler;

        public static synchronized LCIMConversationHandler getInstance() {
            if (null == eventHandler) {
                eventHandler = new LCIMConversationHandler();
            }
            return eventHandler;
        }

        private LCIMConversationHandler() {
        }

        @Override
        public void onUnreadMessagesCountUpdated(AVIMClient client, AVIMConversation conversation) {
            System.out.println("conversation111 " + " updated!");
            System.out.println("conversation111： " + conversation.getUnreadMessagesCount());
        }

        @Override
        public void onLastDeliveredAtUpdated(AVIMClient client, AVIMConversation conversation) {
//            LCIMConversationReadStatusEvent event = new LCIMConversationReadStatusEvent();
//            event.conversationId = conversation.getConversationId();
//            EventBus.getDefault().post(event);
        }

        @Override
        public void onLastReadAtUpdated(AVIMClient client, AVIMConversation conversation) {
//            LCIMConversationReadStatusEvent event = new LCIMConversationReadStatusEvent();
//            event.conversationId = conversation.getConversationId();
//            EventBus.getDefault().post(event);
        }

        @Override
        public void onMemberLeft(AVIMClient client, AVIMConversation conversation, List<String> members, String kickedBy) {
            // 因为不同用户需求不同，此处暂不做默认处理，如有需要，用户可以通过自定义 Handler 实现
        }

        @Override
        public void onMemberJoined(AVIMClient client, AVIMConversation conversation, List<String> members, String invitedBy) {
        }

        @Override
        public void onKicked(AVIMClient client, AVIMConversation conversation, String kickedBy) {
        }

        @Override
        public void onInvited(AVIMClient client, AVIMConversation conversation, String operator) {
        }

        @Override
        public void onMessageRecalled(AVIMClient client, AVIMConversation conversation, AVIMMessage message) {
//            EventBus.getDefault().post(new LCIMMessageUpdatedEvent(message));
        }

        @Override
        public void onMessageUpdated(AVIMClient client, AVIMConversation conversation, AVIMMessage message) {
//            LCIMLogUtils.d("message " + message.getMessageId() + " updated!");
//            EventBus.getDefault().post(new LCIMMessageUpdatedEvent(message));

            // convs 就是想要的结果//即该 conversation 的未读消息数量
//            System.out.println("messagemessage " + message.getMessageId() + " updated!");
//            System.out.println("messagemessage " + message.getMessageId() + " updated!"+ conversation.getUnreadMessagesCount());
        }
    @Override
    public void onInfoChanged(AVIMClient client, AVIMConversation conversation, JSONObject attr, String operator) {
        super.onInfoChanged(client, conversation, attr, operator);
            System.out.println("conversation: " + conversation.getConversationId() );
            System.out.println("client " + client.toString());
            System.out.println("attr " + attr.toString());
    }
}