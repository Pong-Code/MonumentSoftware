package monumentossoftware.objetcs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitedProfile {
    
    private String name;
    private String email;
    private Date createdAt;

    public VisitedProfile(String name, String email, Date createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAtAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return dateFormat.format(createdAt);
    }
    
}
    
