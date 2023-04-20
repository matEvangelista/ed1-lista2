package classes;

import java.util.Vector;

public class GenericQueue<T> {
    protected int size; // número máximo de elementos da fila
    protected int n; // número de elementos
    protected int ini; // posição do primeiro elemento da fila
    public Vector<T> vector; // vetor com os elementos


    // construtor
    public GenericQueue(int size) {
        this.size = size;
        vector = new Vector<T>(size);
        ini = 0;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == size;
    }

    public T remove() {
        T element = null; // se não der para remover, retorna null
        // não vou passar por referência porque não funciona com classes do tipo final, e.g., Integer, Character
        if (!isEmpty()) {
            element = vector.get(ini);
            ini = (ini + 1) % size; // a fila anda, mas seus elementos não
            n--;
        }

        return element;
    }

    public boolean insert(T element) {
        int end;
        if (!isFull()) {
            end = (ini + n) % size;
            vector.add(end, element);
            n++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String string = "";
        GenericQueue<T> auxQueue = new GenericQueue<T>(size);
        while (!isEmpty()) {
            T temp = remove();
            string += temp.toString() + (n == 0 ? "." : ",\n"); // assumindo, é claro, que T terá toString() definido
            auxQueue.insert(temp);
        }
        while (!auxQueue.isEmpty()) {
            insert(auxQueue.remove());
        }
        return string;
    }

    public int getN() {
        return n;
    }
}
