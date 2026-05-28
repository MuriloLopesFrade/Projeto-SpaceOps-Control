package Entidades.EventoSistema;

public class EventoSistema {
    /*
        Representa eventos críticos ocorridos durante a missão.

        Objetivo:
        -Registrar ocorrências que possam impactar o funcionamento do sistema e o IPO.

        Exemplos de eventos:
        -tempestade solar;
        -falha mecânica;
        -superaquecimento;
        -perda de sinal;
        -bateria crítica;
        -colisão.
     */

    private String descricao;
    private String dataHora;
    private int impacto;

    public EventoSistema(String descricao, String dataHora, int impacto) {
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.impacto = impacto;
    }

    public String gerarResumoEvento(){
        return null;
    }
}
