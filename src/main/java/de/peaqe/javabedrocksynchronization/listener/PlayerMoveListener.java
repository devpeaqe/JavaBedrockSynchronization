package de.peaqe.javabedrocksynchronization.listener;

import de.peaqe.javabedrocksynchronization.JBS;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} PlayerMoveListener
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 20:56 Uhr
 * *
 */

public class PlayerMoveListener implements Listener {

    JBS jbs;

    public PlayerMoveListener(JBS jbs) {
        this.jbs = jbs;
        Bukkit.getPluginManager().registerEvents(this, jbs);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (jbs.getSynchronizationCache().playerInList(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

}
