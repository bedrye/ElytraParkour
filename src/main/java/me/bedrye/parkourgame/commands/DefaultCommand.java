package me.bedrye.parkourgame.commands;

import com.sun.tools.javac.util.List;
import me.bedrye.parkourgame.commands.spawncommands.SpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class DefaultCommand {

    protected String usage;
    protected String description;
    protected String permission;

    protected ArrayList< Class<? extends DefaultCommand> > subClasses;

    public String getFullCommand(){
        return usage;
    }
    public String getFullPermission(){
        return permission;
    }
    public DefaultCommand(){
        usage = "ep";
        description = "main command";
        permission = "epicParkourGame";
        subClasses = new ArrayList<>( Arrays.asList(
                CancelCommand.class,
                CreateCommand.class,
                DeleteCommand.class,
                EditCommand.class,
                InfoCommand.class,
                SaveCommand.class,
                SpawnCommand.class
        ));
    }
    public Class<? extends DefaultCommand> getSubClass(String s) throws InstantiationException, IllegalAccessException {
        DefaultCommand g;
        for (Class<? extends DefaultCommand> c:subClasses
             ) {
            g= c.newInstance();
            Bukkit.getServer().getConsoleSender().sendMessage(c.toString());
            if(g.getUsage().equals(s)) return c;
        }
        return this.getClass();

    }
    public String getUsage(){
        return usage;
    }

    public void runCommand(CommandSender commandSender,@Nullable String s) throws Exception{};


}
