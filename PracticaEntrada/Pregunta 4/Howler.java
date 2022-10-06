// Pregunta 4

public class Howler {
    public Howler(long shadow){
        // No hace falta agregar nada aquí para que el código compile.
    }
    private Howler(int moon) {
        super();
    }
    // Agregamos esta función para demostrar que funciona
    public static void main(String[] args) {
        Wolf w = new Wolf("a");
        Howler h = new Howler(2L);
    }
}
class Wolf extends Howler {
     protected Wolf(String stars) {
        super(2L);
     }
     public Wolf() {
         // Se agregó una llamada al constructor de la superclase
         // cuyo parámetro es de tipo long para evitar que llame
         // al constructor por defecto, pues esto ya no es posible.
         super(2L);
     }
 }