package ru.alexferz.manytomany.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexferz.manytomany.jpa.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
