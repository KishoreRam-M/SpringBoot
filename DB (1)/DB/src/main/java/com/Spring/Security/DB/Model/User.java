package com.Spring.Security.DB.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @JsonProperty("UserId")
    private int id;

    @JsonProperty("UserName") // Mapping JSON property "UserName" to "username" field
    private String username;  // Changed field name to "username" to match the repository query

    @JsonProperty("UserPassword")
    private String password;

}
