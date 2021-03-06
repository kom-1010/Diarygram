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
  <script>
    const startId = `${startId}`;
    let lastId = `${lastId}`;
    const url = `/post`;
    const loginUser = `${user["name"]}`;
    const loginProfile = `${user["profile"]}`;
    const loginId = `${user["id"]}`;
  </script>
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
          삶을 여러 사람과 공유하세요!
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
<script src="/js/load.js"></script>
<script src="/js/loginCheck.js"></script>
<script>
  loginCheck(loginUser, loginProfile, loginId);
</script>c
<script src="/js/ajax.js"></script>
<script src="/js/postHandle.js"></script>
<script src="/js/chat.js"></script>

</body>
</html>
