package monumentossoftware.objetcs;


public class Users {
    
    private String name;
    private String email;
    private  String role;
    private int id;
    
    public Users(String name, String email, String role, int id) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.id = id;
    }
    
    public String getNAme() {
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
    
}
