package me.syfe.vitatolles.events;

import me.syfe.vitatolles.utils.PlayerHealthUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerDeathEvent event) {
        Player playerKiller = event.getEntity().getKiller();
        Player playerKilled = event.getEntity();

        if (playerKiller != null) {
            // Player killer receives health
            PlayerHealthUtils.giveHeart(playerKiller);
            // Player killed loses health
            PlayerHealthUtils.takeHeart(playerKilled);
        }
    }
}
