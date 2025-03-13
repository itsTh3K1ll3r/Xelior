package me.itsth3k1ll3r.Xelior.Calculus;

import me.itsth3k1ll3r.Xelior.Loggers.Logger;

public class Calculus {

    private static Logger logger = new Logger();

    public void calc(Integer a, Integer b) {
        // a = smaller result, b = big result
        Double result = (double) ((a*100) / b);
        logger.result("The result is " + result + "%");
    }
}
