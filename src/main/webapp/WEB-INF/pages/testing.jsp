<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="row">
	<div class="alert alert-success" role="alert">
		<h4><s:message code="test" /> ${topic.name}</h4>
		<p id="info_blTest">
            <s:message code="testing.p.timeLeft" /> <code id="info_timeLeft">30 <s:message code="sec" /></code>
            <s:message code="testing.p.correctAnswers" /> <code id="info_correctAnswers">0</code>, <s:message code="points" />: <code id="info_points">0</code>.
            <s:message code="testing.p.think" />
		</p>
	</div>
	<h1 id="question">...</h1>
	<div class="list-group" id="possible_answers"></div>
</div>
<script type="text/javascript">
	$(document).ready(function () {
		App.initTesting(${infoTesting.questionNumber} + 1, ${infoTesting.correctAnswers}, ${infoTesting.points});
		App.bindQuestion(${topic.id});
	});
</script>