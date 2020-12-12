# O Jogo

O objetivo deste trabalho é implementar um jogo de cartas virtual simples, tipo RPG de cartas ou
Supertrunfo, inspirado no World of Warcraft. O jogo deve ser jogado automaticamente a partir
de sorteios aleatórios. Implemente com o nível de sofisticação que achar que tem capacidade,
mas entenda que o objetivo aqui é explorar todos os conhecimentos de POO que discutimos até
aqui.

Você deve escrever uma classe principal chamada Jogo onde tudo irá acontecer. A hierarquia de
classes abaixo deve ser escrita para que os personagens possam ser codificados. A classe
superior, Personagem, deve ser uma classe abstrata que contenha os métodos relacionados a
jogabilidade, como por exemplo perder ou ganhar vida. Nas classes Orcs e Humanos temos as
características de cada povo, e devem ser classes de Interface, contendo os poderes e assinaturas
de métodos que devem ser implementados pelos personagens em si (classes filha).

<img  src="https://user-images.githubusercontent.com/61257292/101771978-80e10480-3ac9-11eb-97f5-2e49031df706.jpeg">

A Classe jogo conterá dois vetores de 100 personagens de cada povo, um de Orcs e outro de
Humanos, que vão se enfrentar em 100 rodadas par-a-par. O personagem de índice 30 dos Orcs
enfrenta o personagem de índice 30 dos Humanos, por exemplo. Ganhando aquele povo que, ao
final de 100 rodadas, tiver a maior quantidade de personagens com maior quantidade de vida
(soma dos personagens que tem mais vida na comparação par-a-par, ou seja, número de
vitórias). Você deve implementar a interface Comparable para permitir a comparação das vidas
diretamente pelo Objeto.

Portanto, todos os personagens, Orcs ou Humanos, tem uma determinada quantidade de vida,
que deve iniciar com o valor 100. Dependendo de cada luta entre dois personagens, esse valor
pode ser incrementado (ganha vida) ou decrementado (perde vida). Essa mudança vai acontecer 
com a diferença entre os valores dos atributos que estiverem envolvidos na luta, como explicarei
mais adiante.

Os Orcs têm atributos de força, habilidade e agilidade e os Humanos de inteligência, velocidade
e equipamentos. Quando se enfrentando, Orcs sempre lutam com Humanos, e vice-versa,
através de um de seus atributos que deve ser sorteado. Sempre em pares força vs. inteligência,
habilidade vs. velocidade e agilidade vs. equipamentos. Cada um desses atributos tem um valor
inicial diferente para cada tipo de Orc ou de Humano. As tabelas abaixo detalharão isso. 
   
 <table>
  <thead>
    <th> </th>
    <th>Força</th>
    <th>Habilidade</th>
    <th>Agilidade</th>
  </thead>
  <tbody><tr>
    <td>Ogro</td>
    <td>60</td>
    <td>60</td>
    <td>20</td>
  </tr>
  <tr>
    <td>Mago</td>
    <td>20</td>
    <td>80</td>
    <td>40</td>
  </tr>
  <tr>
   <td>Demônio</td>
   <td>80</td>
   <td>20</td>
   <td>60</td>
  </tr>
 </tbody></table>

<table>
  <thead>
    <th> </th>
    <th>Inteligência</th>
    <th>Velocidade</th>
    <th>Equipamentos</th>
  </thead>
  <tbody><tr>
    <td>Arqueiro</td>
    <td>60</td>
    <td>60</td>
    <td>20</td>
  </tr>
  <tr>
    <td>Soldado</td>
    <td>20</td>
    <td>80</td>
    <td>40</td>
  </tr>
  <tr>
   <td>Robô</td>
   <td>80</td>
   <td>20</td>
   <td>60</td>
  </tr>
 </tbody></table>

Quando um Arqueiro enfrentar um Mago através dos atributos força vs. inteligência, teremos 60
pontos de Inteligência do Arqueiro vs. 20 pontos de Força do Mago, o que resultará na vitória do
Arqueiro com 40 pontos de diferença. Isso fará com que o Mago que lutou contra o Arqueiro
perca 40 pontos de vida, e que esse último ganhe 40 pontos de vida.

Retomando o jogo, para iniciar é preciso criar um vetor de Orcs e um de Humanos com 100
personagens de diferentes tipos de cada povo. Para criar um novo personagem, você deve
instanciar aleatoriamente uma das 3 Classes de um dos tipos. O primeiro Orc pode ser, por
exemplo, um Ogro e o primeiro Humano um Robô. Serão vários tipos de Orcs e de Humanos.
Você precisa criar um método que mostre os tipos dos personagens do vetor de cada povo.
Também é preciso mostrar o resultado de cada luta individual, indicando o vencedor. No final, é
preciso mostrar o povo vencedor e o total de vida resultante de cada povo

Utilizem a classe Random para gerar os números aleatórios
(https://www.devmedia.com.br/numeros-aleatorios-em-java-a-classe-java-util-random/26355).
Usar também toString() para as impressões.
