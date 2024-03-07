package me.bedrye.parkourgame.commands.spawncommands;

import me.bedrye.parkourgame.StaticMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class RemoveSpawnCommand extends SpawnCommand {
    public RemoveSpawnCommand(){
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
            StaticMethods.removeSpawnPoint(pl);
        }
        else {
            StaticMethods.removeSpawnPoint(pl,Integer.parseInt(s));
        }
        commandSender.sendMessage("Removed a checkpoint from the map");
    }


}
