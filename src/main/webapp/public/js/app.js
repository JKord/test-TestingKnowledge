var App = {

    init: function (callback) {
        if (callback !== undefined) {
            callback();
        }
    },

    today: function () {
        var date = new Date();
        return date.getDay() + '-' + date.getMonth() + '-' + date.getYear();
    }
}

var ErrorApp = {
    show:function(msg){
        alert(msg.message);
    }
}

$(document).ready(function () {

});