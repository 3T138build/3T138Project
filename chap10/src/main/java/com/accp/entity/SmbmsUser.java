package com.accp.entity;

import java.util.Calendar;
import java.util.Date;
public class SmbmsUser {

  private Integer id;

  private String userCode;

  private String userName;

  private String userPassword;

  private Integer gender;
  private Date birthday;

  private String phone;
  private String address;

  private Integer userRole;

  private Integer createdBy;

  private Date creationDate;

  private Integer modifyBy;

  private Date modifyDate;

  private int age;

  private String idPicPath;
  private SmbmsRole smbmsRole;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getUserRole() {
    return userRole;
  }

  public void setUserRole(Integer userRole) {
    this.userRole = userRole;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Integer getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Integer modifyBy) {
    this.modifyBy = modifyBy;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public SmbmsRole getSmbmsRole() {
    return smbmsRole;
  }

  public void setSmbmsRole(SmbmsRole smbmsRole) {
    this.smbmsRole = smbmsRole;
  }

  public int getAge() {
    Calendar calendar=Calendar.getInstance();//获取当前时间
    calendar.get(Calendar.YEAR);//返回年

    Calendar aa=Calendar.getInstance();//设置出生年月
    aa.setTime(birthday);
    int age=calendar.get(Calendar.YEAR)-aa.get(Calendar.YEAR);//返回年
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getIdPicPath() {
    return idPicPath;
  }

  public void setIdPicPath(String idPicPath) {
    this.idPicPath = idPicPath;
  }

  @Override
  public String toString() {
    return "SmbmsUser{" +
            "id=" + id +
            ", userCode='" + userCode + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", gender=" + gender +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", userRole=" + userRole +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", age=" + age +
            ", idPicPath='" + idPicPath + '\'' +
            ", smbmsRole=" + smbmsRole +
            '}';
  }
}
