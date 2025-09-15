import java.util.ArrayList;

public class SetADT <T>{
    public ArrayList<T> data;

    public SetADT() {
        data = new ArrayList<>();
    }

    public int longitud(){
        return data.size();
    }

    public void agregar(T elemento){
        if(!this.contiene(elemento)){
            data.add(elemento);
        }
    }
    public boolean contiene(T elemento){
        return data.contains(elemento);
    }

    public void eliminar(T elemento){
        data.remove(elemento);
    }

    public String toString(){
        String resultado= "";
        for (T t: data){
            resultado += "," + t.toString();
        }
        return resultado;
    }

    public boolean equals(SetADT<T> conjuntoN) {
        if (this.longitud() != conjuntoN.longitud()) {
            return false;
        }  //esto es para ver que ambos conjuntos sean de la misma longitud, porque si no lo son, nos evitamos problemas t arrojamos false.
        for (T elemento : this.data) {
            if (conjuntoN.contiene(elemento)) {
                return true;
            } //recorre los elementos en ambos conjuntos y si contiene los mismos da true.
        }
        return false;
    }

    public boolean esSubConjunto(SetADT<T> conjuntoN) {
        for (T elemento : this.data) {
            if (!conjuntoN.contiene(elemento)) {
                return false;
        }
    } //básicamente lo mismo que en equals, solo no se hace la validación de la longitud
        return true; 
    }

    public SetADT<T> union(SetADT<T> otroConjunto) {
    SetADT<T> conjuntoUnion = new SetADT<>();
        for (T elemento : this.data) {
        conjuntoUnion.agregar(elemento);
    }
        for (T elemento : otroConjunto.data) {
        conjuntoUnion.agregar(elemento);
    } //solo agregamos todos los elementos de cada conjunto en el conjunto union, que es el nuevo
    
        return conjuntoUnion;
    }

    public SetADT<T> interseccion(SetADT<T> otroConjunto) {
    SetADT<T> conjuntoInterseccion = new SetADT<>();
        for (T elemento : this.data) {
        if (otroConjunto.contiene(elemento)) {
            conjuntoInterseccion.agregar(elemento);
        }
    }  //usamos lo que ya tenemos, si el otro conjunto contiene lo de este conjunto, se agrega al conjunto interseccion.
        return conjuntoInterseccion;
    }

    public SetADT<T> diferencia(SetADT<T> otroConjunto) {
    SetADT<T> conjuntoDiferencia = new SetADT<>();
    
    for (T elemento : this.data) {
        if (!otroConjunto.contiene(elemento)) {  //es lo mismo que intersección, pero agregamos lo que NO contienen ambos
            conjuntoDiferencia.agregar(elemento);
        }
    }
    return conjuntoDiferencia;
}
}
