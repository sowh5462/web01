<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>게시판</h1>
<a href="/posts/insert">글쓰기</a>
<table>
  	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td><a href="/posts/read?id=${vo.id}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td>
				<fmt:formatDate type="date" value="${vo.date}" pattern="yyyy-MM-dd hh:mm:ss"/>
			</td>
		</tr>
	</c:forEach>
</table>
