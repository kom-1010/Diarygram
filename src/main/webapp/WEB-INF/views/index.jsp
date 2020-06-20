<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
  <title>Diarygram</title>
  <meta charset="utf-8" />
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1, user-scalable=no"
  />
  <link rel="stylesheet" href="/css/main.css" />
</head>
<body class="is-preload">
<!-- Wrapper -->
<div id="wrapper">
  <!-- Header -->
  <header id="header">
    <h1><a href="/">Diarygram</a></h1>
    <nav class="links">
      <ul>
        <li><a href="/">Home</a></li>
        <li id="myPost"></li>
        <li id="newPost"></li>
      </ul>
    </nav>
  </header>

  <!-- Main -->
  <div id="main">
  </div>

  <!-- Sidebar -->
  <section id="sidebar">
    <!-- Intro -->
    <section id="intro">
      <a href="/" class="logo"
      ><img src="/images/logo.jpg" alt=""
      /></a>
      <header>
        <h2>Diarygram</h2>
        <p>
          삶을 여러 사람과 나눠보세요!
        </p>
      </header>
    </section>

    <!-- author -->
    <section>
    <ul class="actions" id="area-account">
    </ul>
  </section>

    <!-- Footer -->
    <section id="footer">
      <ul class="icons">
        <li>
          <a href="#" class="icon brands fa-twitter"
          ><span class="label">Twitter</span></a
          >
        </li>
        <li>
          <a href="#" class="icon brands fa-facebook-f"
          ><span class="label">Facebook</span></a
          >
        </li>
        <li>
          <a href="#" class="icon brands fa-instagram"
          ><span class="label">Instagram</span></a
          >
        </li>
        <li>
          <a href="#" class="icon solid fa-rss"
          ><span class="label">RSS</span></a
          >
        </li>
        <li>
          <a href="#" class="icon solid fa-envelope"
          ><span class="label">Email</span></a
          >
        </li>
      </ul>
      <p class="copyright">
        &copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>.
        Images: <a href="http://unsplash.com">Unsplash</a>.
      </p>
    </section>
  </section>
</div>

<!-- Scripts -->
<script src="/js/jquery.min.js"></script>
<script src="/js/browser.min.js"></script>
<script src="/js/breakpoints.min.js"></script>
<script src="/js/util.js"></script>
<script src="/js/main.js"></script>
<script src="/js/loginCheck.js"></script>
<script>
  const startId = `${startPost["id"]}`;
  let lastId = `${lastPost["id"]}`;
  const url = `/rest`;
  loginCheck(`${user["name"]}`);
</script>
<script src="/js/load.js"></script>
<script>
  function ajaxDelete(id){
    $.ajax({
      type: 'delete',
      url: '/rest/'+id,
      async: false,
    }).done(function(response){
      alert("삭제하였습니다.");
      location.href = "/";
    });
  }
</script>
<script>
  function ajaxLike(pId, pTitle, pContent, pLikes) {

    const data = new Object();
    data["id"] = pId;
    data["title"] = pTitle;
    data["content"] = pContent;
    data["likes"] = pLikes+1;
    console.log(data);

    $.ajax({
      type : "put",
      url : `/rest`,
      dataType : 'json',
      contentType : 'application/json',
      data : JSON.stringify(data),
      success : function (data) {
        alert("좋아요 성공");
        location.href = "/";
      },
      error   : function (error) {
        console.log(error);
      }
    });
  }
</script>
</body>
</html>
