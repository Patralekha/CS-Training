package com.example.hackathonbackend.services;

import com.example.hackathonbackend.model.BidPlayer;
import com.example.hackathonbackend.model.Bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Service
public class BiddingService {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Collection<Bidding> findAllBids() {

        List<Bidding> bidList= null;
        bidList = namedParameterJdbcTemplate.query("select * from biding", new RowMapper<Bidding>() {
            @Override
            public Bidding mapRow(ResultSet resultSet, int i) throws SQLException {
                Bidding biding=new Bidding();
                biding.setTeam1(resultSet.getDouble("team1"));
                biding.setTeam2(resultSet.getDouble("team2"));
                biding.setTeam3(resultSet.getDouble("team3"));
                biding.setPlayer_id(resultSet.getInt("players_id"));

                return biding;
            }
        });
        return bidList;
    }

    public Bidding getPlayerBid(Integer id){
    Bidding biding= namedParameterJdbcTemplate.queryForObject("select * from biding where player_id=:player_id",
            new MapSqlParameterSource("player_id",id),
            new RowMapper<Bidding>() {


        @Override
        public Bidding mapRow(ResultSet resultSet, int i) throws SQLException {
            Bidding biding=new Bidding();
            biding.setTeam1(resultSet.getDouble("team1"));
            biding.setTeam2(resultSet.getDouble("team2"));
            biding.setTeam3(resultSet.getDouble("team2"));
            biding.setPlayer_id(resultSet.getInt("players_id"));

            return biding;

        }


    });
        return biding;
    }

    public boolean setPlayerBid(Bidding p){
        String insert="insert into biding values(:team1,:team2,:team3,:player_id)";
        int result=namedParameterJdbcTemplate.update(insert, new BeanPropertySqlParameterSource(p));
        return result>0;
    }

}
