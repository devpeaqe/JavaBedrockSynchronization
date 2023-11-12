package de.peaqe.javabedrocksynchronization.cache;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} SynchronizationCache
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 20:53 Uhr
 * *
 */

public class SynchronizationCache {

    List<String> playerNames;

    public SynchronizationCache() {
        this.playerNames = new ArrayList<>();
    }

    public boolean playerInList(Player player) {
        return playerNames.contains(player.getName());
    }

    public void addPlayer(Player player) {
        playerNames.add(player.getName());
    }

    public void removePlayer(Player player) {
        playerNames.remove(player.getName());
    }

}
