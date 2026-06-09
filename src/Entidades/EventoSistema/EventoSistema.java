package Entidades.EventoSistema;

public class EventoSistema {

    private String id;
    private String descricao;
    private String tipoEvento;
    private String dataHora;



    public EventoSistema(String tipoEvento,String dataHora, String descricao,String id) {
        this.tipoEvento = tipoEvento;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.id = id;
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

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public String gerarResumoEvento(){

        String aux = "";

        aux += "Tipo de evento: "+tipoEvento+"\n";
        aux += "Identificador do Evento: "+id+"\n";
        aux += "Data/Hora: "+dataHora+"\n";
        aux += "Descrição: "+descricao+"\n";

        return aux;
    }
}
