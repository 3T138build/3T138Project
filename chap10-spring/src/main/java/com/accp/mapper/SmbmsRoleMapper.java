package com.accp.mapper;

import com.accp.entity.SmbmsRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 17:06 2018/10/9
 * @Modified By:
 */

public interface SmbmsRoleMapper {

    List<SmbmsRole> queryroleList(SmbmsRole smbmsRole);

}
