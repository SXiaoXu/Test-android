package com.example.myapplicationtest;

import java.util.List;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;

public class CustomConversationEventHandler extends AVIMConversationEventHandler {
        @Override
        public void onInvited(AVIMClient client, AVIMConversation conversation, String invitedBy) {
            System.out.println("client " + client.toString() + "邀请你的人："+invitedBy);
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

}
