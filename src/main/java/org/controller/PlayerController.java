package org.controller;

import org.model.Player;
import org.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayerController
{

    @Autowired
    IPlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        try
        {
            List<Player> list = playerService.get();

            if (list.isEmpty() || list.size() == 0)
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable int id)
    {
        Optional<Player> player = playerService.get(id);

        if (player.isPresent())
        {
            return new ResponseEntity<Player>(player.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player)
    {
        try
        {
            return new ResponseEntity<Player>(playerService.add(player), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/players")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player)
    {
        try
        {
            return new ResponseEntity<Player>(playerService.add(player), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable int id)
    {
        try
        {
            playerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}