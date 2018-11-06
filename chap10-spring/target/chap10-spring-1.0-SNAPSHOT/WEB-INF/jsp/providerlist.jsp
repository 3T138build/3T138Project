
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
        	<form method="get" action="${pageContext.request.contextPath }providerlist">
				<input name="method" value="query" type="hidden">
				<span>供应商编码：</span>
				<input name="proCode" type="text" value="${proCode }">
				
				<span>供应商名称：</span>
				<input name="proName" type="text" value="${proName }">

				<input type="hidden" name="pageNo" value="1"/>
				<input value="查 询" type="submit" id="searchbutton">
				<a href="${pageContext.request.contextPath }doAddProvider">添加供应商</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${providerPager.datas}" var="p" >
				<tr>
					<td>
					<span>${p.proCode}</span>
					</td>
					<td>
					<span>${p.proName}</span>
					</td>
					<td>
					<span>${p.proContact}</span>
					</td>
					<td>
					<span>${p.proPhone}</span>
					</td>
					<td>
					<span>${p.proFax}</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${p.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewProvider" href="javascript:;" proid=${p.id } proname=${p.proName }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyProvider" href="javascript:;" proid=${p.id } proname=${p.proName }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                        <c:forEach items="${p.smbmsBillList}" var="s">
							<%--判断供应商下有子类--%>
							<c:if test="${s.id==null}">
								<span><a class="deleteProvider" href="javascript:;" proid=${p.id } proname=${p.proName }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
							</c:if>
						</c:forEach>

					</td>
				</tr>
			</c:forEach>
        </table>
	<input type="hidden" id="totalPageCount" value="${providerPager.totalPage}"/>
	<c:import url="provpage.jsp"></c:import>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/providerlist.js"></script>
