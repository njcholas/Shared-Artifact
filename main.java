import java.sql.*;

public class SQLInjectionExample {

    public static void main(String[] args) {
        try {
            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meu_banco_de_dados", "usuario", "senha");

            // Obter o nome do usuário a partir do parâmetro de entrada
            String nomeUsuario = args[0];

            // Criar a consulta SQL
            String sql = "SELECT * FROM usuarios WHERE nome = '" + nomeUsuario + "'";

            // Executar a consulta SQL
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Processar os resultados da consulta
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome"));
            }

            // Fechar os recursos do banco de dados
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}