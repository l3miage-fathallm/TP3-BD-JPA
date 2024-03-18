package fr.uga.l3miage.tp3.exo1.models;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ArtistEntity {
    @Id
    private String name;

    private String biography;

    @Enumerated(EnumType.STRING)
    private GenreMusical genreMusical;

    @OneToMany(mappedBy = "artistEntity",cascade = CascadeType.ALL)
    private Set<AlbumEntity> albumEntities;
}
