import java.sql.*;
import java.util.ArrayList;

public class MySQLHandler {
    private Connection connection;

    public MySQLHandler() {
        try {
            // Set up connection to database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBName +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Scene> readScenes() {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "select * from story";
            ResultSet resultSet = stmt.executeQuery(SQLQuery);
            ArrayList<Scene> scenes = new ArrayList<>();

            while (resultSet.next()) {
                Scene scene = new Scene(resultSet.getInt("id"), resultSet.getString("body"));
                scenes.add(scene);
            }
            return scenes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<Link> readLinks() {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "select * from links";
            ResultSet resultSet = stmt.executeQuery(SQLQuery);
            ArrayList<Link> links = new ArrayList<>();

            while (resultSet.next()) {
                Link link = new Link(resultSet.getInt("id"), resultSet.getInt("story_id"), resultSet.getInt(
                        "target_id"), resultSet.getString("description"));
                links.add(link);
            }
            return links;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}