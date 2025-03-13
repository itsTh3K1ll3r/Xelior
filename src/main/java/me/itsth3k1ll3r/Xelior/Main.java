package me.itsth3k1ll3r.Xelior;
import me.itsth3k1ll3r.Xelior.Calculus.Calculus;
import me.itsth3k1ll3r.Xelior.Loggers.Logger;
import me.itsth3k1ll3r.Xelior.Database.Database;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static Logger logger = new Logger();
    public static void main(String[] args) {
        Database db = new Database();
        db.check("oes2025.db");
        db.table_check("oes2025.db", "OES2025_DATASET");

        logger.welcome("Welcome to Xelior!");
        logger.info("Please type a statement below");

        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("STOP")) {
                logger.info("Shutting down Xelior!");
                break;
            }
            if(input.equalsIgnoreCase("NOSQL")) {
                Calculus calc = new Calculus();
                logger.info("Quitting SQL querying.");
                logger.welcome("Entering calculus mode.");
                logger.warn("In order to exit calculus mode, type QUITCALC");
                while(true) {
                    String input2 = scanner.nextLine();
                    if(input2.equalsIgnoreCase("QUITCALC")) {
                        logger.info("Exiting calculus mode!");
                        logger.welcome("Welcome to Xelior!");
                        logger.info("Please type a statement below");
                        break;
                    }
                    StringTokenizer st = new StringTokenizer(input2, " ");
                    Integer a=69,b=69;
                    while(st.hasMoreTokens()) {
                        if(a != 69 && b!=69) break;
                        if(a==69) a = Integer.valueOf(st.nextToken());
                        else b = Integer.valueOf(st.nextToken());
                    }
                    calc.calc(a,b);

                }
            }
            else {
                db.feeder(input, "oes2025.db", "OES2025_DATASET");
            }

        }
    }
}