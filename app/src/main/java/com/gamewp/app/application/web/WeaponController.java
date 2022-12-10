package com.gamewp.app.application.web;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gamewp.app.application.service.IWeaponService;
import com.gamewp.app.domain.entity.Weapon;

@RestController
@RequestMapping(
    path = "/api/weapons",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class WeaponController {
    private IWeaponService weaponService;

    public WeaponController(IWeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping
    public ResponseEntity findAllWeapons() {
        try {
            return ResponseEntity.ok().body(this.weaponService.findAll());
        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> findWeaponById(@PathVariable("id") UUID id) {

        Optional<Weapon> weapon = this.weaponService.findById(id);

        if (weapon.isPresent()) {
            return ResponseEntity.ok(weapon.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createWeapon(@RequestBody Weapon weapon) {
        Weapon newWeapon = this.weaponService.create(weapon);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(newWeapon.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
            .header("Location", uri.toString()).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateWeapon(
        @PathVariable(value = "id") UUID id,
        @RequestBody Weapon weapon) {

        this.weaponService.update(id, weapon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWeapon(@PathVariable(value = "id") UUID id) {

        try {
            this.weaponService.delete(id);
            
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
