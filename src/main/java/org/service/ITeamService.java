package org.service;

import org.model.Team;

import java.util.List;
import java.util.Optional;

public interface ITeamService
{

    Team add(Team team);

    List get();

    Optional get(int id);

    void delete(int id);
}
