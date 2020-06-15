<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
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
        <h1><a href="/index/">Diarygram</a></h1>
        <nav class="links">
          <ul>
            <li><a href="/index/">Home</a></li>
            <li><a href="/mine/">My Page</a></li>
            <li><a href="/new/">New Post</a></li>
          </ul>
        </nav>
      </header>

      <!-- Main -->
      <div id="main">
        <!-- Post -->
        <article class="post">
          <header>
            <div class="title">
              <h2><a href="/single/">Add Post</a></h2>
              <p>You can create new diary!</p>
            </div>
          </header>
          <section>
            <form method="post" action="#">
              <div class="row gtr-uniform">
                <div class="col-12 col-12-xsmall">
                  <input
                    type="text"
                    name="demo-name"
                    id="demo-name"
                    value=""
                    placeholder="Title"
                  />
                </div>
                <div class="col-12 col-12-xsmall">
                  <input
                    type="text"
                    name="demo-name"
                    id="demo-name"
                    value=""
                    placeholder="Subtitle"
                  />
                </div>

                <div class="col-12 actions">
                  <button class="button icon solid fa-upload">Image</button>
                </div>

                <div class="col-12">
                  <textarea
                    name="demo-message"
                    id="demo-message"
                    placeholder="Enter your message"
                    rows="6"
                  ></textarea>
                </div>

                <div class="col-12">
                  <ul class="actions">
                    <li><input type="submit" value="Save" /></li>
                    <li><a href="/index/" class="button">Cancle</a></li>
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
          <a href="/index/" class="logo"
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
          <ul class="actions">
            <!-- Not login state-->
            <li>
              <a href="/login/" class="button large">로그인</a>
            </li>
            <li>
              <a href="/signup/" class="button large">회원가입</a>
            </li>

            <!-- Login state -->
            <!-- <li class="author" style="float: left;">
              <span class="name">Jinsu</span>
              <img src="images/avatar.jpg" alt="" />
            </li>
            <li>
              <a href="/single/" class="button large">로그아웃</a>
            </li> -->
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
  </body>
</html>
