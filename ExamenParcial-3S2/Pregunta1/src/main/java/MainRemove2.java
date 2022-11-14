import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainRemove2 {
    public static void main(String[] args) {
        MainRemove2 mainRemove2 = new MainRemove2();
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('a', 'z', '/'));
        mainRemove2.remove(chars);
        chars.forEach(System.out::println);
    }
    public void remove(List<Character> chars) {
        char end = 'z';
        // Insertar código
        System.out.println("No hay ningún problema con este código y hace lo que se espera de él");
        chars.removeIf(c -> {
            char start = 'a'; return start <= c && c <= end; });
    }
}
