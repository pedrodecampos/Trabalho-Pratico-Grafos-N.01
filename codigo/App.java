import java.util.Scanner;
import java.util.Calendar;

public class App {
    public static void main(String[] args) {
        Gerador gerador = new Gerador();
        Grafo grafo;
        Scanner scanner = new Scanner(System.in);
        int escolha;
        
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Totalmente Aleatorio");
            System.out.println("2. Euleriano");
            System.out.println("3. SemiEulerinao");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            int vert;
            switch (escolha) {
                case 1:
                    System.out.println("Qual o numeros de vertices o grafo deve ter?");
                    vert = scanner.nextInt();
                    System.out.println("Qual o numeros de arestas o grafo deve ter?");
                    int aresta = scanner.nextInt();
                    try {
                        grafo = gerador.aleatorioSimples(vert, aresta);
                        menuFleury(scanner, grafo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Qual o numeros de vertices o grafo deve ter?");
                    vert = scanner.nextInt();
                    grafo = gerador.eulerianoAleatorio(vert);
                    menuFleury(scanner, grafo);
                    break;
                case 3:
                    System.out.println("Qual o numeros de vertices o grafo deve ter?");
                    vert = scanner.nextInt();
                    grafo = gerador.semieulerianoSimples(vert);
                    menuFleury(scanner, grafo);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);

        scanner.close();
    }


    public static void menuFleury(Scanner scanner, Grafo grafo){
        long tempoInic;
        long tempoFim;
        int escolha;
    do {
    System.out.println("=== Fleury ===");
            System.out.println("1. Com Naive");
            System.out.println("2. Com Tarjan");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                System.out.println(grafo.verificarEureliano());
                    Fleury fleury = new Fleury(grafo);
                    tempoInic = Calendar.getInstance().getTimeInMillis();
                    fleury.encontrarCaminhoEuleriano();
                    tempoFim = Calendar.getInstance().getTimeInMillis();
                    System.out.println("Tempo incio em milisegundos: "+tempoInic);
                    System.out.println("Tempo fim em milisegundos: "+tempoFim);
                    System.out.println("Tempo de execucao em milisegundos: "+(tempoFim-tempoInic)+"\n");
                    return;
                case 2:
                    System.out.println("Ainda nao implementado");
                    break;
                case 0:
                    System.out.println("Voltando!\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);
    }
}

