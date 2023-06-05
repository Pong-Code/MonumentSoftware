package monumentossoftware.objetcs;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class AsyncUpdater {
    public static Monuments monuments = new Monuments();
    private static ScheduledExecutorService executor;

    //Task assincrona que vai executar de 5 em 5 minutos para atualizar o cache dos monumentos
    public static void startUpdatingMonuments(Monuments monuments) {
        System.out.println("Iniciado com sucesso o task!");
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if(Monuments.monumentMap.isEmpty()) {
                Mysql.fetchMonumentsFromDatabase(monuments);
            }else {
                updateMonumentsInList();
            }
            
            System.out.println("Atualizou, passou 5m?");
        }, 0, 5, TimeUnit.MINUTES);
    }

    public static void stopUpdatingMonuments() {
        if (executor != null) {
            executor.shutdown();
        }
    }
    
    
    public static void updateMonumentsInList() {
        //Atualizar a lista com todos os ids de monumentos da db
        Mysql.loadMonumentsFromDb();
        for (int id : Mysql.databaseMonumentIds) {
            //Verificar se tem algum ID que não exista
            if (!Monuments.monumentMap.containsKey(id)) {
                //Se encontrar algum, adiciona 
                Mysql.addMonumentInListById(id, monuments);
            }
        }
    }
    
    
    // Envia o email de recuperação de senha de forma assíncrona
    public static void sendRecoveryEmailAsync(String recipientEmail, String recoveryCode) {
        Runnable task = () -> Utils.sendRecoveryEmail(recipientEmail, recoveryCode);
        executor.execute(task);
    }
}
