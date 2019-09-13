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
public class ArquivoImpressao {
    
    private ComputadorThread _computador;
    private int _tempoEspera;
    
    private String _conteudo;

    public ArquivoImpressao(ComputadorThread Computador, String Conteudo) {
        _computador = Computador;
        _conteudo = Conteudo;
    }

    public ComputadorThread getComputador() {
        return _computador;
    }

    public ArquivoImpressao setComputador(ComputadorThread Computador) {
        _computador = Computador;
        return this;
    }

    public String getConteudo() {
        return _conteudo;
    }

    public ArquivoImpressao setConteudo(String Conteudo) {
        this._conteudo = Conteudo;
        return this;
    }

    public void setTempoEspera(int _tempoEspera) {
        this._tempoEspera = _tempoEspera;
    }

    @Override
    public String toString() {
        return _computador.getIdentificacaoComputador() + " " + _conteudo + _tempoEspera + "s.";
    }
    
}
