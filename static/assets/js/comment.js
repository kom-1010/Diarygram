const comment = document.querySelector(".btn-comment");
const commentArea = document.querySelector(".area-comment");
console.log(comment);

comment.addEventListener("click", function () {
  const htmlText = `<form>
            <div class="row gtr-uniform">
            <div class="col-12">
                <input type="text" placeholder="input comment!" />
            </div>
            <div class="col-12">
                <div class="actions">
                    <button type="submit">Comment</button>
                </div>
            </div>
            </div>
        </form>
        <ul class="alt">
            <li>
                <img src="images/avatar.jpg" alt="" />
                <span class="name">Jinsu</span>
                : Wow. This is vary beautiful!
            </li>
			<li>
                <img src="images/avatar.jpg" alt="" />
                <span class="name">Jinsu</span>
                : Wow. This is vary beautiful!
            </li>
            <li>
                <img src="images/avatar.jpg" alt="" />
                <span class="name">Jinsu</span>
                : Wow. This is vary beautiful!
            </li>
        </ul>
        <a href="single.html" class="button large">더보기</a>`;
  commentArea.innerHTML = htmlText;
});
