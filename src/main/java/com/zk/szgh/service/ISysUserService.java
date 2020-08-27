package com.zk.szgh.service;

import com.github.pagehelper.PageInfo;
import com.zk.szgh.dao.domain.SysUser;

/**
 * @Classname ISysUserService
 * @Description TODO
 * @Date 2020/8/21 3:35 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ISysUserService @see support-api
 */
public interface ISysUserService {
    public SysUser findByUsername(String username);

    public SysUser findUserById(String id);

    public PageInfo<SysUser> getAllUser(Integer offset,Integer limit);
}
