package com.accp.service;

import com.accp.entity.Pager;
import com.accp.entity.SmbmsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 15:55 2018/10/9
 * @Modified By:
 */
public interface SmbmsUserService {
    //用户登陆
    SmbmsUser queryLoginUser(@Param("userCode") String userCode,
                        @Param("userPassword") String userPassword);

    //查询所有用户
    Pager<SmbmsUser> queryUser(@Param("smbmsUser") SmbmsUser smbmsUser,
                               @Param("pageNo") int pageNo,
                               @Param("pageSize") int pageSize);
    //用户详情
    SmbmsUser viewUser(Integer id);
    //查询用户编码
    String queyuserCode(@Param("userCode") String userCode,
                        @Param("userPassword") String userPassword,
                        @Param("id") Integer id);
    //新增用户
    String insertUser(SmbmsUser smbmsUser, HttpServletRequest request, MultipartFile attach);
    //删除用户
    Integer deleteUser(@Param("id") Integer uid);
    //修改用户
    boolean updateUser(SmbmsUser smbmsUser);

}


