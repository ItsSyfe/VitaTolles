package me.syfe.vitatolles;

import me.syfe.vitatolles.commands.GiveHeartCommand;
import me.syfe.vitatolles.commands.SetHealthCommand;
import me.syfe.vitatolles.events.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class VitaTolles extends JavaPlugin {

    public static final Logger LOGGER = Logger.getLogger("VitaTolles");

    @Override
    public void onEnable() {
        // Plugin startup logic
        LOGGER.info("VitaTolles has been enabled!");
        this.getCommand("giveheart").setExecutor(new GiveHeartCommand());
        this.getCommand("sethealth").setExecutor(new SetHealthCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        LOGGER.info("VitaTolles has been disabled!");
    }
}
