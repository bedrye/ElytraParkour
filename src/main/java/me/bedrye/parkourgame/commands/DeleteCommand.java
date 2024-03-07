package me.bedrye.parkourgame.commands;

import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class DeleteCommand extends DefaultCommand{
    public DeleteCommand(){
        usage = "delete";
        description = "deletes the map";
        permission = "delete";
        subClasses = new ArrayList();
    }

    @Override
    public void runCommand(CommandSender commandSender,@Nullable String s) throws Exception {
        if (s == null) {
            throw new IllegalArgumentException("Invalid index DEEX1");
        }
        StaticMethods.deleteMap(Integer.parseInt(s));
        commandSender.sendMessage("Deleted the map");
    }

}
