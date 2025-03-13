package me.itsth3k1ll3r.Xelior.Database;
import me.itsth3k1ll3r.Xelior.Loggers.Logger;

import java.io.File;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Database {
    private static Logger logger = new Logger();
    public static void check(String dbname) {
        String dbPath = Paths.get("src/main/resources/db", dbname).toAbsolutePath().toString();
        var url ="jdbc:sqlite:"+dbPath;
        File dbFile = new File(dbPath);
        if(dbFile.exists() && dbFile.isFile()) {
            try (var conn = DriverManager.getConnection(url)) {
                logger.success("Database found: " + dbname);
            } catch(Exception e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.error("No database called " + dbname + " was found.");
        }

    }

    public void table_check(String dbName, String tableName) {
        String dbPath = Paths.get("src/main/resources/db", dbName).toAbsolutePath().toString();
        var url ="jdbc:sqlite:"+dbPath;

        var query = "SELECT * FROM " + tableName + ";";

        try(var conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.executeQuery();

            logger.success("Table " + tableName + " exists!");

        } catch(SQLException e) {
            logger.error("Uh oh! Error incoming...");
            e.printStackTrace();
        }

    }
    public void feeder(String stmt, String dbName, String tableName) {
        String dbPath = Paths.get("src/main/resources/db", dbName).toAbsolutePath().toString();
        var url ="jdbc:sqlite:"+dbPath;

        String q = "SELECT COUNT(*) AS total FROM " + tableName + " WHERE ";
        StringTokenizer st = new StringTokenizer(stmt, " ");
        while(st.hasMoreTokens()) {
            q = q + st.nextToken() + " AND ";
        }
        q = q.substring(0, q.length()-4);
        //logger.info(q);

        try (var conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(q)) {
            ResultSet rs = pstmt.executeQuery();

            logger.result("There are " + rs.getInt("total") + " elements.");

        } catch(SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
