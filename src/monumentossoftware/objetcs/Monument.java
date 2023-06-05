package monumentossoftware.objetcs;

public class Monument {
    private final int id;
    private String name;
    private String country;
    private String status;
    private final double latitude;
    private final double longitude;
    private String year;
    private String desc;
    private final int owner;
    private String photo;

    public Monument(int id, String name, String year, String desc, String country, double latitude, double longitude, int owner, String status, String photo) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;
        this.desc = desc;
        this.owner = owner;
        this.photo = photo;
    }

    public void updateFields(String name, String desc, String country, String status, String year, String photo, boolean checkPhoto) {
        this.name = name;
        this.desc = desc;
        this.country = country;
        this.status = status;
        this.year = year;
        if (checkPhoto) {
            this.photo = photo;
        }
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

    public String getStatus() {
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

    public String getPhoto() {
        return photo;
    }
}
