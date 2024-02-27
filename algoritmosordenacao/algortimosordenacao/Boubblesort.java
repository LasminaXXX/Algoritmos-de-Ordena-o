/**
 * Boubblesort
 */ 
package algortimosordenacao;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
   

public class Boubblesort {

    /**
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<>(); 
        String caminhoArquivoOrdenado = "C:\\Users\\gamer\\OneDrive\\Área de Trabalho\\algoritimos\\algoritmosordenacao\\txt\\ordenados.txt";
        ArrayList<Integer> numerosArquivoOrdenado = new ArrayList<>(lerarquivo(numeros, caminhoArquivoOrdenado));


        String caminhoArquivoDesordenado = "C:\\Users\\gamer\\OneDrive\\Área de Trabalho\\algoritimos\\algoritmosordenacao\\txt\\invertidos.txt";
        ArrayList<Integer> numerosArquivoDesordenado = new ArrayList<>(lerarquivo(numeros, caminhoArquivoDesordenado));
        System.out.println("Ordenação via Bobble Sort(Invertidos):");
        long inicioExecucaoDesor = System.currentTimeMillis();
        OrdenadosBoubbleSort(numerosArquivoDesordenado);
        long fimExecucaoDesor = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fimExecucaoDesor - inicioExecucaoDesor));

        
        }

        
        public static ArrayList<Integer> OrdenadosBoubbleSort(ArrayList<Integer> ListaNumeros){
            int trocas = 0;
            int comparacoes = 0;
            for (int i = 0; i < ListaNumeros.size(); i++) {
                int auxiliar;
                
                for (int j = 0; j < ListaNumeros.size()-1; j++) {
                    comparacoes ++;
                    if (ListaNumeros.get(j) > ListaNumeros.get(j+1)) {
                        trocas ++;
                        auxiliar = ListaNumeros.get(j);
                        ListaNumeros.set(j, ListaNumeros.get(j+1));
                        ListaNumeros.set(j+1, auxiliar);
                    }
                }
            }

            System.out.println("Quantidade de comparações realizadas: " + comparacoes + "Quantidade de trocas realizadas: " + trocas);
            return ListaNumeros; 
        } 
        /**
         * Leitura dos arquivos
         */
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

}