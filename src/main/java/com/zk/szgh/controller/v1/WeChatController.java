package com.zk.szgh.controller.v1;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zk.szgh.annotation.PassToken;
import com.zk.szgh.bean.vo.LoginUser;
import com.zk.szgh.utils.HttpClientUtil;
import com.zk.szgh.utils.StringUtils;
import com.zk.szgh.utils.json.JsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WeChatController
 * @Description TODO
 * @Date 2020/8/27 10:41 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WeChatController @see support-api
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    Logger log = LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private WxMaService wxMaService;

    /**
     * 登陆验证工作
     */

    @PostMapping("/login")
    @PassToken
    public void login(@RequestBody LoginUser loginUser){
        String s = JsonUtil.toJson(loginUser);
        System.out.println(s);
        if (StringUtils.isBlank(loginUser.getCode())){
            new RuntimeException("Code 不能为空");
        }
        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(loginUser.getCode());
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            // 用户信息校验
            if (!wxMaService.getUserService().checkUserInfo(session.getSessionKey(), loginUser.getRawData(), loginUser.getSignature())) {
                return ;
            }
            WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(session.getSessionKey(), loginUser.getEncrypteData(), loginUser.getIv());
            System.out.println(userInfo.getNickName());
            System.out.println(userInfo.getOpenId());
            System.out.println(userInfo.getCity());
            //可以在下面加入其他逻辑
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

//    @PostMapping("/login")
//    @PassToken
//    public void login(String code){
//        if (StringUtils.isBlank(code)){
//            new RuntimeException("Code 不能为空");
//        }
//        try {
//            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
//            log.info(session.getSessionKey());
//            log.info(session.getOpenid());
//            //可以在下面加入其他逻辑
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * 获取用户信息
     */
    @GetMapping("/info")
    public String info(String sessionKey,String signature, String rawData, String encryptedData, String iv) {
        // 用户信息校验
        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }
        // 解密用户信息
        WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return "OK";
    }

    @GetMapping("/phone")
    public String phone(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        // 用户信息校验
        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        return "OK";
    }


}
