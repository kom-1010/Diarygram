function ajax(methodType, url, message) {
    $.ajax({
        type: methodType,
        url: url,
        success: () => {
            alert(message);
            location.href = '/';
        },
        error: (request, status, error) => {
            console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
        }
    })
}