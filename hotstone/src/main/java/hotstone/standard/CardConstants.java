package hotstone.standard;
import java.util.*;

public class CardConstants {
    // Initialize card information
    public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    public static final List<Object> dos = Arrays.asList("Dos", 2, 2, 2);
    public static final List<Object> tres = Arrays.asList("Tres", 3, 3, 3);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);
    // public static final List<Object> uno = Arrays.asList("Uno", 1, 1, 1);

    // Construct list of card information
    public static final List<List<Object>> allCards = Arrays.asList(uno, dos, tres);

    // Return card info
    public List<Object> getCardInfo(int i) {
        return allCards.get(i - 1);
    }
}
