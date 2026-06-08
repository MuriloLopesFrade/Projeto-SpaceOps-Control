package Util;

import Entidades.DroneAereo.DroneAereo;
import Entidades.EntidadeEspacial.EntidadeEspacial;
import Entidades.EstacaoEnergia.EstacaoEnergia;
import Entidades.EventoSistema.EventoSistema;
import Entidades.RoboExplorador.RoboEspacial;
import Entidades.RoboExplorador.RoboExplorador;
import Entidades.RoboExplorador.RoboTerrestre;
import Entidades.SensorEspacial.SensorEspacial;

import javax.swing.*;
import java.util.ArrayList;

public class ControleMissao {

    /*
        Responsabilidade:
        -Gerenciar toda a lógica principal do sistema.

        Objetivos:
        -armazenar entidades;
        -armazenar eventos;
        -controlar o IPO;
        -realizar buscas;
        -gerar relatórios gerais.
     */

    static ArrayList<Integer> entidades=new ArrayList<>();
    static ArrayList<EventoSistema> eventos=new ArrayList<>();


    public void menu(){

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    
                    ==== Monitoramento SpaceOps Control ====
                    
                    1-Cadastro de entidade;
                    2-Listagem de entidades;
                    3-Gerenciar de eventos do Sistema;
                    4-Calcular IPO;
                    5-Relatório geral;
                    0-Sair
                    
                    Digite a opção escolhida: 
                    """));

            switch (opcao){
                case 1:
                    cadastroEntidade();
                    break;
                case 2:
                    listarEntidades();
                    break;
                case 3:
                    GerenciadorEvento();
                    break;
                case 4:
                    calcularIPO();
                    break;
                case 5:
                    gerarRelatorioGeral();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Sistema inserrando.....");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida");
            }

        }while (opcao!=0);


    }

    public void cadastroEntidade(){
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    
                    ==== Cadastro de entidades ====
                    
                    1- Drone Áereo
                    2- Estação de Energia
                    3- Robô Espacial
                    4- Robô Terrestre
                    5- Sensor Espacial
                    0- Voltar ao menu principal
                    
                    Digite a opção escolhida: 
                    """));

            switch (opcao){
                case 1:
                    entidades.add(cadastroDroneAereo());
                    break;
                case 2:
                    entidades.add(cadastroEstacaoEnergia());
                    break;
                case 3:
                    entidades.add(cadastroRoboEspacial());
                    break;
                case 4:
                    entidades.add(cadastroRoboTerrestre());
                    break;
                case 5:
                    entidades.add(cadastroSensorEspacial());
                    break;
                case 0:
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida");
            }

        }while (opcao!=0);
    }


    private int cadastroSensorEspacial() {
        return 0;
    }

    private int cadastroRoboTerrestre() {
        return 0;
    }

    private int cadastroRoboEspacial() {
        return 0;
    }

    private int cadastroEstacaoEnergia() {
        return 0;
    }

    private int cadastroDroneAereo() {
        return 0;
    }


    public void listarEntidades(){
        JOptionPane.showMessageDialog(null,"==== Listagem de entidades ====");
    }

    private void GerenciadorEvento() {

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    
                    ==== Gereniador de Eventos do Sistema ====
                    
                    1- Registrar
                    2- Consultar
                    0- Voltar ao menu principal
                    
                    Digite a opção escolhida: 
                    """));

            switch (opcao){
                case 1:
                    eventos.add(registrarEvento());
                    JOptionPane.showMessageDialog(null,"Evento Cadastrado com sucesso!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"consultaEvento()");
                    break;
                case 0:
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida");
            }

        }while (opcao!=0);
    }

    public EventoSistema registrarEvento(){

        String tipoEvento = JOptionPane.showInputDialog("Tipo de Evento: ");
        String dataHora = JOptionPane.showInputDialog("Data e Hora (dd/mm/yyyy-h:m:s): ") ;
        String descricao = JOptionPane.showInputDialog("Descrição do Evento: ");

        return new EventoSistema(tipoEvento,dataHora,descricao);

    }


    public void calcularIPO(){
        JOptionPane.showMessageDialog(null,"==== Calculo IPO ====");
    }

    public void gerarRelatorioGeral(){
        JOptionPane.showMessageDialog(null,"==== Registro Gerar ====");
    }


}
