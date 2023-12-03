import java.util.Random;
import java.util.LinkedList;


public class Gerador {
    public Random random = new Random();
    
    public Grafo aleatorioSimples(int nVertices, int nArestas) throws IllegalArgumentException{
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

    public Grafo eulerianoSimples(int nVertices){
        
        Grafo novGrafo = new Grafo(nVertices);
        for (int i = 0; i < nVertices - 1; i++) {
            novGrafo.adicionarAresta(i, i + 1);
        }

        novGrafo.adicionarAresta(nVertices - 1, 0);
        return novGrafo;
    }

    public Grafo eulerianoAleatorio(int numVertices) {
        Grafo novoGrafo = new Grafo(numVertices);
        
        for (int i = 0; i < numVertices; i++) {
            int grauAtual = novoGrafo.getAdjacentes(i).size();
            
            do{
                // Escolha aleatoriamente um vértice
                int verticeAleatorio = random.nextInt(numVertices);
                LinkedList<Integer> listaDest = novoGrafo.getAdjacentes(verticeAleatorio);
                if ((i != verticeAleatorio && !novoGrafo.getListaAdjacencia().get(i).contains(verticeAleatorio))
                && (listaDest.size() % 2 !=0 || listaDest.size() == 0)) {
                    // Adicione uma aresta entre os dois vértices
                    novoGrafo.adicionarAresta(i, verticeAleatorio);
                    grauAtual++;
                }
            } while (grauAtual % 2 != 0 || grauAtual == 0);
        
        }
        return novoGrafo;
    }
    
    public Grafo semieulerianoSimples(int nVertices){
        
        Grafo novGrafo = new Grafo(nVertices);
        for (int i = 0; i < nVertices - 1; i++) {
            novGrafo.adicionarAresta(i, i + 1);
        }
        return novGrafo;
    }
}
