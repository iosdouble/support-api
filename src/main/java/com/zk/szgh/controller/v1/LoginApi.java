package com.zk.szgh.controller.v1;

import com.github.pagehelper.PageInfo;
import com.zk.szgh.annotation.UserLoginToken;
import com.zk.szgh.bean.resp.ResultResp;
import com.zk.szgh.bean.vo.UserVo;
import com.zk.szgh.constant.ResultRespStatus;
import com.zk.szgh.dao.domain.SysUser;
import com.zk.szgh.service.ISysUserService;
import com.zk.szgh.service.impl.TokenService;
import com.zk.szgh.utils.ResultRespUtil;
import com.zk.szgh.utils.SecurityUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Classname LoginApi
 * @Description TODO
 * @Date 2020/8/21 3:34 PM
 * @Created by nihui
 * @Version 1.0
 * @Description LoginApi @see support-api
 */
@RestController
@RequestMapping("/api")
public class LoginApi {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private TokenService tokenService;

    //登录
    @ApiOperation(value = "用户登录获取Token接口")
    @PostMapping("/login")
    public ResultResp<Object> login(@RequestBody UserVo user){
        ResultResp resultResp = new ResultResp();
        SysUser userForBase = sysUserService.findByUsername(user.getUsername());
        if(userForBase==null){
            Exception exception = new Exception("用户不存在或密码错误");
            ResultResp<Object> objectResultResp = ResultRespUtil.doResultResp(exception, null);
            return objectResultResp;
        }else {
            if (!SecurityUtils.matchesPassword(user.getPassword(),userForBase.getPassword())){
                Exception exception = new Exception("用户名或密码错误");
                ResultResp<Object> objectResultResp = ResultRespUtil.doResultResp(exception, null);
                return objectResultResp;
            }else {
                String token = tokenService.getToken(userForBase);
                resultResp.setDate(new Date());
                resultResp.setStatus(ResultRespStatus.NORMAL);
                resultResp.setResponse(token);
                return resultResp;
            }
        }
    }

    @ApiOperation(value = "获取所有用户列表信息")
    @GetMapping("/getUserList")
    @UserLoginToken
    public ResultResp<PageInfo<SysUser>> pageInfoResultResp(){
        ResultResp resultResp = new ResultResp();
        resultResp.setDate(new Date());
        resultResp.setStatus(ResultRespStatus.NORMAL);
        PageInfo<SysUser> allUser = sysUserService.getAllUser(0, 5);
        resultResp.setResponse(allUser);
        return resultResp;
    }

}
