// ajax를 사용하여 데이터를 load하는 코드 작성하기
// post 데이터는 rest/post/{id}를 통해 가져올 수 잇다.
// user 데잍터는 rest/user/{id}를 통해 가져올 수 있다.
// scroll을 내릴 때마다 새로운 데이터 추가하는 코드 작성할  계획

const main = document.getElementById("main");
let startId = 1;

function writeHTML(data) {
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
                    <p>${data["post"]["content"]}</p>
                    <footer>
                        <ul class="stats">
                            <li><button class="icon solid fa-heart">28</button></li>
                            <li><a href="/single/" class="button large">128</a></li>
                        </ul>
                    </footer>
                </article>`;
}

function loadData(startId){
    for(var i=startId;i<startId+3;i++) {
        $.ajax({
            type: 'get',
            url: `rest/${i}`,
            dataType: 'json',
            success: writeHTML ,
            error: function (error) {
                console.log("error: ", error);
            }
        });
    }
}

loadData(startId);