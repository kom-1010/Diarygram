function postCreate() {
    const title = document.getElementById("post-title").value;
    const content = document.getElementById("post-content").value;

    const data = new Object();
    data["title"] = title;
    data["content"] = content;

    const methodType = "POST";
    const url = "/rest/new";
    const dataType = "json";
    const contentType = "application/json";
    const dataJson = JSON.stringify(data);
    const message = "글을 생성하였습니다.";

    if(data["title"]!="" && data["content"]!="")
        ajax(methodType, url, dataType, contentType, dataJson, message);
    else
        alert("제목과 내용을 입력해주세요.");
}

function postUpdate(id, likes) {
    const title = document.getElementById("post-title").value;
    const content = document.getElementById("post-content").value;

    const data = new Object();
    data["id"] = id;
    data["title"] = title;
    data["content"] = content;
    data["likes"] = likes;

    const methodType = "PUT";
    const url = "/rest";
    const dataType = "json";
    const contentType = "application/json";
    const dataJson = JSON.stringify(data);
    const message = "글을 수정하였습니다.";

    if(data["title"]!="" && data["content"]!="") {
        ajax(methodType, url, dataType, contentType, dataJson, message);
    } else {
        alert("제목과 내용을 입력해주세요.");
    }
}

function postLike(id, title, content, likes) {
    const data = new Object();
    data["id"] = id;
    data["title"] = title;
    data["content"] = content;
    data["likes"] = likes+1;

    const methodType = "PUT";
    const url = "/rest";
    const dataType = "json";
    const contentType = "application/json";
    const dataJson = JSON.stringify(data);
    const message = "좋아요!";

    ajax(methodType, url, dataType, contentType, dataJson, message);
}

function postDelete(id){
    const methodType = "DELETE";
    const url = '/rest/'+id;
    const dataType = null;
    const contentType = null;
    const data = null;
    const message = "글을 삭제하였습니다.";

    ajax(methodType, url, dataType, contentType, data, message);
}