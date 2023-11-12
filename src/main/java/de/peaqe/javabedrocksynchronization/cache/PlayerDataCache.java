package de.peaqe.javabedrocksynchronization.cache;

import de.peaqe.javabedrocksynchronization.handler.data.PlayerData;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} PlayerDataCache
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 21:19 Uhr
 * *
 */

public class PlayerDataCache {

    Map<String, PlayerData> playerDataMap;

    public PlayerDataCache() {
        this.playerDataMap = new HashMap<>();
    }

    @Nullable
    public PlayerData getPlayerData(String name) {
        return playerDataMap.get(name);
    }

    public void addPlayerData(String name, PlayerData playerData) {
        this.playerDataMap.put(name, playerData);
    }

    public void removePlayerData(String name) {
        this.playerDataMap.remove(name);
    }

}
