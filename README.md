
# 🚀 SpaceOps Control

Sistema de gerenciamento de robôs e equipamentos para exploração espacial desenvolvido em Java.

O **SpaceOps Control** tem como objetivo simular o controle de uma operação espacial, permitindo cadastrar, monitorar e analisar diferentes tipos de entidades exploradoras, como robôs, drones, sensores e estações de energia.

O sistema aplica conceitos de **Programação Orientada a Objetos (POO)**, utilizando herança, polimorfismo, encapsulamento e interfaces para representar diferentes comportamentos das entidades.

---

# 🌌 Contexto do Projeto

Em missões espaciais, diversos equipamentos autônomos são utilizados para coleta de dados, exploração de ambientes e suporte energético.

O SpaceOps Control permite:

- Gerenciamento de unidades exploradoras;
- Monitoramento de desempenho;
- Avaliação de riscos ambientais;
- Cálculo de autonomia operacional;
- Análise do Índice de Performance Operacional (IPO);
- Geração de relatórios das entidades cadastradas.

---

# 🛠️ Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Java Swing (JOptionPane)
- ArrayList para gerenciamento de entidades

---

# 📚 Conceitos de POO aplicados

## Encapsulamento

Os atributos das entidades são privados e acessados através de métodos específicos, garantindo controle sobre os dados.

Exemplo:

```java
private double nivelBateria;
````

O acesso ocorre através de métodos:

```java
getNivelBateria();
setNivelBateria();
```

---

## Herança

Foi criada uma hierarquia de classes para representar características em comum.

Estrutura:

```
EntidadeEspacial
        |
        ├── DroneAereo
        |
        ├── EstacaoEnergia
        |
        ├── SensorEspacial
        |
        └── RoboExplorador
                |
                ├── RoboTerrestre
                |
                └── RoboEspacial
```

A superclasse `EntidadeEspacial` concentra características comuns:

* Identificação;
* Nome;
* Relatórios;
* Status da entidade.

---

# 🛰️ Entidades do Sistema

## EntidadeEspacial

Classe abstrata base do sistema.

Responsável por definir o comportamento comum das entidades espaciais.

Métodos:

* `gerarRelatorio()`
* `obterStatus()`

---

## 🤖 RoboExplorador

Superclasse dos robôs exploradores.

Representa características comuns:

* Nível de bateria;
* Velocidade;
* Autonomia;
* Desempenho.

Métodos:

* `calcularAutonomia()`
* `atualizarBateria()`
* `calcularDesempenho()`

---

## 🚀 RoboEspacial

Representa robôs utilizados em exploração fora de ambientes terrestres.

Atributos principais:

* Combustível;
* Radiação recebida;
* Área monitorada;
* Dados coletados.

Funcionalidades:

* Retorno científico;
* Análise de risco;
* Índice IPO.

---

## 🛞 RoboTerrestre

Representa robôs que exploram superfícies planetárias.

Características:

* Distância percorrida;
* Desgaste das esteiras;
* Inclinação do terreno;
* Área explorada.

Realiza cálculos como:

* Eficiência de exploração;
* Autonomia em terreno;
* Risco operacional.

---

## 🛸 DroneAereo

Responsável por exploração aérea.

Características:

* Altitude máxima;
* Área mapeada;
* Autonomia de voo.

Calcula:

* Cobertura aérea;
* Autonomia final de voo;
* Risco operacional.

---

## 🔋 EstacaoEnergia

Representa estruturas responsáveis pelo fornecimento energético.

Possui:

* Energia gerada;
* Rendimento do sistema;
* Consumo atual.

Calcula:

* Capacidade energética;
* Eficiência operacional;
* Índice IPO.

---

## 📡 SensorEspacial

Responsável pelo monitoramento ambiental.

Coleta:

* Temperatura;
* Radiação;
* Pressão atmosférica.

Realiza:

* Avaliação de risco ambiental;
* Índice de segurança.

---

## ⚠️ EventoSistema

Representa eventos registrados durante a operação.

Armazena:

* Descrição;
* Tipo;
* Data e hora.

---

# 🔌 Interfaces

## CalculavelIPO

Define um contrato para entidades capazes de calcular o Índice de Performance Operacional.

Implementada por:

* RoboTerrestre;
* RoboEspacial;
* SensorEspacial;
* EstacaoEnergia.

Método:

```java
fornecerIndiceIPO()
```

---

## AvaliadorRisco

Define comportamento para entidades que possuem análise de risco.

Implementada por:

* RoboTerrestre;
* RoboEspacial;
* DroneAereo;
* EstacaoEnergia.

Método:

```java
calcularRisco()
```

---

# 📊 Índice IPO

O Índice de Performance Operacional representa a condição geral de uma entidade em uma escala de 0 a 100.

Interpretação:

| Faixa    | Significado           |
| -------- | --------------------- |
| 80 - 100 | 🟢 Operação segura    |
| 50 - 79  | 🟡 Atenção necessária |
| 0 - 49   | 🔴 Estado crítico     |

O cálculo considera fatores como:

* Autonomia;
* Desempenho;
* Risco;
* Eficiência energética;
* Capacidade operacional.

---

# 🏗️ Estrutura do Projeto

```
SpaceOpsControl
│
├── src
│   │
│   ├── entidades
│   │   ├── EntidadeEspacial.java
│   │   ├── RoboExplorador.java
│   │   ├── RoboTerrestre.java
│   │   ├── RoboEspacial.java
│   │   ├── DroneAereo.java
│   │   ├── EstacaoEnergia.java
│   │   ├── SensorEspacial.java
│   │   └── EventoSistema.java
│   │
│   ├── interfaces
│   │   ├── CalculavelIPO.java
│   │   └── AvaliadorRisco.java
│   │
│   └── sistema
│       └── ControleMissao.java
│
└── README.md
```

---

# ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/SpaceOps-Control.git
```

2. Abra o projeto em uma IDE Java:

* IntelliJ IDEA
* Eclipse
* VS Code

3. Execute a classe principal:

```java
Main.java
```

---

# 👨‍💻 Autor

Murilo Lopes

Projeto acadêmico desenvolvido para estudo de:

* Programação Orientada a Objetos;
* Modelagem de sistemas;
* Interfaces e polimorfismo em Java.
