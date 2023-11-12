package de.peaqe.javabedrocksynchronization.commands;

import de.peaqe.javabedrocksynchronization.JBS;
import de.peaqe.javabedrocksynchronization.handler.data.PlayerData;
import de.peaqe.javabedrocksynchronization.handler.inventory.InventoryHandler;
import de.peaqe.javabedrocksynchronization.utils.KickScreen;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} SyncCommand
 * *
 * Information's:
 * {@code @type:} Java-Class (Bukkit Command)
 * {@code @date:} 12.11.2023 | 21:05 Uhr
 * *
 */

public class SyncCommand implements CommandExecutor, TabExecutor {

    JBS jbs;

    public SyncCommand(JBS jbs) {
        this.jbs = jbs;
        Objects.requireNonNull(Bukkit.getPluginCommand("sync")).setExecutor(this);
        Objects.requireNonNull(Bukkit.getPluginCommand("sync")).setTabCompleter(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return true;
        if (!(args.length == 1)) return true;

        var arg = args[0];
        var target = Bukkit.getPlayer(arg);

        if (target == null) return true;

        if (!player.getName().startsWith(".") && target.getName().startsWith(".")) {

            // Right format
            var bedrockName = target.getName();
            var bedrockUniqueID = target.getUniqueId().toString();

            var playerData = new PlayerData(
                    player.getName(),
                    player.getUniqueId().toString(),
                    bedrockName,
                    bedrockUniqueID,
                    InventoryHandler.toBase64(player.getInventory()),
                    player.getTotalExperience(),
                    player.getLocation(),
                    player.getHealth(),
                    player.getFoodLevel()
            );

            this.jbs.getDataHandler().loadToDatabase(playerData);

            this.jbs.getPlayerDataCache().addPlayerData(target.getName(), playerData);
            this.jbs.getPlayerDataCache().addPlayerData(player.getName(), playerData);

            new KickScreen().send(target);
            new KickScreen().send(player);

            this.jbs.getSynchronizationCache().removePlayer(player);
            this.jbs.getSynchronizationCache().removePlayer(target);

        }


        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        ArrayList<String> matches = new ArrayList<>();

        if (args.length == 1) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                if (player.getName().startsWith(".")) {
                    if (this.jbs.getPlayerDataCache().getPlayerData(player.getName()) != null) return;
                    matches.add(player.getName());
                }
            });
        }

        return matches;
    }
}

