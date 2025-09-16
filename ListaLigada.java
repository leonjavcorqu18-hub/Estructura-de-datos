public class ListaLigada<T> {
    Nodo<T> head;
    int tamanio = 0;
    Nodo<T> currNode;

    public ListaLigada() {
    }

    public boolean estaVacia(){
        return head == null;
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public void agregar(T valor){
        if (this.head == null){
            // head = nuevo
            this.head = new Nodo<>(valor);
            this.tamanio++;
        }else {
            // encontrar el iultimo y agregar en nuevo
            currNode = this.head;
            while (currNode.getSiguiente() != null){
                currNode = currNode.getSiguiente();
            }
            currNode.setSiguiente(new Nodo<>(valor));
            this.tamanio++;
        }
    }

    public int buscar(T valor){
        currNode = this.head;
        int contador = 0;
        while (currNode != null){
            if(currNode.getData() == valor){
                return contador;
            }
            contador++;
            currNode = currNode.getSiguiente();
        }
        return -1;
    }

    public boolean actualizar(T actual, T nuevo){
        currNode = this.head;
        while (currNode != null){
            if(currNode.getData() == actual){
                currNode.setData(nuevo);
                return true;
            }
            currNode = currNode.getSiguiente();
        }
        return false;
    }
    public void trasversal(){
        currNode = this.head;
        while (currNode != null){
            System.out.print(currNode);
            currNode = currNode.getSiguiente();
        }
        System.out.println();
    }

    public void agregarAlFinal(T valor) {
    if (this.head == null) {
        this.head = new Nodo<>(valor);
        this.tamanio++;
    } else {
        currNode = this.head;
        while (currNode.getSiguiente() != null) {
            currNode = currNode.getSiguiente();
        }
        currNode.setSiguiente(new Nodo<>(valor));
        this.tamanio++;
        }
    }

    public void agregarAlInicio(T valor) {
    if (this.head == null) {
        this.head = new Nodo<>(valor);
        this.tamanio++;
    } else {
        Nodo<T> nuevoNodo = new Nodo<>(valor, this.head);
        this.head = nuevoNodo;
        this.tamanio++;
        }
    }

    public boolean agregar_despues_de(T valor1, T valor) {
    if (this.head == null) {
        return false;
    }
    currNode = this.head;
    while (currNode != null) {
        if (currNode.getData() == valor1) {
            Nodo<T> nuevoNodo = new Nodo<>(valor, currNode.getSiguiente());
            currNode.setSiguiente(nuevoNodo);
            this.tamanio++;
            return true; 
        }
        currNode = currNode.getSiguiente();
    }  
        return false;
    }
    public void eliminar(int posicion) {
    Nodo<T> anterior = null;
    currNode = this.head;
    int contador = 0;   
    while (currNode != null) {
        if (contador == posicion) {
            if (anterior == null) {
                this.head = currNode.getSiguiente();
            } else {
                anterior.setSiguiente(currNode.getSiguiente());
            }
            this.tamanio--;
            return;
        }
        anterior = currNode;
        currNode = currNode.getSiguiente();
        contador++;
        }
    }
    public void eliminarElPrimero() {
    if (this.head != null) {
        this.head = this.head.getSiguiente();
        this.tamanio--;
    }
    }

    public void eliminarElFinal() {
    if (this.head == null) {
        return;
    }
    if (this.head.getSiguiente() == null) {
        this.head = null;
        this.tamanio--;
        return;
    }
    currNode = this.head;
    while (currNode.getSiguiente().getSiguiente() != null) {
        currNode = currNode.getSiguiente();
    }
    currNode.setSiguiente(null);
    this.tamanio--;
}
}  