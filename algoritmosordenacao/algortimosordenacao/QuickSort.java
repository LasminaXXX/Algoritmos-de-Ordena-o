package algortimosordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSort{

    public static void main(String[] args) {
        String caminhoArquivo = "C:\\\\Users\\\\gamer\\\\OneDrive\\\\Área de Trabalho\\\\algoritimos\\\\algoritmosordenacao\\\\txt\\\\invertidos.txt";
        ArrayList<Integer> numeros = lerArquivo(caminhoArquivo);

        System.out.println("Ordenação usando Quick Sort (Invertidos): ");

        long inicioExecucao = System.currentTimeMillis();
        int[] invertidosEstats = quicksort(numeros, 0, numeros.size() - 1);
        long fimExecucao = System.currentTimeMillis();

        System.out.println("\nTempo de execução: " + (fimExecucao - inicioExecucao) + " milissegundos\nQuantidade de comparações feitas: " + invertidosEstats[1] + "\nQuantidade de trocas: " + invertidosEstats[0]);





        String caminhoArquivoOrdenados = "C:\\\\Users\\\\gamer\\\\OneDrive\\\\Área de Trabalho\\\\algoritimos\\\\algoritmosordenacao\\\\txt\\\\ordenados.txt";
        ArrayList<Integer> numerosOrdenados = lerArquivo(caminhoArquivoOrdenados);

        System.out.println("Ordenação usando Quick Sort (Ordenados): ");
  
        long inicioExecucaoOrdenados = System.currentTimeMillis();
        int[] ordenadosEstats = quicksort(numerosOrdenados, 0, numerosOrdenados.size() - 1);
        long fimExecucaoOrdenados = System.currentTimeMillis();

        System.out.println("\nTempo de execução: " + (fimExecucaoOrdenados - inicioExecucaoOrdenados) + " milissegundos\nQuantidade de comparações feitas: " + ordenadosEstats[1] + "\nQuantidade de trocas: " + ordenadosEstats[0]);





        String caminhoArquivoAleatorios = "C:\\\\Users\\\\gamer\\\\OneDrive\\\\Área de Trabalho\\\\algoritimos\\\\algoritmosordenacao\\\\txt\\\\aleatorios.txt";
        ArrayList<Integer> numerosAleatorios = lerArquivo(caminhoArquivoAleatorios);

        System.out.println("Ordenação usando Quick Sort (Aleatorios): ");
  
        long inicioExecucaoAleatorios = System.currentTimeMillis();
        int[] aleatoriosEstats = quicksort(numerosAleatorios, 0, numerosAleatorios.size() - 1);
        long fimExecucaoAleatoria = System.currentTimeMillis();

        System.out.println("\nTempo de execução: " + (fimExecucaoAleatoria - inicioExecucaoAleatorios) + " milissegundos\nQuantidade de comparações feitas: " + aleatoriosEstats[1] + "\nQuantidade de trocas: " + aleatoriosEstats[0]);




    }
    /**
     * @param v
     * @param start
     * @param end
     * @return
     */
    public static int[] quicksort(ArrayList<Integer> v, int start, int end) {
        int comparacoes = 0;
        int troca = 0;
        if (end>start) {
    
            int pivo = v.get((start+end)/2);
    
            int i = start;
    
            int f = end;
    
            while (f>i) {
                comparacoes++;
                while (i <= end && v.get(i) < pivo) i++;
                while (f >= start && v.get(f) >= pivo) f--;
    
                if (f>i) {
                    troca++;
                    int aux = v.get(f);
                    v.set(f, v.get(i));
                    v.set(i, aux);
                    i++;
                    f--;
                }
    
            }
            if (f!= end)
                quicksort(v, start, f);
            if (i!=start)
                quicksort(v, i, end);
        
        }
        return new int[]{troca, comparacoes};
        
    }
    private static ArrayList<Integer> lerArquivo(String caminho) {
        ArrayList<Integer> numeros = new ArrayList<>();
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

    private static void exibirParteDoArrayList(ArrayList<Integer> numeros) {
        for (int i = 0; i < Math.min(10, numeros.size()); i++) {
            System.out.print(numeros.get(i) + " ");
        }
        System.out.println("...");
    }
}

