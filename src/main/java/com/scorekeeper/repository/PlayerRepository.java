package com.scorekeeper.repository;

import com.scorekeeper.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>
{

}
