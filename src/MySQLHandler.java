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

    public int getSceneId(String s) {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "SELECT id FROM story WHERE body = '" + s + "'";
            ResultSet resultSet = stmt.executeQuery(SQLQuery);
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public Scene addScene(String s) {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "INSERT INTO story(body) VALUES ('" + s + "')";
            stmt.execute(SQLQuery);
            return new Scene(getSceneId(s), s);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Scene(-1, "");
        }
    }

    public Link addLink(int sourceId, int targetId, String desc) {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery =
                    "INSERT INTO links(story_id, target_id, description) VALUES ('"+ sourceId +"','" + targetId + "','" + desc +
                            "')";
            stmt.execute(SQLQuery);
            return new Link(sourceId, targetId, desc);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Link(-1, -1, "");
        }
    }

    public void removeLink(int sourceId, int targetId, String desc) {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "DELETE FROM `solo-adventure`.`links` WHERE (story_id = '" + sourceId + "' AND " +
                    "target_id = '" + targetId + "' AND description = '" + desc + "');";
            stmt.execute(SQLQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeScene(int id) {
        try {
            Statement stmt = connection.createStatement();
            String SQLQuery = "DELETE FROM `solo-adventure`.`story` WHERE (id = '" + id + "')";
            stmt.execute(SQLQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}