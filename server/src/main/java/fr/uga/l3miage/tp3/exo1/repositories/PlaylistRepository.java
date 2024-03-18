package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, String> {
    Set<PlaylistEntity> findAllBySongEntitiesContaining(String name);
}
