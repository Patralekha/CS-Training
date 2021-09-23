package com.example.hackathonbackend.controller;

import com.example.hackathonbackend.model.BidPlayer;
import com.example.hackathonbackend.model.Bidding;
import com.example.hackathonbackend.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BiddingController {


     //order by highest bid amount
    @Autowired
    BiddingService biddingService;

    @CrossOrigin
    @GetMapping("/biddingTable")
    public Collection<Bidding> getAllBids(){
        return biddingService.findAllBids();
    }



    @CrossOrigin
    @GetMapping("/getplayerbid")
    public Bidding getplayerBid(@RequestParam Integer id){
        return biddingService.getPlayerBid(id);
    }


    @CrossOrigin
    @PostMapping("/biddingSubmit")   //player id in body+amount+team name    ????
    public boolean submitBid(@RequestBody Bidding p){
        return biddingService.setPlayerBid(p);
    }


}
