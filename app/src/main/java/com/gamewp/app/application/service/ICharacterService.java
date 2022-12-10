package com.gamewp.app.application.service;

import java.util.Optional;
import java.util.UUID;

import com.gamewp.app.domain.entity.Character;

public interface ICharacterService {
    Iterable<Character> findAll();
    Optional<Character> findById(UUID id);
    Character create(Character toAdd);
    Character update(UUID id, Character toUpdate);
    Character uploadImg(UUID id, byte[] fileContentBase64);
    void delete(UUID id);
}
