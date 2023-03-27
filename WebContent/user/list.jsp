<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<h1>사용자목록</h1>

<table>
	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.uid }</td>
			<td>${vo.upass }</td>
			<td>${vo.uname }</td>
			<td>${vo.address }</td>
			<td>
				<fmt:formatDate value="${vo.join_date }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
	</c:forEach>
</table>
