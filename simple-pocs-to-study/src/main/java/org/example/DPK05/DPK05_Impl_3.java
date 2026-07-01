import java.util.Arrays;
import java.util.Comparator;

public class DPK05_Impl_3 {

    enum Beatle {
        JOHN("John", 100),
        PAUL("Paul", 90),
        GEORGE("George", 80),
        RINGO("Ringo", 70);

        private final String displayName;
        private final int power;

        Beatle(String displayName, int power) {
            this.displayName = displayName;
            this.power = power;
        }

        public String getDisplayName() {
            return displayName;
        }

        public int getPower() {
            return power;
        }

        public static Beatle fromName(String name) {
            for (Beatle beatle : values()) {
                if (beatle.displayName.equalsIgnoreCase(name)) {
                    return beatle;
                }
            }
            return null;
        }
    }

    public static String getMostPowerful(String name1, String name2) {
        Beatle b1 = Beatle.fromName(name1);
        Beatle b2 = Beatle.fromName(name2);

        if (b1 == null || b2 == null) {
            return "Invalid name";
        }

        if (b1.getPower() > b2.getPower()) {
            return b1.getDisplayName();
        } else if (b2.getPower() > b1.getPower()) {
            return b2.getDisplayName();
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        System.out.println(getMostPowerful("John", "Paul")); // John
    }
}
