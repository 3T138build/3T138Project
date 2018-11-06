package com.accp.service;

import com.accp.entity.Pager;
import com.accp.entity.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 9:12 2018/10/11
 * @Modified By:
 */

public interface SmbmsBillService {
    Pager<SmbmsBill> billList(@Param("smbmsBill") SmbmsBill smbmsBill,
                              @Param("pageNo") int pageNo,
                              @Param("pageSize") int pageSize);
    SmbmsBill viewBill(@Param("id") Integer id);
    Integer deleBill(@Param("id") Integer id);
    boolean insertBill(SmbmsBill smbmsBill);
    //修改订单
    boolean updateBill(SmbmsBill smbmsBill);
}
