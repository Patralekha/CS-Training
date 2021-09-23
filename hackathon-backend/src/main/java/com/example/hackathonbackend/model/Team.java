package com.example.hackathonbackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@RequiredArgsConstructor
public class Team {

    int team_id ;
    String team_name;
    String team_owner;
    int strength;
    int primary ;
}
