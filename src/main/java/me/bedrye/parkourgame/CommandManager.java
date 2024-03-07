package me.bedrye.parkourgame;

import me.bedrye.parkourgame.commands.DefaultCommand;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            DefaultCommand cmd = new DefaultCommand();
            DefaultCommand newCmd;
            int i=0;
            for (;i<strings.length;i++) {
                newCmd = cmd.getSubClass(strings[i]).newInstance();
                if(cmd.getUsage().equals(newCmd.getUsage())) {break;}
                cmd = newCmd;
            }
            if(i==strings.length-1){
                cmd.runCommand(commandSender,strings[i]);
            }
            else {
                cmd.runCommand(commandSender, null);
            }
        } catch (Exception e){
            Bukkit.getServer().getConsoleSender().sendMessage(e.getMessage());
            commandSender.sendMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
