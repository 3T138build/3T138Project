package com.accp.service.impl;

import com.accp.entity.Pager;
import com.accp.entity.SmbmsUser;
import com.accp.mapper.SmbmsUserMapper;
import com.accp.service.SmbmsUserService;
import com.accp.util.MybatiUtil;
//import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: xiaoke
 * @Description:
 * @Date: Created in 15:56 2018/10/9
 * @Modified By:
 */
@Service("smbmsUserService")
public class SmbmsUserServiceImpl implements SmbmsUserService {

    @Resource
     private SmbmsUserMapper smbmsUserMapper;

    public SmbmsUser queryLoginUser(String userCode,String userPassword) {

        SmbmsUser smbmsUser1 = smbmsUserMapper.queryLoginUser(userCode,userPassword);

        return smbmsUser1;
    }


    public Pager<SmbmsUser> queryUser( SmbmsUser smbmsUser,int pageNo,int pageSize) {

        int count = smbmsUserMapper.countUser(smbmsUser);//总行数
        Pager<SmbmsUser> userPager=new Pager<SmbmsUser>();
         userPager.setPageNo(pageNo);
         userPager.setPageSize(pageSize);
         userPager.setTotalRows(count);
         userPager.setTotalPage((userPager.getTotalRows()+pageSize-1)/pageSize);
        List<SmbmsUser> smbmsUsers = smbmsUserMapper.queryUser(smbmsUser,(pageNo-1)*pageSize,pageSize);
        //切割图片路径
       /* for(SmbmsUser s:smbmsUsers){
            if(s.getIdPicPath()!=null){//判断是否有图片
                String[] strarr= s.getIdPicPath().split("SNAPSHOT\\\\");
                s.setIdPicPath(strarr[1]);
            }
        }*/
        userPager.setDatas(smbmsUsers);

        return userPager;
    }

    public SmbmsUser viewUser(Integer id) {

        SmbmsUser smbmsview = smbmsUserMapper.viewUser(id);

        return smbmsview;
    }

    public String queyuserCode(String userCode,String userPassword,Integer id) {

        SmbmsUser smbmsUser = smbmsUserMapper.queyuserCode(userCode,userPassword,id);

        return JSON.toJSONString(smbmsUser);

    }

    public String insertUser(SmbmsUser smbmsUser, HttpServletRequest request, MultipartFile attach) {

        String idPicPath=null;
        String  flg=null;
        //判断文件是否为空
        if(!attach.isEmpty()){
            //定义上传目标路径
            String path=request.getSession().getServletContext().
                    getRealPath("images"+ File.separator+"uploadfiles");
            //获取原文件名
            String oldFileName=attach.getOriginalFilename();
            //获取文件名后缀
            String prefix= FilenameUtils.getExtension(oldFileName);
            //获取原文件大小
            int filesize=500000;
            if(attach.getSize()>filesize){
               // request.setAttribute("uploadFileError",);
                flg=" * 上传大小不得超过500k";
            }else if(prefix.equalsIgnoreCase("jpg")||
                    prefix.equalsIgnoreCase("png") ){
                //当前系统时间+随机数+"_Personal.jpg"
                String fileName=System.currentTimeMillis()
                        + RandomUtils.nextInt(1000000)+"_Personal.jpg";
                File targeFile=new File(path,fileName);
                if(!targeFile.exists()){//判断文件是否存在
                    targeFile.mkdirs(); //创建文件
                }
                try {
                    attach.transferTo(targeFile);
                } catch (IOException e) {
                    e.printStackTrace();
                   // request.setAttribute("uploadFileError"," * 上传失败");
                    flg=" * 上传失败";
                }
                /* idPicPath=path+File.separator+fileName;*/
                idPicPath="images\\uploadfiles"+File.separator+fileName;
            }else{
                //request.setAttribute("uploadFileError"," * 上传图片格式必须为jpg,png");
                flg=" * 上传图片格式必须为jpg,png";
            }

        }
        if(flg==null){
            smbmsUser.setIdPicPath(idPicPath);
            if(smbmsUserMapper.insertUser(smbmsUser)>0){
              return flg;
            }
        }
        return flg;
    }

    public Integer deleteUser(Integer uid) {

        return smbmsUserMapper.deleteUser(uid);
    }

    public boolean updateUser(SmbmsUser smbmsUser) {

        if(smbmsUserMapper.updateUser(smbmsUser)>0){

            return true;
        }
        return false;
    }


}
