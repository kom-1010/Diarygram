function restDelete(id) {
    $.ajax({
        type: 'delete',
        url: `/rest/delete/${id}`,
        dataType: 'json',
        async: false,
        success: function() {
        } ,
        error: function () {
        },
    });
}

function restUpdate(id) {
    $.ajax({
        type: 'put',
        url: `/rest/update/${id}`,
        dataType: 'json',
        async: false,
        success: function() {
        } ,
        error: function () {
        },
    });
}