<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="row">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title"><s:message code="result.label.title" /></h3>
		</div>
		<div class="panel-body">
			<p><s:message code="result.p.info" arguments="${info.questionNumber},${info.correctAnswers}"/>
			<p><s:message code="result.p.infoPoints" arguments="${info.points}"/>
		</div>
	</div>
	<a href="/" type="button" class="btn btn-primary"><s:message code="result.btn.indexPage" /></a>
	<br><br>
</div>