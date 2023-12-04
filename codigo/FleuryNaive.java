import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FleuryNaive {

    private Grafo grafo;

    public FleuryNaive(Grafo grafo) {
        this.grafo = grafo;
    }

    private boolean isArestaValida(int u, int v) {
        return grafo.getListaAdjacencia().get(u).size() != 0 && grafo.getListaAdjacencia().get(v).size() != 0;
    }

    private void removerAresta(int u, int v) {
        grafo.getListaAdjacencia().get(u).remove((Integer) v);
        grafo.getListaAdjacencia().get(v).remove((Integer) u);
    }

    private boolean verificarConectividade() {
        Naive naive = new Naive();

        // Fazemos uma cópia do grafo original para não modificar o estado durante o
        // loop
        Grafo copiaGrafo = new Grafo(grafo.getNumVertices());
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            copiaGrafo.getListaAdjacencia().add(new LinkedList<>(grafo.getListaAdjacencia().get(i)));
        }

        for (int i = 0; i < copiaGrafo.getNumVertices(); i++) {
            List<Integer> arestas = copiaGrafo.getListaAdjacencia().get(i);
            for (int neighbor : arestas) {
                if (i <= neighbor) {
                    // Remover aresta (i, neighbor)
                    copiaGrafo.getListaAdjacencia().get(i).remove((Integer) neighbor);
                    copiaGrafo.getListaAdjacencia().get(neighbor).remove((Integer) i);

                    // Verificar se é conexo
                    boolean conectado = naive.conectividade(copiaGrafo);

                    // Restaurar a aresta para não modificar o grafo original
                    copiaGrafo.getListaAdjacencia().get(i).add(neighbor);
                    copiaGrafo.getListaAdjacencia().get(neighbor).add(i);

                    if (!conectado) {
                        return false; // A aresta (i, neighbor) é uma ponte
                    }
                }
            }
        }
        return true;
    }

    private void imprimirCaminhoEuleriano(int inicio) {
        DFS(inicio);
        System.out.println();
    }

    private void DFS(int v) {
        System.out.print(v + " / ");

        List<Integer> vizinhos = new ArrayList<>(grafo.getListaAdjacencia().get(v));

        if (vizinhos.size() == 1) {
            int proxAresta = vizinhos.get(0);
            removerAresta(v, proxAresta);
            DFS(proxAresta);
        } else {
            for (int neighbor : vizinhos) {
                if (isArestaValida(v, neighbor)) {
                    removerAresta(v, neighbor);
                    DFS(neighbor);
                }
            }
        }
    }

    public void encontrarCaminhoEuleriano() {
        int oddDegreeCount = 0;
        int startVertex = 0;

        for (int i = 0; i < grafo.getListaAdjacencia().size(); i++) {
            if (grafo.getListaAdjacencia().get(i).size() % 2 != 0) {
                oddDegreeCount++;
                startVertex = i;
            }
        }

        if (oddDegreeCount == 0 || oddDegreeCount == 2) {
            if (verificarConectividade()) {
                imprimirCaminhoEuleriano(startVertex);
            } else {
                System.out.println("Não existe caminho Euleriano para este grafo.");
            }
        } else {
            System.out.println("Não existe caminho Euleriano para este grafo.");
        }
    }
}
