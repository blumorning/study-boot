package com.bluemorning.web.repository;

import com.bluemorning.web.domain.Board;
import com.bluemorning.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
  Board findByUser(User user);
}
