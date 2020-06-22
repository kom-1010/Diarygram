package kr.ac.jejunu.post;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private String title;
    private String content;
    private Integer user_id;
    private String created_at;
    private Integer likes;
    private String image;
}
