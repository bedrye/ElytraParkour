package me.bedrye.parkourgame.commands;

import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class CancelCommand extends DefaultCommand{

    public CancelCommand(){
        usage  = "cancel";
        description = "cancels the creation of the map";
        permission = "cancel";
        subClasses = new ArrayList();
    }
    @Override
    public void runCommand(CommandSender commandSender,@Nullable String s) throws Exception {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("[EP] cannot execute from console");
            return;
        }
        Player pl = (Player) commandSender;
        if (!StaticMethods.removeTemporary(pl)) {
            throw new IllegalArgumentException("You are not editing any map CAEX1");
        }
    }


}
