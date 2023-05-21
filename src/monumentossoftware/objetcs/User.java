package monumentossoftware.objetcs;

import java.text.SimpleDateFormat;
import java.util.Date;


public class User {
    
    public static User user;
    
    private String name;
    private String email;
    private  String role;
    private int id;
    private Date createdAt;
    
    public User(String name, String email, String role, int id, Date createdAt) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.id = id;
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
    public int getid() {
        return id;
    }
    
    public String getCreatedAtAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return dateFormat.format(createdAt);
    }
    
}
