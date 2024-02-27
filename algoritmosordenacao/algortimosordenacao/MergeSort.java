package algortimosordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        String caminhoArquivoOrdenado = "C:\\Users\\gamer\\OneDrive\\Área de Trabalho\\algoritimos\\algoritmosordenacao\\txt\\ordenados.txt";
        ArrayList<Integer> numerosArquivoOrdenado = lerarquivo(numeros, caminhoArquivoOrdenado);

        System.out.println("Ordenação via Merge Sort (Ordenados):");
        long inicioExecucao = System.currentTimeMillis();
        int[] estatisticasOrdenado = ordenarMergeSort(numerosArquivoOrdenado);
        long fimExecucao = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fimExecucao - inicioExecucao));
        System.out.println("Quantidade de comparações realizadas: " + estatisticasOrdenado[0]);
        System.out.println("Quantidade de trocas realizadas: " + estatisticasOrdenado[1]);

        System.out.println("");

        // Repetir o mesmo padrão para os outros arquivos (invertidos e aleatórios)
    }

    public static int[] ordenarMergeSort(ArrayList<Integer> listaNumeros) {
        int[] estatisticas = new int[2];  // [0] comparações, [1] trocas
        ArrayList<Integer> auxiliar = new ArrayList<>(listaNumeros.size());
        for (int i = 0; i < listaNumeros.size(); i++) {
            auxiliar.add(0);
        }
        mergeSort(listaNumeros, 0, listaNumeros.size() - 1, auxiliar, estatisticas);
        return estatisticas;
    }

    public static void mergeSort(ArrayList<Integer> listaNumeros, int inicio, int fim, ArrayList<Integer> auxiliar, int[] estatisticas) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(listaNumeros, inicio, meio, auxiliar, estatisticas);
            mergeSort(listaNumeros, meio + 1, fim, auxiliar, estatisticas);
            merge(listaNumeros, inicio, meio, fim, auxiliar, estatisticas);
        }
    }

    public static void merge(ArrayList<Integer> listaNumeros, int inicio, int meio, int fim, ArrayList<Integer> auxiliar, int[] estatisticas) {
        for (int k = inicio; k <= fim; k++) {
            auxiliar.set(k, listaNumeros.get(k));
        }

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            estatisticas[0]++;  // contabiliza a comparação

            if (i > meio) {
                listaNumeros.set(k, auxiliar.get(j++));
            } else if (j > fim) {
                listaNumeros.set(k, auxiliar.get(i++));
            } else if (auxiliar.get(j) < auxiliar.get(i)) {
                estatisticas[1]++;  // contabiliza a troca
                listaNumeros.set(k, auxiliar.get(j++));
            } else {
                listaNumeros.set(k, auxiliar.get(i++));
            }
        }
    }
    public static ArrayList<Integer> lerarquivo(ArrayList<Integer> numeros, String caminho) {
            try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
                String linha;

                while ((linha = reader.readLine()) != null) {
                    try {
                        int numero = Integer.parseInt(linha);
                        numeros.add(numero);
                    } catch (NumberFormatException e) {
                        System.err.println("Ignorando linha inválida: " + linha);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return numeros; 

        }
    // Restante do código (lerArquivo) permanece inalterado
}
