package com.gamewp.app.application.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.gamewp.app.domain.entity.Character;

@Repository
public class CharacterRepository {

    private final Map<UUID, Character> characters =
        new HashMap<>();
    
    public List<Character> findAll() {
        return List.copyOf(characters.values());
    }

    public Optional<Character> findById(UUID id) {
        return Optional.ofNullable(characters.get(id));
    }

    public void save(Character character) {
        characters.put(character.getId(), character);
    }

    public void delete(UUID id) {
        characters.remove(id);
    }
}
