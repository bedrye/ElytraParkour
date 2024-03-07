package me.bedrye.parkourgame;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.bukkit.plugin.java.JavaPlugin.getProvidingPlugin;

public class Map {
    private String mapName;
    private final ArrayList<SpawnPoint> spawnPoints = new ArrayList<>();
    private Location lobby;
    public Map(String string, Location loc){
        mapName = string;
        lobby = loc;
    }
    public void removeSpawnPoint(int i) throws IndexOutOfBoundsException{
        if (0 <= i && i < spawnPoints.size()) {
            spawnPoints.remove(i);
        }
        else  {
            throw new IndexOutOfBoundsException("Invalid Index MP.removeSpawnPointEX1");
        }
    }
    public void removeSpawnPoint() {
            spawnPoints.remove( spawnPoints.size()-1);
    }
    public void addSpawnPoint(Location loc,int i) {
        if (0 <= i && i <= spawnPoints.size()) {
            spawnPoints.add(i,new SpawnPoint(loc));
        }
        else  {
            throw new IndexOutOfBoundsException("Invalid Index MP.addSpawnPointEX1");
        }
    }
    public void addSpawnPoint(Location loc) {
            spawnPoints.add(new SpawnPoint(loc));
    }
    public SpawnPoint getSpawnPoint(int i){
        return spawnPoints.get(i);
    }

    public String getMapName() {
        return mapName;
    }
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }

    public Location getLobby() {
        return lobby;
    }
    protected void writeToYML(int a) throws IOException {
        File userfile = new File(getProvidingPlugin(ParkourGame.class).getDataFolder()+File.separator+"Maps"+File.separator+a+"-"+mapName+".yml");
        FileConfiguration mapConfig = YamlConfiguration.loadConfiguration(userfile);
        mapConfig.set("saved.name",mapName);
        mapConfig.set("saved.lobby.x",lobby.getX());
        mapConfig.set("saved.lobby.y",lobby.getY());
        mapConfig.set("saved.lobby.z",lobby.getZ());
        mapConfig.set("saved.lobby.world",lobby.getWorld().getName());
        for (int i =0;i<spawnPoints.size();i++) {
            mapConfig.set("saved.spawns."+i+".x",spawnPoints.get(i).getLocation().getX());
            mapConfig.set("saved.spawns."+i+".y",spawnPoints.get(i).getLocation().getY());
            mapConfig.set("saved.spawns."+i+".z",spawnPoints.get(i).getLocation().getZ());
            mapConfig.set("saved.spawns."+i+".world",spawnPoints.get(i).getLocation().getWorld().getName());

        }
        mapConfig.save(userfile);


    }

    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder(mapName +
                "\nLobby's coordinates:" + lobby.getBlockX() + " " + lobby.getBlockY() + " " + lobby.getBlockZ() +
                "\nNumber of checkpoints:" + spawnPoints.size()+
                "\nCheckpoints: \n")
                ;
        for (int i=0;i<spawnPoints.size();i++) {
             temp.append(i).append(spawnPoints.get(i).toString()).append("\n");
        }
        return temp.toString();
    }

}
