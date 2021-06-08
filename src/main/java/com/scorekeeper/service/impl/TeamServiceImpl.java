package com.scorekeeper.service.impl;

import java.util.List;
import java.util.Optional;

import com.scorekeeper.model.Team;
import com.scorekeeper.repository.TeamRepository;
import com.scorekeeper.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService
{
    @Autowired
    TeamRepository teamRepository;

    @Override
    public Team add(Team team)
    {
        return teamRepository.save(team);
    }

    @Override
    public List get()
    {
        return teamRepository.findAll();
    }

    @Override
    public Optional get(int id)
    {
        return teamRepository.findById(id);
    }

    @Override
    public void delete(int id)
    {
        if (get(id).isPresent())
        {
            teamRepository.delete((Team) get(id).get());
        }
    }
}
