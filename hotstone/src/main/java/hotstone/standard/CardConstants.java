package hotstone.standard;
import java.util.*;

public class CardConstants {
    public List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    public List<Object> dos = Arrays.asList("Dos", 2, 2, 2);
    public List<Object> tres = Arrays.asList("Tres", 3, 3, 3);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);

    public List<List<Object>> allCards = Arrays.asList(uno, dos, tres);

    public List<Object> getCardInfo(int i) {
        return allCards.get(i - 1);
    }
}
