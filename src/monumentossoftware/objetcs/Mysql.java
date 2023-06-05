package monumentossoftware.objetcs;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Mysql {
    //Lista que puxa os monumentos da base de dados de 5 em 5 minutos com a classe AsyncUpdater
    public static List<Integer> databaseMonumentIds = new ArrayList<>();

    //Credenciais para conexão da base de dados
    private static final String URL = "jdbc:mysql://localhost:3306/monuments";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //Usando Hikari para pool de conexões (melhor desempenho)
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;
    
    static {
    config.setJdbcUrl(URL);
    config.setUsername(USERNAME);
    config.setPassword(PASSWORD);
    dataSource = new HikariDataSource(config);
}
    
    // Método para obter uma conexão do pool
    public static Connection connect() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(0);
            return null;
        }
}
    
//**************Users**************
    
//Criação da tabela de Users
public static void createTableUsers() {
  String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
      + "id INTEGER PRIMARY KEY AUTO_INCREMENT,\n"
      + "name TEXT NOT NULL,\n"
      + "email TEXT NOT NULL UNIQUE,\n"
      + "password TEXT NOT NULL,\n"
      + "role TEXT NOT NULL,\n"
      + "about TEXT NOT NULL,\n"
      + "photo TEXT NOT NULL,\n"
      + "created_at DATE NOT NULL DEFAULT CURRENT_TIMESTAMP\n"
      + ");";
  try (Connection conn = connect();
      PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.executeUpdate();
    System.out.println("Tabela 'users' criada com sucesso!");
  } catch (SQLException e) {
    System.out.println(e.getMessage());
    System.exit(0);
  }
}



//Procura o dono de um monumento
public static void addUserToVisitedProfiles(int id) {
    String sql = "SELECT name, email, created_at, about, role, photo FROM Users WHERE id = ?";
    try (Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date createdAt = rs.getDate("created_at");
            String desc = rs.getString("about");
            String photo = rs.getString("photo");
            String role = rs.getString("role");
            if(desc.equals("")) {
                desc = "Nada sobre o utilizador";
            }
            VisitedProfilers profile = new VisitedProfilers();
            profile.addProfile(id, name, role,desc, email, photo,createdAt);
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}



// Verifica o Login e guarda os valores do utilizador na classe User
public static boolean login(String email, String password) {
    String sql = "SELECT * FROM Users WHERE email = ?";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String hashedPassword = rs.getString("password");
            if (BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified) {
                // Senhas correspondem
                String name = rs.getString("name");
                String about = rs.getString("about");
                String role = rs.getString("role");
                int id = rs.getInt("id");
                String photo = rs.getString("photo");
                Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
                Date createdAt = new Date(createdAtTimestamp.getTime());
                User.user = new User(name, about, email, role, id,photo, createdAt);
                System.out.println(User.user.getName());
                return true;
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    System.out.println("email: " + email);
    System.out.println("password: " + password);
    return false;
}


//Atualizar os dados do Utilizador
public static boolean UpdateUserFields(int userId, String name, String role, String about, String photo, boolean updatephoto) {
    String sql;
    int number = 4;
    //Verificar se precisa atualizar a foto de perfil
    if(updatephoto) {
        sql = "UPDATE Users SET name = ?, role = ?, about = ?, photo = ? WHERE id = ?";
        number = 5;
    }else {
        sql = "UPDATE Users SET name = ?, role = ?, about = ? WHERE id = ?";
    }
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, name);
        stmt.setString(2, role);
        stmt.setString(3, about);
        if(updatephoto) {
            stmt.setString(4,photo);
            
        }
        stmt.setInt(number,userId);
        
        //Executar
         stmt.executeUpdate();
         User.user.updateFields(name, about, role, "", false);
         VisitedProfilers profile = new VisitedProfilers();
         VisitedProfile profile1 = profile.getVisitedProfileById(User.user.getId());
         profile1.updateFields(name, about, role, "", false);
         System.out.println("Campos do usuário atualizados com sucesso!");
         return true;
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar os campos do usuário: " + e.getMessage());
        return false;
    }
}



