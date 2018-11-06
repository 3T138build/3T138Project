package com.accp.service;

import com.accp.entity.Pager;
import com.accp.entity.SmbmsProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 10:33 2018/10/11
 * @Modified By:
 */
public interface SmbmsProviderService {


    Pager<SmbmsProvider> providerList(@Param("smbmsProvider") SmbmsProvider smbmsProvider,
                                      @Param("pageNo") int pageNo,
                                      @Param("pageSize") int pageSize);

    //ajax查询供应商
    List<SmbmsProvider> ProviderContactAjax();

    //供应商详情
    SmbmsProvider providerView(@Param("id") Integer id);
    //删除供应商
    String deleteProvider(@Param("id") Integer id);
    //增加供应商
    boolean insertProvder(SmbmsProvider smbmsProvider);
    //修改供应商
    boolean updateProvder(SmbmsProvider smbmsProvider);
    //查询供应商下的订单
    SmbmsProvider providerChild(@Param("id") int id);

}
