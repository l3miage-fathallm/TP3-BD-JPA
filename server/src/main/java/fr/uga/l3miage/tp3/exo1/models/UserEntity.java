package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String name;
    @Email
    private String mail;

    @OneToMany
    @JoinColumn(name = "name")
    private Set<PlaylistEntity> playlistEntities;
}
