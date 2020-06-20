// ajax를 사용하여 데이터를 load하는 코드 작성하기
// post 데이터는 rest/post/{id}를 통해 가져올 수 잇다.
// user 데잍터는 rest/user/{id}를 통해 가져올 수 있다.
// scroll을 내릴 때마다 새로운 데이터 추가하는 코드 작성할  계획
let currLastId;

function writePost(data) {
    const main = document.getElementById("main");
    main.innerHTML += `
                <article class="post">
                    <header>
                        <div class="title">
                            <h2><a href="/single/${data["post"]["id"]}">${data["post"]["title"]}</a></h2>
                        </div>
                        <div class="meta">
                            <time class="published">${data["post"]["created_at"]}</time>
                            <div class="author">
                                <span class="name">${data["user"]["name"]}</span>
                                <img src="/images/avatar.jpg" alt="" />
                            </div>
                        </div>
                    </header>
                    <a href="/single/${data["post"]["id"]}" class="image featured"><img src="/images/pic01.jpg" alt=""/></a>
                    <p class="post-content">${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><button class="icon solid fa-heart">28</button></li>
                            <li><a href="/single/" class="button large">128</a></li>
                            <li><a href="/update/${data["post"]["id"]}"><button>수정</button></a></li>
                            <li><button onclick="ajaxDelete(${data["post"]["id"]})">삭제</button></li>
                        </ul>
                    </footer>
                </article>`;
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
