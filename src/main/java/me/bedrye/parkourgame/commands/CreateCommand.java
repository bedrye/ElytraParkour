package me.bedrye.parkourgame.commands;

import me.bedrye.parkourgame.Map;
import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class CreateCommand extends DefaultCommand{

    public CreateCommand(){
        usage = "create";
        description = "creates a new map";
        permission = "epicParkourGame";
        subClasses = new ArrayList();
    }

    @Override
    public void runCommand(CommandSender commandSender,@Nullable String s) throws Exception {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("[EP] cannot execute from console");
            return;
        }
        Player pl = (Player) commandSender;
        if (s==null) {
            throw new IllegalArgumentException("Cannot create a map.There is no name CREX1");
        }
        if (StaticMethods.addTemporary(pl, new Map(s, pl.getLocation()))) {
            throw new IllegalArgumentException("You are already editing a map CREX2");
        }
        commandSender.sendMessage("Created a new map");
    }



}
