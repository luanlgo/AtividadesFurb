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
public class CronometroThread extends Thread {
    
    private int _Tempo;
    private final int _segundo_em_milissegundos = 1000;
    
    public CronometroThread(int valor) {
        _Tempo = valor;
    }
    
    @Override
    public void run() {
        while (_Tempo > 0) {
            System.out.println(_Tempo);
            _Tempo --;
            try {
                sleep(_segundo_em_milissegundos);
            } catch (InterruptedException ex) {
                interrupt();
            }
        }
        System.out.println(_Tempo);
        System.out.println("Acorda ai carai.");
    }
}
