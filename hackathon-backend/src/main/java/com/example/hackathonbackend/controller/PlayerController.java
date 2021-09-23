package com.example.hackathonbackend.controller;


import com.example.hackathonbackend.model.Player;
import com.example.hackathonbackend.model.Team;
import com.example.hackathonbackend.model.TeamPlayers;
import com.example.hackathonbackend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @CrossOrigin
    @GetMapping("/viewallplayers")
    public Collection<Player> getall(){
        return playerService.getAll();
    }

    @CrossOrigin
    @GetMapping("/viewplayerbyname")
    public Player findAByName(@RequestParam String name) {
        return playerService.getByName(name);
    }

    @CrossOrigin
    @GetMapping("/getfinalteams")
    public Collection<TeamPlayers> getAllTeam(){
        return playerService.getTeams();
    }

    @CrossOrigin
    @GetMapping("/finalTeamOfPlayer")
    public Collection<Player> getFinalTeamsById(@RequestParam int id) {
        return playerService.getFinalTeamById(id);
    }


    @CrossOrigin
    @GetMapping("/unsoldPlayers")
    public Collection<Player> unsoldPlayers(){
        return playerService.getAllUnsold();
    }

    @CrossOrigin
    @PatchMapping("/setPrice")
    public boolean setPrice(@RequestBody Player p,@PathVariable("id") Integer id){ // can be changed later on
     //p.save(partialUpdate, id);
        return playerService.setBasePrice(p);
    }
}
