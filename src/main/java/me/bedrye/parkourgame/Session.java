package me.bedrye.parkourgame;

import org.bukkit.entity.Player;

public class Session {
    private final Map map;
    private final Player player;
    private int spawnPointNumber;

    public Session(Map m, Player p){
        map = m;
        player = p;
        spawnPointNumber=0;
    }

    public int getSpawnPointNumber() {
        return spawnPointNumber;
    }

    public void setSpawnPointNumber(int spawnPointNumber) {
        this.spawnPointNumber = spawnPointNumber;
    }
    public void resetPlayer(){
        player.teleport(map.getSpawnPoint(spawnPointNumber).getLocation());
    }
    public void fullResetPlayer(){
        player.teleport(map.getLobby());
    }

}
