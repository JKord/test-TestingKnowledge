var App = {
    test: null,

    init: function (callback) {
        if (callback !== undefined) {
            callback();
        }
    },

    initTesting: function (questionNumber, correctAnswers, points) {
        this.test = {
            questionNumber: questionNumber,
            topicId: null,
            timeLeft: 30,
            timeLeftTimer: null,
            questionBl: $('#question'),
            answersBl: $('#possible_answers'),
            infoTimeLeft: $('#info_timeLeft'),
            infCorrectAnswers: $('#info_correctAnswers'),
            infoPoints: $('#info_points')
        };

        this.test.infoTimeLeft.html(this.test.timeLeft + ' сек.');
        this.test.infCorrectAnswers.html(correctAnswers);
        this.test.infoPoints.html(points);
    },

    today: function () {
        var date = new Date();
        return date.getDay() + '-' + date.getMonth() + '-' + date.getYear();
    },

    timerTesting: function() {
        App.test.timeLeft = 30;
        App.test.infoTimeLeft.text(App.test.timeLeft + ' сек.');
        clearInterval(this.test.timeLeftTimer);
        this.test.timeLeftTimer = setInterval(function() {
            App.test.infoTimeLeft.text(--App.test.timeLeft + ' сек.');
            if(App.test.timeLeft < 1) {
                clearInterval(App.test.timeLeftTimer);
                App.test.questionNumber++;
                alert('Час на відповідь закінчився. Перейти до наступного питання.');
                App.loadQuestion();
            }
        }, 1000);
    },
    
    finishTesting: function(data) {
        clearInterval(this.test.timeLeftTimer);
        App.test.infoTimeLeft.text('-');
        App.test.questionBl.text('Тест завершено');
        App.test.answersBl.html('<a href="/result" type="button" class="btn btn-success">Результат</a><br><a href="/" type="button" class="btn btn-primary">На головну сторінку</a>');
    },

    loadQuestion: function () {
        this.test.questionBl.html('...');
        this.test.answersBl.html('<h3>Отримання даних...</h3>');
        $.get('/testing/'+this.test.topicId+'/question/'+ this.test.questionNumber, function(data){
            if (data.code == 1) {
                App.test.questionBl.html(data.data.question.text);
                App.test.answersBl.html(getPossibleAnswers(data.data.question.answers));
                App.timerTesting();
            } else if (data.code == 2) {
                App.finishTesting(data);
            } else {
                MessageApp.show(data);
            }
        });
    },

    checkingAnswer: function(answerId) {
        $.ajax({ type: "POST", url: '/testing/'+this.test.topicId+'/question/'+ this.test.questionNumber,
            dataType: 'json', data: { answerId: answerId }, success: function(data){
                if (data.code == 1) {
                    App.test.infCorrectAnswers.html(data.data.correctAnswers);
                    App.test.infoPoints.html(data.data.points);
                } else {
                    MessageApp.show(data);
                }
            }
        });
    },

    bindQuestion: function (topicId) {
        this.test.topicId = topicId;
        this.loadQuestion();
        this.test.answersBl.on('click', 'a[data-id]', function() {
            App.checkingAnswer($(this).data('id'));
            App.test.questionNumber++;
            App.loadQuestion(topicId);
        });
    }
};

var MessageApp = {
    show: function(msg){
        alert(msg.message);
    }
};

$(document).ready(function () {

});