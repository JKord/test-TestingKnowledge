<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
	<h1><s:message code="index.label.title" /></h1>
	<s:url value="/testing/{id}" var="testingLink" htmlEscape="true">
		<s:param name="id" value=""></s:param>
	</s:url>
	<div class="list-group">
	  <c:forEach var="topic" items="${topics}" varStatus="status">
		<a href="${testingLink}${topic.id}" class="list-group-item">${topic.name}</a>
	  </c:forEach>
	</div>
</div>