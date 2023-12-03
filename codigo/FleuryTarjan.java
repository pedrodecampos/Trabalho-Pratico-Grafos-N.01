import java.util.ArrayList;
import java.util.List;

public class FleuryTarjan {

    private Grafo grafo;

    public FleuryTarjan(Grafo grafo) {
        this.grafo = grafo;
    }

    private boolean isPonte(int u, int v) {
        List<int[]> pontes = Tarjan.encontrarPontes(grafo);

        for (int[] ponte : pontes) {
            if ((ponte[0] == u && ponte[1] == v) || (ponte[0] == v && ponte[1] == u)) {
                return true; // A aresta (u, v) é uma ponte
            }
        }

        return false;
    }

    private boolean isArestaValida(int u, int v) {
        return grafo.getListaAdjacencia().get(u).size() != 0 && grafo.getListaAdjacencia().get(v).size() != 0;
    }

    private void removerAresta(int u, int v) {
        grafo.getListaAdjacencia().get(u).remove((Integer) v);
        grafo.getListaAdjacencia().get(v).remove((Integer) u);
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
            for (int neighbor : grafo.getListaAdjacencia().get(v)) {
                if (isArestaValida(v, neighbor) && !isPonte(v, neighbor)) {
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
            imprimirCaminhoEuleriano(startVertex);
        } else {
            System.out.println("Não existe caminho Euleriano para este grafo.");
        }
    }
}
