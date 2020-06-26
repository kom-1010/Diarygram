package kr.ac.jejunu.post;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class FileHandler {

    public void fileSave(HttpServletRequest request, MultipartFile image, String filename, String s) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/") +
                s + filename);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(image.getBytes());
        bufferedOutputStream.close();
    }

    public String getFilename(MultipartFile file, String title, Integer id) {
        String filename;
        String orgFilename = file.getOriginalFilename();
        String ext = orgFilename.substring(orgFilename.lastIndexOf("."));
        filename = id + "_" + title + ext;
        return filename;
    }
}
