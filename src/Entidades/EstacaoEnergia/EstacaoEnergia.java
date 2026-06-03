package Entidades.EstacaoEnergia;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class EstacaoEnergia extends EntidadeEspacial implements CalculavelIPO, AvaliadorRisco {

    /*
        Representa estações responsáveis pelo fornecimento energético da missão.
     */

    private double energiaGerada; // energia produzida pela estação.
    private double rendimentoSistema; // eficiência dos equipamentos (0 a 100%).
    private double consumoAtual; // energia que a base está consumindo.

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

    public double calcularEficienciaEnergetica(){
        /*
            Calcula o desempenho energético da estação.
         */

        double energiaDisponivel = energiaGerada*(rendimentoSistema/100);

        return (energiaDisponivel/consumoAtual)*100;
    }

    // Métodos erdados da Interface
    public double fornecerIndiceIPO(){

        /*
            Fatores levados em consideração:
            -energiaGerada;
            -rendimentoSistema;
            -consumoAtual;
            -eficiencia (calculada em calcularEficiênciaEnergetica());

         */

        double indiceEnergia =
                (energiaGerada / 1000) * 100;


        double indiceConsumo =
                100 - ((consumoAtual / 1000) * 100);


        return (indiceEnergia*0.15)+(rendimentoSistema*0.15)+(indiceConsumo*0.25)+ (calcularEficienciaEnergetica()*0.45);
    }

    public double calcularRisco(){
        return 0;
    }

    // Métodos erdados da SuperClasse

    public String obterStatus() {

        String status;

        if (calcularEficienciaEnergetica()>= 80){
            status = "Operação efetiva";
        } else if (calcularEficienciaEnergetica() >= 30) {
            status = "Atenção";
        }else {
            status = "Crítico";
        }

        return status;
    }

    public String gerarRelatorio() {

        String aux= "==== Estação de Energia ====\n";
        aux += super.toString();
        aux += "Energia Gerada: "+energiaGerada+"\n";
        aux += "Rendimento Sistema: "+rendimentoSistema+"%\n";
        aux += "Consumo da esatão: "+consumoAtual+"\n";
        aux += "Eficiencia: "+calcularEficienciaEnergetica()+"%\n";
        aux += "Indice IPO: "+fornecerIndiceIPO()+"%\n";
        aux += "Status: "+obterStatus()+"\n";


        return aux;
    }


}
