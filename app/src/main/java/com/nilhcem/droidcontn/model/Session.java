package com.nilhcem.droidcontn.model;

import java.util.List;

import lombok.Value;

@Value
public class Session {

    int roomId;
    List<Integer> speakersId;
    String title;
    String description;
}
