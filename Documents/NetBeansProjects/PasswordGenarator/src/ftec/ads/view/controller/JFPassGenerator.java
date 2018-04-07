/**
 * 
 * Programa que gera senhas aleatorias de numeros e letras.
 * Sendo que o usuario escolhe a quantidade de caracteres a senha ira ter.
 * Salvando em banco de dados para um posterior consulta no proprio aplicativo.
 * Sendo que a entrada nela sera feita mediante senha cadastrada.
 * Autor: Luis Fernando.
 * 
 * Data inicial: 04/05/2016
 * Versão: 1.0.0
 * 
 * Classe de JFrame do aplicativo.
 */
package ftec.ads.view.controller;

import ftec.ads.model.Conexao;
import ftec.ads.model.PassGenerator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;


public class JFPassGenerator extends javax.swing.JFrame {
    private static PassGenerator pass;
    private boolean modific = true;
    public JFPassGenerator() {
        
        initComponents();
        updateTable();
        
        
    }
    public void hideTable(){   
        
        tabCons.getColumnModel().getColumn(0).setWidth(-1);
        tabCons.getColumnModel().getColumn(0).setMaxWidth(-1);
        tabCons.getColumnModel().getColumn(0).setMinWidth(-1);
        tabCons.getColumnModel().getColumn(0).setPreferredWidth(0);
    }    
    /*
    * Metodo que atualiza a tabela de visualização, chamando o metodo externo 
    * loadPassGenerator(), em caso de falha aciona uma mensagem de erro para o usuario.
    */
    public void updateTable(){
        try{
            pass = new PassGenerator();
            ResultSet rs = pass.loadPassGenerator();
             tabCons.setModel(Conexao.buildTableModel(rs));
             hideTable();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "conexao falhou!\n"
            +ex.getMessage() + "\n" + ex.getCause());
        }
    }  
   /**
    * Salva o numero de caracter conforme o botao de radio selecionado
    * @return 
    */ 
    private int numero_caracter(){
    int numero_caracter = 0;
    if(rbtn4.isSelected()){
        numero_caracter = 4;
    }if(rbtn8.isSelected()){
        numero_caracter = 8;
    }if(rbtn16.isSelected()){
        numero_caracter = 16;
    }
    return numero_caracter;
    }
    /**
     * seta o botao de radio conforme o numero de caracter salvo no banco
     * @param numero_caracter 
     */
    private void setBtnRadioGroup(int numero_caracter){
    
    if(numero_caracter == 4){
        
        rbtn4.setSelected(true);
    }if(numero_caracter == 8){
        rbtn8.setSelected(true);
    }if(numero_caracter == 16){
       rbtn16.setSelected(true) ;
    }
    }
    
    
    /*
    * Metodo que seleciona uma linha especifica da tabela mostrada com um clique  do mouse e
    * set todos os itens da tabela nas variaveis especificas, em caso de erro aciona uma mensagem de erro para o usuario.
    */
    public void selectLineOnTable(){
        try{
           int linha = tabCons.getSelectedRow();
           int id_senha = Integer.parseInt(tabCons.getModel().getValueAt(linha, 0).toString());
           int numero_caracter = Integer.parseInt(tabCons.getModel().getValueAt(linha, 2).toString());
           modific = false;

           pass = new PassGenerator();
           ResultSet rs = pass.load(id_senha);
           rs.first();
           lblID.setText(rs.getString(1));
           txtNome.setText(rs.getString(2));
           setBtnRadioGroup(numero_caracter);
           txtSenha.setText(rs.getString(4));

            
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao consultar tabela\n"
           +ex.getMessage() + "\n" + ex.getCause());
           }
    }
    
    /*
    * Metodo que grava um novo cadastrato no banco
    */
    public void insert(){
        try{
            
            String nome = txtNome.getText();
            int numero_caracter = numero_caracter();
            String senha = txtSenha.getText();
 

            pass = new PassGenerator(nome,numero_caracter,senha);
            pass.insert();
            updateTable();
            modific = false;
            txtNome.setText("");
            rbtnGroupNumberCarac.clearSelection();
            txtSenha.setText("");
  

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar\n"
            +ex.getMessage());}  
    }
    
    /*
    * Metodo que grava um novo cadastrato no banco
    */
    public void update(){
        try{
            modific = true;
            int id_senha = Integer.parseInt(lblID.getText());
            String nome = txtNome.getText();
            int numero_caracter = numero_caracter();
            String senha = txtSenha.getText();
 

            pass = new PassGenerator(id_senha,nome,numero_caracter,senha);
            pass.update();
            updateTable();
            
            lblID.setText("");
            txtNome.setText("");
            rbtnGroupNumberCarac.clearSelection();
            txtSenha.setText("");
  

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar\n"
            +ex.getMessage());}  
    }
    /*
    * metodo que seta os dados que estiverem nos campos de cadastrados para inserir novos.
    * em caso de erro aciona  uma mensagem para o usuario.
    */
    public void fresh(){
        modific = true;
        updateTable();
        lblID.setText("");
        txtNome.setText("");
        rbtnGroupNumberCarac.clearSelection();
        txtSenha.setText("");
 
   }    
    
    /*
    * metodo que apaga um cadastro selecionado.
    */
    public void delete(){
        try{   
            int id_senha = Integer.parseInt(lblID.getText());  
            pass = new PassGenerator();
            pass.setId_senha(id_senha);
            pass.delete();
            modific = true;
            updateTable();
            lblID.setText("");
            txtNome.setText("");
            rbtnGroupNumberCarac.clearSelection();
             txtSenha.setText("");

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar tabela\n"
            +ex.getMessage() + "\n" + ex.getCause());}   
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGroupNumberCarac = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCons = new javax.swing.JTable();
        lblSCad = new javax.swing.JLabel();
        lblIDSenha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCaracter = new javax.swing.JLabel();
        rbtn4 = new javax.swing.JRadioButton();
        rbtn8 = new javax.swing.JRadioButton();
        rbtn16 = new javax.swing.JRadioButton();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        btnGerar = new javax.swing.JButton();
        BtnNova = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PasswordGenerator");
        setSize(new java.awt.Dimension(600, 300));

        tabCons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabCons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabConsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabCons);

        lblSCad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSCad.setText("Senhas Cadastradas:");
        lblSCad.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setText("Ex.: Facebook, google+,gmail, etc.");
        txtNome.setToolTipText("Digite o nome do site ou aplicativo que deseja salvar uma senha.");
        txtNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeMouseClicked(evt);
            }
        });

        lblCaracter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCaracter.setText("Numeros de caracteres:");
        lblCaracter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        rbtnGroupNumberCarac.add(rbtn4);
        rbtn4.setText("4");

        rbtnGroupNumberCarac.add(rbtn8);
        rbtn8.setText("8");

        rbtnGroupNumberCarac.add(rbtn16);
        rbtn16.setText("16");

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSenha.setText("Senha:");
        lblSenha.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnGerar.setText("Gerar Senha");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        BtnNova.setText("Nova");
        BtnNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovaActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblID.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(lblSCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIDSenha)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCaracter)
                                    .addComponent(lblSenha))
                                .addGap(18, 18, 18)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(rbtn4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtn8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtn16)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtSenha)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(112, 112, 112)
                                .addComponent(txtNome)))
                        .addGap(23, 23, 23)
                        .addComponent(btnGerar)
                        .addGap(89, 89, 89))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(BtnNova)
                        .addGap(28, 28, 28)
                        .addComponent(btnSalvar)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID)
                        .addGap(148, 148, 148))))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIDSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSCad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaracter)
                    .addComponent(rbtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtn8)
                    .addComponent(rbtn16)
                    .addComponent(btnGerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNova)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(lblID))
                .addGap(64, 64, 64))
        );

        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 /**
 * Ao se clicar no campo texto a dica de digitação apaga.
 * @param evt 
 */    
    private void txtNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeMouseClicked
        txtNome.setText("");

       
    }//GEN-LAST:event_txtNomeMouseClicked
