package de.peaqe.javabedrocksynchronization.listener;

import de.peaqe.javabedrocksynchronization.JBS;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} PlayerQuitListener
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 21:18 Uhr
 * *
 */

public class PlayerQuitListener implements Listener {

    JBS jbs;

    public PlayerQuitListener(JBS jbs) {
        this.jbs = jbs;
        Bukkit.getPluginManager().registerEvents(this, jbs);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        var player = event.getPlayer();
        var playerData = this.jbs.getPlayerDataCache().getPlayerData(player.getName());

        if (playerData == null) {
            System.out.println("Failed to update data for " + player.getName());
            return;
        }

        this.jbs.getDataHandler().loadToDatabase(playerData);
        System.out.println("Successfully updated data for " + player.getName());

        this.jbs.getPlayerDataCache().removePlayerData(player.getName());

    }

}
