/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorImpressao;

/**
 *
 * @author lmilano
 */
public class Principal {
    
    public static void main(String[] argss) {
        ServidorThread servidor = new ServidorThread(3, 6000);
        ComputadorThread computador1 = new ComputadorThread(2000, 6, servidor);
        
        computador1.start();
        servidor.start();
    }
}
