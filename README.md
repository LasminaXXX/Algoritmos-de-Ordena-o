# Algoritmos-de-Ordena-o
Este projeto tem como objetivo realizar testes com algoritmos de ordenação usando 3 arquivos txt distintos, cada um deles contendo um milhão de números não repetidos. Os algoritmos serão testados com um txt contendo uma lista de 1.000.000 numeros inteiros organizados da seguinte forma:
* Com números inteiros já ordenados
* Com números inteiros invertidos (do menor para o menor)
* Com números inteiros aleatorios
## 1 Especificações Técnicas 
o testes foram realizado em um notebook lenovo com processador ryzen 5 3500u, 12 Gb de memória ram, placa de vídeo integrada vega 8  e ssd de 256 Gb. Em relação ao SO da máquina, foi utilizado o Windows 10 Pro  64 bits versão 22h2.
## 2 Algoritmos
### 2.1 Bubble Sort 
O Bubble Sort, ou ordenação por flutuação, é um algoritmo de ordenação dos mais simples. A ideia é percorrer um conjunto de elementos diversas vezes, e a cada passagem fazer flutuar para o topo o maior elemento da sequência. O algoritmo de ordenação Bubble Sort possui uma complexidade de tempo média e pior caso de O(n^2), o que significa que o tempo de execução aumenta quadrativamente com o tamanho da entrada. Para uma entrada significativamente grande, como 1 milhão de números, o Bubble Sort pode se tornar ineficiente comparado a algoritmos de ordenação mais eficientes, como o Merge Sort ou o Quick Sort, que têm complexidade de tempo média de O(n log n). Na tentativa de realizar os testes, conseguimos o resultado referente a verificação do arquivo já ordenado, sendo retornado os seguintes valores:

|                   | Tempo de execução (em segundos)  | Quantidade de Comparações  |  Quantidade de Trocas   |
|-------------------|----------------------------------|----------------------------|-------------------------|
| Arquivo Ordenado  |              2558,787            |            726.379.968       |            0            |
| Arquivo Invertido |                ----              |              10^12         |          10^12          | 
| Arquivo Aleatorio |                ----              |              10^12         |          10^12          |

### 2.2 insertion Sort
Insertion Sort, ou ordenação por inserção, é um algoritmo de ordenação que, dado uma estrutura constrói uma matriz final com um elemento de cada vez, uma inserção por vez. O Insertion Sort, quando se comparado ao Bubble Sort (algoritmo anterior), tem sim um aumento de desempenho, mas ainda é um algoritmo que possui uma complexidade de tempo média e pior caso de O(n^2), assim como o Bubble Sort.

|                   | Tempo de execução (em segundos)  | Quantidade de Comparações  |  Quantidade de Trocas   |
|-------------------|----------------------------------|----------------------------|-------------------------|
| Arquivo Ordenado  |              2548,787            |            622981199       |            0            |
| Arquivo Invertido |                ----              |            5*10^11         |            5*10^11      | 
| Arquivo Aleatorio |                ----              |            5*10^11         |            5*10^11      |

### 2.3 Merge Sort 
O merge sort, ou ordenação por mistura, é um exemplo de algoritmo de ordenação por comparação do tipo dividir-para-conquistar. Sua ideia básica consiste em Dividir e Conquistar. Fazendo os testes com os arquivos txt, temos: 

|                   | Tempo de execução (em segundos)  | Quantidade de Comparações  |  Quantidade de Trocas   |
|-------------------|----------------------------------|----------------------------|-------------------------|
| Arquivo Ordenado  |                0,4               |           19.951.445       |            0            |
| Arquivo Invertido |                0,925             |           41.902.892       |         10.884.999      | 
| Arquivo Aleatorio |                2,395             |           64.805.742       |         10.765.507      |


### 2.4 Quick Sort
O Quick Sort é o algoritmo de ordenação interna mais rápido que se conhece para uma ampla variedade de situações. Provavelmente é o mais utilizado. A idéia básica é dividir o problema de ordenar um conjunto com n itens em dois problemas menores. Os problemas menores são ordenados independentemente. O Quicl Sort foi inventado por C.A.R. Hoare em 1960, quando visitou a Universidade de Moscovo como estudante. Naquela época, Hoare trabalhou em um projeto de tradução de máquina para o National Physical Laboratory. Implementado o algortimo Quick Sort mencionado acima e ultiizando para ordenar os arquivos, temos como resultado os seguintes valores: 

|                   | Tempo de execução (em segundos)  | Quantidade de Comparações  |  Quantidade de Trocas   |
|-------------------|----------------------------------|----------------------------|-------------------------|
| Arquivo Ordenado  |                0,118             |              1             |            0            |
| Arquivo Invertido |                0,368             |           500.000          |          500.000        | 
| Arquivo Aleatorio |                0,551             |           87.505           |           87.504        |


