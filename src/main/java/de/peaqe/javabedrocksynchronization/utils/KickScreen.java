package de.peaqe.javabedrocksynchronization.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} KickScreen
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 21:12 Uhr
 * *
 */

public class KickScreen {

    String kickMessage() {
        return """
                §8« §3§lJBS §8»\s

                §7Du wurdest erfolgreich registriert!
                §7Du kannst den Server nun wieder betreten.""";

    }

    public void send(Player player) {
        player.kick(Component.text(kickMessage()));
    }

}
