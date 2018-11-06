package com.accp.service.impl;


import com.accp.entity.Pager;
import com.accp.entity.SmbmsBill;
import com.accp.mapper.SmbmsBillMapper;
import com.accp.service.SmbmsBillService;
import com.accp.util.MybatiUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/*
 **
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 9:12 2018/10/11
 * @Modified By:
*/



@Service("smbmsBillService")
public class SmbmsBillServiceImpl implements SmbmsBillService {

    @Resource
    private SmbmsBillMapper smbmsBillMapper;

    public Pager<SmbmsBill> billList(SmbmsBill smbmsBill, int pageNo, int pageSize) {

        int count = smbmsBillMapper.billCount(smbmsBill);
        Pager<SmbmsBill>billPager=new Pager<SmbmsBill>();
         billPager.setPageNo(pageNo);
         billPager.setPageSize(pageSize);
         billPager.setTotalRows(count);
         billPager.setTotalPage((billPager.getTotalRows()+pageSize-1)/pageSize);
        List<SmbmsBill> smbmsBills = smbmsBillMapper.billList(smbmsBill,(pageNo-1)*pageSize,pageSize);
         billPager.setDatas(smbmsBills);

        return billPager;
    }

    public SmbmsBill viewBill( Integer id) {

        SmbmsBill smbmsBill1 = smbmsBillMapper.viewBill(id);

        return smbmsBill1;
    }

    public Integer deleBill(Integer id) {

        return smbmsBillMapper.deleBill(id);
    }

    public boolean insertBill(SmbmsBill smbmsBill) {

       if(smbmsBillMapper.insertBill(smbmsBill)>0){
           return true;
       }
        return false;
    }

    public boolean updateBill(SmbmsBill smbmsBill) {

       if(smbmsBillMapper.updateBill(smbmsBill)>0){
           return true;
       }
        return false;
    }


}

