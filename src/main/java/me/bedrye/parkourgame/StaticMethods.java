package me.bedrye.parkourgame;

import org.bukkit.entity.Player;

import javax.naming.ContextNotEmptyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaticMethods {
    private static final Map<Player, me.bedrye.parkourgame.Map> tempMaps = new HashMap<>();
    private static final Map<Player, Session> sessions = new HashMap<>();
    private static final ArrayList<me.bedrye.parkourgame.Map> maps = new ArrayList<>();
    public static boolean addTemporary(Player p, me.bedrye.parkourgame.Map m){
        if (!tempMaps.containsKey(p)) {
            tempMaps.put(p, m);
            return false;
        }
        return true;
    }
    public static boolean removeTemporary(Player p) {
        if (tempMaps.containsKey(p)) {
            tempMaps.remove(p);
            return true;
        }
        return false;

    }
    public static boolean addSession(Player p, Session  m){
        if (!sessions.containsKey(p)) {
            sessions.put(p, m);
            return true;
        }
        return false;
    }
    public static boolean removeSession(Player p) {
        if (sessions.containsKey(p)) {
            sessions.remove(p);
            return true;
        }
        return false;

    }
    public static boolean isInSession(Player p){
        return sessions.containsKey(p);

    }
    public static boolean saveMap(Player p){
        if (tempMaps.containsKey(p)) {
            maps.add(tempMaps.get(p));
            tempMaps.remove(p);
            return false;
        }
        return true;
    }
    public static boolean isInTempMaps(Player p){
    return (tempMaps.containsKey(p));
    }
    public static String showInfo(int a) throws Exception{
        if (a<0||a>=maps.size())
            throw new IndexOutOfBoundsException("Index is out of bounds showInfoEX2");
        return maps.get(a).toString();

    }
    public static void deleteMap(int a) throws Exception{
        if (a<0||a>=maps.size())
            throw new IndexOutOfBoundsException("Index is out of bounds deleteMapEX2");
        maps.remove(a);

    }
    public static void addSpawnPoint(Player p )throws Exception{
        if (tempMaps.containsKey(p)) {
            tempMaps.get(p).addSpawnPoint(p.getLocation());
        }
        else {
            throw new ContextNotEmptyException("You are not editing any map addSpawnPointEX1");
        }
    }
    public static void addSpawnPoint(Player p ,int i)throws Exception{
        if (tempMaps.containsKey(p)) {
            tempMaps.get(p).addSpawnPoint(p.getLocation(),i);
        }
        else {
            throw new ContextNotEmptyException("You are not editing any map addSpawnPointEX2");
        }
    }
    public static void removeSpawnPoint(Player p ,int i)throws Exception{
        if (tempMaps.containsKey(p)) {
            tempMaps.get(p).removeSpawnPoint(i);
        }
        else {
            throw new ContextNotEmptyException("You are not editing any map removeSpawnPointEX2");
        }
    }
    public static void removeSpawnPoint(Player p )throws Exception{
        if (tempMaps.containsKey(p)) {
            tempMaps.get(p).removeSpawnPoint();
        }
        else {
            throw new ContextNotEmptyException("You are not editing any map removeSpawnPointEX2");
        }
    }
    public static void reedit(Player p, int a) throws Exception{
        if (tempMaps.containsKey(p))
            throw new CloneNotSupportedException("You are already editing other map reeditEX1");
        if (a<0||a>=maps.size())
            throw new IndexOutOfBoundsException("Index is out of bounds reeditEX2");
        tempMaps.put(p, maps.get(a));
        maps.remove(a);

    }
}
