# Trabalho Prático N.01

Alunos: Pedro Afonso, Lucas, Lucca
Professor: Zenilton Kleber Gonçalves do Patrocínio Júnior

Algoritmos baseados em grafos são usados em diversas áreas para auxiliar nas resoluções de inúmeros
problemas. Considere um grafo simples não-direcionado G = (V, E), em que V representa o conjunto de
vértices e E o conjunto de arestas, como o ilustrado pela Figura
![image](https://github.com/pedrodecampos/Trabalho-Pr-tico-Grafos-N.01/assets/15385678/fcbdac62-088f-461a-879b-7ac19c07182b)
Uma ponte em um grafo é definida como uma aresta cuja remoção torna o grafo desconexo. O problema de
se determinar as pontes existentes em um grafo apresenta várias aplicações, dentre elas encontrar caminhos
(ou ciclos) eulerianos. Neste trabalho você deverá implementar dois métodos para identificação de
pontes: (i) um método naïve em que se testa a conectividade após a remoção de cada aresta; e (ii) o
método de Tarjan (1974).
Além disso, sua implementação deverá encontrar um caminho euleriano em um grafo qualquer (ou
determinar que ele não existe) usando método de Fleury (juntamente com cada uma das duas estratégias
descritas para a identificação de pontes). Devem ser realizados experimentos que para avaliar o tempo
médio gasto para as duas estratégias aplicadas a grafos aleatórios (eurelianos, semi-euleriano e não
eurelianos) contendo 100, 1.000, 10.000 e 100.000 vértices.
Você deverá entregar além dos códigos implementados, um relatório (obrigatoriamente feito em TeX) em
formato PDF (juntamente com seus códigos-fontes em TeX) descrevendo detalhes das implementações, dos
experimentos e resultados obtidos. O trabalho pode ser desenvolvido e entregue em grupos de até 03 (três)
alunos. O trabalho deve ser desenvolvido e entregue separadamente por cada grupo – contudo discussões
entre os grupos para melhoria das soluções apresentadas são estimuladas.
