package com.example.hackathonbackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BidPlayer {
    int team_id ;

    int player_id;
    String player_name;

}
