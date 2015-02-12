<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="row">
	<h1>Оберіть тест</h1>
	<s:url value="/testing/{id}" var="testingLink" htmlEscape="true">
		<s:param name="id" value=""></s:param>
	</s:url>
	<div class="list-group">
		<a href="${testingLink}1" class="list-group-item">Тест 1</a>
		<a href="${testingLink}2" class="list-group-item">Тест 2</a>
		<a href="${testingLink}3" class="list-group-item">Тест 3</a>
		<a href="${testingLink}4" class="list-group-item">Тест 4</a>
		<a href="${testingLink}5" class="list-group-item">Тест 5</a>
		<a href="${testingLink}6" class="list-group-item">Тест 6</a>
	</div>
</div>