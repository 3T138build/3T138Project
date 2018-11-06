package com.accp.controller;


import com.accp.entity.Pager;
import com.accp.entity.SmbmsBill;
import com.accp.entity.SmbmsProvider;
import com.accp.service.SmbmsBillService;
import com.accp.service.SmbmsProviderService;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 功能描述：
 *
 * @Author: xiaoke
 * @Date:2018/10/19 16:50
 * @Description:
 */

@Controller
public class SmbmsBillController {

      @Resource
       private SmbmsBillService smbmsBillService;
       @Resource
       private SmbmsProviderService smbmsProviderService;

       //订单查询
      @RequestMapping("/billlist")
       public String billList(SmbmsBill smbmsBill, SmbmsProvider smbmsProvider,
                              @RequestParam(defaultValue = "1") Integer pageNo,
                              @RequestParam(defaultValue = "5") Integer pageSize,
                              HttpServletRequest request){
          Pager<SmbmsBill> billPager = smbmsBillService.billList(smbmsBill, pageNo, pageSize);
          Pager<SmbmsProvider> providerPager = smbmsProviderService.providerList(smbmsProvider, 1, 99999);
          request.setAttribute("billPager",billPager);
          request.setAttribute("providerPager",providerPager);
          request.setAttribute("providerId",smbmsBill.getProviderId());
           request.setAttribute("productName",smbmsBill.getProductName());
           request.setAttribute("isPayment",smbmsBill.getIsPayment());
          return "billlist";
       }

       //供应商查询
        @RequestMapping("/providerlist")
        public String providerList(SmbmsProvider smbmsProvider,
                                    @RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "5") Integer pageSize,
                                     HttpServletRequest request){
            Pager<SmbmsProvider> providerPager = smbmsProviderService.providerList(smbmsProvider,pageNo,pageSize);
             request.setAttribute("providerPager",providerPager);
             request.setAttribute("proCode",smbmsProvider.getProCode());
             request.setAttribute("proName",smbmsProvider.getProName());
            return "providerlist";
        }
       //订单详情
       @RequestMapping("/billView")
       public String billView(Integer id, HttpServletRequest request){
           SmbmsBill smbmsBill = smbmsBillService.viewBill(id);
           request.setAttribute("smbmsBill",smbmsBill);
           return "billview";
       }

      //删除订单
    @ResponseBody
    @RequestMapping("/deleteBill")
      public Object deleteBill(Integer billid){

          return JSON.toJSONString(smbmsBillService.deleBill(billid));
      }

      //AJax查询供应商
      @RequestMapping("/providerAjax")
      @ResponseBody
      public Object providerAjax(){
          List<SmbmsProvider> smbmsProviders = smbmsProviderService.ProviderContactAjax();
          return JSON.toJSONString(smbmsProviders);
      }

      //准备跳转到添加用户
    @RequestMapping("/doBill")
    public String doBill(){

          return "billadd";
    }
       //添加用户
    @RequestMapping("/addBill")
     public String addBill(SmbmsBill smbmsBill){
         if(smbmsBillService.insertBill(smbmsBill)){
             return "redirect:billlist";
         }
         return "redirect:doBill";
     }

   //查询修改用户信息
    @RequestMapping("/doupdateBill")
      public String doupdateBill(Integer id,HttpServletRequest request){
          SmbmsBill smbmsBill = smbmsBillService.viewBill(id);
          request.setAttribute("smbmsBill",smbmsBill);
        return "billmodify";
      }

     //修改用户
     @RequestMapping("/updateBill")
    public String updateBill(SmbmsBill smbmsBill){
      if(smbmsBillService.updateBill(smbmsBill)){
          return "redirect:billlist";
      }
    return "redirect:doupdateBill";
     }

     //查询供应商详情
      @RequestMapping("/proView")
     public String providerView(Integer proid,HttpServletRequest request){
         SmbmsProvider smbmsProvider = smbmsProviderService.providerView(proid);
          request.setAttribute("smbmsProvider",smbmsProvider);
         return "providerview";
     }

     //准备跳转增加供应商
    @RequestMapping("/doAddProvider")
      public String doAddProvider(){

          return "provideradd";
      }
       //增加供应商
      @RequestMapping("/addProvider")
       public String addProvider(SmbmsProvider smbmsProvider){

          if(smbmsProviderService.insertProvder(smbmsProvider)){
              return "redirect:providerlist";
          }

          return "redirect:doAddProvider";
       }

       //跳到修改供应商页面
       @RequestMapping("/doUpdateProvider")
      public String doUpdateProvider(Integer proid,HttpServletRequest request){
           SmbmsProvider smbmsProvider = smbmsProviderService.providerView(proid);
              request.setAttribute("smbmsProvider",smbmsProvider);
           return "providermodify";
       }

       //修改供应商
      @RequestMapping("/updateProvider")
       public String updateProvider(SmbmsProvider smbmsProvider){

          if(smbmsProviderService.updateProvder(smbmsProvider)){
              return "redirect:providerlist";
          }

          return "redirect:doUpdateProvider";
       }

      //删除供应商
        @RequestMapping("/deleteProvider")
        @ResponseBody
        public Object deleteProvider(Integer proid){
            String json="";
            SmbmsProvider smbmsProvider = smbmsProviderService.providerChild(proid);
            if(smbmsProvider.getSmbmsBillList().get(0).getId()==null){
                json = smbmsProviderService.deleteProvider(proid);//1
                json="0";
            }else{
                json=String.valueOf(smbmsProvider.getSmbmsBillList().size());
            }
          return JSON.toJSONString(json);
        }
}

