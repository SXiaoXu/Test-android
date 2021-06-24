//package com.example.myapplicationtest;
//
//import java.util.List;
//
//import cn.leancloud.im.v2.LCIMClient;
//import cn.leancloud.im.v2.LCIMConversation;
//import cn.leancloud.im.v2.LCIMConversationEventHandler;
//
//
//public class CustomConversationEventHandler extends LCIMConversationEventHandler {
//        @Override
//        public void onInvited(LCIMClient client, LCIMConversation conversation, String invitedBy) {
//            System.out.println("onInvited------- " +invitedBy);
//        }
//        @Override
//        public void onMemberLeft(LCIMClient client, LCIMConversation conversation, List<String> members, String kickedBy) {
//                System.out.println("onMemberLeft ------" +kickedBy);
//                System.out.println("members ------" +members.toString());
//                System.out.println("conversationm--members ------" +conversation.getMembers().toString());
//
//
//
//        }
//        @Override
//        public void onMemberJoined(LCIMClient client, LCIMConversation conversation, List<String> members, String invitedBy) {
//                System.out.println("onMemberJoined -----："+invitedBy);
//
//        }
//        @Override
//        public void onKicked(LCIMClient client, LCIMConversation conversation, String kickedBy) {
//                System.out.println("onKicked -----："+kickedBy);
//
//        }
//
//        @Override
//        public void onBlocked(LCIMClient client, LCIMConversation conversation, String operator) {
//                super.onBlocked(client, conversation, operator);
//                System.out.println("onBlocked ----------: " + operator);
//
//        }
//
//        @Override
//        public void onUnblocked(LCIMClient client, LCIMConversation conversation, String operator) {
//                super.onUnblocked(client, conversation, operator);
//                System.out.println("onUnblocked-------- : " + operator);
//
//        }
//
//        @Override
//        public void onMemberBlocked(LCIMClient client, LCIMConversation conversation, List<String> members, String operator) {
//                super.onMemberBlocked(client, conversation, members, operator);
//                System.out.println("onMemberBlocked------- : " + operator);
//
//        }
//
//        @Override
//        public void onMemberUnblocked(LCIMClient client, LCIMConversation conversation, List<String> members, String operator) {
//                super.onMemberUnblocked(client, conversation, members, operator);
//                System.out.println("onMemberUnblocked------- : " + operator);
//
//        }
//
//}
