function ajax(methodType, url, dataType, contentType, data, message) {
    $.ajax({
        type: methodType,
        url: url,
        dataType : dataType,
        contentType : contentType,
        data : data,
        success: () => {
            alert(message);
            location.href = '/';
        },
        error: (request, status, error) => {
            console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
        }
    })
}

function ajaxUpdate(url, data, message) {
    $.ajax({
        type : "put",
        url : url,
        dataType : 'json',
        contentType : 'application/json',
        data : data,
        success : () => {
            alert(message);
            location.href = "/";
        },
        error: (request, status, error) => {
            console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
        }
    });
}