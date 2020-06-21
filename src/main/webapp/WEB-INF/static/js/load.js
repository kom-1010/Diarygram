let currLastId;

function writePost(data) {
    const main = document.getElementById("main");
    if(loginDo=="") {
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
                                <img src="/images/avatar.jpg" alt="" />
                            </div>
                        </div>
                    </header>
                    <img src="/images/pic01.jpg" alt=""/>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><a href="/login" class="icon solid fa-heart button" onclick="alert('로그인이 필요한 서비스입니다.')">${data["post"]["likes"]}</a></li>
                            <li><a href="/single/" class="button large like-btn">128</a></li>
                            <li><a href="/login" class="button" onclick="alert('로그인이 필요한 서비스입니다.')">수정</a></li>
                            <li><a href="/login" class="button" onclick="alert('로그인이 필요한 서비스입니다.')">삭제</a></li>
                        </ul>
                    </footer>
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
                                <img src="/images/avatar.jpg" alt="" />
                            </div>
                        </div>
                    </header>
                    <img src="/images/pic01.jpg" alt=""/>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><button class="icon solid fa-heart like-btn" onclick="postLike(${data["post"]["id"]},'${data["post"]["title"]}','${data["post"]["content"]}',${data["post"]["likes"]})">${data["post"]["likes"]}</button></li>
                            <li><a href="/single/" class="button large like-btn">128</a></li>
                            <li><a href="/update/${data["post"]["id"]}" class="button">수정</a></li>
                            <li><button onclick="postDelete(${data["post"]["id"]})">삭제</button></li>
                        </ul>
                    </footer>
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
            success: writePost ,
            error: function (error) {
                postLimit ++;
            }
        });
        currLastId = i-1;
    }
}

loadPost(startId, lastId, url, loginDo);

function getCurrentScrollPercentage(){
    return (window.scrollY + window.innerHeight) / document.body.clientHeight * 100
}

document.addEventListener('scroll', () => {
    const currentScrollPercentage = getCurrentScrollPercentage()
    if(currentScrollPercentage > 90){
        loadPost(startId, currLastId, url);
    }
});
