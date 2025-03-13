package me.itsth3k1ll3r.Xelior.Loggers;
import me.itsth3k1ll3r.Xelior.Loggers.Colors;
public class Logger {

    private Colors colors = new Colors();
    private String tag = "Xelior >> ";

    public void warn(String msg) {
        System.out.println(colors.YELLOW + tag + msg + colors.RESET);
    }
    public void info(String msg) {
        System.out.println(colors.BLUE + tag + msg + colors.RESET);
    }
    public void error(String msg) {
        System.out.println(colors.RED + tag + msg + colors.RESET);
    }
    public void success(String msg) {
        System.out.println(colors.GREEN + tag + msg + colors.RESET);
    }
    public void result(String msg) {
        System.out.println(colors.CYAN + tag + msg + colors.RESET);
    }
    public void welcome(String msg) {
        System.out.println(colors.PURPLE + tag + msg + colors.RESET);
    }
}