//Inserir User
public static boolean insertUser(String name, String email, String password) {
    String sql = "INSERT INTO Users(name, email, password, role, about, photo) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, Utils.encriptarPassword(password));
        pstmt.setString(4, "visitante");
        pstmt.setString(5, "");
        pstmt.setString(6,"");
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

//Verifica se o email já está registrado
public static boolean emailExists(String email) {
    String sql = "SELECT * FROM Users WHERE email = ?";
    System.out.println("2 " + email);
    try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return false;
}

//Função de mudar a senha do utilizador
public static void changeUserPassword(String email, String newPassword) {
    String sql = "UPDATE Users SET password = ? WHERE email = ?";
    try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, newPassword);
        pstmt.setString(2, email);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Senha do usuário " + email + " atualizada com sucesso!");
        } else {
            System.out.println("Não foi possível atualizar a senha do usuário " + email);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.exit(0);
    }
}
        



//**************Monumentos**************

//Criar base de dados monumento
public static void createTableMonumentos() {
    String sql = "CREATE TABLE IF NOT EXISTS Monuments (\n"
            + " id INTEGER PRIMARY KEY AUTO_INCREMENT,\n"
            + " id_user INTEGER NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " description TEXT NOT NULL,\n"
            + " country TEXT NOT NULL,\n"
            + " status TEXT NOT NULL,\n"
            + " year VARCHAR(255) NOT NULL,\n"
            + " latitude DOUBLE NOT NULL,\n"
            + " longitude DOUBLE NOT NULL,\n"
            + " photo TEXT NOT NULL,\n"
            + " FOREIGN KEY(id_user) REFERENCES Users(id)\n"
            + ");";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela Monuments criada com sucesso.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

//Função de deletar um monumento da base de dados
public static void deleteMonumentFromDb(int monumentId) {
    String sql = "DELETE FROM Monuments WHERE id = ?;";
    
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, monumentId);
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        System.out.println("Erro ao remover monumento da base de dados: " + e.getMessage());
    }
}


//Atualizar os dados do Monumento
public static boolean UpdateMonumentFields(int MonumentId, String name, String desc, String country, String status, String year, String photo, boolean updatephoto) {
    String sql;
    int number = 6;
    //Verificar se precisa atualizar a foto de perfil
    if(updatephoto) {
        sql = "UPDATE Monuments SET name = ?, description = ?, country = ?, status = ?, year = ?, photo = ? WHERE id = ?";
        number = 7;
    }else {
        sql = "UPDATE Monuments SET name = ?, description = ?, country = ?, status = ?, year = ? WHERE id = ?";
    }
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, name);
        stmt.setString(2, desc);
        stmt.setString(3, country);
        stmt.setString(4, status);
        stmt.setString(5, year);
        if(updatephoto) {
            stmt.setString(6,photo);
            
        }
        stmt.setInt(number,MonumentId);
        //Executar
         stmt.executeUpdate();
         return true;
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar os campos do usuário: " + e.getMessage());
        return false;
    }
}

//Puxa todos os monumentos da base de dados para o cache (quando o programa inicia) pela Classe AsyncUpdater
public static void fetchMonumentsFromDatabase(Monuments monuments) {
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Monuments")) {
         monuments.clearMonuments();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            int owner = rs.getInt("id_user");
            String country = rs.getString("country");
            String status = rs.getString("status");
            String year = rs.getString("year");
            String desc = rs.getString("description");
            String photo = rs.getString("photo");
            // Adiciona o monumento à lista de monumentos na classe Monuments
            monuments.addMonument(id, name, year, desc, country, latitude, longitude, owner, status, photo);
        }
        System.out.println(monuments.getSize() + " Monumentos buscados com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao buscar monumentos: " + e.getMessage());
    }
}



public static void loadMonumentsFromDb() {
    if (!databaseMonumentIds.isEmpty()) {
        databaseMonumentIds.clear();
    }
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT id FROM Monuments")) {
        
        while (rs.next()) {
            int id = rs.getInt("id");
            databaseMonumentIds.add(id);
        }
        
    } catch (SQLException e) {
        System.out.println("Erro ao carregar monumentos do banco de dados: " + e.getMessage());
    }
}


