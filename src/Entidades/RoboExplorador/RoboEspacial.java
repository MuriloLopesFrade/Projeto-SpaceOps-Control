package Entidades.RoboExplorador;

import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class RoboEspacial extends RoboExplorador implements CalculavelIPO, AvaliadorRisco {

    /*
        Representa robôs que operam fora da superfície planetária.

        Exemplos:
        - robôs orbitais;
        - satélites autônomos;
     */

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

    // Método específico da classe
    public double calcularRetornoCientifico(){

        return (quantidadeDadosColetados * 0.8) + (areaMonitorada * 0.2);
    }

    public double calcularExposicaoEspacial(){

        return nivelRadiacao * (areaMonitorada/100);
    }

    public double calcularDesempenho(){

        return (areaMonitorada * 0.4) + (quantidadeDadosColetados * 0.6);
    }

    public  double calcularAutonomia(){

        return (getNivelBateria() * 0.4)+(combustivel*0.6);
    }

    public void atualizarBateria(){

        double consumo = (areaMonitorada* 0.02)+(quantidadeDadosColetados*0.03)+(nivelRadiacao*0.01);

        double novoNivelBateria = getNivelBateria() - consumo;

        setNivelBateria(novoNivelBateria);
    }

    public double fornecerIndiceIPO(){

        return calcularAutonomia()*0.4+ calcularDesempenho()*0.4+ (100-calcularRisco())*0.2;
    }

    public double calcularRisco(){

        return ((100-combustivel)*0.4)+ ((100-getNivelBateria())*0.4)+(nivelRadiacao*0.2);
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

        aux += "==== Robô Espacial: "+ getNome() + "====\n";
        aux += "Identificados: "+ getId() + "\n";
        aux += "Bateria: "+ getNivelBateria() + "\n";
        aux += "Combustivel: "+ combustivel + "%\n";
        aux += "Radiação: "+ nivelRadiacao + "\n";
        aux += "Área Monitorada: "+ areaMonitorada +"km²\n";
        aux += "Quantidade de dados coletados: "+ quantidadeDadosColetados + "GB\n";
        aux += "Desempenho: "+ calcularExposicaoEspacial() + "%\n";
        aux += "Autonomia: "+ calcularAutonomia() + "%\n";
        aux += "Risco: "+ calcularRisco() + "%\n";
        aux += "Retorno Cientifico: "+ calcularRetornoCientifico() + "\n";
        aux += "Exposicao espacial: "+ calcularExposicaoEspacial() + "\n";
        aux += "Indice IPO: "+ fornecerIndiceIPO() + "%\n";
        aux += "Status: "+ obterStatus() + "\n";

        return aux;
    }

}
