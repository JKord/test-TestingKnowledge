var App = {
    questionNumber: 1,

    init: function (callback) {
        if (callback !== undefined) {
            callback();
        }
    },

    today: function () {
        var date = new Date();
        return date.getDay() + '-' + date.getMonth() + '-' + date.getYear();
    },

    loadQuestion: function (topicId, questionId) {
        var questionBl = $('#question'), answersBl = $('#possible_answers');
        questionBl.html('...');
        answersBl.html('<h3>Отримання даних...</h3>');
        $.get('/testing/'+topicId+'/question/'+questionId, function(data){
            if (data.code == 1) {
                questionBl.html(data.data.question.text);
                answersBl.html(getPossibleAnswers(data.data.question.answers));
            } else {
                MessageApp.show(data);
            }
        });
    },

    bindQuestion: function (topicId) {
        App.loadQuestion(topicId, App.questionNumber);
        
    }
}

var MessageApp = {
    show: function(msg){
        alert(msg.message);
    }
}

$(document).ready(function () {

});