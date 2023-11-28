import java.util.List;

public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        Naive metodoNeive = new Naive();

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(5, 0);
        
        grafo.imprimirListaAdjacencia();

        metodoNeive.testConectividade(grafo);

        List<int[]> pontes = Tarjan.encontrarPontes(grafo);

        System.out.println("Pontes no grafo:");
        for (int[] ponte : pontes) {
            System.out.println(ponte[0] + " - " + ponte[1]);
        }
    }
}
