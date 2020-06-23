function loadChat(postId, ul){
    $.ajax({
        type: 'get',
        url: `/rest/chat/${postId}`,
        dataType: 'json',
        async: false,
        success: (data) => {
            const chatData = data.chatList;
            for(let i=0;i<chatData.length;i++) {
                console.log(chatData[i]);
                ul.innerHTML +=
                    `<li>${chatData[i]["user_id"]} / ${chatData[i]["content"]} / ${chatData[i]["created_at"]} </li>`;
            }
        } ,
        error: () => {
        },
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

