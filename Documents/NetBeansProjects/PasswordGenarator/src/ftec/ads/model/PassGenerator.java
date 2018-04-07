package ftec.ads.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/** 
 * Classe responsavel pela manipulação dos dados junto ao banco de dados,
 * inserindo, deletando e atualizando.
 */

public class PassGenerator{
    private int id_senha;
    private String nome;
    private int numero_caracter;
    private String senha;
    
    
    public PassGenerator(){}
    
    public PassGenerator(String nome, int numero_caracter,String senha){
        this.nome = nome;
        this.numero_caracter = numero_caracter;
        this.senha = senha;
    }
    
    public PassGenerator(int id_senha,String nome, int numero_caracter,String senha){
        this.id_senha = id_senha;
        this.nome = nome;
        this.numero_caracter = numero_caracter;
        this.senha = senha;
    }
    
    /*
    * Metodo que carrega os dados da tabela, dos dados comparados com o parametro. 
    *@param numero de id para ser comparado com o mesmo na tabela.
    */ 
    public ResultSet load(int id) throws SQLException {
        Statement st = null;
        try{
            ResultSet rs;
            st = Conexao.getDb().createStatement(1005, 1007);
            rs = st.executeQuery("SELECT * FROM fn_select_password(" + id + ")");
            return rs;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados!\n"
            +ex.getMessage() + "\n" + ex.getCause());}
        return null;
    }
    
    /*
    * Metodo que carrega os dados da tabela.
    */
    public ResultSet loadPassGenerator() throws SQLException {
        Statement st = null;
        try{
            st = Conexao.getDb().createStatement();
            ResultSet rs = st.executeQuery("select* from fn_select_password (0) order by 1");
            return rs;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados!\n"
            +ex.getMessage() + "\n" + ex.getCause());}
        return null;
    }     
   /**
    * Metodo que chama uma funcao sql que faz a inserção na tabela.
    * @throws SQLException 
    */ 
    public void insert() throws SQLException{
        CallableStatement cst = null;
        try {
            cst = Conexao.getDb().prepareCall("{ call public.fn_insert_password(?,?,?) }");
            cst.setString(1, this.getNome());
            cst.setInt(2, this.getNumero_caracter());
            cst.setString(3, this.getSenha());
            
            if (cst.execute()) {
                JOptionPane.showMessageDialog(null, "Dado inserido com sucesso!\n");
            }else{
                JOptionPane.showMessageDialog(null, "Falha ao tentar inserir o dado!");
        }           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar !\n"+ex.getMessage() + "\n" + ex.getCause());
        }finally{
            if (cst!=null) {
                cst.close();
            }
        }
    }
   /**
    * Metodo que chama uma funcao sql que faz o update da tabela.
    * @throws SQLException 
    */
    public void update() throws SQLException{
        CallableStatement cst = null;
        try {
            cst = Conexao.getDb().prepareCall("{ call public.fn_update_password( ?,?,?,?) }");
            cst.setInt(1, this.getId_senha());
            cst.setString(2, this.getNome());
            cst.setInt(3, this.getNumero_caracter());
            cst.setString(4, this.getSenha());
            
            
            if (cst.execute()) {
                JOptionPane.showMessageDialog(null, "Alteração foi um sucesso!\n");
            }else{
                JOptionPane.showMessageDialog(null, "Alteração falhou!\n");
            }           
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados!\n"
            +ex.getMessage() + "\n" + ex.getCause());
        }finally{
            if (cst!=null) {
                cst.close();
            }
        }
    }    
    /**
     * Metodo que chama a função sql do banco de dados que deleta o arquivo.
     * @throws SQLException 
     */
    public void delete() throws SQLException{
        CallableStatement cst = null;
        try{
            cst = Conexao.getDb().prepareCall("{ call public.fn_delete_password( ? ) }");
            cst.setInt(1, this.getId_senha());
            if (cst.execute()) {
                JOptionPane.showMessageDialog(null, " exclusão foi um sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o dado!");
            }           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados!\n"
            +ex.getMessage() + "\n" + ex.getCause());

        }finally{
            if (cst!=null){
                cst.close();
            }
        }
    } 
    /**
     * @return the id_senha
     */
    public int getId_senha() {
        return id_senha;
    }

    /**
     * @param id_senha the id_senha to set
     */
    public void setId_senha(int id_senha) {
        this.id_senha = id_senha;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numero_caracter
     */
    public int getNumero_caracter() {
        return numero_caracter;
    }

    /**
     * @param numero_caracter the numero_caracter to set
     */
    public void setNumero_caracter(int numero_caracter) {
        this.numero_caracter = numero_caracter;
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
    
    
    
}
