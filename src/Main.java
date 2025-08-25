import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("--- Demonstração Prática de Big O ---");
        System.out.print("Digite o valor de N (tamanho da lista): ");
        int n = scanner.nextInt();
// 1. Criação da lista com N elementos aleatórios (operação rápida)
        ListaEncadeada<Integer> listaDeNumeros = new ListaEncadeada<>();
// Gera números num intervalo menor que N para garantir duplicatas
        int limiteRandomico = n > 100 ? n / 2 : n;
        for (int i = 0; i < n; i++) {
            listaDeNumeros.inserirNoInicio(random.nextInt(limiteRandomico));
        }
        System.out.println("Lista com " + n + " elementos aleatórios criada.");
// Para N grande, a exibição da lista é omitida para não poluir o console.
        if (n <= 20) {
            System.out.print("Lista original: ");
            listaDeNumeros.exibir();
        }
        // 2. Medição de tempo da operação O(n^2)
        System.out.println("\nIniciando a operação O(n^2) de remover duplicatas...");
        long tempoInicial = System.nanoTime();
        listaDeNumeros.removerDuplicatasSimples();
        long tempoFinal = System.nanoTime();
        long duracaoEmNano = tempoFinal - tempoInicial;
// Convertendo para milissegundos para melhor legibilidade
        double duracaoEmMs = duracaoEmNano / 1_000_000.0;
        System.out.printf("Operação concluída em: %.4f milissegundos.\n", duracaoEmMs);
        if (n <= 20) {
            System.out.print("Lista processada: ");
            listaDeNumeros.exibir();
        }
        scanner.close();
        // --- Teste O(1): remover do início ---
        if (n > 0) {
            System.out.println("\nRemovendo do início (O(1))...");
            long t0 = System.nanoTime();
            listaDeNumeros.removerDoInicio(); // O(1)
            long t1 = System.nanoTime();
            double duracaoUs = (t1 - t0) / 1_000.0; // micros
            System.out.printf("Remoção do início levou: %.3f microssegundos.\n", duracaoUs);

            if (n <= 20) {
                System.out.print("Após remover do início: ");
                listaDeNumeros.exibir();
            }
        } else {
            System.out.println("\nN = 0: lista vazia, nada para remover do início.");
        }
        try {
            int valor = listaDeNumeros.obterEm(2);
            System.out.println("Elemento na posição 2: " + valor);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        // --- Teste O(n): remover um valor específico ---
        if (n > 0) {
            int valorParaRemover = listaDeNumeros.inicio.dado;
            System.out.println("\nRemovendo valor " + valorParaRemover + " (O(n))...");
            listaDeNumeros.removerValor(valorParaRemover);
            if (n <= 20) {
                System.out.print("Após remover o valor " + valorParaRemover + ": ");
                listaDeNumeros.exibir();
            }
        }
        System.out.println("\nInserindo no fim...");
        listaDeNumeros.inserirNoFim(999);
        if (n <= 20) {
            System.out.print("Após inserir 999 no fim: ");
            listaDeNumeros.exibir();
        }
        System.out.println("\nTamanho da lista: " + listaDeNumeros.tamanho());

    }
}