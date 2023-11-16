package arboles;

public class Arboles {

    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Hello World");

        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(20);
        arbol.insertar(80);
        arbol.insertar(15);
        arbol.insertar(30);
        arbol.insertar(60);
        arbol.insertar(40);
        arbol.insertar(90);
        arbol.insertar(75);
        arbol.insertar(33);
        arbol.insertar(82);
        arbol.insertar(5);
        
        
        System.out.println("Recorriendo arbol inorden");
        arbol.inorden();

        System.out.println("\nRecorriendo arbol preorden");
        arbol.preorden();

        System.out.println("\nRecorriendo arbol posorden");
        arbol.posorden();

        System.out.println("\nBuscando el menor valor dentro del arbol");
        arbol.imprimeMenor();
        
        
        System.out.println("\nBuscando solamente las hojas");
        arbol.mostrarhojas();
            
        
        System.out.println("\nBuscando los datos del nivel n");
        arbol.buscarnivel(2);
        
        
        System.out.println("\nMostrando la cantidad de niveles del arbol");
        System.out.println("Cantidad niveles del arbol: " + arbol.cantidadniveles());
        
    }

}
