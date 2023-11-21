public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        Naive metodoNeive = new Naive();

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 0);
        grafo.imprimirListaAdjacencia();

        metodoNeive.testConectividade(grafo);
    }
}
