package me.bedrye.parkourgame.commands.spawncommands;

import com.sun.tools.javac.util.List;
import me.bedrye.parkourgame.Map;
import me.bedrye.parkourgame.StaticMethods;
import me.bedrye.parkourgame.commands.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class SpawnCommand extends DefaultCommand {
    public SpawnCommand(){
        usage = "spawn";
        description = "creates a new map";
        permission = "epicParkourGame";
        subClasses = new ArrayList<>( Arrays.asList(
                AddSpawnCommand.class,
                RemoveSpawnCommand.class
        )) ;
    }
    @Override
    public void runCommand(CommandSender commandSender,@Nullable String s) throws Exception {

    }


}
