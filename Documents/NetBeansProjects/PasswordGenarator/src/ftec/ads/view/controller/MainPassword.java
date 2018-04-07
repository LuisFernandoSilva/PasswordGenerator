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
 */
package ftec.ads.view.controller;

public class MainPassword {
    private static JFLogin tela;
    public static void main(String[] args) {
        
       tela = new JFLogin();
       tela.setLocationRelativeTo(null);
       tela.setVisible(true);
        
    }
    
}
