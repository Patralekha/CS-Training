package com.example.hackathonbackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TeamPlayers {

    int team_id ;
    String team_name;
int player_id;
String player_name;
String specification;

}
