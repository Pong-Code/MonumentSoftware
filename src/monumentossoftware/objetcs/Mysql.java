package monumentossoftware.objetcs;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Mysql {
    
    public static List<Integer> databaseMonumentIds = new ArrayList<>();

    
    private static final String URL = "jdbc:mysql://localhost:3306/monuments";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    // Faz a conexão com a base de dados
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return conn;
    }

//**************Users**************

//Cria a tabela users
public static void createTableUsers() {
    String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
            + "id INTEGER PRIMARY KEY AUTO_INCREMENT,\n"
            + "name TEXT NOT NULL,\n"
            + "email TEXT NOT NULL UNIQUE,\n"
            + "password TEXT NOT NULL,\n"
            + "role TEXT NOT NULL,\n"
            + "sobre TEXT NOT NULL,\n"
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
public static String getName(int iduser) {
    try {
        Connection conn = connect();
        String sql = "SELECT * FROM Users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, iduser);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("name");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return "null";
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
                String role = rs.getString("role");
                int id = rs.getInt("id");
                Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
                Date createdAt = new Date(createdAtTimestamp.getTime());
                User.user = new User(name, email, role, id, createdAt);
                if(User.user == null) {
                    System.out.println(User.user.getName());
                }
                
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

//Inserir User
public static boolean insertUser(String name, String email, String password) {
    String sql = "INSERT INTO Users(name, email, password, role, sobre) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, Utils.EncriptarPassword(password));
        pstmt.setString(4, "visitante");
        pstmt.setString(5, "");
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}


public static User getUserById(int id) {
    String sql = "SELECT * FROM Users WHERE id = ?";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String role = rs.getString("role");
            Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
            Date createdAt = new Date(createdAtTimestamp.getTime());
            return new User(name, email, role, id, createdAt);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
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

public static String getCreateAt(int id) {
    String sql = "SELECT * FROM Users WHERE id = ? AND senha = ?";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
            Date createdAt = new Date(createdAtTimestamp.getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
            return dateFormat.format(createdAt);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return "null";
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


public static void fetchMonumentsFromDatabase() {
    Monuments monuments = new Monuments();
    monuments.clearmonuments();
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Monuments")) {
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
            // Adiciona o monumento à lista de monumentos na classe Monuments
            monuments.addmonument(id, name, year, desc, country, latitude, longitude, owner, status);
        }
        System.out.println("Monumentos buscados com sucesso!");
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

public static void addMonumentInListById(int id) {
    String sql = "SELECT * FROM Monuments WHERE id = ?";
    Monuments monuments = new Monuments();

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

            monuments.addmonument(id, name, year, desc, country, latitude, longitude, owner, status);
        }

        rs.close();
    } catch (SQLException e) {
        System.out.println("Erro ao buscar monumento por ID: " + e.getMessage());
    }
}


public static int countMonuments(int id) {
    String sql = "SELECT COUNT(*) FROM Monuments WHERE usuario_id = ?";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return 0;
    }
}

//Inserir Monumento
public static int insertMonument(String name,String description, String country, String estado, String year, double latitude, double longitude, int owner) {
    String sql = "INSERT INTO Monuments(name, description, country, status, year, id_user, latitude, longitude) VALUES(?,?,?,?,?,?,?,?)";
    int monumentId = -1;
    
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, name);
        pstmt.setString(2, description);
        pstmt.setString(3, country);
        pstmt.setString(4, estado);
        pstmt.setString(5, year);
        pstmt.setInt(6, owner);
        pstmt.setDouble(7, latitude);
        pstmt.setDouble(8, longitude);
        
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                monumentId = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao inserir monumento: " + e.getMessage());
    }
    return monumentId;
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




public static void createTables() {
    createTableUsers();
    createTableMonumentos();
    createClassificationsTable();
}
}
