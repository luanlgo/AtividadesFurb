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
public class Adicao extends Thread{
    
    private int _buffer;
    
    public Adicao(int valor) {
        _buffer = valor;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            _buffer ++;
            System.out.println(_buffer);
        }
    }
    
}
