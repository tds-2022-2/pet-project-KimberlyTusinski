package com.gamewp.app.application.web;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gamewp.app.application.service.ICharacterService;
import com.gamewp.app.domain.entity.Character;

@RestController
@RequestMapping(
    path = "/api/characters",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class CharacterController {
    private ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity findAllCharacters() {
        try {
            return ResponseEntity.ok().body(this.characterService.findAll());
        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findCharacterById(@PathVariable("id") UUID id) {
        Optional<Character> character = this.characterService.findById(id);

        if (character.isPresent()) {
            return ResponseEntity.ok(character.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/upload/img/{id}")
    public ResponseEntity<byte[]> getUploadImg(@PathVariable("id") UUID id) {
        Optional<Character> character = this.characterService.findById(id);

        if (character.isPresent()) {
            return ResponseEntity.ok(character.get().getImg());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createCharacter(@RequestBody Character character) {
        Character newCharacter = this.characterService.create(character);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(newCharacter.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
            .header("Location", uri.toString()).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateCharacter(
        @PathVariable("id") UUID id,
        @RequestBody Character character) {

        this.characterService.update(id, character);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void uploadCharacterImg(
        @PathVariable("id") UUID id,
        @RequestParam("image") MultipartFile file) {
        
        try {
            this.characterService.uploadImg(id, Base64.encodeBase64(file.getBytes()));
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") UUID id) {
        try {
            this.characterService.delete(id);
            
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
