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
    private String tipoEvento;
    private String dataHora;



    public EventoSistema(String tipoEvento,String dataHora, String descricao) {
        this.tipoEvento = tipoEvento;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String gerarResumoEvento(){

        String aux = "==== Evento do Sistema ====\n";

        aux += "Data/Hora: "+ dataHora+"\n";
        aux += "Descrição: "+ descricao+"\n";

        return aux;
    }
}
