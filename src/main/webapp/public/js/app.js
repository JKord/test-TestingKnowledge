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

        this.test.infoTimeLeft.html(this.test.timeLeft + Local.sec);
        this.test.infCorrectAnswers.html(correctAnswers);
        this.test.infoPoints.html(points);
    },

    today: function () {
        var date = new Date();
        return date.getDay() + '-' + date.getMonth() + '-' + date.getYear();
    },

    timerTesting: function() {
        this.test.timeLeft = 30;
        this.test.infoTimeLeft.text(this.test.timeLeft + Local.sec);
        clearInterval(this.test.timeLeftTimer);
        var self = this;
        this.test.timeLeftTimer = setInterval(function() {
            self.test.infoTimeLeft.text(--self.test.timeLeft + Local.sec);
            if(self.test.timeLeft < 1) {
                clearInterval(self.test.timeLeftTimer);
                self.test.questionNumber++;
                alert(Local.timeEnd);
                self.loadQuestion();
            }
        }, 1000);
    },
    
    finishTesting: function(data) {
        clearInterval(this.test.timeLeftTimer);
        this.test.infoTimeLeft.text('-');
        this.test.questionBl.text(Local.testEnd);
        this.test.answersBl.html('<a href="/result" type="button" class="btn btn-success">'+Local.btn.result+'</a><br><a href="/" type="button" class="btn btn-primary">'+Local.btn.mainPage+'</a>');
    },

    loadQuestion: function () {
        this.test.questionBl.html('...');
        this.test.answersBl.html('<h3>' + Local.receiveData + '</h3>');
        var self = this;
        $.get('/testing/'+this.test.topicId+'/question/'+ this.test.questionNumber, function(data){
            if (data.code == 1) {
                self.test.questionBl.html(data.data.question.text);
                self.test.answersBl.html(self.getPossibleAnswers(data.data.question.answers));
                self.timerTesting();
            } else if (data.code == 2) {
                self.finishTesting(data);
            } else {
                MessageApp.show(data);
            }
        });
    },

    checkingAnswer: function(answerId) {
        var self = this;
        $.ajax({ type: "POST", url: '/testing/'+this.test.topicId+'/question/'+ this.test.questionNumber,
            dataType: 'json', data: { answerId: answerId }, success: function(data){
                if (data.code == 1) {
                    self.test.infCorrectAnswers.html(data.data.correctAnswers);
                    self.test.infoPoints.html(data.data.points);
                } else {
                    MessageApp.show(data);
                }
            }
        });
    },

    bindQuestion: function (topicId) {
        this.test.topicId = topicId;
        this.loadQuestion();
        var self = this;
        this.test.answersBl.on('click', 'a[data-id]', function() {
            self.checkingAnswer($(this).data('id'));
            self.test.questionNumber++;
            self.loadQuestion(topicId);
        });
    },

    getPossibleAnswers: function (answers) {
        var html = '';
        $.each(answers, function(key, answer) {
            html += '<a href="#"'+key+' class="list-group-item list-group-item-success" data-id="'+answer.id+'">'+answer.text+'</a>'
        });

        return html;
    }
};

var MessageApp = {
    show: function(msg){
        alert(msg.message);
    }
};