package me.bedrye.parkourgame.commands;


import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class EditCommand extends DefaultCommand{

    public EditCommand(){
        usage = "edit";
        description = "desc";
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
            throw new IllegalArgumentException("Invalid index EDEX1");
        }
        StaticMethods.reedit(pl,Integer.parseInt(s));
        commandSender.sendMessage("Editing map with id of "+s);
    }


}
