package com.example.hackathonbackend.services;

import com.example.hackathonbackend.model.Player;
import com.example.hackathonbackend.model.Team;
import com.example.hackathonbackend.model.TeamPlayers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class PlayerService {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Collection<Player> getAll(){

        List<Player> players=null;
        players=namedParameterJdbcTemplate.query("select * from players", new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player=new Player();
                player.setPlayer_id(resultSet.getInt("player_id"));
                player.setPlayer_name(resultSet.getString("player_name"));
                player.setLowest_Bid(resultSet.getInt("lowest_Bid"));
                //player.setNumber_of_macthes(resultSet.getInt("number_macthes"));
                player.setSpecification(resultSet.getString("specification"));
                player.setSocial_media_following(resultSet.getString("social_media_following"));
                player.setTeam_id(resultSet.getInt("team_id"));
                player.setIs_selected(resultSet.getInt("is_selected"));
                player.setFinal_bid_amount(resultSet.getInt("final_bid_amount"));

                return player;
            }
        });
        return players;
    }


    public Player getByName(String name){

        //List<Player> players=null;
        Player player=namedParameterJdbcTemplate.queryForObject("select * from players where player_name=:player_name",
                new MapSqlParameterSource("player_name",name),
        new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player=new Player();
                player.setPlayer_id(resultSet.getInt("player_id"));
                player.setPlayer_name(resultSet.getString("player_name"));
                player.setLowest_Bid(resultSet.getInt("lowest_Bid"));
                //player.setNumber_of_macthes(resultSet.getInt("number_macthes"));
                player.setSpecification(resultSet.getString("specification"));
                player.setSocial_media_following(resultSet.getString("social_media_following"));
                player.setTeam_id(resultSet.getInt("team_id"));
                player.setIs_selected(resultSet.getInt("is_selected"));
                player.setFinal_bid_amount(resultSet.getInt("final_bid_amount"));

                return player;
            }
        });
        return player;
    }



    public Collection<TeamPlayers> getTeams(){

        List<TeamPlayers> tp=null;
        tp=namedParameterJdbcTemplate.query("\n" +
                "select player_id,player_name,team_id,team_name,specification from players p,team t inner join on p.team_id=t.team_id group by t.team_id", new RowMapper<TeamPlayers>() {
            @Override
            public TeamPlayers mapRow(ResultSet resultSet, int i) throws SQLException {
                TeamPlayers tp=new TeamPlayers();
                tp.setPlayer_id(resultSet.getInt("player_id"));
                tp.setPlayer_name(resultSet.getString("player_name"));
                tp.setTeam_name(resultSet.getString("team_name"));
                tp.setTeam_id(resultSet.getInt("team_id"));
                tp.setSpecification(resultSet.getString("specification"));
                return tp;
            }
        });
        return tp;
    }

    public Collection<Player> getAllUnsold(){

        List<Player> players=null;
        players=namedParameterJdbcTemplate.query("select * from players where is_selected=0", new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player=new Player();
                player.setPlayer_id(resultSet.getInt("player_id"));
                player.setPlayer_name(resultSet.getString("player_name"));
                player.setLowest_Bid(resultSet.getInt("lowest_Bid"));
                //player.setNumber_of_macthes(resultSet.getInt("number_macthes"));
                player.setSpecification(resultSet.getString("specification"));
                player.setSocial_media_following(resultSet.getString("social_media_following"));
                player.setTeam_id(resultSet.getInt("team_id"));
                player.setIs_selected(resultSet.getInt("is_selected"));
                player.setFinal_bid_amount(resultSet.getInt("final_bid_amount"));

                return player;
            }
        });
        return players;
    }


    public Collection<Player> getFinalTeamById(Integer id){

        List<Player> players=null;
        players=namedParameterJdbcTemplate.query("select * from players where team_id="+id, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player=new Player();
                player.setPlayer_id(resultSet.getInt("player_id"));
                player.setPlayer_name(resultSet.getString("player_name"));
                player.setLowest_Bid(resultSet.getInt("lowest_Bid"));
                //player.setNumber_of_macthes(resultSet.getInt("number_macthes"));
                player.setSpecification(resultSet.getString("specification"));
                player.setSocial_media_following(resultSet.getString("social_media_following"));
                player.setTeam_id(resultSet.getInt("team_id"));
                player.setIs_selected(resultSet.getInt("is_selected"));
                player.setFinal_bid_amount(resultSet.getInt("final_bid_amount"));

                return player;
            }
        });
        return players;
    }

    public boolean setBasePrice(Player p){
        String insert="update players set final_bid_amount = :final_bid_amount where player_id=:player_id ";
        int result=namedParameterJdbcTemplate.update(insert,new BeanPropertySqlParameterSource(p));
        return result>0;

    }





}
