package com.zk.szgh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zk.szgh.dao.domain.SysUser;
import com.zk.szgh.dao.domain.SysUserExample;
import com.zk.szgh.dao.mapper.SysUserMapper;
import com.zk.szgh.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysUserServiceImpl
 * @Description TODO
 * @Date 2020/8/21 3:35 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SysUserServiceImpl @see support-api
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findByUsername(String username) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers.size()>0){

        }
        return sysUsers.get(0);
    }

    @Override
    public SysUser findUserById(String id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(id));
        return sysUser;
    }

    @Override
    public PageInfo<SysUser> getAllUser(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset,limit);
        SysUserExample sysUserExample = new SysUserExample();
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return pageInfo;
    }

}
