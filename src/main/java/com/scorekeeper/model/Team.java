package com.scorekeeper.model;

import javax.persistence.*;

@Entity
@Table(name = "team")
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
}
