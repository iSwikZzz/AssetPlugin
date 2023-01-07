package me.iswikzzz.atouts.commands;

import me.iswikzzz.atouts.gui.AssetGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AssetCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player )
            new AssetGui().open((Player) sender);


        return false;
    }
}
