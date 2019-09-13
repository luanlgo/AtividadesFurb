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
public class ComputadorThread extends Thread{
    
    private final int _tempoEnvioDeArquivoEmSegundos;
    private int _quantidadeArquivosEnvio;
    private int _tempoEmEsperaDeEnvioDeArquivo = 0;
    private ArquivoImpressao _arquivoImpressaoAtual;
    private final int _segundoEmMilissegundos = 1000;
    
    private final ServidorThread _servidor;
    
    private String _IdentificacaoComputador = "Computador1";
    
    public ComputadorThread(
            int tempoEnvioDeArquivoEmSegundo, 
            int quantidadeArquivosEnvio,
            ServidorThread servidor)
    {
        _tempoEnvioDeArquivoEmSegundos = tempoEnvioDeArquivoEmSegundo;
        _quantidadeArquivosEnvio = quantidadeArquivosEnvio;
        _servidor = servidor;
    }
    
    @Override
    public void run() {
        while (_quantidadeArquivosEnvio > 0) {
            try {
                sleep(_tempoEnvioDeArquivoEmSegundos);
                EnviarAquivoServidor();
                _quantidadeArquivosEnvio --;
            } catch (InterruptedException ex) {
                interrupt();
            }
        }
    }
    
    private void EnviarAquivoServidor() throws InterruptedException {
        _arquivoImpressaoAtual = new ArquivoImpressao(this, "Arquivo " + _quantidadeArquivosEnvio + ", tempo em espera ");
        while (_arquivoImpressaoAtual != null) {
            try {
                _servidor.AddArquivoFilaImpressao(_arquivoImpressaoAtual);
                System.out.println("Enviou arquivo " + _IdentificacaoComputador);
                _arquivoImpressaoAtual = null;
                _tempoEmEsperaDeEnvioDeArquivo = 0;
            } catch (FilaCheiaException ex) {
                _tempoEmEsperaDeEnvioDeArquivo ++;
                _arquivoImpressaoAtual.setTempoEspera(_tempoEmEsperaDeEnvioDeArquivo);
                sleep(_segundoEmMilissegundos);
            }
        }
    }

    public String getIdentificacaoComputador() {
        return _IdentificacaoComputador;
    }

    public void setIdentificacaoComputador(String _IdentificacaoComputador) {
        this._IdentificacaoComputador = _IdentificacaoComputador;
    }
}
