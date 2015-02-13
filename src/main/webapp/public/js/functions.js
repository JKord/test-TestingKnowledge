function getPossibleAnswers(answers) {
    var html = '';
    $.each(answers, function(key, answer) {
        html += '<a href="#"'+key+' class="list-group-item list-group-item-success" data-id="'+answer.id+'">'+answer.text+'</a>'
    });
    
    return html;
}