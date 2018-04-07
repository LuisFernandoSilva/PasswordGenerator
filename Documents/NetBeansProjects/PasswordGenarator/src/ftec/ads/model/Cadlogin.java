/*
 * 
 */
package ftec.ads.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Cadlogin {
    private String user;
    private String senha;
    private String email;
    
    public Cadlogin(){}
    public Cadlogin(String user,String email,String senha){
        this.user = user;
        this.senha = senha;
        this.email = email;
    
    }
    
   /**
    * Metodo que chama uma funcao sql que faz a inserção na tabela.
    * @throws SQLException 
    */ 
    public void insert() throws SQLException{
        CallableStatement cst = null;
        try {
            cst = Conexao.getDb().prepareCall("{ call public.fn_insert_login( ?,?,?) }");
            cst.setString(1, this.getUser());
            cst.setString(2, this.getEmail());
            cst.setString(3, this.getSenha());

            
            if (cst.execute()) {
                JOptionPane.showMessageDialog(null, "Dado inserido com sucesso!\n");
            }else{
                JOptionPane.showMessageDialog(null, "Falha ao tentar inserir o dado!");
        }           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!"+ex.getMessage()+ ex.getCause());
        }finally{
            if (cst!=null) {
                cst.close();
            }
        }
    }    
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
