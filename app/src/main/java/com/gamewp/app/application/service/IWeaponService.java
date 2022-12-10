package com.gamewp.app.application.service;

import java.util.Optional;
import java.util.UUID;

import com.gamewp.app.domain.entity.Weapon;

public interface IWeaponService {
    Iterable<Weapon> findAll();
    Optional<Weapon> findById(UUID id);
    Weapon create(Weapon toAdd);
    Weapon update(UUID id, Weapon toUpdate);
    void delete(UUID id);
}
