package org.example.ketchup.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter @Setter
@Document(collection = "Games")
public class Game {
    @Id
    private String id;
    private String title;
    private String premiereDate;
    private double price;
}

