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
    <!-- Post -->
    <article class="post">
      <header>
        <div class="title">
          <h2>Update Post</h2>
          <p>You can create new diary!</p>
        </div>
      </header>
      <section>
        <form action="/rest/update/${post.id}" method="POST" enctype="multipart/form-data">
          <div class="row gtr-uniform">
            <div class="col-12">
              <img src="/images/post/${post.image}" id="img-area" width="800" height="500" alt="" style="display: block; margin: 15px auto;">
              <label for="input-image" class="button" style="display: block; margin: 15px auto;">이미지</label>
              <input type="file" name="image" id="input-image" style="display: none;" value=${post.image}>
            </div>
            <div class="col-12 col-12-xsmall">
              <input
                      type="text"
                      name="title"
                      value="${post.title}"
                      id ="post-title"
                      autocomplete="off"
              />
            </div>
            <div class="col-12">
                  <textarea
                          name="content"
                          rows="6"
                          id ="post-content"
                  >${post.content}</textarea>
            </div>
            <div class="col-12">
              <ul class="actions">
                <li><input type="submit" value="Post"></li>
                <li><a href="/" class="button">Cancle</a></li>
              </ul>
            </div>
          </div>
        </form>
      </section>
    </article>
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
  const loginUser = `${user["name"]}`;
  const loginProfile = `${user["profile"]}`;
  loginCheck(loginUser, loginProfile);
</script>
<script src="/js/ajax.js"></script>
<script src="/js/postHandle.js"></script>
<script src="/js/preview.js"></script>
</body>
</html>
