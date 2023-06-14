package ru.alexferz.manytomany.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(schema = "manytomany", name = "link")
public class Link {
    @EmbeddedId
    private LinkKey key;

    @ManyToOne
    @MapsId("key")
    @JoinColumns({
            @JoinColumn(name = "id_status", referencedColumnName = "id_status"),
            @JoinColumn(name = "form", referencedColumnName = "form")
    })
    private Card card;

    @ManyToOne
    @JoinColumn(name = "id_action")
    private CardAction action;

    @Data
    @Embeddable
    public static class LinkKey implements Serializable {
        @Column(name = "id_status")
        private Long statusId;
        private String form;
    }
}
