package Entidades.SensorEspacial;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.CalculavelIPO;

public class SensorEspacial extends EntidadeEspacial implements CalculavelIPO {

    /*
        Representa sensores utilizados para monitoramento ambiental.
     */

    private double temperatura;
    private double radiacao;
    private double pressaoAtmosferica;

    public SensorEspacial(int id, String nome, double pressaoAtmosferica, double radiacao, double temperatura) {
        super(id, nome);
        this.pressaoAtmosferica = pressaoAtmosferica;
        this.radiacao = radiacao;
        this.temperatura = temperatura;
    }

    public double getPressaoAtmosferica() {
        return pressaoAtmosferica;
    }

    public double getRadiacao() {
        return radiacao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setPressaoAtmosferica(double pressaoAtmosferica) {
        this.pressaoAtmosferica = pressaoAtmosferica;
    }

    public void setRadiacao(double radiacao) {
        this.radiacao = radiacao;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double calcularRiscoAmbiental(){
        /*
            Calcula o risco ambiental da região monitorada.

            Lógica:
            -Risco calculado apartir da relevancia de cada atributo
            -Sendo eles: temperatura(30%),radiacao(50%) e pressaoAtmosferica(20%)
         */

        double riscoTemperatura = temperatura*0.3;
        double riscoRadiacao = radiacao*0.5;
        double riscoPressao = pressaoAtmosferica*0.2;

        return riscoTemperatura + riscoRadiacao + riscoPressao;
    }

    public double fornecerIndiceIPO(){

        double risco = calcularRiscoAmbiental();

        double ipo = 100-risco;

        if (ipo<0){
            ipo = 0;
        }

        return ipo;
    }

    public String obterStatus() {

        double ipo= fornecerIndiceIPO();

        if (ipo>=70){
            return "OPERACIONAL";
        } else if (ipo>=40) {
            return "Atenção";
        }

        return "CRÍTICO";}

    public String gerarRelatorio() {

        String aux= "==== Sensor Espacial ====\n";

        aux+= super.toString();
        aux+= "Status: "+ obterStatus()+"\n";
        aux+= "Indice IPO: "+fornecerIndiceIPO()+"%\n";
        aux+= "=> Dados do Sensor:\n";
        aux+= "Presão atmosferica: "+ pressaoAtmosferica+"\n";
        aux+= "temperatura: "+ temperatura+"\n";
        aux+= "radiacao: "+ radiacao+"\n";
        aux+= "Risco ambiental: "+ calcularRiscoAmbiental()+"\n";


        return aux;
    }
}
