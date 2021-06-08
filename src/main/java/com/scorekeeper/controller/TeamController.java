package com.scorekeeper.controller;

import com.scorekeeper.model.Team;
import com.scorekeeper.service.TeamService;
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
public class TeamController
{
    @Autowired
    TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams()
    {
        try
        {
            List<Team> list = teamService.get();

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

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable int id)
    {
        Optional<Team> team = teamService.get(id);

        if (team.isPresent())
        {
            return new ResponseEntity<Team>(team.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> saveTeam(@RequestBody Team team)
    {
        try
        {
            return new ResponseEntity<Team>(teamService.add(team), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/teams")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team)
    {
        try
        {
            return new ResponseEntity<Team>(teamService.add(team), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable int id)
    {
        try
        {
            teamService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
