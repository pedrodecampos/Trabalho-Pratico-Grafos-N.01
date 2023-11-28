import java.util.Random;

public class Gerador {
    public Random random = new Random();
    
    public Grafo aleatorioSimples(int nVertices, int nArestas){
        if (nArestas > nVertices * (nVertices - 1) / 2) {
            throw new IllegalArgumentException("Número de arestas excede o máximo permitido.");
        }
        Grafo novGrafo = new Grafo(nVertices);
        while (nArestas > 0) {
            int origem = random.nextInt(nVertices);
            int destino = random.nextInt(nVertices);

            if (origem != destino && !novGrafo.getListaAdjacencia().get(origem).contains(destino)) {
                novGrafo.adicionarAresta(origem, destino);
                nArestas--;
            }
        }
        return novGrafo;
    }
}
