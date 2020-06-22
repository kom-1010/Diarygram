function postLike(id) {
    const methodType = "PUT";
    const url = `/rest/${id}`;
    const message = "좋아요!";

    ajax(methodType, url, message);
}

function postDelete(id){
    const methodType = "DELETE";
    const url = `/rest/${id}`;
    const message = "글을 삭제하였습니다.";

    ajax(methodType, url, message);
}