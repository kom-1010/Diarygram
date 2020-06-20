const areaAccount = document.getElementById("area-account");
const myPost = document.getElementById("myPost");
const newPost = document.getElementById("newPost");

function loginCheck(user) {
    console.log(user);
    if(user=="") {
        myPost.innerHTML = `<a href="/login" onclick="alert('로그인이 필요한 서비스입니다.')">My Post</a>`;
        newPost.innerHTML = `<a href="/login" onclick="alert('로그인이 필요한 서비스입니다.')">New Post</a>`;
        areaAccount.innerHTML = `
        <li>
          <a href="/login/" class="button large">로그인</a>
        </li>
        <li>
          <a href="/signup/" class="button large">회원가입</a>
        </li>`
    } else {
        myPost.innerHTML = `<a href="/mine">My Post</a>`;
        newPost.innerHTML = `<a href="/new">New Post</a>`;
        areaAccount.innerHTML = `
        <li class="author" style="float: left;">
          <span class="name">${user}</span>
          <img src="/images/avatar.jpg" alt="" />
        </li>
        <li>
          <a href="/rest/logout" class="button large">로그아웃</a>
        </li>`
    }
}