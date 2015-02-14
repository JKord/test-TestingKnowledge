<div class="row">
	<div class="alert alert-success" role="alert">
		<h4>Тест ${topic.name}</h4>
		<p id="info_blTest">
			Часу залишилося на відповідь <code id="info_timeLeft">30 сек.</code>
			Правильних відповідей <code id="info_correctAnswers">0</code>, Балів: <code id="info_points">0</code>.
			Думайте добре, і не довго.
		</p>
	</div>
	<h1 id="question">...</h1>
	<div class="list-group" id="possible_answers"></div>
</div>
<script type="text/javascript">
	$(document).ready(function () {
		App.initTesting(${infoTesting.questionNumber} + 1);
		App.bindQuestion(${topic.id});
	});
</script>