package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserComponent {
    private final UserRepository userRepository;

    public UserEntity getUser(String name){
        return userRepository.findById(name).orElseThrow();
    }
    public UserEntity createUser(){
        UserEntity userEntity = UserEntity
                .builder()
                .mail("user@user.com")
                .name("user")
                .playlistEntities(Set.of())
                .build();
        return userRepository.save(userEntity);
    }
    public UserEntity updateEmail(String name, String newMail){
        UserEntity userEntity = userRepository.findById(name).orElseThrow();
        userEntity.setMail(newMail);
        return userRepository.save(userEntity);
    }
    public void deleteUser(String name){
        userRepository.deleteById(name);
    }
    public Set<UserEntity> getUserIsInDomain(String domaine){
        return userRepository.findAllByMailContaining(domaine);
    }
}
