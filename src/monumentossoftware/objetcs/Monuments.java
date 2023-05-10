package monumentossoftware.objetcs;


public class Monuments {
    private int id;
    private String name;
    private String country;
    private String state;
    private double latitude;
    private double longitude;

    public Monuments(int id, String name, String country, String state, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
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
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
