import java.util.Locale;
import logging.AssignmentLogger;
public class Main {
    public static void main(String[] args) {
        AssignmentLogger.logStaticMethodEntry();

        // Set default language (English)
        Locale defaultLocale = new Locale("en", "IE");
        new CoffeeMachine(defaultLocale);

        AssignmentLogger.logStaticMethodExit();
    }
}
