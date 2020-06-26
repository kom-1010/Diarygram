let currLastId;

function writePost(data) {
    const main = document.getElementById("main");
    if(loginUser=="") {
        main.innerHTML += `
                <article class="post">
                    <header>
                        <div class="title">
                            <h2>${data["post"]["title"]}</h2>
                        </div>
                        <div class="meta">
                            <time class="published">${data["post"]["created_at"]}</time>
                            <div class="author">
                                <span class="name">${data["user"]["name"]}</span>
                                <img src="/images/user/${data["user"]["profile"]}" alt="" />
                            </div>
                        </div>
                    </header>
                    <img src="/images/post/${data["post"]["image"]}" width="800" height="500" alt="" style="display: block; margin: 50px auto;"/>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><a href="/login" class="icon solid fa-heart button" onclick="alert('로그인이 필요한 서비스입니다.')">${data["post"]["likes"]}</a></li>
                            <li><button class="chat-btn" onclick="openChatArea(this, ${data["post"]["id"]})">댓글</button></li>
                            <li><a href="/login" class="button" onclick="alert('로그인이 필요한 서비스입니다.')">수정</a></li>
                            <li><a href="/login" class="button" onclick="alert('로그인이 필요한 서비스입니다.')">삭제</a></li>
                        </ul>
                    </footer>
                    <div class="chat-area" style="display: none;">
                        <form>
                            <input type="text" class="input-chat">
                            <button class="button" type="button" onclick="insertChat(this, ${data["post"]["id"]})" style="display: block; margin: 15px auto;">댓글 작성</button>
                        </form>
                        <div class="table-wrapper">
                            <table>
                                <tbody class="chat-list"></tbody>
                            </table>
                        </div>
                    </div>
                </article>`;
    } else if(loginUser!=data["user"]["name"]){
        main.innerHTML += `
                <article class="post">
                    <header>
                        <div class="title">
                            <h2>${data["post"]["title"]}</h2>
                        </div>
                        <div class="meta">
                            <time class="published">${data["post"]["created_at"]}</time>
                            <div class="author">
                                <span class="name">${data["user"]["name"]}</span>
                                <img src="/images/user/${data["user"]["profile"]}" alt="" />
                            </div>
                        </div>
                    </header>
                    <img src="/images/post/${data["post"]["image"]}" width="800" height="500" alt="" style="display: block; margin: 50px auto;"/>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><button class="icon solid fa-heart like-btn" onclick="postLike(${data["post"]["id"]})">${data["post"]["likes"]}</button></li>
                            <li><button class="chat-btn" onclick="openChatArea(this, ${data["post"]["id"]})">댓글</button></li>
                            <li><button onclick="alert('해당 글의 작성자만 가능합니다.')">수정</button></li>
                            <li><button onclick="alert('해당 글의 작성자만 가능합니다.')">삭제</a></li>
                        </ul>
                    </footer>
                    <div class="chat-area" style="display: none;">
                        <form>
                            <input type="text" class="input-chat">
                            <label class="button" type="button" onclick="insertChat(this, ${data["post"]["id"]})" style="display: block; margin: 15px auto;">댓글 작성</label>
                        </form>
                        <div class="table-wrapper" >
                            <table>
                                <tbody class="chat-list" style="border: 1px solid"></tbody>
                            </table>
                        </div>
                    </div>
                </article>`;
    } else {
        main.innerHTML += `
                <article class="post">
                    <header>
                        <div class="title">
                            <h2>${data["post"]["title"]}</h2>
                        </div>
                        <div class="meta">
                            <time class="published">${data["post"]["created_at"]}</time>
                            <div class="author">
                                <span class="name">${data["user"]["name"]}</span>
                                <img src="/images/user/${data["user"]["profile"]}" alt="" />
                            </div>
                        </div>
                    </header>
                    <img src="/images/post/${data["post"]["image"]}" width="800" height="500" alt="" style="display: block; margin: 50px auto;"/>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><button class="icon solid fa-heart like-btn" onclick="postLike(${data["post"]["id"]})">${data["post"]["likes"]}</button></li>
                            <li><button class="chat-btn" onclick="openChatArea(this, ${data["post"]["id"]})">댓글</button></li>
                            <li><a href="/update/${data["post"]["id"]}" class="button">수정</a></li>
                            <li><button onclick="postDelete(${data["post"]["id"]})">삭제</button></li>
                        </ul>
                    </footer>
                    <div class="chat-area" style="display: none;">
                        <form>
                            <input type="text" class="input-chat">
                            <label class="button" type="button" onclick="insertChat(this, ${data["post"]["id"]})" style="display: block; margin: 15px auto;">댓글 작성</label>
                        </form>
                        <div class="table-wrapper" >
                            <table>
                                <tbody class="chat-list" style="border: 1px solid"></tbody>
                            </table>
                        </div>
                    </div>
                </article>`;
    }
}

function loadPost(startId, lastId, url){
    let postLimit = 3;
    for(let i=lastId;i>lastId-postLimit;i--) {
        if(i<startId) {
            break;
        }
        $.ajax({
            type: 'get',
            url: `${url}/${i}/`,
            dataType: 'json',
            async: false,
            success: (data) => {
                writePost(data);
            } ,
            error: () => {
                postLimit ++;
            },
        });
        currLastId = i-1;
    }
}

loadPost(startId, lastId, url);

function getCurrentScrollPercentage(){
    return (window.scrollY + window.innerHeight) / document.body.clientHeight * 100
}

document.addEventListener('scroll', () => {
    const currentScrollPercentage = getCurrentScrollPercentage()
    if(currentScrollPercentage > 90){
        loadPost(startId, currLastId, url);
    }
});