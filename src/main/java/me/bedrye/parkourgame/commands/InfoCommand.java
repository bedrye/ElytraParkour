package me.bedrye.parkourgame.commands;

import me.bedrye.parkourgame.Map;
import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class InfoCommand extends DefaultCommand{

    public InfoCommand(){
        usage = "info";
        description = "creates a new map";
        permission = "info";
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
            throw new IllegalArgumentException("Invalid index INEX1");
        }
        commandSender.sendMessage(StaticMethods.showInfo(Integer.parseInt(s)));
    }


}
