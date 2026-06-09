package Entidades.EstacaoEnergia;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class EstacaoEnergia extends EntidadeEspacial implements CalculavelIPO, AvaliadorRisco {


    private double energiaGerada;
    private double rendimentoSistema;
    private double consumoAtual;

    public EstacaoEnergia(int id, String nome, double energiaGerada, double rendimentoSistema, double consumoAtual) {
        super(id, nome);
        this.energiaGerada = energiaGerada;
        this.rendimentoSistema = rendimentoSistema;
        this.consumoAtual = consumoAtual;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public double getrendimentoSistema() {
        return rendimentoSistema;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    public void setrendimentoSistema(double rendimentoSistema) {
        this.rendimentoSistema = rendimentoSistema;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public String toString() {
        return super.toString() + "Tipo: Estação de Energia\n";
    }

    public double calcularCapacidadeEnergetica(){

        double energiaDisponivel = energiaGerada*(rendimentoSistema/100);

        return (energiaDisponivel/consumoAtual)*100;
    }

    public double fornecerIndiceIPO(){

        double indiceEnergia = (energiaGerada / 1000) * 100;

        if(indiceEnergia<0){
            indiceEnergia=0;
        }

        double indiceConsumo = 100 - consumoAtual;

        if(indiceConsumo<0){
            indiceConsumo=0;
        }

        return (indiceEnergia*0.15)+(rendimentoSistema*0.15)+(indiceConsumo*0.25);
    }

    public double calcularRisco(){

        double riscoEficiencia = calcularCapacidadeEnergetica()*0.4;
        double riscoIPO = (100-fornecerIndiceIPO())*0.6;

        return riscoEficiencia + riscoIPO;
    }

    // Métodos erdados da SuperClasse

    public String obterStatus() {

        if (calcularCapacidadeEnergetica()>consumoAtual){
            return "Verde";
        } else if (calcularCapacidadeEnergetica()==consumoAtual) {
            return "Amarelo";
        }

        return "Vermelho";
    }

    public String gerarRelatorio() {

        String aux= "==> Estação de Energia"+ getNome() +"\n";
        aux += "Identificador: "+ getId() +"\n";
        aux += "Energia Gerada: "+energiaGerada+"\n";
        aux += "Rendimento Sistema: "+rendimentoSistema+"%\n";
        aux += "Consumo da estatão: "+consumoAtual+"%\n";
        aux += "Probabilidade de risco: "+String.format("%.2f",calcularRisco())+"%\n";
        aux += "Capacidade energetica: "+String.format("%.2f",calcularCapacidadeEnergetica())+"%\n";
        aux += "Indice IPO: "+String.format("%.2f",fornecerIndiceIPO())+"%\n";
        aux += "Status: "+obterStatus()+"\n";

        return aux;
    }


}