public static void addMonumentInListById(int id, Monuments monuments) {
    String sql = "SELECT * FROM Monuments WHERE id = ?";
    

    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String country = rs.getString("country");
            String status = rs.getString("status");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            int owner = rs.getInt("id_user");
            String year = rs.getString("year");
            String desc = rs.getString("description");
            String photo = rs.getString("photo");
            monuments.addMonument(id, name, year, desc, country, latitude, longitude, owner, status, photo);
        }

        rs.close();
    } catch (SQLException e) {
        System.out.println("Erro ao buscar monumento por ID: " + e.getMessage());
    }
}


//Inserir Monumento e retorna o ID do monumento inserido
public static boolean insertMonument(String name,String description, String country, String estado, String year, double latitude, double longitude, int owner, String photo) {
    String sql = "INSERT INTO Monuments(name, description, country, status, year, id_user, latitude, longitude, photo) VALUES(?,?,?,?,?,?,?,?,?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, description);
        pstmt.setString(3, country);
        pstmt.setString(4, estado);
        pstmt.setString(5, year);
        pstmt.setInt(6, owner);
        pstmt.setDouble(7, latitude);
        pstmt.setDouble(8, longitude);
        pstmt.setString(9, photo);
        pstmt.executeUpdate();
        //Adicionado monumento com sucesso na db!
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao inserir monumento: " + e.getMessage());
        return false;
    }
}

public static boolean deleteMonument(int monumentId) {
    String deleteClassificationsSql = "DELETE FROM Classifications WHERE monumento_id = ?";
    String deleteMonumentSql = "DELETE FROM Monuments WHERE id = ?";
    
    try (Connection conn = connect();
         PreparedStatement deleteClassificationsStmt = conn.prepareStatement(deleteClassificationsSql);
         PreparedStatement deleteMonumentStmt = conn.prepareStatement(deleteMonumentSql)) {
        
        // Excluir as classificações associadas ao monumento
        deleteClassificationsStmt.setInt(1, monumentId);
        deleteClassificationsStmt.executeUpdate();
        
        // Excluir o monumento
        deleteMonumentStmt.setInt(1, monumentId);
        int rowsDeleted = deleteMonumentStmt.executeUpdate();
        
        if (rowsDeleted > 0) {
            // Monumento eliminado com sucesso
            return true;
        } else {
            // Não foi encontrado um monumento com o ID fornecido
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao eliminar monumento: " + e.getMessage());
        return false;
    }
}



//**************Classificações**************

//Criar tabela Classificação
public static void createClassificationsTable() {
    String sql = "CREATE TABLE IF NOT EXISTS Classifications (\n"
               + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
               + "monumento_id INT NOT NULL,\n"
               + "usuario_id INT NOT NULL,\n"
               + "classification INT NOT NULL,\n"
               + "FOREIGN KEY (monumento_id) REFERENCES Monuments(id),\n"
               + "FOREIGN KEY (usuario_id) REFERENCES Users(id)\n"
               + ");";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela Classifications criada com sucesso!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

// Função para calcular a média de classificação por monumento
    public static double calculateAverageRatingForMonument(int monumentId) {
        String sql = "SELECT AVG(classification) FROM Classifications WHERE monumento_id = ?";
        
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, monumentId);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return 0.0;
    }
    
    // Função para o utilizador classificar e atualizar a base de dados
    public static void rateMonument(int userId, int monumentId, int rating) {
        //Raramente nega esta verificação, pois já é verificado antes, mas é uma questão de segurança
        if (rating < 1 || rating > 5) {
            System.out.println("Avaliação inválida. A classificação deve estar entre 1 e 5.");
            return;
        }
        String sql = "INSERT INTO Classifications(monumento_id, usuario_id, classification) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, monumentId);
            stmt.setInt(2, userId);
            stmt.setInt(3, rating);
            stmt.executeUpdate();
            System.out.println("Classificação registrada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Verificar se o utilizador já classificou um monumento
    public static boolean hasUserRatedMonument(int userId, int monumentId) {
        String sql = "SELECT COUNT(*) FROM Classifications WHERE usuario_id = ? AND monumento_id = ?";
        
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, monumentId);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }


public static void createTables() {
    createTableUsers();
    createTableMonumentos();
    createClassificationsTable();
}
}
