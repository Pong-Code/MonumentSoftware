package monumentossoftware.objetcs;

import java.util.HashMap;
import java.util.Map;

public class Monuments {
    public static Map<Integer, Monument> monumentMap;

    public Monuments() {
        monumentMap = new HashMap<>();
    }
    
    public void addMonument(int id, String name, String year, String desc, String country, double latitude, double longitude, int owner, String status, String photo) {
        Monument monument = new Monument(id, name, year, desc, country, latitude, longitude, owner, status, photo);
        monumentMap.put(id, monument);
    }
    
    public int getSize() {
        return monumentMap.size();
    }
    
    public void clearMonuments() {
        monumentMap.clear();
    }

    public Monument getMonumentById(int id) {
        return monumentMap.get(id);
    }

    public void removeMonument(int id) {
        monumentMap.remove(id);
    }
}
