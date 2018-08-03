<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
    <%@ page trimDirectiveWhitespaces="true" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
    <%@ taglib uri="/struts-tags" prefix="s"  %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<jsp:include page="/WEB-INF/jsp/ui/uphead.jsp"></jsp:include>
<title>日志列表</title>
</head>
<body>
<table class="table table-hover" >
	
	<tr class="active" >
		<td ><input type="checkbox" name ="id"/> </td>
		<th>title</th>
		<th>author  </th>	
		<th>releasedDate</th>
		<th>modifiedDate</th>	

	</tr>

			<c:forEach  var="Article"  items="${articlelist}">
				
					
			<tr>
				<td ><input  data-rid=${Article.id } type="checkbox" name ="ids"/> </td>
				<td>${Article.title}</td>
				<td>${Article.author}</td>
				
				<td><fmt:formatDate value="${Article.releasedDate}" type="date" dateStyle="long"/></td>
				<td><fmt:formatDate value="${Article.modifiedDate}" type="date" dateStyle="long"/></td> 

				<td  hidden="true" id="Article${Article.id }" ></td>
				
				
			</tr>
			
			</c:forEach>
	
	</table>
</body>
</html>