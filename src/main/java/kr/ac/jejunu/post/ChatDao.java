package kr.ac.jejunu.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatDao extends JpaRepository<Chat, Integer> {
    @Query("select c from chat c where c.post_id = ?1")
    List<Chat> findByPost_id(Integer post_id);
}
