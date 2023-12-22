package com.martin.dungeon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBC {

    private String URL = "jdbc:mariadb://localhost:3306/DungeonRunDB";
    private String USER = "root";
    private String password = "martin123";

    Connection connection;

    public void open () {

        try {
            connection = DriverManager.getConnection(URL, USER, password);
            System.out.println("Database connected");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int createPlayer (Player newPlayer) {
        int incrementID = 0;
        String sql = "INSERT INTO players (Playername, PlayerSTR, PlayerAGI, PlayerHP, PlayerXP, PlayerLV, PlayerBaseHP, PlayerIsAlive ) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newPlayer.getName());
            preparedStatement.setInt(2, newPlayer.getStr());
            preparedStatement.setInt(3, newPlayer.getAgi());
            preparedStatement.setInt(4, newPlayer.getHp());
            preparedStatement.setInt(5, newPlayer.getXp());
            preparedStatement.setInt(6, newPlayer.getLv());
            preparedStatement.setInt(7, newPlayer.getBaseHp());
            preparedStatement.setInt(8, 1);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return incrementID;
    }

    public int updatePlayerStats(int str, int agi, int hp, int xp,int lv,int baseHP, int id) {

        String sql = "UPDATE players set PlayerSTR = ?, PlayerAGI = ?, PlayerHP = ?, PlayerXP = ?, PlayerLV = ?, PlayerBaseHP = ? where PlayerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, str);
            preparedStatement.setInt(2, agi);
            preparedStatement.setInt(3, hp);
            preparedStatement.setInt(4, xp);
            preparedStatement.setInt(5, lv);
            preparedStatement.setInt(6, baseHP);
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updatePlayerDead(int Dead, int id) {

        String sql = "UPDATE players set PlayerIsAlive = ? where PlayerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int idFinder(){
        String sql = "SELECT PlayerID FROM Players order by PlayerID desc";
        int playerID = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                playerID = rs.getInt("PlayerID");
                return playerID;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return 0;
    }

    public ArrayList<Player> listOfPlayers() {

        String query = "SELECT * FROM Players where PlayerIsAlive = 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Player> players = new ArrayList<>();
            while (results.next()) {
                List<IItems> invent = new ArrayList<>(3);
                Player player = new Player(invent);
                player.setId(results.getInt("PlayerID"));
                player.setName(results.getString("PlayerName"));
                player.setStr(results.getInt("PlayerSTR"));
                player.setAgi(results.getInt("PlayerAGI"));
                player.setHp(results.getInt("PlayerHP"));
                player.setXp2(results.getInt("PlayerXP"));
                player.setLv(results.getInt("PlayerLV"));
                player.setBaseHp(results.getInt("PlayerBaseHP"));

                players.add(player);
            }
            results.close();
            return players;
        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }


}
