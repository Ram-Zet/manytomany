package ru.alexferz.manytomany;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.alexferz.manytomany.jpa.entity.Card;
import ru.alexferz.manytomany.jpa.repository.CardRepository;

import java.util.List;

@SpringBootApplication
public class ManytomanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManytomanyApplication.class, args);
    }

    @Bean
    public ApplicationRunner starter(CardRepository cardRepository) {
        return args -> {
            List<Card> all = cardRepository.findAll();
            for (Card card: all) {
                System.out.println("Card Id: " + card.getId());
                card.getLinks().forEach(link -> {
                    System.out.println(link.getAction().getAction());
                });
                System.out.println("====================");
            }

        };
    }

}
