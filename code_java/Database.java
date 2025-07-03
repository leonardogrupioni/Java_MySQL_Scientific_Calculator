import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection con;
    private Statement st;
    private String strConexao = "jdbc:mysql://localhost:3306/CALCULADORA";

    public Database() throws Exception {
        this.con = conectarDB(strConexao, "root", "root");
        this.st = con.createStatement();
    }

    private Connection conectarDB(String url, String user, String password) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void gravarDadosDB(String calculadora, double operando1, String operador, double operando2, double resultado, String status, String mensagem) throws Exception {
        try {
            String SQL = "INSERT INTO operacoes (calculadora, operando1, operador, operando2, resultado, status, mensagem) " +
                         "VALUES ('" + calculadora + "', " + operando1 + ", '" + operador + "', " + operando2 + ", " + resultado + ", '" + status + "', '" + mensagem + "')";
            st.execute(SQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
