package com.example.hackathonbackend.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@RequiredArgsConstructor
public class Player {

    int player_id ;
    String player_name;
    int lowest_Bid ;
    int number_of_macthes;
    String specification;
    String social_media_following;
    int  is_selected ;
    int final_bid_amount;
    int team_id;
}
