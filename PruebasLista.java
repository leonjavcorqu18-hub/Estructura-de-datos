public class PruebasLista {
    public static void main(String[] args) {
    ListaLigada<Integer> lista = new ListaLigada<>();
    System.out.println("La lista esta vacia? " + lista.estaVacia());
    lista.agregar(32);
    lista.agregar(25);
    lista.agregar(97);
    lista.agregar(11);
    System.out.println("La lista esta vacia? " + lista.estaVacia());
    System.out.println("tamanio: " + lista.getTamanio());
    System.out.println("contiene: ");
    lista.trasversal();
    System.out.println("--Agregamos al inicio, al final y despues de 32--");
    lista.agregarAlInicio(44);
    lista.agregarAlFinal(100);
    lista.agregar_despues_de(32, 1);
    lista.trasversal();
    System.out.println("--actualizamos 97 con 1500--");
    lista.actualizar(97, 1500);
    lista.trasversal();
    System.out.println("tamanio: " + lista.tamanio);
    lista.eliminar(2);
    System.out.println("--eliminamos 1--");
    lista.trasversal();
    System.out.println("--eliminamos le primero y el ultimo--");
    lista.eliminarElFinal();
    lista.eliminarElPrimero();
    lista.trasversal();
    System.out.println("tamanio: " + lista.tamanio);
    }
}
