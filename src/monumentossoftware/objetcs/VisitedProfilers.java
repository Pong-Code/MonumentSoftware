package monumentossoftware.objetcs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VisitedProfilers {
    //Map para guardar os perfis visitados (cache)
    private static Map<Integer, VisitedProfile> visitedProfiles = new HashMap<>();
    
    //Pegar um utilizador pelo ID, se não tiver no cache, buscar na base de dados
    public static VisitedProfile getVisitedProfileById(int id) {
        if (!visitedProfiles.containsKey(id)) {
            Mysql.addUserToVisitedProfiles(id); // TODO: Implementar o método addUserToVisitedProfiles
        }
        return visitedProfiles.get(id);
    }

    //Adiciona um perfil ao cache
    public static void addProfile(int id, String name, String role, String descuser, String email, String photo, Date date) {
        VisitedProfile profile = new VisitedProfile(id, name, role, descuser, email, photo, date);
        visitedProfiles.put(id, profile);
    }
}
