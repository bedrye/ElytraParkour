package me.bedrye.parkourgame;

import org.bukkit.Location;

import javax.naming.ContextNotEmptyException;
import java.util.ArrayList;

public class Map {
    private String mapName;
    private ArrayList<SpawnPoint> spawnPoints = new ArrayList<>();
    private Location lobby;
    public Map(String string, Location loc){
        mapName = string;
        lobby = loc;
    }
    public void removeSpawnPoint(int i) throws  Exception{
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
