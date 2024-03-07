package me.bedrye.parkourgame.commands;

import me.bedrye.parkourgame.Map;
import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SaveCommand extends DefaultCommand{
    public SaveCommand(){
        usage = "save";
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
        if (StaticMethods.saveMap(pl)) {
            throw new IllegalArgumentException("You are not editing any map SAEX1");
        }
        commandSender.sendMessage("Saved the map");
    }


}
