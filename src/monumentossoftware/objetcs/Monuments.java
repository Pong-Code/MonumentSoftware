package monumentossoftware.objetcs;



import java.util.HashMap;
import java.util.Map;

public class Monuments {
    public static Map<Integer, Monument> monumentMap;

    public Monuments() {
        monumentMap = new HashMap<>();
    }
    
    public void addmonument(int id, String name, String year,String desc, String country, double latitude, double longitude, int owner, String status) {
        Monument monument = new Monument(id, name, year, desc, country, latitude, longitude, owner, status);
        monumentMap.put(id, monument);
    }
    
    public void clearmonuments() {
        monumentMap.clear();
    }

    public Monument getMonumentById(int id) {
        return monumentMap.get(id);
    }

    public void removeMonument(int id) {
        monumentMap.remove(id);
    }

    public class Monument {
        private int id;
        private String name;
        private String country;
        private String status;
        private double latitude;
        private double longitude;
        private String year;
        private String desc;
        private int owner;

        public Monument(int id, String name, String year,String desc, String country, double latitude, double longitude, int owner, String status) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.status = status;
            this.latitude = latitude;
            this.longitude = longitude;
            this.year = year;
            this.desc = desc;
            this.owner = owner;
            
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public String getState() {
            return status;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
        public String getYear() {
            return year;
        }
        public String getDesc() {
            return desc;
        }
        public int getOwner() {
            return owner;
        }
    }
}

