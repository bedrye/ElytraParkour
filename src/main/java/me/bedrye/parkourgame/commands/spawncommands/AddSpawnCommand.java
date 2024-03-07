package me.bedrye.parkourgame.commands.spawncommands;

import me.bedrye.parkourgame.Map;
import me.bedrye.parkourgame.StaticMethods;
import me.bedrye.parkourgame.commands.DefaultCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class AddSpawnCommand extends SpawnCommand {

    public AddSpawnCommand(){
        usage = "add";
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
            StaticMethods.addSpawnPoint(pl);
        }
        else {
            StaticMethods.addSpawnPoint(pl,Integer.parseInt(s));

        }
        commandSender.sendMessage("Added a new checkpoint to the map");
    }


}
