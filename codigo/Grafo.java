import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    // grafo em si
    private int numVertices;
    private List<LinkedList<Integer>> listaAdjacencia;

    //
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdjacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            listaAdjacencia.add(new LinkedList<>());
        }
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < numVertices && destino >= 0 && destino < numVertices) {
            listaAdjacencia.get(origem).add(destino);
        } else {
            throw new IllegalArgumentException("Vertices fora do intervalo valido.");
        }
    }

    public List<LinkedList<Integer>> getListaAdjacencia() {
        return listaAdjacencia;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void imprimirListaAdjacencia() {
        System.out.println("Lista de Adjacência do Grafo:");

        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int vizinho : listaAdjacencia.get(i)) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }
}