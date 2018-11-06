package com.accp.controller;

import com.accp.entity.Pager;
import com.accp.entity.SmbmsRole;
import com.accp.entity.SmbmsUser;
import com.accp.service.SmbmsRoleService;
import com.accp.service.SmbmsUserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 ** 功能描述：
 *
 * @Author: xiaoke
 * @Date:2018/10/19 10:11
 * @Description:
 */

@Controller
public class SmbmsUserController {

     @Resource
      public SmbmsUserService smbmsUserService;
     @Resource
      public SmbmsRoleService smbmsRoleService;

    //登录
    @RequestMapping("/login")
    public String login(String userCode, String userPassword, HttpSession session){
        SmbmsUser smbmsUser = smbmsUserService.queryLoginUser(userCode,userPassword);

         if(smbmsUser!=null){
            smbmsUser.setUserPassword(null);//密码清除
            session.setAttribute("smbmsUser",smbmsUser);//存用户在session
            return "redirect:userlist";//路径重定向到userlist
        }
        return "redirect:login.jsp";
    }

     //查询用户
      @RequestMapping("/userlist")
     public String userlist(SmbmsUser smbmsUser, SmbmsRole smbmsRole,
                            @RequestParam(defaultValue = "1") Integer pageNo,
                            @RequestParam(defaultValue = "5") Integer pageSize, HttpServletRequest request){

          Pager<SmbmsUser>  userPager= smbmsUserService.queryUser(smbmsUser,pageNo,pageSize);
          List<SmbmsRole> roleList= smbmsRoleService.queryroleList(smbmsRole);
          request.setAttribute("userPager",userPager);
          request.setAttribute("userName",smbmsUser.getUserName());
          request.setAttribute("userRole",smbmsUser.getUserRole());
          request.setAttribute("roleList",roleList);
        return "userlist";
      }

      //跳转添加用户
      @RequestMapping("/doUser")
      public String doUser(@ModelAttribute("flg") String msg, Model model){
          //拿到重定向得到的参数uploadFileError
          //保存到request请求域
          model.addAttribute("uploadFileError", msg);

        return "useradd";
      }

      //添加用户
       @RequestMapping("/userSave")
       public String userAdd(SmbmsUser smbmsUser, HttpServletRequest request,
                             @RequestParam(value="a_idPicPath",required = false)MultipartFile attach,
                             RedirectAttributes model){
         String flg=smbmsUserService.insertUser(smbmsUser,request,attach);
           if(flg==null){
               return "redirect:userlist";
           }
           //addFlashAttribute方法会把参数值暂存于session，待重定向URL获取该参数后从session中移除
           model.addFlashAttribute("flg",flg);

        return "redirect:doUser";//重定向到doUser
       }

    //Ajax查询用户编号
    @RequestMapping("/userCodeajax")
    @ResponseBody
    public Object queyUserCode(@RequestParam String userCode){
        String json=null;
        if(userCode!=null && !userCode.equals("")){
             json=smbmsUserService.queyuserCode(userCode,null,null);
         }
          if(userCode.equals("")){
              json="";
          }
        return JSON.toJSONString(json);
    }

    //Ajax查询角色
    @RequestMapping(value = "/roleajax")
    @ResponseBody
    public Object RoleListAjax(){

        List<SmbmsRole> json=smbmsRoleService.queryroleList(null);
        return JSON.toJSONString(json);
    }

    //查询用户详情
    @RequestMapping("/queyUserView")
      public String queyUserView(Integer id,HttpServletRequest request){

       SmbmsUser smbmsUser= smbmsUserService.viewUser(id);
       request.setAttribute("smbmsUser",smbmsUser);
        return "userview";
      }

    //Ajax删除用户
    @ResponseBody
    @RequestMapping("/deleteUser")
    public Object deleteUser(Integer uid){

        return JSON.toJSONString(smbmsUserService.deleteUser(uid));
    }
    //查询修改用户信息
    @RequestMapping("/queyUserView2")
    public String queyUserView2(Integer id,HttpServletRequest request){

        SmbmsUser smbmsUser= smbmsUserService.viewUser(id);
        request.setAttribute("smbmsUser",smbmsUser);
        return "usermodify";
    }

    //修改用户
    @RequestMapping("/updateUser")
    public String updateUser(SmbmsUser smbmsUser){

        if(smbmsUserService.updateUser(smbmsUser)){
            return "redirect:userlist";
        }
        return "usermodify";
    }

     //跳转到修改用户密码
     @RequestMapping("/doUpdateUserPwd")
      public String doUpdateUserPwd(){

        return "pwdmodify";
      }
      @RequestMapping("/pwdAjax")
      @ResponseBody
      public Object pwdAjax(Integer uid,String oldpassword){
          String s = smbmsUserService.queyuserCode(null, oldpassword, uid);
          return JSON.toJSONString(s);
      }


      //修改密码
     @RequestMapping("/updateUserPwd")
      public String updateUserPwd(SmbmsUser smbmsUser){
         if(smbmsUserService.updateUser(smbmsUser)){
             return "redirect:userlist";
         }
        return "redirect:doUpdateUserPwd";
      }

      @RequestMapping("/loginto")
     public String login(HttpSession session){

        session.removeAttribute("smbmsUser");//清除会话信息
        return "redirect:login.jsp";
}
}
