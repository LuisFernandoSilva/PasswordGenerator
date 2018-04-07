package ftec.ads.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Classe responsavel pela conexao com o banco.
 */

public class Conexao {
    private static Connection db;
    private static String url = "jdbc:postgresql://localhost:5432/PasswordGenerator";
    private static String usr =  "postgres";
    private static String pwd = "82832095";
    
    /**
    * metodo privado que conecta com o banco de dados, passando o nome do banco,usuario, senha.
    */
    private static void Conectar(){
        db = null;
        try{ 
            db = DriverManager.getConnection(url, usr, pwd);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar tabela\n"
            +e.getMessage() + "\n" + e.getCause());}
    }
   /**
    * Metodo que constroi uma tabela conforme os dados da tabela.
    * @param rs
    * @return
    * @throws SQLException 
    */
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData  metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for(int column = 1; column <= columnCount; column++){
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        while (rs.next()){
            Vector<Object> vector = new Vector<>();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);    
    }       
    /**
    * @return the db
    */
    public static Connection getDb() {
        if (db == null){Conectar();}
        return db;
    }
    /**
     * @return the url
     */
    public static String getUrl() {
        return url;
    }
    /**
     * @return the usr
     */
    public static String getUsr() {
        return usr;
    }

    /**
     * @return the pwd
     */
    public static String getPwd() {
        return pwd;
    }
    
}
