package com.zk.szgh.controller.v1;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import com.zk.szgh.annotation.PassToken;
import com.zk.szgh.config.properties.WxMaConfiguration;
import com.zk.szgh.utils.StringUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * @Classname WeChatController
 * @Description TODO
 * @Date 2020/8/27 10:41 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WeChatController @see support-api
 */
@RestController("/wechat")
public class WeChatController {

    Logger log = LoggerFactory.getLogger(WeChatController.class);


    @Autowired
    private WxMaService wxMaService;

    /**
     * 登陆验证工作
     * @param code
     */
    @PostMapping("/login")
    public void login(String code){
        if (StringUtils.isBlank(code)){
            new RuntimeException("Code 不能为空");
        }
        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //可以在下面加入其他逻辑
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
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
