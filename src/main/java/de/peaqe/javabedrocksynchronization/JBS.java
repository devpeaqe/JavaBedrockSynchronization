package de.peaqe.javabedrocksynchronization;

import de.peaqe.javabedrocksynchronization.cache.PlayerDataCache;
import de.peaqe.javabedrocksynchronization.cache.SynchronizationCache;
import de.peaqe.javabedrocksynchronization.commands.SyncCommand;
import de.peaqe.javabedrocksynchronization.handler.DataHandler;
import de.peaqe.javabedrocksynchronization.listener.PlayerJoinListener;
import de.peaqe.javabedrocksynchronization.listener.PlayerMoveListener;
import de.peaqe.javabedrocksynchronization.listener.PlayerQuitListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JBS extends JavaPlugin {

    DataHandler dataHandler;
    SynchronizationCache synchronizationCache;
    PlayerDataCache playerDataCache;

    @Override
    public void onLoad() {
        this.dataHandler = new DataHandler();
        this.synchronizationCache = new SynchronizationCache();
        this.playerDataCache = new PlayerDataCache();
    }

    @Override
    public void onEnable() {
        new SyncCommand(this);
        new PlayerJoinListener(this);
        new PlayerMoveListener(this);
        new PlayerQuitListener(this);
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public SynchronizationCache getSynchronizationCache() {
        return synchronizationCache;
    }

    public PlayerDataCache getPlayerDataCache() {
        return playerDataCache;
    }
}
