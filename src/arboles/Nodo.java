/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author Usuario
 */
public class Nodo {
    
    private int id; //referencia del arbol
    private Nodo hijoizq; //referencia a una rama
    private Nodo hijoder;// referencia a otra rama
    
    public Nodo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getHijoizq() {
        return hijoizq;
    }

    public void setHijoizq(Nodo hijoizq) {
        this.hijoizq = hijoizq;
    }

    public Nodo getHijoder() {
        return hijoder;
    }

    public void setHijoder(Nodo hijoder) {
        this.hijoder = hijoder;
    }
    
    
    
}
