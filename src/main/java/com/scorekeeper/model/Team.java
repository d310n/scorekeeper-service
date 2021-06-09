package com.scorekeeper.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String teamName;

    private String teamState;

    public Team()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getTeamState()
    {
        return teamState;
    }

    public void setTeamState(String teamState)
    {
        this.teamState = teamState;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teams")
    @JsonBackReference
    private List<Player> players = new ArrayList<>();
}
