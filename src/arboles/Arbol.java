package arboles;

public class Arbol {

    private Nodo raiz;
    int resultado = 0;
    int nivelactual = 0;
    int nivelarbol;

    public void insertar(int x) { //primer paso para insertar en el arbol
        if (raiz == null) { //si no hay elementos en el arbol, se crea la raiz 
            raiz = new Nodo(x);
        } else {
            insertarRecursivo(raiz, x);
        }
    }

    private void insertarRecursivo(Nodo n, int x) {
        if (x < n.getId()) { // esta validacion es para saber si debemos insertar a la izquierda
            if (n.getHijoizq() == null) { // validamos si el hijo izquierdo tiene algo, si no hay, lo creamos
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

    public void inorden() { //imprimir el arbol en inorden
        if (raiz != null) {
            inordenRecursivo(raiz);
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private void inordenRecursivo(Nodo n) { //metodo recursivo para mostrar arbol inorden
        if (n != null) {
            inordenRecursivo(n.getHijoizq());
            System.out.print(n.getId() + ", ");
            inordenRecursivo(n.getHijoder());
        }
    }

    public void preorden() { //imprimir el arbol en preorden
        if (raiz != null) {
            preordenRecursivo(raiz);
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private void preordenRecursivo(Nodo n) { //metodo recursivo para mostrar arbol preorden
        if (n != null) {
            System.out.print(n.getId() + ", ");
            inordenRecursivo(n.getHijoizq());
            inordenRecursivo(n.getHijoder());
        }
    }

    public void posorden() { //imprimir el arbol en posorden
        if (raiz != null) {
            posordenrecursivo(raiz);
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private void posordenrecursivo(Nodo n) { //metodo recursivo para mostrar arbol posorden
        if (n != null) {
            posordenrecursivo(n.getHijoizq());
            posordenrecursivo(n.getHijoder());
            System.out.print(n.getId() + ", ");
        }
    }

    //imprimir menor numero en el arbol
    public void imprimeMenor() {
        if (raiz != null) {
            System.out.println("El numero menor en el arbol es: " + imprimeMenorRecursivo(raiz));
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private int imprimeMenorRecursivo(Nodo n) {

        if (resultado == 0) {
            resultado = n.getId();
        }

        if (n != null) {
            imprimeMenorRecursivo(n.getHijoizq());
            imprimeMenorRecursivo(n.getHijoder());

            if (n.getId() < resultado) {
                resultado = n.getId();
            }
        }

        return resultado;

    }

    //imprimir hojas (los nodos que no tengan hijos
    public void mostrarhojas() {
        if (raiz != null) {
            mostrarHojasRecursivo(raiz);
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private void mostrarHojasRecursivo(Nodo n) {

        if (n != null) {

            if (n.getHijoder() == null && n.getHijoizq() == null) {
                System.out.println(n.getId());
            } else {
                mostrarHojasRecursivo(n.getHijoder());
                mostrarHojasRecursivo(n.getHijoizq());
            }
        }
    }

    //imprimir nivel n del arbol
    public void buscarnivel(int nivelrequerido) {
        System.out.println("Datos del nivel: " + nivelrequerido);
        if (raiz != null) {
            buscarnivelrecursivo(raiz, nivelactual, nivelrequerido);
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }

    private void buscarnivelrecursivo(Nodo n, int nivelactual, int nivelrequerido) {

        if (n != null) {
            if (nivelrequerido == nivelactual) {
                System.out.println(n.getId());
            } else {
                buscarnivelrecursivo(n.getHijoizq(), nivelactual + 1, nivelrequerido);
                buscarnivelrecursivo(n.getHijoder(), nivelactual + 1, nivelrequerido);
            }
        }

    }

    // imprimir altura del arbol 
    public int cantidadniveles(){
        return cantidadnivelesrecursivo(raiz);
    }
    
    private int cantidadnivelesrecursivo(Nodo n){
        if (n == null){
            return 0;
        } else {
            int alturaizq = cantidadnivelesrecursivo(n.getHijoizq());
            int alturader = cantidadnivelesrecursivo(n.getHijoder());
            
            if (alturaizq > alturader){
                return alturaizq + 1;
            } else {
                return alturader + 1;
            }
        }
    }
    
    /*
    public void mostrarnivelarbol() {
        if (raiz != null) {
            System.out.println("El nivel actual del arbol es: " + mostrarnivelarbolrecursivo(raiz));
        } else {
            System.out.println("No hay nada en la raiz, el arbol está vacío");
        }
    }
    int alturaizq;
    int alturader;
    
    private int mostrarnivelarbolrecursivo(Nodo n) {

        if (n != null) {
            alturaizq += mostrarnivelarbolrecursivo(n.getHijoizq());
            alturader += mostrarnivelarbolrecursivo(n.getHijoder());

            if(alturaizq > alturader){
                nivelarbol = alturaizq + 1;
            } else {
                if(alturader > alturaizq){
                    nivelarbol = alturader + 1;
                }
            }
  
        }
        
        return nivelarbol;
        
    }*/

}
