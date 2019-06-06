package com.karat.cn.common.jiguang;

import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.message.MessageListResult;
import cn.jmessage.api.user.UserListResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 极光im 即时聊天 java服务器端工具类
 * https://docs.jiguang.cn/jmessage/server/rest_api_im/
 * zmh 2018-11-15 14:34:25
 */
public class JimUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(JimUtils.class);

    // 需要先去极光申请注册极光IM，获取appkey和masterSecret
    private static final String appkey = "";
    private static final String masterSecret = "";

    /** 注册用户 */
    public static Map<String,Object> registerUsers(String username,String password,String nickname) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            // username和password的长度限制在 4 ~ 128 位
            if(StringUtils.isBlank(username) || StringUtils.isBlank(password)
                    || username.length() < 4 || username.length() > 128
                    || password.length() < 4 || password.length() > 128){
                result.put("code",500);
                result.put("message","用户名或密码不合法");
                return result;
            }

            List<RegisterInfo> users = new ArrayList<>();
            RegisterInfo user = RegisterInfo.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setNickname(nickname)
                    .build();
            users.add(user);
            RegisterInfo[] regUsers = new RegisterInfo[users.size()];
            String res = client.registerUsers(users.toArray(regUsers));
            result.put("code",0);
            result.put("message","success");
            LOG.info(res);
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }


    /** 获取所有用户列表 */
    public static Map<String,Object> getAllUsers(Integer start,Integer end) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            UserListResult userList = client.getUserList(start, end);
            result.put("code",0);
            result.put("userList",userList);
            LOG.info("success");
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }

    /** 更新昵称 */
    public static Map<String,Object> changeNickname(String username,String nickname) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            if(StringUtils.isBlank(username)
                    || username.length() < 4 || username.length() > 128){
                result.put("code",500);
                result.put("message","用户名不合法");
                return result;
            }
            client.updateUserInfo(username,nickname,null,null,0,null,null,null);
            result.put("code",0);
            result.put("message","success");
            LOG.info("success");
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }


    /** 删除用户 */
    public static Map<String,Object> deleteUser(String username) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            if(StringUtils.isBlank(username)
                    || username.length() < 4 || username.length() > 128){
                result.put("code",500);
                result.put("message","用户名不合法");
                return result;
            }
            client.deleteUser(username);
            result.put("code",0);
            result.put("message","success");
            LOG.info("success");
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }

    /** 禁用/启用 用户,1启用 0禁用 */
    public static Map<String,Object> forbidUser(String username,Integer disable) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            ResponseWrapper res = client.forbidUser(username, disable == 0);
            result.put("code",0);
            result.put("message","success");
            LOG.info("response code: " + res.responseCode);
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }



    /** 获取用户聊天记录 时间格式 yyyy-MM-dd HH:mm:ss */
    public static Map<String,Object> getUserMessages(String username,Integer count,String beginTime,String endTime) {
        Map<String,Object> result = new HashMap<>();
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            MessageListResult userMessages = client.getUserMessages(username, count, beginTime, endTime);
            result.put("code",0);
            result.put("userMessages",userMessages);
            LOG.info("success");
        } catch (APIConnectionException e) {
            result.put("code",500);
            result.put("message",e);
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            result.put("code",600);
            result.put("message",e.getErrorMessage());
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(registerUsers("username","password","nickname"));
        // System.out.println(getAllUsers(0,1000));
        // System.out.println(changeNickname("username","nickname"));
        // System.out.println(deleteUser("username"));
        // System.out.println(forbidUser("username",0));
        // System.out.println(getUserMessages("username",1000,"2018-01-01 00:00:00","2018-12-31 23:59:59"));
    }
}
