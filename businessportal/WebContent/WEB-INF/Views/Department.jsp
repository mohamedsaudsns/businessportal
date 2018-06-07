<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<ul id="myTab" class="nav nav-tabs">

	<c:set var="count" value="0" scope="page" />




	<c:forEach items="${requestScope.departmentAccess}" var="department"
		varStatus="status">


		<c:if test="${ department.displayflag == 'true' }">


			<c:set var="count" value="${count + 1}" scope="page" />
			<c:choose>

				<c:when test="${count==1}">
					<li class="active"><a
						href="<c:out value="${department.departmentAccessId}"/>"
						data-toggle="tab"> <c:out
								value="${department.departmentAccessValue}" />
					</a></li>
				</c:when>



				<c:otherwise>
					<li><a href="<c:out value="${department.departmentAccessId}"/>" data-toggle="tab"><c:out
								value="${department.departmentAccessValue}" /> </a></li>
				</c:otherwise>
			</c:choose>

		</c:if>


		<%-- 					<li class="active"><a href="#<c:out value="${department.departmentAccessId}"/>" --%>
		<%-- 						data-toggle="tab"> <c:out value="${department.departmentAccessValue}"/> </a></li> --%>


		<!-- 					<li><a href="#logistics" data-toggle="tab">Logistics</a></li> -->



	</c:forEach>

</ul>

