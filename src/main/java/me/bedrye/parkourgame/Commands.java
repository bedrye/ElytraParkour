package me.bedrye.parkourgame;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if (commandSender instanceof ConsoleCommandSender) {
                commandSender.sendMessage("[EP] cannot execute from console");
                return true;
            }
            if (s.equalsIgnoreCase("ep")) {
                Player pl = (Player) commandSender;
                switch (strings[0]) {
                    case "create":
                        if (strings.length<2) {
                            throw new IllegalArgumentException("Cannot create a map.There is no name CREX1");
                        }
                        if (StaticMethods.addTemporary(pl, new Map(strings[1], pl.getLocation()))) {
                            throw new IllegalArgumentException("You are already editing a map CREX2");
                        }
                        commandSender.sendMessage("Created a new map");
                        break;
                    case "delete":
                        if (strings.length==1) {
                            throw new IllegalArgumentException("Invalid index DEEX1");
                        }
                        StaticMethods.reedit(pl,Integer.parseInt(strings[1]));
                        commandSender.sendMessage("Deleted the map");
                        break;
                    case "save":
                        if (StaticMethods.saveMap(pl)) {
                            throw new IllegalArgumentException("You are not editing any map SAEX1");
                        }
                        commandSender.sendMessage("Saved the map");
                        break;
                    case "edit":
                        if (strings.length<2) {
                            throw new IllegalArgumentException("Invalid index EDEX1");
                        }
                        StaticMethods.reedit(pl,Integer.parseInt(strings[1]));
                        commandSender.sendMessage("Editing map with id of "+strings[1]);
                        break;
                    case "cancel":
                        if (!StaticMethods.removeTemporary(pl)) {
                            throw new IllegalArgumentException("You are not editing any map CAEX1");
                        }
                        break;
                    case "info":
                        if (strings.length<2) {
                            throw new IllegalArgumentException("Invalid index INEX1");
                        }
                        commandSender.sendMessage(StaticMethods.showInfo(Integer.parseInt(strings[1])));
                        break;
                    case "addspawn":
                        if (strings.length<2) {
                            StaticMethods.addSpawnPoint(pl);
                        }
                        else {
                            StaticMethods.addSpawnPoint(pl,Integer.parseInt(strings[1]));

                        }
                        commandSender.sendMessage("Added a new checkpoint to the map");
                        break;
                    case "removespawn":
                        if (strings.length<2) {
                            StaticMethods.removeSpawnPoint(pl);
                        }
                        else {
                            StaticMethods.addSpawnPoint(pl,Integer.parseInt(strings[1]));
                        }
                        commandSender.sendMessage("Removed a checkpoint from the map");
                        break;
                    default:
                        return false;
                }
            }
        } catch (Exception e){
            Bukkit.getServer().getConsoleSender().sendMessage(e.getMessage());
            commandSender.sendMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
