//codigo com base em codigo gerado pelo ChatGPT

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tarjan {
    public static List<int[]> encontrarPontes(Grafo grafo) {
        List<int[]> pontes = new ArrayList<>();
        int tempo = 0;

        // Arrays para armazenar o tempo de descoberta e os ancestrais dos vértices
        int[] descoberta = new int[grafo.getNumVertices()];
        int[] baixo = new int[grafo.getNumVertices()];
        int[] pai = new int[grafo.getNumVertices()];
        Arrays.fill(pai, -1);

        // Função auxiliar para encontrar pontes recursivamente
        encontrarPontesRecursivo(0, descoberta, baixo, pai, pontes, tempo, grafo);

        return pontes;
    }

    private static void encontrarPontesRecursivo(int u, int[] descoberta, int[] baixo, int[] pai,
     List<int[]> pontes, int tempo, Grafo grafo) {
        descoberta[u] = baixo[u] = ++tempo;

        for (int v : grafo.getListaAdjacencia().get(u)) {
            if (descoberta[v] == 0) {
                pai[v] = u;
                encontrarPontesRecursivo(v, descoberta, baixo, pai, pontes, tempo, grafo);

                baixo[u] = Math.min(baixo[u], baixo[v]);

                if (baixo[v] > descoberta[u]) {
                    pontes.add(new int[]{u, v});
                }
            } else if (v != pai[u]) {
                baixo[u] = Math.min(baixo[u], descoberta[v]);
            }
        }
    }
}
