<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${smbmsUser.userCode }</span></p>
            <p><strong>用户名称：</strong><span>${smbmsUser.userName }</span></p>
            <p><strong>用户性别：</strong>
            	<span>
            		<c:if test="${smbmsUser.gender == 1 }">男</c:if>
					<c:if test="${smbmsUser.gender == 2 }">女</c:if>
				</span>
			</p>
            <p><strong>出生日期：</strong><span><fmt:formatDate value='${smbmsUser.birthday}' pattern='yyyy-MM-dd '/></span></p>
            <p><strong>用户电话：</strong><span>${smbmsUser.phone }</span></p>
            <p><strong>用户地址：</strong><span>${smbmsUser.address }</span></p>
            <p><strong>用户角色：</strong><span>${smbmsUser.smbmsRole.roleName}</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userview.js"></script>
<%--
<script>
       $.getJSON("userview.action",function (data) {
      if(data!=null){
      var xxx="<div class='providerView'>"+
           "<p><strong>用户编号：</strong><span>"+data[0].userCode+"</span></p>"+
          "<p><strong>用户名称：</strong><span>"+data[0].userName+"</span></p>"+
          "<p><strong>用户性别：</strong>"+
          "<span>"+
          "<c:if test='data[0].gender==1'>男</c:if>"+
          "<c:if test='data[0].gender==2'>女</c:if>"+
          "</span>"+
          "</p>"+
          "<p><strong>出生日期：</strong><span>"+data[0].birthday+"</span></p>"+
          "<p><strong>用户电话：</strong><span>"+data[0].phone+"</span></p>"+
          "<p><strong>用户地址：</strong><span>"+data[0].address+"</span></p>"+
          "<p><strong>用户角色：</strong><span>"+data[0].userRoleName+"</span></p>"+
          "<div class='providerAddBtn'>"+
          "    <input type='button' id='back' name='back' value='返回' >"+
          "    </div>"+
          "    </div>"
          $(".right").append(xxx);
      }

       });


</script>--%>
