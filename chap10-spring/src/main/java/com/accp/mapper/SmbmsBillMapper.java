package com.accp.mapper;

import com.accp.entity.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 19:23 2018/10/10
 * @Modified By:
 */
public interface SmbmsBillMapper {
     int billCount(@Param("smbmsBill") SmbmsBill smbmsBill);
    List<SmbmsBill> billList(@Param("smbmsBill") SmbmsBill smbmsBill,
                             @Param("pageNo") int pageNo,
                             @Param("pageSize") int pageSize);
     //订单详情
     SmbmsBill viewBill(@Param("id") Integer id);
      //删除订单
     int deleBill(@Param("id") Integer id);
      //增加订单
     int insertBill(SmbmsBill smbmsBill);
     //修改订单
     int updateBill(SmbmsBill smbmsBill);
}
