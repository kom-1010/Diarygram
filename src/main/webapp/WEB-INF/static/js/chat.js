function openChatArea(e) {
    const $article = e.target.parentElement.parentElement.parentElement.parentElement;
    const $chatArea = $article.querySelector(".chat-area");
    if($chatArea.style.display == 'none')
        $chatArea.style.display = 'block';
    else
        $chatArea.style.display = 'none';
}

