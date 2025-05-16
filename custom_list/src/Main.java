public class Main {
    public static void main(String[] args) {
        CustomList <Integer> lista = new CustomList<>();
        System.out.println("size "+ lista.size());
        lista.addLast(4);
        lista.addLast(1);
        lista.addLast(9);
        lista.addFirst(7);

//        System.out.println("size "+ lista.size());
//        System.out.println(lista.getFirst() +" "+ lista.getLast());
//        System.out.println(lista.removeFirst());
//        System.out.println(lista.getFirst() +" "+ lista.getLast());
//        System.out.println(lista.removeLast());
//        System.out.println(lista.getFirst() +" "+ lista.getLast());

        //NIEOPTYMALNE!!!!!!!!!
        for(int i = 0 ; i < lista.size() ; i++){
            System.out.println(lista.get(i));
        }
    }
}
