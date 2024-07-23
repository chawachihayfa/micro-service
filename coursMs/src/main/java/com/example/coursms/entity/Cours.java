package com.example.coursms.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cours")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cours {
    @Id
    private String id;
    private String title;
    private String description;
    private String instructor;
    private String content;
}
