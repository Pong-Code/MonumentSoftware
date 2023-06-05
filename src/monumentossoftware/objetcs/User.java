package monumentossoftware.objetcs;

import java.text.SimpleDateFormat;
import java.util.Date;


public class User {
    
    public static User user;
    
    private String name;
    private String about;
    private final String email;
    private  String role;
    private final int id;
    private String photo;
    private final Date createdAt;
    
    public void updateFields(String name, String about, String role, String photo, boolean checkphoto) {
        this.name = name;
        this.about = about;
        this.role = role;
        if(checkphoto) this.photo = photo;
    }
    
    public User(String name, String about, String email, String role, int id, String photo, Date createdAt) {
        this.name = name;
        this.about = about;
        this.email = email;
        this.role = role;
        this.id = id;
        this.photo = photo;
        this.createdAt = createdAt;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getRole() {
        return role;
    }
    public int getId() {
        return id;
    }
    public String getPhoto() {
        return photo;
    }
    public String getAbout() {
        return about;
    }
    
    public String getCreatedAtAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return dateFormat.format(createdAt);
    }
    
    public void clearUser() {
    user = null;
}
    
}
