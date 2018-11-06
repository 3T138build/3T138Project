
package com.accp.service.impl;

import com.accp.entity.SmbmsRole;
import com.accp.mapper.SmbmsRoleMapper;
import com.accp.service.SmbmsRoleService;
import com.accp.util.MybatiUtil;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 17:10 2018/10/9
 * @Modified By:
 */


@Service("smbmsRoleService")
public class SmbmsRoleServiceImpl implements SmbmsRoleService {

    @Resource
    private SmbmsRoleMapper smbmsRoleMapper;

    public List<SmbmsRole> queryroleList(SmbmsRole smbmsRole) {
         List<SmbmsRole> smbmsRoles = smbmsRoleMapper.queryroleList(smbmsRole);

        return smbmsRoles;
    }


}


