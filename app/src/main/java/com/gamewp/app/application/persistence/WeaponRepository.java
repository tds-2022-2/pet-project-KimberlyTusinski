package com.gamewp.app.application.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.gamewp.app.domain.entity.Weapon;

@Repository
public class WeaponRepository {

    private final Map<UUID, Weapon> weapons =
        new HashMap<>();
    
    public List<Weapon> findAll() {
        return List.copyOf(weapons.values());
    }

    public Optional<Weapon> findById(UUID id) {
        return Optional.ofNullable(weapons.get(id));
    }

    public void save(Weapon weapon) {
        weapons.put(weapon.getId(), weapon);
    }

    public void delete(UUID id) {
        weapons.remove(id);
    }
}
