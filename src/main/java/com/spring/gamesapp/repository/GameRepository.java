package com.spring.gamesapp.repository;

import com.spring.gamesapp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
