package Entidades.SensorEspacial;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.CalculavelIPO;

public class SensorEspacial extends EntidadeEspacial implements CalculavelIPO {

    private double temperatura;
    private double radiacao;
    private double pressaoAtmosferica;

    public SensorEspacial(int id, String nome, double temperatura, double radiacao, double pressaoAtmosferica) {
        super(id, nome);
        this.temperatura = temperatura;
        this.radiacao = radiacao;
        this.pressaoAtmosferica = pressaoAtmosferica;
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

    public String toString() {
        return super.toString() + "Tipo: Sensor Espacial\n";
    }

    public double calcularRiscoAmbiental(){

        double riscoTemperatura;

        if (temperatura >= -20 && temperatura <= 45) {
            riscoTemperatura = 0;
        }
        else if ((temperatura >= -40 && temperatura < -20) || (temperatura > 45 && temperatura <= 60)) {
            riscoTemperatura = 50;
        }
        else {
            riscoTemperatura = 100;
        }
        double riscoRadiacao = radiacao*0.5;
        double riscoPressao = (1 - pressaoAtmosferica) * 100;;

        return (riscoTemperatura*0.3) + (riscoRadiacao*0.5) + (riscoPressao*0.2);
    }

    public double fornecerIndiceIPO(){

        double ipo = (1-(calcularRiscoAmbiental()/100)) *100;

        if (ipo<0){
            ipo = 0;
        }

        if (ipo>100){
            ipo = 100;
        }

        return ipo;
    }

    public String obterStatus() {

        double ipo= fornecerIndiceIPO();

        if (ipo>=70){
            return "Verde";
        } else if (ipo>=40) {
            return "Amarelo";
        }

        return "Vermelho";}

    public String gerarRelatorio() {

        String aux= "==> Sensor Espacial: "+getNome()+"\n";

        aux+= "Identificador:"+ getId() +"\n";
        aux+= "Indice IPO: "+String.format("%.2f", fornecerIndiceIPO())+"%\n";
        aux+= "Presão atmosferica: "+ pressaoAtmosferica+"\n";
        aux+= "temperatura: "+ temperatura+"°C\n";
        aux+= "radiacao: "+ radiacao+"%\n";
        aux+= "Nível de risco ambiental: "+ String.format("%.2f", calcularRiscoAmbiental())+"%\n";
        aux+= "Status: "+obterStatus()+"\n";

        return aux;
    }
}
