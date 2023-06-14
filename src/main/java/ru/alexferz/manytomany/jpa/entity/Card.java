package ru.alexferz.manytomany.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "manytomany", name = "link",
            joinColumns = {
                    @JoinColumn(name = "id_status", referencedColumnName = "id_status"),
                    @JoinColumn(name = "form", referencedColumnName = "form")
            },
            inverseJoinColumns = @JoinColumn(name = "id_action", referencedColumnName = "id_action")
    )
    Set<CardAction> actions = new HashSet<>();

}
