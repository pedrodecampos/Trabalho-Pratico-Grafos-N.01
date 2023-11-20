public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);

        grafo.adicionarVertice(v1);
        grafo.adicionarVertice(v2);
        grafo.adicionarVertice(v3);
        grafo.adicionarVertice(v4);

        grafo.adicionarAresta(v1, v2);
        grafo.adicionarAresta(v2, v3);
        grafo.adicionarAresta(v3, v4);
        grafo.adicionarAresta(v4, v1);

    }
}
