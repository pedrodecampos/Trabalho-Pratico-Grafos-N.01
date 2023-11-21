import java.util.LinkedList;
import java.util.Queue;

public class Naive {

    public void testConectividade(Grafo grafo) {
        System.out.println("Testando a conectividade apos a remoca de cada aresta");
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (int aux : grafo.getListaAdjacencia().get(i)) {
                // Remover aresta (i, aux)
                grafo.getListaAdjacencia().get(i).remove(Integer.valueOf(aux));
                // Verificar se é conexo
                boolean conexo = conectividade(grafo);
                System.out.println("Removendo aresta: " + i + "," + aux + "Grafo conectado: " + conexo);
                grafo.getListaAdjacencia().get(i).add(aux);
            }
        }

    }

    public boolean conectividade(Grafo grafo) {
        Queue<Integer> fila = new LinkedList<>();
        boolean[] visitados = new boolean[grafo.getNumVertices()];

        fila.add(0); // Começar a busca a partir do primeiro vértice
        visitados[0] = true;

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();

            for (int vizinho : grafo.getListaAdjacencia().get(verticeAtual)) {
                if (!visitados[vizinho]) {
                    visitados[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }

        // Verificar se todos os vértices foram visitados
        for (boolean visitado : visitados) {
            if (!visitado) {
                return false;
            }
        }

        return true;
    }
}
