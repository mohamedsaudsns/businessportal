<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div id="sidebar" class="nav-collapse ">
	<!-- sidebar menu start-->
	<ul class="sidebar-menu" id="nav-accordion">
<c:forEach items="${requestScope.menuAccess}" var="menu">  
<%--  <c:out value="${menu.menuAccessName}"/> --%>


<%--     <c:out value="${menu.id.menuId}"/><p>   --%>

<li class="mt" style="display: none"><input type="hidden" value="1"><a id="<c:out value="${menu.menuAccessValue}"/>" href="<c:out value="${menu.menuAccessValue}"/>?roleId=<c:out value="${menu.roleId}"/>" title="<c:out value="${menu.menuAccessName}"/>">
 <i class="fa fa-chevron-circle-right" style="
    color: #fae700;
" ></i> 
<!-- 				class="fa fa-arrow-right" ></i>  -->
				
				
				<span><c:out value="${menu.menuAccessName}"/></span>
		</a></li>

<%-- <c:if test="${menu.id.menuId==1}">   --%>
<!-- 		<li class="mt" style="display: none"><input type="hidden" value="1"><a id="VendorDetails" href="VendorDetails"> <i -->
<!-- 				class="fa fa-user"></i> <span>Vendor Profile</span> -->
<!-- 		</a></li> -->
<%-- 	</c:if>   --%>
	
<%-- 	<c:if test="${menu.id.menuId==2}">   --%>
<!-- 		<li class="mt" style="display: none"><input type="hidden" value="2"><a id="CustomerDetails" href="CustomerDetails"> <i -->
<!-- 				class="fa fa-user"></i> <span>Customer Profile</span> -->
<!-- 		</a></li> -->
<%-- 			</c:if>   --%>
<%-- 		<c:if test="${menu.id.menuId==3}">   --%>
<!-- 		<li class="mt" style="display: none"><input type="hidden" value="3"><a id="OutstandingReport" href="OutstandingReport"> <i -->
<!-- 				class="fa fa-cogs"></i> <span>Account Payable Report</span> -->
<!-- 		</a></li>	 -->
<%-- 			</c:if>   --%>
<%-- 		<c:if test="${menu.id.menuId==4}">   --%>
<!-- 			<li class="mt" style="display: none"><input type="hidden" value="4"><a id="CustomerOutstandingReport" href="CustomerOutstandingReport"> <i -->
<!-- 				class="fa fa-cogs"></i> <span>Account Receivable Report</span> -->
<!-- 		</a></li>	 -->
<%-- 			</c:if>  		 --%>
</c:forEach>  
	</ul>
	<!-- sidebar menu end-->
</div>