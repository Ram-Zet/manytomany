package ru.alexferz.manytomany.jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "actionId")
@Entity
@Table(schema = "manytomany", name = "card_action")
public class CardAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_action")
    private Long actionId;

    private String action;


}
