package monumentossoftware.objetcs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitedProfile {
    private final int id;
    private String name;
    private final Date createdAt;
    private final String email;
    private String photo;
    private String descuser;
    private String role;

    public VisitedProfile(int id, String name, String role, String descuser, String email, String photo, Date date) {
        this.id = id;
        this.name = name;
        this.descuser = descuser;
        this.email = email;
        this.photo = photo;
        this.createdAt = date;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAtAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(createdAt);
    }

    public String getEmail() {
        return email;
    }

    public String getDesc() {
        return descuser;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRole() {
        return role;
    }

    public void updateFields(String name, String about, String role, String photo, boolean checkphoto) {
        this.name = name;
        this.descuser = about;
        this.role = role;
        if (checkphoto) {
            this.photo = photo;
        }
    }
}

