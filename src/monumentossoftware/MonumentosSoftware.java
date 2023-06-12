package monumentossoftware;

import monumentossoftware.interfaces.login.FormLogin;
import monumentossoftware.objetcs.Mysql;


public class MonumentosSoftware {

    public static void main(String[] args) {
        //Cria as tabelas Mysql na db "monuments" se ainda não existirem
        Mysql.createTables();
        //Inicia o programa pela form Login
        FormLogin login = new FormLogin();
        login.show();
    }
    
}
