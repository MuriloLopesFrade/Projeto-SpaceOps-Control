package Entidades.RoboExplorador;

import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class RoboTerrestre extends RoboExplorador implements CalculavelIPO, AvaliadorRisco {

    /*
        Classe feita para representar robôs responsáveis pela exploração da superfície planetária.
     */

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


    public double calcularAutonomia(){

        double autonomiaBase = getNivelBateria() * 10;
        double desgaste = desgasteEsteiras * 0.2;
        double penalidadeTerreno = inclinacaoAtual * 2;
        double penalidadeVelocidade = super.getVelocidade() * 0.3;

        return autonomiaBase - desgaste - penalidadeTerreno -penalidadeVelocidade;
    }

    public void atualizarBateria(){

        double nivelBateria = super.getNivelBateria();

        double consumoDistancia = distanciaPercorrida * 0.1;
        double consumoInclinacao = inclinacaoAtual * 0.2;
        double usoVelicidade = super.getVelocidade() * 0.3;
        double consumoTotal = consumoDistancia + consumoInclinacao + usoVelicidade;

        nivelBateria -= consumoTotal;

        if (nivelBateria < 0) {
            nivelBateria = 0;
        }

        setNivelBateria(nivelBateria);
    }

    public double calcularDesempenho(){
        return (areaExplorada*0.6)+((100-desgasteEsteiras)*0.4);
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
        return (desgasteEsteiras*0.5)+(inclinacaoAtual*0.3)+((100-getNivelBateria())*0.2);
    }

    public double fornecerIndiceIPO(){

        /*
            Criterios a serem utilizados:
            -calcularAutonomiaTerreno()
            -calcularDesempenho()
            -calcularRisco()

            A ideia é somar a os criterios aplicados com os seus devidos pesos aplicados
         */

        double indiceAutonomia = calcularAutonomia() * 0.3;
        double indiceDesempenho = calcularDesempenho() * 0.2;
        double indiceRisco = (100-calcularRisco())*0.5;

        return indiceAutonomia + indiceDesempenho + indiceRisco;
    }

    public String gerarRelatorio(){

        String aux = "==== Robô Terrestre: "+ getNome() +"====\n";

        aux += "Identificador: "+ getId();
        aux += "Distancia percorrida: "+ distanciaPercorrida+"\n";
        aux += "Desgaste de esteiras: "+ desgasteEsteiras+"\n";
        aux += "Inclinação Atual: "+ inclinacaoAtual+"\n";
        aux += "Área explorada: "+ areaExplorada+"\n";
        aux += "Indice IPO: "+fornecerIndiceIPO()+"\n";
        aux += "Nível Bateria: "+ getNivelBateria()+"\n";
        aux += "Autonomia Terreno: "+ calcularAutonomia()+"\n";
        aux += "Desempenho: "+ calcularDesempenho()+"\n";
        aux += "Status: "+ obterStatus() +"\n";

        return aux;
    }

}
