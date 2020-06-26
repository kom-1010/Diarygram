function deleteChat(id) {
    $.ajax({
        type: 'delete',
        url: `/chat/${id}`,
        success: () => {
            alert("댓글을 삭제하였습니다.");
            location.href = "/";
        } ,
        error: () => {
            alert("에러 발생")
        }
    })
}

function loadChat(postId, ul){
    $.ajax({
        type: 'get',
        url: `/chat/${postId}`,
        dataType: 'json',
        async: false,
        success: (data) => {
            const chatData = data.chatList;
            const userData = data.userList;
            if (chatData !== undefined) {
                for (let i = 0; i < chatData.length; i++) {
                    ul.innerHTML +=
                        `<tr>
                                <td><button onclick="deleteChat(${chatData[i]["id"]})">X</button></td>
                                <td>${chatData[i]["created_at"]}</td> 
                                <td>${chatData[i]["content"]}</td>
                                <td>
                                    <div class="author">
                                        <span class="name">${userData[i]["name"]}</span>
                                        <img src="/images/user/${userData[i]["profile"]}" alt="" />
                                    </div>
                                </td>
                         </tr>`;
                }
            }
        } ,
        error: () => {},
    });
}

function openChatArea(e, postId) {
    const $article = e.parentNode.parentNode.parentNode.parentNode;
    const $chatArea = $article.querySelector(".chat-area");
    if($chatArea.style.display == 'none') {
        $chatArea.style.display = 'block';
        const $chatUl = $chatArea.querySelector(".chat-list");
        $chatUl.innerHTML = "";
        loadChat(postId, $chatUl);

    } else $chatArea.style.display = 'none';
}

function insertChat(e, postId) {
    const $inputChat = e.parentNode.querySelector(".input-chat");
    const chatMessage =  $inputChat.value;
    const $ul = e.parentNode.parentNode.querySelector(".chat-list");
    const data = new Object();
    data["post_id"] = postId;
    data["content"] = chatMessage;

    $.ajax({
        type: 'post',
        url: `/chat`,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        async: false,
        success: () => {
            $ul.innerHTML = "";
            loadChat(postId, $ul);
            $inputChat.value = "";
        } ,
        error: () => {},
    });
}
