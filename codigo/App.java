import java.util.List;

public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        Naive metodoNeive = new Naive();
        Gerador gerador = new Gerador();

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(5, 4);
        grafo.imprimirListaAdjacencia();

        metodoNeive.testConectividade(grafo);

        List<int[]> pontes = Tarjan.encontrarPontes(grafo);

        System.out.println("Pontes no grafo:");
        for (int[] ponte : pontes) {
            System.out.println(ponte[0] + " - " + ponte[1]);
        }

        Fleury fleury = new Fleury(grafo);
        fleury.encontrarCaminhoEuleriano();

        Grafo aux;
        aux = gerador.eulerianoAleatorio(100);
        aux.imprimirListaAdjacencia();
        System.out.println(aux.verificarEureliano());
    }
}
