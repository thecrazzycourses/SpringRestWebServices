package com.carzzy.rahul.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "User Bean used to hold User Data")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "Name should not be blank & Name at least should have 2 char")
    @Size(min = 2, message = "Name at least should have 2 char")
    @NotBlank(message = "Name should not be blank")
    private String name;

    @ApiModelProperty(notes = "Birth date should be in the past")
    @Past
    private Date birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

}
