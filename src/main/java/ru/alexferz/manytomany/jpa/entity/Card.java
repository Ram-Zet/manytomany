package ru.alexferz.manytomany.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "manytomany", name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_status")
    private Long statusId;

    private String form;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
    List<Link> links = new ArrayList<>();

}
