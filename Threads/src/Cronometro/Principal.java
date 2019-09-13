/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronometro;

/**
 *
 * @author lmilano
 */
public class Principal {
    
    public static void main(String[] argss) {
        CronometroThread cronometroThread = new CronometroThread(20);
        
        cronometroThread.start();
    }
    
}
