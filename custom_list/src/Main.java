public class Main {
    public static void main(String[] args) {
        CustomList <Integer> lista = new CustomList<>();
        lista.addLast(4);
        lista.addLast(1);
        lista.addLast(9);
        lista.addFirst(7);
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.removeFirst());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.removeLast());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
    }
}
