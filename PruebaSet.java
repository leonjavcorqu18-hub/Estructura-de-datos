public class PruebaSet {
    public static void main(String[] args) {
        SetADT<Integer> conjunto = new SetADT<>();
        conjunto.agregar(15);
        conjunto.agregar(2);
        conjunto.agregar(2);
        conjunto.agregar(2);
        conjunto.agregar(23);
        conjunto.agregar(29);
        conjunto.agregar(22);
        conjunto.agregar(22);
        conjunto.agregar(11);
        conjunto.agregar(11);
        conjunto.agregar(22);
        System.out.println(conjunto);

        SetADT<Integer> segundoConjunto = new SetADT<>();
        segundoConjunto.agregar(2);
        segundoConjunto.agregar(2);
        segundoConjunto.agregar(92);
        segundoConjunto.agregar(2);
        segundoConjunto.agregar(23);
        segundoConjunto.agregar(23);
        segundoConjunto.agregar(22);
        segundoConjunto.agregar(22);
        segundoConjunto.agregar(16);
        segundoConjunto.agregar(11);
        segundoConjunto.agregar(22);
        segundoConjunto.agregar(24);
        System.out.println(segundoConjunto);

        System.out.println("los dos conjuntos, ¿Son iguales? (longitud) " + conjunto.equals(segundoConjunto));
        System.out.println("¿el conjunto 1 es subconjunto del conjunto 2? " + conjunto.esSubConjunto(segundoConjunto));

        SetADT<Integer> conjuntoUnion = conjunto.union(segundoConjunto);
        System.out.println("el conjunto union de C1 y C2 sería: " + conjuntoUnion);

        SetADT<Integer> interseccion = conjunto.interseccion(segundoConjunto);
        System.out.println("Intersección: " + interseccion);

        SetADT<Integer> diferencia = conjunto.diferencia(segundoConjunto);
        System.out.println("Diferencia: " + diferencia);
    }
}