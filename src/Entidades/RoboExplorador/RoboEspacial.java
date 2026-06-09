package Entidades.RoboExplorador;

import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class RoboEspacial extends RoboExplorador implements CalculavelIPO, AvaliadorRisco {

    private double combustivel;
    private double nivelRadiacao;
    private double areaMonitorada;
    private double quantidadeDadosColetados;


    public RoboEspacial(int id, String nome, double nivelBateria, double velocidade, double areaMonitorada, double combustivel, double nivelRadiacao, double quantidadeDadosColetados) {
        super(id, nome, nivelBateria, velocidade);
        this.areaMonitorada = areaMonitorada;
        this.combustivel = combustivel;
        this.nivelRadiacao = nivelRadiacao;
        this.quantidadeDadosColetados = quantidadeDadosColetados;
    }

    public double getAreaMonitorada() {
        return areaMonitorada;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public double getNivelRadiacao() {
        return nivelRadiacao;
    }

    public double getQuantidadeDadosColetados() {
        return quantidadeDadosColetados;
    }

    public void setAreaMonitorada(double areaMonitorada) {
        this.areaMonitorada = areaMonitorada;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public void setNivelRadiacao(double nivelRadiacao) {
        this.nivelRadiacao = nivelRadiacao;
    }

    public void setQuantidadeDadosColetados(double quantidadeDadosColetados) {
        this.quantidadeDadosColetados = quantidadeDadosColetados;
    }

    public String toString() {
        return super.toString() + "Tipo: Robô Espacial\n";
    }

    public double calcularRetornoCientifico(){

        return (quantidadeDadosColetados * 0.8) + (areaMonitorada * 0.2);
    }

    public double calcularExposicaoEspacial(){

        return nivelRadiacao * (areaMonitorada/100);
    }

    public double calcularDesempenho(){

        return ((areaMonitorada/2000)* 0.4) + ((combustivel/100) * 0.6);
    }

    public void atualizarBateria(){

        double consumo = ((areaMonitorada/200)* 0.2)+((quantidadeDadosColetados/500)*0.3)+(nivelRadiacao*0.1);

        double novoNivelBateria = getNivelBateria() - consumo;

        setNivelBateria(novoNivelBateria);
    }

    public  double calcularAutonomia(){

        return ((getNivelBateria()/100) * 0.4)+((combustivel/200)*0.6);
    }

    public double calcularRisco(){

        return ((100-combustivel)*0.4)+ ((100-getNivelBateria())*0.4)+(nivelRadiacao*0.2);
    }

    public double fornecerIndiceIPO(){

        return ((calcularAutonomia()/100)*0.4)+ ((calcularDesempenho()/100)*0.4)+ ((100-calcularRisco())*0.2);
    }

    public String obterStatus(){

        double ipo = fornecerIndiceIPO();

        if(ipo>=80){
            return "Verde";
        } else if (ipo>=50) {
            return "Amarelo";
        }

        return "Vermelho";
    }

    public String gerarRelatorio() {

        String aux ="";

        aux += "==> Robô Espacial: "+ getNome() + "\n";
        aux += "Identificados: "+ getId() + "\n";
        aux += "Bateria: "+ Math.round(getNivelBateria()) + "%\n";
        aux += "Combustivel: "+ combustivel + "%\n";
        aux += "Radiação: "+ nivelRadiacao + "Becquerel\n";
        aux += "Área Monitorada: "+ areaMonitorada +"km²\n";
        aux += "Quantidade de dados coletados: "+ quantidadeDadosColetados + "\n";
        aux += "Desempenho: "+String.format("%.2f",calcularExposicaoEspacial()) + "%\n";
        aux += "Autonomia: "+ String.format("%.2f",calcularAutonomia()) + "%\n";
        aux += "Risco: "+ String.format("%.2f",calcularRisco()) + "%\n";
        aux += "Pontuação de retorno Cientifico: "+ String.format("%.2f", calcularRetornoCientifico()) + "\n";
        aux += "Índice de exposição espacial: "+ String.format("%.2f", calcularExposicaoEspacial()) + "\n";
        aux += "Indice IPO: "+ String.format("%.2f", fornecerIndiceIPO()) + "%\n";
        aux += "Status: "+ obterStatus() + "\n";

        return aux;
    }

}
