package com.gamewp.app.application.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gamewp.app.application.persistence.CharacterRepository;
import com.gamewp.app.domain.entity.Character;


@Service
public class CharacterServiceImpl implements ICharacterService {

    private CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Iterable<Character> findAll() {
        return this.characterRepository.findAll();
    }

    @Override
    public Optional<Character> findById(UUID id) {
        return this.characterRepository.findById(id);
    }

    @Override
    public Character create(Character newCharacter) {
        this.characterRepository.save(newCharacter);

        return newCharacter;
    }

    @Override
    public Character update(UUID id, Character toUpdate) {
        this.characterRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        toUpdate.setId(id);
        this.characterRepository.save(toUpdate);
        
        return null;
    }

    @Override
    public Character uploadImg(UUID id, byte[] fileContentBase64) {
        Character toUpdate = this.characterRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        toUpdate.setId(id);
        toUpdate.setImg(fileContentBase64);
        this.characterRepository.save(toUpdate);
        
        return null;
    }

    @Override
    public void delete(UUID id) {
        this.characterRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        this.characterRepository.delete(id);
    }
}
