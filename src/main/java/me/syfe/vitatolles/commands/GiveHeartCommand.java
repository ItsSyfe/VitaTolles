package me.syfe.vitatolles.commands;

import me.syfe.vitatolles.utils.PlayerHealthUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveHeartCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player recipient = Bukkit.getPlayer(args[0]);
            Player senderPlayer = (Player) sender;

            // Only give hearts if the player is online
            if (recipient != null && senderPlayer != recipient) {
                PlayerHealthUtils.giveHeart(recipient);
                recipient.sendMessage("§aYou received a heart from §e" + senderPlayer.getName());
                PlayerHealthUtils.takeHeart(senderPlayer);
                senderPlayer.sendMessage("§aYou gave a heart to §e" + recipient.getName());
            } else {
                senderPlayer.sendMessage("§cPlayer not found");
            }
            return true;
        }
        return false;
    }
}
