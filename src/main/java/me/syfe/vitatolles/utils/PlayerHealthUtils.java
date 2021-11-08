package me.syfe.vitatolles.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class PlayerHealthUtils {
    public static void takeHeart(Player player) {
        AttributeInstance maxHealth = getMaxHealth(player);

        if(maxHealth.getValue() - 2 <= 0) {
            eliminatePlayer(player);
        } else {
            maxHealth.setBaseValue(maxHealth.getValue() - 2);
        }
    }

    public static void giveHeart(Player player) {
        AttributeInstance maxHealth = getMaxHealth(player);

        if (player.getGameMode() == GameMode.SPECTATOR) {
            Location reviveLocation = player.getBedSpawnLocation() != null ? player.getBedSpawnLocation() : player.getWorld().getSpawnLocation();

            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(reviveLocation);
            Bukkit.broadcastMessage(player.getName() + " has been revived!");
        } else {
            maxHealth.setBaseValue(maxHealth.getValue() + 2);
        }
    }

    public static void setHealth(Player player, int hearts) {
        AttributeInstance maxHealth = getMaxHealth(player);

        maxHealth.setBaseValue(hearts);
    }

    public static AttributeInstance getMaxHealth(Player player) {
        return player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
    }

    public static void eliminatePlayer(Player player) {
        Bukkit.broadcastMessage(player.getName() + " has been eliminated!");
        player.setGameMode(GameMode.SPECTATOR);
    }
}
