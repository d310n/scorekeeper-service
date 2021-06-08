package com.scorekeeper.repository;

import com.scorekeeper.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer>
{

}

