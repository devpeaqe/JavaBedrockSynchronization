package de.peaqe.javabedrocksynchronization.listener;

import de.peaqe.javabedrocksynchronization.JBS;
import de.peaqe.javabedrocksynchronization.handler.data.PlayerData;
import de.peaqe.javabedrocksynchronization.handler.inventory.InventoryHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} PlayerJoinListener
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 20:44 Uhr
 * *
 */

public class PlayerJoinListener implements Listener {

    JBS jbs;

    public PlayerJoinListener(JBS jbs) {
        this.jbs = jbs;
        Bukkit.getPluginManager().registerEvents(this, jbs);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws IOException {

        var player = event.getPlayer();
        var playerData = new PlayerData();

        if (player.getName().startsWith(".")) {
            playerData = this.jbs.getDataHandler().loadBedrockFromDatabase(player.getUniqueId());
        } else {
            playerData = this.jbs.getDataHandler().loadJavaFromDatabase(player.getUniqueId());
        }

        if (playerData == null) {
            this.jbs.getSynchronizationCache().addPlayer(player);
            return;
        }

        jbs.getPlayerDataCache().addPlayerData(player.getName(), playerData);

        player.getInventory().clear();
        player.getInventory().setContents(
                InventoryHandler.fromBase64(playerData.getInventory()).getContents());

        player.getInventory().setArmorContents(
                InventoryHandler.playerInventoryFromBase64(playerData.getInventory()).getArmorContents());

        player.getInventory().setExtraContents(
                InventoryHandler.playerInventoryFromBase64(playerData.getInventory()).getExtraContents());

        player.getInventory().setStorageContents(
                InventoryHandler.playerInventoryFromBase64(playerData.getInventory()).getStorageContents());

        player.teleport(playerData.getLocation());
        player.setTotalExperience(playerData.getXp());
        player.setHealth(playerData.getHealth());
        player.setFoodLevel(playerData.getFood());

        player.sendActionBar(Component.text("§aSynchronization erfolgreich!"));
        return;

    }

}


