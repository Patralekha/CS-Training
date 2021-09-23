package com.example.hackathonbackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Bidding {

    double team1;
    double team2;
    double team3 ;
    int player_id;
}
