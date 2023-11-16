package arboles;

public class Arbol {
    
    private Nodo raiz;
    
    public void insertar(int x){ //primer paso para insertar en el arbol
        if (raiz == null){ //si no hay elementos en el arbol, se crea la raiz 
            raiz = new Nodo(x);
        } else {
            insertarRecursivo(raiz, x);
        }
    }
    
    public void insertarRecursivo(Nodo n, int x){
        if (x<n.getId()){ // esta validacion es para saber si debemos insertar a la izquierda
            if (n.getHijoizq() == null){ // validamos si el hijo izquierdo tiene algo, si no hay, lo creamos
                n.setHijoizq(new Nodo(x)); //se crea el hijo izquierdo
            } else {
                insertarRecursivo(n.getHijoizq(), x);
            }
        } else { //entonces vamos a insertar al lado derecho
            if (n.getHijoder() == null) { //validamos si el hijo derecho tiene algo, si no hay, lo creamos
                n.setHijoder(new Nodo(x)); //se crea el hijo derecho
            } else { // si el hijo derecho tiene algo, llamamos recursivamente hasta encontrar que no haya nada 
                insertarRecursivo(n.getHijoder(), x);   
            }
        }
    }
    
}
