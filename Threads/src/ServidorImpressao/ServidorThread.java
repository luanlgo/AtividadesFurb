/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorImpressao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmilano
 */
public class ServidorThread extends Thread{
    
    private final ArquivoImpressao[] _filaArquivosImpressao;
    private final int _tempoDeEnvioParaImpressora;
   
    public ServidorThread(int tamanhoFilaArquivosServidor, int tempoDeEnvioParaImpressoraEmSegundos) {
        _filaArquivosImpressao = new ArquivoImpressao[tamanhoFilaArquivosServidor];
        _tempoDeEnvioParaImpressora = tempoDeEnvioParaImpressoraEmSegundos;
    }

    public ArquivoImpressao[] getFilaArquivosImpressao() {
        return _filaArquivosImpressao;
    }
    
    public void AddArquivoFilaImpressao(ArquivoImpressao arquivo) throws FilaCheiaException {
        for (int i = 0; i < _filaArquivosImpressao.length; i++) {
            if (_filaArquivosImpressao[i] == null) {
                _filaArquivosImpressao[i] = arquivo;
            } else {
                throw new FilaCheiaException("Sem espaço na fila");
            }
        }
    }
    
    @Override
    public void run(){
        while(true) {
            for (int i = 0; i < _filaArquivosImpressao.length; i++) {
                ArquivoImpressao arquivo = _filaArquivosImpressao[i];
                if (arquivo != null) {
                    System.out.println(arquivo.toString());
                    System.err.println("------------------");
                    try {
                        sleep(_tempoDeEnvioParaImpressora);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
