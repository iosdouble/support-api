package com.zk.szgh.controller.v1;

import com.alibaba.fastjson.JSONObject;
import com.zk.szgh.config.accesstoken.AccessToken;
import com.zk.szgh.config.accesstoken.WeixinGetToken;
import com.zk.szgh.utils.HttpUtil;
import com.zk.szgh.utils.SHA1Util;
import com.zk.szgh.utils.Sha1;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/8/31 11:43 AM
 * @Created by nihui
 * @Version 1.0
 * @Description LoginController @see support-api
 */
@RestController
public class LoginController {
    @Autowired
    private WxMpCardService wxMpCardService;

    @Autowired
    private WeixinGetToken weixinGetToken;

    @GetMapping("/getTicket")
    public String test(){
        try {
//            String cardApiTicket = wxMpCardService.getCardApiTicket();
            String cardApiTicket = getApiTicket();
            Map  map = new HashMap();
            map.put("api_ticket",cardApiTicket);
//            map.put("card_id","pWHBzs2CiTipjFD91Om97baKJEJ8");
            map.put("nonce_str","sadfajdksfa;ldkfj");
            map.put("timestamp",1598457600);
            String s = Sha1.SHA1(map);
            return s;
        } catch (DigestException e) {
            e.printStackTrace();
        }
        return "";
    }
//    @GetMapping("/apiTicket")
    public String getApiTicket(){
        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+token.getAccess_token()+"&type=wx_card";
        String s = HttpUtil.doGet(url);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Object ticket = jsonObject.get("ticket");
        System.out.println(ticket);
        return (String) ticket;
    }
}
