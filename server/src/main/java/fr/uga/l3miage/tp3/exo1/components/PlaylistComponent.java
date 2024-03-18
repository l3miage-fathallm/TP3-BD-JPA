package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import fr.uga.l3miage.tp3.exo1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name){
        return playlistRepository.findById(name).orElseThrow();
    }
    public PlaylistEntity createPlaylist(){
        PlaylistEntity playlistEntity = PlaylistEntity
                .builder()
                .totalDuration(Duration.ofMinutes(3))
                .description("description")
                .name("playlist")
                .songEntities(Set.of())
                .build();
        return playlistRepository.save(playlistEntity);
    }
    public PlaylistEntity updateDescription(String name, String newDescription){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setDescription(newDescription);
        return playlistRepository.save(playlistEntity);
    }
    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }
    public Set<PlaylistEntity> getSongIsInPlaylists(String song){
        return playlistRepository.findAllBySongEntitiesContaining(song);
    }
}