/**
 * metodo que gera a senha conforme o botao de radio selecionado.
 * @param evt 
 */
    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        Random random = new Random();
        try{
        if(rbtn4.isSelected()){
        int x = 10 +(random.nextInt(79));
        char y = (char)(random.nextInt('z'-'a'-1)+'a');
        char a = (char)(random.nextInt('Z'-'A'+1)+'A');
        txtSenha.setText(a+String.valueOf(x)+y);

        
        }if(rbtn8.isSelected()){
        int c = random.nextInt(10);    
        int x = 100 +(random.nextInt(179));
        char y = (char)(random.nextInt('z'-'a'-1)+'a');
        char a = (char)(random.nextInt('Z'-'A'+1)+'A');
        char b = (char)(random.nextInt('Z'-'A'+1)+'A');
        int d = 3 +(random.nextInt(5));
        txtSenha.setText(String.valueOf(c)+a+String.valueOf(x)+y+b+String.valueOf(d));
        
        }
        if(rbtn16.isSelected()){
        int c = random.nextInt(10);    
        int x = 100 +(random.nextInt(179));
        char y = (char)(random.nextInt('z'-'a'-1)+'a');
        char a = (char)(random.nextInt('Z'-'A'+1)+'A');
        char b = (char)(random.nextInt('Z'-'A'+1)+'A');
        int d = 3 +(random.nextInt(5));
        int e = random.nextInt(10);    
        int f = 100 +(random.nextInt(179));
        char g = (char)(random.nextInt('z'-'a'-1)+'a');
        char h = (char)(random.nextInt('Z'-'A'+1)+'A');
        char i = (char)(random.nextInt('Z'-'A'+1)+'A');
        int j = 3 +(random.nextInt(5));
        txtSenha.setText(String.valueOf(j)+i+String.valueOf(c)+a+String.valueOf(x)+y+b+String.valueOf(d)+g+h+String.valueOf(e)+String.valueOf(f));    
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Selecione um dos campos\n"
           +ex.getMessage() + "\n" + ex.getCause());
        }

        
    }//GEN-LAST:event_btnGerarActionPerformed
/**
 * botao que salva ou altera dados 
 * @param evt 
 */
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(modific){
           insert();}
        else{
           update();
           
        }
       
    }//GEN-LAST:event_btnSalvarActionPerformed
/**
 * botao que deleta dado selecionado
 * @param evt 
 */
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        delete();
   
    }//GEN-LAST:event_btnExcluirActionPerformed
/**
 * botao que seta todos os campos para colocar novos pelo usuario
 * @param evt 
 */
    private void BtnNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovaActionPerformed
        fresh();
     
    }//GEN-LAST:event_BtnNovaActionPerformed
/**
 * evento de clique do mouse pelo usuario setando os dados cadastrados nos respectivos campos.
 * @param evt 
 */
    private void tabConsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabConsMouseClicked
        selectLineOnTable();

    }//GEN-LAST:event_tabConsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPassGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNova;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCaracter;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDSenha;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSCad;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel panelMain;
    private javax.swing.JRadioButton rbtn16;
    private javax.swing.JRadioButton rbtn4;
    private javax.swing.JRadioButton rbtn8;
    private javax.swing.ButtonGroup rbtnGroupNumberCarac;
    private javax.swing.JTable tabCons;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
