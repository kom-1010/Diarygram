const postImg = document.getElementById("post-image");
let sel_file;

postImg.addEventListener('change', readURL);

function readURL(e) {
    var files  = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    filesArr.forEach((f) => {
        if(!f.type.match("image.*")) return;
        sel_file = f;

        var reader = new FileReader();
        reader.onload = (event) => {
            $("#img-area").attr("src", event.target.result);
        }
        reader.readAsDataURL(f);
    })
}