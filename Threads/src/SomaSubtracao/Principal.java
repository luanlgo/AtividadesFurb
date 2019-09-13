/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SomaSubtracao;

/**
 *
 * @author lmilano
 */
public class Principal {
    
    public static void main(String[] argss) {
        int valor = 0;
        Subtrair subtrairThread = new Subtrair(valor);
        Adicao adicaoThread = new Adicao(valor);
        
        subtrairThread.start();
        adicaoThread.start();
    }
    
}
