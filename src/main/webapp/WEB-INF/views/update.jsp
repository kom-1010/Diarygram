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
              <h2>Create Post</h2>
              <p>You can create new diary!</p>
            </div>
          </header>
          <section>
              <div class="row gtr-uniform">
                <div class="col-12 col-12-xsmall">
                  <input
                    type="text"
                    name="title"
                    value=""
                    placeholder="${post.title}"
                    id ="post-title"
                  />
                </div>
<%--                <div class="col-12 actions">--%>
<%--                  <input type="file" name="image">--%>
<%--                </div>--%>
                <div class="col-12">
                  <textarea
                    name="content"
                    placeholder="${post.content}"
                    rows="6"
                    id ="post-content"
                  ></textarea>
                </div>
                <div class="col-12">
                  <ul class="actions">
                    <li><input type="submit" value="Post" onclick="ajaxPost()" /></li>
                    <li><a href="/" class="button">Cancle</a></li>
                  </ul>
                </div>
              </div>
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
      loginCheck(`${user["name"]}`);
    </script>
    <script>
      function ajaxPost() {
        const title = document.getElementById("post-title").value;
        const content = document.getElementById("post-content").value;

        const data = new Object();
        data["id"] = `${post.id}`;
        data["title"] = title;
        data["content"] = content;
        data["likes"] = `${post.likes}`;
        console.log(data);

        if(data["title"]!="" && data["content"]!="") {
          $.ajax({
            type : "put",
            url : `/rest`,
            dataType : 'json',
            contentType : 'application/json',
            data : JSON.stringify(data),
            success : function (data) {
              alert("게시글을 수정하였습니다.")
              location.href="/";
            },
            error   : function (error) {
              console.log(error);
            }
          });
        } else {
          alert("제목과 내용을 입력해주세요.");
        }

      }
    </script>
  </body>
</html>
