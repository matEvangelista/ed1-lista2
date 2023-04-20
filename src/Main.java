import classes.GenericQueue;

public class Main {
    public static void main(String[] args) {

        GenericQueue<String> genericQueue = new GenericQueue<>(5);
        genericQueue.insert("John Coltrane");
        genericQueue.insert("Miles Davis");
        genericQueue.insert("Ella Fitzgerald");
        genericQueue.insert("João Gilberto");
        genericQueue.insert("Wes Montgomety");

        System.out.println(genericQueue);

        System.out.println(genericQueue.remove());
        System.out.println(genericQueue);
    }
}