package com.carzzy.rahul.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
