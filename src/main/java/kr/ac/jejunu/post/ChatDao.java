package kr.ac.jejunu.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDao extends JpaRepository<Chat, Integer> {
}
