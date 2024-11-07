package OnlineGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import OnlineGame.model.Game;

public class GameDao {
	
	private static final String INSERT_GAMES_SQL = "INSERT INTO games" +
            "  (gameName, Description, price, Genre, Platform, Publisher, Modes, userID) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_GAMES_BY_ID = "SELECT ID, gameName, Description, price, Genre, Platform, Publisher, Modes, userID FROM games WHERE ID = ?";
    private static final String SELECT_ALL_GAMES = "SELECT * FROM games";
    private static final String DELETE_GAMES_SQL = "DELETE FROM games WHERE ID = ?";
    private static final String UPDATE_GAMES_SQL = "UPDATE games SET gameName = ?, Description = ?, price = ?, Genre = ?, Platform = ?, Publisher = ?,Modes = ?,userID =? WHERE ID = ?";

    //insert
    public void insertGames(Game game) {
        System.out.println(INSERT_GAMES_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GAMES_SQL)) {
            preparedStatement.setString(1, game.getgameName());
            preparedStatement.setString(2, game.getDescription());
            preparedStatement.setString(3, game.getprice());
            preparedStatement.setString(4, game.getGenre());
            preparedStatement.setString(5, game.getPlatform());
            preparedStatement.setString(6, game.getPublisher());
            preparedStatement.setString(7, game.getModes());
            preparedStatement.setString(8, game.getuserID());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateGames(Game game) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_GAMES_SQL)) {
        	statement.setString(1, game.getgameName());
        	statement.setString(2, game.getDescription());
        	statement.setString(3, game.getprice());
        	statement.setString(4, game.getGenre());
        	statement.setString(5, game.getPlatform());
        	statement.setString(6, game.getPublisher());
            statement.setString(7, game.getModes());
            statement.setString(8, game.getuserID());
            statement.setInt(9, game.getID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Game selectGames(int ID) {
    	Game game = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GAMES_BY_ID)) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String gameName = rs.getString("gameName");
                String Description = rs.getString("Description");
                String price = rs.getString("price");
                String Genre = rs.getString("Genre");
                String Platform = rs.getString("Platform");
                String Publisher = rs.getString("Publisher");
                String Modes = rs.getString("Modes");
                String userID = rs.getString("userID");

                game = new Game(ID, gameName, Description, price, Genre, Platform, Publisher, Modes, userID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }

    //select all
    public List<Game> selectAllGames() {
        List<Game> games = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GAMES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String gameName = rs.getString("gameName");
                String Description = rs.getString("Description");
                String price = rs.getString("price");
                String Genre = rs.getString("Genre");
                String Platform = rs.getString("Platform");
                String Publisher = rs.getString("Publisher");
                String Modes = rs.getString("Modes");
                String userID = rs.getString("userID");

                games.add(new Game(ID, gameName, Description, price, Genre, Platform, Publisher, Modes, userID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    //delete
    public boolean deleteGame(int ID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_GAMES_SQL)) {
            statement.setInt(1, ID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public List<Game> selectGamesByUserID(String userID) throws SQLException {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games WHERE userID = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                String gameName = resultSet.getString("gameName");
                String Description = resultSet.getString("Description");
                String price = resultSet.getString("price");
                String Genre = resultSet.getString("Genre");
                String Platform = resultSet.getString("Platform");
                String Publisher = resultSet.getString("Publisher");
                String Modes = resultSet.getString("Modes");
                String UserID = resultSet.getString("userID");
                    Game game = new Game(ID, gameName, Description, price, Genre, Platform, Publisher, Modes, UserID);
                    games.add(game);
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
        return games;
    }



}
