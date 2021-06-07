package org.service;

import org.model.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerService
{

    Player add(Player player);

    List get();

    Optional get(int id);

    void delete(int id);
}
