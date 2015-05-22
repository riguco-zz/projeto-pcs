package BDConexao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author riguco
 */
public class criaConexao {
    private Connection criaConexao;
    public Connection connect () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado com sucesso");
        }catch (ClassNotFoundException cnfe) {
            System.out.println("Conexao falhou" + cnfe);    
        }

        String url = "jdbc:mysql://localhost:3306/pcs";
        try {
            criaConexao = (Connection) DriverManager.getConnection(url, "root", "toor");
            System.out.println("Conectado ao banco");
        }
        catch (SQLException se){
            System.out.println("Sem database" + se);
        }

        return criaConexao;       
    }  
}
