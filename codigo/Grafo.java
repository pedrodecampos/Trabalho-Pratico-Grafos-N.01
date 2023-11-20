import java.util.ArrayList;
import java.util.List;


public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        arestas.add(new Aresta(origem, destino));
        arestas.add(new Aresta(destino, origem)); // Não direcionado, adicionamos a aresta no sentido contrário também
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }


}