package com.example.myapplicationtest;

import java.util.List;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.json.JSONObject;

public class CustomConversationEventHandler extends AVIMConversationEventHandler {
        @Override
        public void onInvited(AVIMClient client, AVIMConversation conversation, String invitedBy) {
            // 当前 clientId（Jerry）被邀请到对话，执行此处逻辑
        }

        @Override
        public void onMemberLeft(AVIMClient client, AVIMConversation conversation, List<String> members, String kickedBy) {

        }

        @Override
        public void onMemberJoined(AVIMClient client, AVIMConversation conversation, List<String> members, String invitedBy) {

        }

        @Override
        public void onKicked(AVIMClient client, AVIMConversation conversation, String kickedBy) {

        }

    @Override
    public void onInfoChanged(AVIMClient client, AVIMConversation conversation, JSONObject attr, String operator) {
        super.onInfoChanged(client, conversation, attr, operator);

        System.out.println("conversation: " + conversation.getConversationId() );
        System.out.println("client " + client.toString());
        System.out.println("attr " + attr.toString());
    }
}
