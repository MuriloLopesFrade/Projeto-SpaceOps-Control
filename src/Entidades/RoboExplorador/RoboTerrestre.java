package Entidades.RoboExplorador;

import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class RoboTerrestre extends RoboExplorador implements CalculavelIPO, AvaliadorRisco {

    private double distanciaPercorrida;
    private double desgasteEsteiras;
    private double inclinacaoAtual;
    private double areaExplorada;

    public RoboTerrestre(int id, String nome, double nivelBateria, double velocidade, double distanciaPercorrida, double desgasteEsteiras, double inclinacaoAtual, double areaExplorada) {
        super(id, nome, nivelBateria, velocidade);
        this.distanciaPercorrida = distanciaPercorrida;
        this.desgasteEsteiras = desgasteEsteiras;
        this.inclinacaoAtual = inclinacaoAtual;
        this.areaExplorada = areaExplorada;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public double getDesgasteEsteiras() {
        return desgasteEsteiras;
    }

    public double getInclinacaoAtual() {
        return inclinacaoAtual;
    }

    public double getAreaExplorada() {
        return areaExplorada;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public void setDesgasteEsteiras(double desgasteEsteiras) {
        this.desgasteEsteiras = desgasteEsteiras;
    }

    public void setInclinacaoAtual(double inclinacaoAtual) {
        this.inclinacaoAtual = inclinacaoAtual;
    }

    public void setAreaExplorada(double areaExplorada) {
        this.areaExplorada = areaExplorada;
    }

    public String toString() {
        return super.toString() + "Tipo: Robô Terrestre\n";
    }

    public  double calcularEficienciaExploracao(){
        return areaExplorada / distanciaPercorrida;
    }

    public double calcularAutonomia(){

        double autonomiaBase = (getNivelBateria()/100) * 0.1;
        double desgaste = (desgasteEsteiras/100) * 0.2;
        double penalidadeTerreno = inclinacaoAtual * 0.2;
        double penalidadeVelocidade = (getVelocidade()/100) * 0.3;

        double autonomia = autonomiaBase - desgaste - penalidadeTerreno -penalidadeVelocidade;

        if (autonomia < 0) {
            autonomia = 0;
        }

        if (autonomia > 100) {
            autonomia = 100;
        }
        return autonomia;
    }

    public void atualizarBateria(){

        double nivelBateria = super.getNivelBateria();

        double consumoDistancia = (distanciaPercorrida/2000) * 0.1;
        double consumoInclinacao = (inclinacaoAtual/50) * 0.2;
        double usoVelicidade = (getVelocidade()/100) * 0.3;
        double consumoTotal = consumoDistancia + consumoInclinacao + usoVelicidade;

        nivelBateria -= consumoTotal;

        if (nivelBateria < 0) {
            nivelBateria = 0;
        }

        if (nivelBateria > 100) {
            nivelBateria = 100;
        }

        setNivelBateria(nivelBateria);
    }

    public double calcularDesempenho(){

        double desempenho = ((areaExplorada/2000)*0.6)+((100-desgasteEsteiras)*0.4);

        if (desempenho < 0) {
            desempenho = 0;
        }

        if (desempenho > 100) {
            desempenho = 100;
        }
        return desempenho;
    }

    public String obterStatus(){

        if (getNivelBateria() >= 70) {
        return "Verde";
        }

        if (getNivelBateria() >= 30) {
            return "Amarelo";
        }

        return "Vermelho";
    }

    public double calcularRisco(){
        return (desgasteEsteiras*0.5)+((inclinacaoAtual/50)*0.3)+((getNivelBateria())*0.2);
    }

    public double fornecerIndiceIPO(){

        double indiceAutonomia = (calcularAutonomia()/100) * 0.3;
        double indiceDesempenho = (calcularDesempenho()/100) * 0.2;
        double indiceRisco = (100-calcularRisco())*0.5;

        return indiceAutonomia + indiceDesempenho + indiceRisco;
    }

    public String gerarRelatorio(){

        String aux = "==> Robô Terrestre: "+ getNome() +"\n";

        aux += "Identificador: "+ getId()+"\n";
        aux += "Distancia percorrida: "+ distanciaPercorrida+"km\n";
        aux += "Desgaste de esteiras: "+ desgasteEsteiras+"%\n";
        aux += "Inclinação Atual: "+ inclinacaoAtual+"°\n";
        aux += "Área explorada: "+ areaExplorada+"\n";
        aux += "Indice IPO: "+String.format("%.2f",fornecerIndiceIPO())+"%\n";
        aux += "Eficiência da exploração: "+String.format("%.2f",calcularEficienciaExploracao())+"%\n";
        aux += "Nível atual bateria: "+String.format("%.2f",getNivelBateria())+"%\n";
        aux += "Autonomia Terreno: "+String.format("%.2f",calcularAutonomia())+"%\n";
        aux += "Desempenho: "+String.format("%.2f",calcularDesempenho())+"%\n";
        aux += "Status: "+ obterStatus() +"\n";

        return aux;
    }

}
