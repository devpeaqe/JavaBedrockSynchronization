package de.peaqe.javabedrocksynchronization.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} SynchCommand
 * * 
 * Information's:
 * {@code @type:} Java-Class (Bukkit Command)
 * {@code @date:} 12.11.2023 | 21:05 Uhr
 * * 
 */

public class SynchCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        ArrayList<String> matches = new ArrayList<>();
        
        return matches;
    }
}

