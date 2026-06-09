package Util;

import Entidades.DroneAereo.DroneAereo;
import Entidades.EntidadeEspacial.EntidadeEspacial;
import Entidades.EstacaoEnergia.EstacaoEnergia;
import Entidades.EventoSistema.EventoSistema;
import Entidades.RoboExplorador.RoboEspacial;
import Entidades.RoboExplorador.RoboExplorador;
import Entidades.RoboExplorador.RoboTerrestre;
import Entidades.SensorEspacial.SensorEspacial;
import Interface.CalculavelIPO;

import javax.swing.*;
import java.util.ArrayList;

public class ControleMissao {

    static ArrayList<EntidadeEspacial> entidades=new ArrayList<>();
    static ArrayList<EventoSistema> eventos=new ArrayList<>();

    // Menu Principal
    public void menu(){

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    
                    ==== Monitoramento SpaceOps Control ====
                    
                    1- Cadastrar nova entidade;
                    2- Listar entidades cadastradas;
                    3- Executar cálculo específico de uma entidade;
                    4- Registrar evento no sistema;
                    5- Consultar histórico de eventos
                    6- Calcular e exibir o IPO;
                    7- Exibir relatório geral do sistema;
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
                    calculoEspecificoEntidade();
                    break;
                case 4:
                    registrarEvento();
                    break;
                case 5:
                    consultaHistoricoEvento();
                    break;
                case 6:
                    calcularIPO();
                    break;
                case 7:
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

    // Menu de Cadastro de Entidades
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
                    JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso");
                    break;
                case 2:
                    entidades.add(cadastroEstacaoEnergia());
                    JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso");
                    break;
                case 3:
                    entidades.add(cadastroRoboEspacial());
                    JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso");
                    break;
                case 4:
                    entidades.add(cadastroRoboTerrestre());
                    JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso");
                    break;
                case 5:
                    entidades.add(cadastroSensorEspacial());
                    JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso");
                    break;
                case 0:
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida");
            }

        }while (opcao!=0);
    }

    // linha 127-213 Parte de coleta de dados e a criação dos objteos das classes para o cadastro
    private DroneAereo cadastroDroneAereo() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Número de identificação: "));

        String nome = JOptionPane.showInputDialog("Informe o nome do dispotivo: ");

        double altitudeMaxima = Double.parseDouble(JOptionPane.showInputDialog("Altitude máxima de alcance : "));

        double areaMapeada = Double.parseDouble(JOptionPane.showInputDialog("Tamanho da área de mapeamento: "));

        double autonomiaVoo = Double.parseDouble(JOptionPane.showInputDialog("Nível autonomia de voo: "));

        return new DroneAereo(id,nome,altitudeMaxima,areaMapeada,autonomiaVoo);
    }

    private EstacaoEnergia cadastroEstacaoEnergia() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Número de identificação: "));

        String nome = JOptionPane.showInputDialog("Informe o nome do dispotivo: ");

        double energiaGerada = Double.parseDouble(JOptionPane.showInputDialog("Quanto de energia a Estação tem capacidade de gerar: "));

        double rendimentoSistema = Double.parseDouble(JOptionPane.showInputDialog("Quanto de rendimento previsto para o Sistema da Estação: "));

        double consumoAtual = Double.parseDouble(JOptionPane.showInputDialog("Qual será consumo da Estação: "));

        return new EstacaoEnergia(id,nome,energiaGerada,rendimentoSistema,consumoAtual);

    }

    private RoboEspacial cadastroRoboEspacial() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Número de identificação: "));

        String nome = JOptionPane.showInputDialog("Informe o nome do dispotivo: ");

        double nivelBateria = Double.parseDouble(JOptionPane.showInputDialog("Nível de bateria do Robô: "));

        double velocidade = Double.parseDouble(JOptionPane.showInputDialog("Velocidade media do Robô: "));

        double areaMonitorada = Double.parseDouble(JOptionPane.showInputDialog("Tamanho da área monitorada: "));

        double combustivel = Double.parseDouble(JOptionPane.showInputDialog("Nível de combustivel do Robô: "));

        double nivelRadiacao = Double.parseDouble(JOptionPane.showInputDialog("Nível de Radiação da orbita explorada: "));

        double quantidadeDadosColetados = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de dados coletados: "));

        return new RoboEspacial(id,nome,nivelBateria,velocidade,areaMonitorada,combustivel,nivelRadiacao,quantidadeDadosColetados);
    }

    private RoboTerrestre cadastroRoboTerrestre() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Número de identificação: "));

        String nome = JOptionPane.showInputDialog("Informe o nome do dispotivo: ");

        double nivelBateria = Double.parseDouble(JOptionPane.showInputDialog("Nível de bateria do Robô: "));

        double velocidade = Double.parseDouble(JOptionPane.showInputDialog("Velocidade media do Robô: "));

        double distanciaPercorrida = Double.parseDouble(JOptionPane.showInputDialog("Distância Percorrida pelo Robô: "));

        double desgasteEsteiras = Double.parseDouble(JOptionPane.showInputDialog("Nível de desgaste das esteiras do Robô: "));

        double inclinacaoAtual = Double.parseDouble(JOptionPane.showInputDialog("Nível de inclinação do terreno explorado: "));

        double areaExplorada = Double.parseDouble(JOptionPane.showInputDialog("Tamanho da área explorada: "));

        return new RoboTerrestre(id,nome,nivelBateria,velocidade,distanciaPercorrida,desgasteEsteiras,inclinacaoAtual,areaExplorada);
    }

    private SensorEspacial cadastroSensorEspacial() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Número de identificação: "));

        String nome = JOptionPane.showInputDialog("Informe o nome do dispotivo: ");

        double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Temperatura do Sensor Espacial: "));

        double radiacao = Double.parseDouble(JOptionPane.showInputDialog("Nível de radiação que atinge o Sensor Espacial: "));

        double pressaoAtmosferica = Double.parseDouble(JOptionPane.showInputDialog("Pressão atmosférica que atinge o Sensor Espacial: "));

        return new SensorEspacial(id,nome,temperatura,radiacao,pressaoAtmosferica);
    }

    // Parte de Listagem das entidades
    public void listarEntidades(){

        String lista="";

        for (int i = 0; i < entidades.size(); i++) {
            lista+= (i+1)+"- "+entidades.get(i)+"\n";
        }

        JOptionPane.showMessageDialog(null, lista);
    }

    public void calculoEspecificoEntidade(){

        String lista="";

        for (int i = 0; i < entidades.size(); i++) {
            lista+= (i+1)+"- "+entidades.get(i)+"\n";
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(lista+"\nEscolha uma entidade:"));

        EntidadeEspacial entidade = entidades.get(escolha);


        if (entidade instanceof DroneAereo droneAereo){

            String resultadoCalculo="";
            double exclusico1 = droneAereo.calcularCoberturaAerea();
            double exclusico2 = droneAereo.calcularAutonomiaFinalVoo();

            resultadoCalculo+="Área total de Cobertura: "+exclusico1+"km²\n";
            resultadoCalculo+="Autonomia Final: "+exclusico2+"%\n";

            JOptionPane.showMessageDialog(null, resultadoCalculo);
        } else if (entidade instanceof EstacaoEnergia estacao) {
            String resultadoCalculo="";
            double eficienciaEstacao = estacao.calcularCapacidadeEnergetica();

            resultadoCalculo+="Eficiencia da estação: "+eficienciaEstacao+"%\n";

            JOptionPane.showMessageDialog(null, resultadoCalculo);

        } else if (entidade instanceof RoboEspacial roboEspacial) {
            String resultadoCalculo="";
            double retornoCientifico = roboEspacial.calcularRetornoCientifico();
            double exposicaoEspacial = roboEspacial.calcularExposicaoEspacial();

            resultadoCalculo+="Pontuação do RetornoCientifico: "+retornoCientifico+"\n";
            resultadoCalculo+="Nível de exposição a radiação: "+exposicaoEspacial+"%\n";

            JOptionPane.showMessageDialog(null, resultadoCalculo);
        } else if (entidade instanceof RoboTerrestre roboTerrestre) {
            String resultadoCalculo="";
            double EficienciaExploracao = roboTerrestre.calcularEficienciaExploracao();

            resultadoCalculo+="Eficiencia de Exploração: "+EficienciaExploracao+"%\n";

            JOptionPane.showMessageDialog(null, resultadoCalculo);
        } else if (entidade instanceof SensorEspacial sensor) {
            String resultadoCalculo="";
            double calcularRiscoAmbiental = sensor.calcularRiscoAmbiental();

            resultadoCalculo+="Nível de risco ambiental: "+calcularRiscoAmbiental+"%\n";

            JOptionPane.showMessageDialog(null, resultadoCalculo);
        }

    }

    // Funcionalidades do Menu de Eventos
    public void registrarEvento(){

        String id = JOptionPane.showInputDialog("Identificador do Evento: ");
        String tipoEvento = JOptionPane.showInputDialog("Tipo de Evento: ");
        String dataHora = JOptionPane.showInputDialog("Data e Hora (dd/mm/yyyy-h:m:s): ") ;
        String descricao = JOptionPane.showInputDialog("Descrição do Evento: ");

        eventos.add(new EventoSistema(tipoEvento,dataHora,descricao,id));

        JOptionPane.showMessageDialog(null,"Evento Registrado com sucesso!");

    }

    private void consultaHistoricoEvento() {

        String consulta="==== Historico de Eventos ====\n";

        for (EventoSistema evento: eventos){

            consulta+=evento.gerarResumoEvento();

        }

        JOptionPane.showMessageDialog(null,consulta);

    }

    // Visualização dos Resultados do Incide IPO
    public void calcularIPO(){

        String resultado = "==== Calcular IPO  ====\n";

        for (EntidadeEspacial entidade:entidades){
            if (entidade instanceof CalculavelIPO){
                resultado+= entidade.getNome() +"\n";
                resultado+= " -> IPO: " +((CalculavelIPO) entidade).fornecerIndiceIPO()+"\n\n";
            }
        }

        JOptionPane.showMessageDialog(null,resultado);
    }

    // Visualização do Relatorio de total das as Entidades
    public void gerarRelatorioGeral(){

        String relatorio="====> Relatorio Geral Do Sistema\n";

        for (EntidadeEspacial entidade: entidades){
            relatorio+=entidade.gerarRelatorio();
            relatorio+="\n";
        }

        JOptionPane.showMessageDialog(null,relatorio);
    }

}