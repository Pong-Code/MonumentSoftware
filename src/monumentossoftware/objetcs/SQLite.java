package monumentossoftware.objetcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SQLite {
    
    private static final String URL = "jdbc:sqlite:database.db";

    
//Faz a conexão com a base de dados
public static Connection connect() {
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(URL);
        System.out.println("Conexão com o banco de dados estabelecida!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    return conn;
}

//**************Users**************

//Cria a tabela users
public static void createTableUsers() {
    String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + "name TEXT NOT NULL,\n"
            + "email TEXT NOT NULL UNIQUE,\n"
            + "password TEXT NOT NULL,\n"
            + "role TEXT NOT NULL\n"
            + ");";
    try (Connection conn = connect();
            Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela 'users' criada com sucesso!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.exit(0);
    }
}

//Registra Users na db
public static void registerUser(String name, String email, String password, String role) {
    try {
        Connection conn = connect();
        String sql = "INSERT INTO Users(nome, email, password, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, Utils.EncriptarPassword(password));
        pstmt.setString(4, role);
        pstmt.executeUpdate();
        System.out.println("Usuário registrado com sucesso!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

//Verifica o Login e guarda os valores do utilizador na classe User
public static Users login(String email, String senha) {
    String sql = "SELECT * FROM Users WHERE email = ? AND senha = ?";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        pstmt.setString(2, Utils.EncriptarPassword(senha));
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String role = rs.getString("role");
            int id = rs.getInt("id");
            Users user = new Users(name, email, role,id);
            return user;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
}

//Verifica se o email já está registrado
public static boolean emailExists(String email) {
    String sql = "SELECT * FROM Users WHERE email = ?";
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



//**************Monumentos**************


//Criar base de dados monumento
public static void createTableMonumentos() {
    String sql = "CREATE TABLE IF NOT EXISTS Monuments (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL,\n"
            + " country TEXT NOT NULL,\n"
            + " classifications INTEGER DEFAULT 0,\n"
            + " status TEXT NOT NULL,\n"
            + " latitude REAL NOT NULL,\n"
            + " longitude REAL NOT NULL\n"
            + ");";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela Monuments criada com sucesso.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

//Inserir Monumento
public static boolean insertMonumento(String name, String localizacao, String country, int classifications, String estado, double latitude, double longitude) {
    String sql = "INSERT INTO Monuments(name, country, classifications, status, latitude, longitude) VALUES(?,?,?,?,?,?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(3, country);
        pstmt.setInt(4, classifications);
        pstmt.setString(5, estado);
        pstmt.setDouble(6, latitude);
        pstmt.setDouble(7, longitude);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}


//**************Classificações**************

//Criar tabela Classificação
public static void createClassificacoesTable() {
    String sql = "CREATE TABLE IF NOT EXISTS Classifications (\n"
               + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
               + "monumento_id INTEGER NOT NULL,\n"
               + "usuario_id INTEGER NOT NULL,\n"
               + "classificacao INTEGER NOT NULL,\n"
               + "FOREIGN KEY(monumento_id) REFERENCES Monuments(id),\n"
               + "FOREIGN KEY(usuario_id) REFERENCES Users(id)\n"
               + ");";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela Classificacoes criada com sucesso!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}



public static void createTables() {
    createTableUsers();
    createTableMonumentos();
    createClassificacoesTable();
}


    
}
