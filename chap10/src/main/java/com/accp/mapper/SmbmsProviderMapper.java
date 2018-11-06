package com.accp.mapper;

import com.accp.entity.SmbmsProvider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 10:31 2018/10/11
 * @Modified By:
 */

public interface SmbmsProviderMapper {
     //查询供应商总数
     int providerCount(@Param("smbmsProvider") SmbmsProvider smbmsProvider);
     //查询供应商
    List<SmbmsProvider> providerList(@Param("smbmsProvider") SmbmsProvider smbmsProvider,
                                     @Param("pageNo") int pageNo,
                                     @Param("pageSize") int pageSize);
    //ajax查询供应商
     List<SmbmsProvider> ProviderContactAjax();
    //供应商详情
     SmbmsProvider providerView(@Param("id") Integer id);
    //删除供应商
    int deleteProvider(@Param("id") Integer id);
    //增加供应商
     int insertProvder(SmbmsProvider smbmsProvider);
     //修改供应商
     int updateProvder(SmbmsProvider smbmsProvider);
     //查询供应商下的订单
     SmbmsProvider providerChild(@Param("id") int id);
}
