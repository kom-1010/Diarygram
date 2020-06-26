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

function postLike(id) {
    const methodType = "PUT";
    const url = `/post/like/${id}`;
    const message = "좋아요!";

    ajax(methodType, url, message);
}

function postDelete(id){
    const methodType = "DELETE";
    const url = `/post/${id}`;
    const message = "글을 삭제하였습니다.";

    ajax(methodType, url, message);
}