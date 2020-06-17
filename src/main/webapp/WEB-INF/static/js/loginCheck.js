const areaAccount = document.getElementById("area-account");

function loginCheck(user) {
    if(user==null) {
        areaAccount.innerHTML = `
        <li>
          <a href="/login/" class="button large">로그인</a>
        </li>
        <li>
          <a href="/signup/" class="button large">회원가입</a>
        </li>`
    } else {
        areaAccount.innerHTML = `
        <li class="author" style="float: left;">
          <span class="name">${user}</span>
          <img src="images/avatar.jpg" alt="" />
        </li>
        <li>
          <a href="#" class="button large">로그아웃</a>
        </li>`
    }
}