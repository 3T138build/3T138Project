package com.accp.service;

import com.accp.entity.SmbmsRole;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 17:09 2018/10/9
 * @Modified By:
 */
public interface SmbmsRoleService {
    //查询所有角色
    List<SmbmsRole> queryroleList(SmbmsRole smbmsRole);

}
