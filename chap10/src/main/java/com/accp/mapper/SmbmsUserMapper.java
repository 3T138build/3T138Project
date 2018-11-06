package com.accp.mapper;

import com.accp.entity.SmbmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 15:02 2018/10/9
 * @Modified By:
 */

public interface SmbmsUserMapper {
    //用户登陆
    SmbmsUser queryLoginUser(@Param("userCode") String userCode,
                        @Param("userPassword") String userPassword);

    //查询总行数
    int countUser(@Param("smbmsUser") SmbmsUser smbmsUser);
    //查询所有用户
    List<SmbmsUser> queryUser(@Param("smbmsUser") SmbmsUser smbmsUser,
                              @Param("pageNo") int pageNo,
                              @Param("pageSize") int pageSize);
    //用户详情
    SmbmsUser viewUser(Integer id);
    //查询用户编码
    SmbmsUser queyuserCode(@Param("userCode") String userCode,
                           @Param("userPassword") String userPassword,
                           @Param("id") Integer id);
    //新增用户
    int insertUser(SmbmsUser smbmsUser);
    //删除用户
    int deleteUser(@Param("id") Integer uid);
    //修改用户
    int updateUser(SmbmsUser smbmsUser);
}
