package com.zk.szgh.controller.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zk.szgh.utils.HttpClientUtil;
import com.zk.szgh.utils.MD5Util;
import com.zk.szgh.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WeiWinLoginController
 * @Description TODO
 * @Date 2020/8/29 3:57 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeiWinLoginController @see support-api
 */
@RestController
public class WeiWinLoginController {
    private static final Logger logger = LoggerFactory.getLogger(WeiWinLoginController.class);

    @Value("mall.user.login.key")
    private String loginKey;

    @Autowired
    private RedisUtil redisUtil;



//
//    public JSONObject login(String token) {
//        // 获取用户 openid {"session_key":"jD6iMEg58WvpBP2LnDZlXQ==","openid":"orhZe5UPLD68g0aPcTk0FijhkOKc"}
//        JSONObject authInfo = null;
//        try {
//            authInfo = geuAuthInfo(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String openid = authInfo.getString("openid");
//
////        保存登陆信息
//
//        if (CollectionUtils.isEmpty(users) || users.size() != 1) {
//            // 用户第一次登陆
//            user = saveShoppingUser(openid);
//        } else {
//            // 第二次登陆
//            updateUserLastLoginTime(users.get(0));
//            user = users.get(0);
//        }
//
//        ShoppingUserEx userEx = new ShoppingUserEx();
//        BeanUtils.copyProperties(user, userEx);
//        userEx.setSessionKey(authInfo.getString("session_key"));
//        String tempToken = MD5Util.getMD5(openid + '-' + loginKey);
////        存缓存
//        redisUtil.set(tempToken, userEx);
//        JSONObject res = new JSONObject();
//        res.put("token",tempToken);
//        res.put("userinfo",user);
//        return res;
//    }
//
//    private void updateUserLastLoginTime(ShoppingUser shoppingUser) {
//        ShoppingUser record = new ShoppingUser();
//        record.setUserId(shoppingUser.getUserId());
//        record.setLoginLastTime(new Date());
//        mapper.updateByPrimaryKeySelective(record);
//    }
//
//    /**
//     * 用户第一次登陆 记录
//     *
//     * @param openid
//     */
//    private ShoppingUser saveShoppingUser(String openid) {
//        ShoppingUser user = new ShoppingUser();
//        user.setStatus(SystemConstant.YES);
//        user.setWxOpenid(openid);
//        user.setLoginLastTime(new Date());
//        user.setCreateTime(new Date());
//        mapper.insert(user);
//        return user;
//    }

    private JSONObject geuAuthInfo(String code) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("appid", "wxbe73ae03c5a67e77");
        params.put("secret", "c134e8c325808e2ee15c85a8fdfb26a1");
        params.put("grant_type", "authorization_code");
        params.put("js_code", code);
        String auth_url = "https://api.weixin.qq.com/sns/jscode2session";
        String authString = HttpClientUtil.doGet(auth_url, params);
        if (StringUtils.isEmpty(authString)) {
            throw new Exception("获取openid失败");
        }
        return JSON.parseObject(authString);
    }
}
