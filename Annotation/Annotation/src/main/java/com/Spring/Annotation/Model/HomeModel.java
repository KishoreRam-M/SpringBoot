package com.Spring.Annotation.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table( name = "Home")
public class HomeModel {
    @Id
    @Column(name = "ID ")
    private String Homeid;
    @Column(name = "Place")
    private String place;
    @Column(name = "Name")
    private String HomeName;
}
