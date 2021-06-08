package com.scorekeeper.service.impl;

import java.util.List;
import java.util.Optional;

import com.scorekeeper.model.Player;
import com.scorekeeper.repository.PlayerRepository;
import com.scorekeeper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService
{
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player add(Player player)
    {
        return playerRepository.save(player);
    }

    @Override
    public List get()
    {
        return playerRepository.findAll();
    }

    @Override
    public Optional get(int id)
    {
        return playerRepository.findById(id);
    }

    @Override
    public void delete(int id)
    {
        if (get(id).isPresent())
        {
            playerRepository.delete((Player) get(id).get());
        }
    }
}
