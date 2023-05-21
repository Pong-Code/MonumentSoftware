package monumentossoftware.objetcs;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class AsyncUpdater {
    private static ScheduledExecutorService executor;

    //Task assincrona que vai executar de 5 em 5 minutos
    public static void startUpdatingMonuments(Monuments monuments) {
        System.out.println("Iniciado com sucesso o task!");
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if(Monuments.monumentMap.isEmpty()) {
                Mysql.fetchMonumentsFromDatabase();
            }else{
                updateMonumentsInDb();
            }
            updateMonumentsInList();
            updateDbWithNewMonuments();
            System.out.println("Atualizou, passou 5m?");
        }, 0, 5, TimeUnit.MINUTES);
    }

    public static void stopUpdatingMonuments() {
        if (executor != null) {
            executor.shutdown();
        }
    }
    
    //Elimina na db os monumentos que já não existem
    private static void updateMonumentsInDb() {
        Mysql.loadMonumentsFromDb();
        for (int id : Mysql.databaseMonumentIds) {
            if (!Monuments.monumentMap.containsKey(id)) {
                Mysql.deleteMonumentFromDb(id);
            }
        }
    }
    
    private static void updateMonumentsInList() {
        for (int id : Mysql.databaseMonumentIds) {
            if (!Monuments.monumentMap.containsKey(id)) {
                Mysql.addMonumentInListById(id);
            }
        }
    }
    
    private static void updateDbWithNewMonuments() {
        for (int id : Monuments.monumentMap.keySet()) {
            if (!Mysql.databaseMonumentIds.contains(id)) {
                Monuments.Monument monument = Monuments.monumentMap.get(id);
                Mysql.insertMonument(monument.getName(), monument.getDesc(), monument.getCountry(), monument.getState(), monument.getYear(), monument.getLatitude(), monument.getLongitude(), monument.getOwner());
            }
        }
    }
    
}
