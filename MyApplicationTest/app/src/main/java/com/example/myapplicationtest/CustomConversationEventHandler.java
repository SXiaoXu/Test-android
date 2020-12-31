package com.example.myapplicationtest;

import java.util.List;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;

public class CustomConversationEventHandler extends AVIMConversationEventHandler {
        @Override
        public void onInvited(AVIMClient client, AVIMConversation conversation, String invitedBy) {
            System.out.println("onInvited------- " +invitedBy);
        }
        @Override
        public void onMemberLeft(AVIMClient client, AVIMConversation conversation, List<String> members, String kickedBy) {
                System.out.println("onMemberLeft ------" +kickedBy);

        }
        @Override
        public void onMemberJoined(AVIMClient client, AVIMConversation conversation, List<String> members, String invitedBy) {
                System.out.println("onMemberJoined -----："+invitedBy);

        }
        @Override
        public void onKicked(AVIMClient client, AVIMConversation conversation, String kickedBy) {
                System.out.println("onKicked -----："+kickedBy);

        }

        @Override
        public void onBlocked(AVIMClient client, AVIMConversation conversation, String operator) {
                super.onBlocked(client, conversation, operator);
                System.out.println("onBlocked ----------: " + operator);

        }

        @Override
        public void onUnblocked(AVIMClient client, AVIMConversation conversation, String operator) {
                super.onUnblocked(client, conversation, operator);
                System.out.println("onUnblocked-------- : " + operator);

        }

        @Override
        public void onMemberBlocked(AVIMClient client, AVIMConversation conversation, List<String> members, String operator) {
                super.onMemberBlocked(client, conversation, members, operator);
                System.out.println("onMemberBlocked------- : " + operator);

        }

        @Override
        public void onMemberUnblocked(AVIMClient client, AVIMConversation conversation, List<String> members, String operator) {
                super.onMemberUnblocked(client, conversation, members, operator);
                System.out.println("onMemberUnblocked------- : " + operator);

        }
}
