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
            listaAdjacencia.get(destino).add(origem);
        } else {
            throw new IllegalArgumentException("Vertices fora do intervalo valido.");
        }
    }

    public List<LinkedList<Integer>> getListaAdjacencia() {
        return listaAdjacencia;
    }
    public LinkedList<Integer> getAdjacentes(int index) {
        return this.listaAdjacencia.get(index);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getGrau(int v){
        return listaAdjacencia.get(v).size();
    }

    public boolean verificarEureliano(){
        for(int i=0;i<numVertices;i++){
            if(getGrau(i)%2 !=0){
                return false;
            }
        }      return true;

    }

    public boolean verificarSemiAureliano(){
        int aux=0;
        for (int i =0; i<numVertices;i++){
            if(getGrau(i)%2!=0){
                aux++;
            }
        }
        return aux ==2;
    }

    public boolean verificarNaoAureliano(){
        for(int i = 0;i<numVertices;i++){
            if(getGrau(i)%2!=0){
                return true;
            }
        }
    return false;
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