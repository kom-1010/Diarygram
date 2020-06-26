package kr.ac.jejunu.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User, Integer> {
    @Query("select u from user_info u where u.name = ?1")
    User findByName(String name);
}

