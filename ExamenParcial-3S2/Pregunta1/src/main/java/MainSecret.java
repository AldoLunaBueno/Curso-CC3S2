import java.util.function.Function;

public class MainSecret {
    public static void main(String[] args) {
        Secret1 secret1 = new Secret1();
        // Usando la clase Secret1
        System.out.println(secret1.magic(2.1));

        // Usando una expresión lambda en su lugar
        Function<Double, String> poof = d -> "Poof";
        System.out.println(poof.apply(2.1));
    }
}

interface Secret {
    String magic(double d);
}
class Secret1 implements Secret {
    public String magic(double d) {
        return "Poof";
    }
}

