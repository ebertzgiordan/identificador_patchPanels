# **Projeto: Sistema de mapeamento de cabos de rede**

Feito por: Giordan Ebertz
Obs: O diagrama UML está no arquivo de relatório 😁

**Descrição**

Este projeto é uma aplicação de linha de comando desenvolvida em Java para **gerenciar portas de Patch Panels ou de Patch Voices**.

O usuário pode adicionar portas identificadas como LG \- lógicas e TL \-  telefone, logo após isso pode identificar o Patch Panel e sua respectiva porta. Além de poder citar a localização física caso tenha mais de um CPD, a porta também pode ser sinalizada como ocupada ou não, podendo não estar ativa. 

Também pede qual é o usuário final do cabeamento que pode ser pesquisado. O sistema também permite observações como cor do cabo, tubulação, caminho na construção, etc.

Caso o cabo seja Lógico ele pedirá a sua categoria, Cat6, Cat6a, Cat6 f utp, entre outros. Além do seu uso, como impressora, roteador, servidor, etc. Ou então caso seja de telefone poderá pedir o Ramal e a cor do cabo Cat5e passado.

O projeto conta com diversas opções abertas ao usuário como a listagem de todas as portas, ou com filtros por estarem ocupadas ou livres. Também efetua busca por código, podendo também remover o mesmo. Outra funcionalidade é a busca por usuário final, podendo fazer a pesquisa sem precisar de código, apenas com o nome do setor ou da pessoa que o utiliza.

O projeto demonstra conceitos de:

* Orientação a Objetos (Herança, Polimorfismo)  
* Uso de Classes Abstratas e Interfaces  
* Collections (`ArrayList`)  
* Tratamento de Exceções  
* Menu interativo para manipulação dos dados

---

## 

## **Requisitos**

* Java JDK 8 ou superior  
* Terminal ou IDE (Ex: NetBeans, VS Code, IntelliJ, Eclipse)

---

## **Estrutura do Projeto**

/src  
  ├── Main.java  
  ├── PatchPanel.java  
  ├── Porta.java  
  ├── PortaLogica.java  
  ├── PortaTelefone.java  
  ├── Pesquisa.java  
  └── PortaNaoEncontradaException.java  
---

## **Instruções de Compilação e Execução**

### 1\. Clonar ou baixar os arquivos

### 2\. Compilar o projeto

### 3\. Executar o programa

O menu de opções será exibido no terminal.

---

**Funcionalidades**

## **Menu Principal**

---

## **Exemplo de Uso**

Selecione uma opção:  
1 \- Adicionar nova porta  
2 \- Listar todas as portas  
3 \- Listar portas livres  
...  
Opção: 1

Tipo de porta (1 \- Lógica, 2 \- Telefone):  
1  
Patch Panel (ex: TL01 ou LG01):  
TL01  
Número da Porta (ex: 01):  
05  
Localização física:  
Rack Principal  
Está ocupada? (true/false):  
false  
Usuário Final:  
Giordan  
Observações:  
Cabeamento passado pela sala do jurídico  
Tipo de Cabo (ex: Cat6):  
Cat6  
Uso (ex: Internet):  
Pc  
---

**Conceitos de Programação Aplicados**

* **Herança**: `Porta` é uma classe abstrata, herdada por `PortaLogica` e `PortaTelefone`.  
* **Polimorfismo**: Métodos `getDetalhes()` e `getTipo()` sobrescritos nas subclasses.  
* **Classes Abstratas e Interface**: Uso de `Porta` (abstrata) e `Pesquisa` (interface).  
* **Collections**: `ArrayList` utilizado para armazenar todas as portas cadastradas.  
* **Tratamento de Exceções**: Implementação de `try-catch` para entradas inválidas e exceção personalizada `PortaNaoEncontradaException`.

---

## **Observações**

* Apenas códigos de Patch Panels que iniciem com **"TL"** ou **"LG"** são aceitos.  
* O sistema trata entradas inválidas sem encerrar inesperadamente.  
* Códigos das portas são formados juntando o código do Patch Panel \+ Número da Porta (ex: `TL0105`).
