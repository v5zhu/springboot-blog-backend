package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.PermissionDao;
import com.mfx.blog.dao.RolePermissionDao;
import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.modal.entity.RolePermissionDO;
import com.mfx.blog.service.PermissionService;
import com.mfx.blog.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertRolePermission(RolePermissionDO rolePermissionDO) {
        rolePermissionDao.insert(rolePermissionDO);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteById(Long roleId, Long permissionId) {
        Integer result = rolePermissionDao.deleteByPrimaryKey(roleId, permissionId);
        return result;
    }
}