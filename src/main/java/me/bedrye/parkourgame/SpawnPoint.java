package me.bedrye.parkourgame;

import org.bukkit.Location;


public class SpawnPoint {
    SpawnPoint(Location loc){
        location=loc;
    }
    private final Location location;
    public Location getLocation(){
        return location;
    }
    @Override
    public String toString(){
        return "Checkpoint's coordinates:"+location.getBlockX()+" "+location.getBlockY()+" "+location.getBlockZ();
    }


}
