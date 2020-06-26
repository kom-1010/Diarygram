const areaAccount = document.getElementById("area-account");
const myPost = document.getElementById("myPost");
const newPost = document.getElementById("newPost");

function loginCheck(username, profile, id) {
    if(username=="") {
        myPost.innerHTML = `<a href="/login" onclick="alert('로그인이 필요한 서비스입니다.')">My Post</a>`;
        newPost.innerHTML = `<a href="/login" onclick="alert('로그인이 필요한 서비스입니다.')">New Post</a>`;
        areaAccount.innerHTML = `
        <li>
          <a href="/login/" class="button large">로그인</a>
        </li>
        <li>
          <a href="/signup/" class="button large">회원가입</a>
        </li>`;
    } else {
        myPost.innerHTML = `<a href="/mine/${id}">My Post</a>`;
        newPost.innerHTML = `<a href="/new">New Post</a>`;
        areaAccount.innerHTML = `
        <li class="author" style="float: left;">
          <span class="name">${username}</span>
          <img src="/images/user/${profile}" alt="" />
        </li>
        <li>
          <a href="/profile/${id}" class="button large">프로필 수정</a>
        </li>
        <li>
          <a href="/user/logout" class="button large">로그아웃</a>
        </li>`
    }
}