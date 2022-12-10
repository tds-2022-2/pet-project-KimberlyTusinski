package com.gamewp.app.application.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gamewp.app.application.persistence.WeaponRepository;
import com.gamewp.app.domain.entity.Weapon;

@Service
public class WeaponServiceImpl implements IWeaponService {
    private WeaponRepository weaponRepository;

    public WeaponServiceImpl(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    @Override
    public Iterable<Weapon> findAll() {
        return this.weaponRepository.findAll();
    }

    @Override
    public Optional<Weapon> findById(UUID id) {
        return this.weaponRepository.findById(id);
    }

    @Override
    public Weapon create(Weapon newWeapon) {
        this.weaponRepository.save(newWeapon);
        
        return newWeapon;
    }

    
    @Override
    public Weapon update(UUID id, Weapon toUpdate) {
        this.weaponRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Weapon not found"));

        toUpdate.setId(id);
        this.weaponRepository.save(toUpdate);
        
        return null;
    }

    @Override
    public void delete(UUID id) {
        this.weaponRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Weapon not found"));

        this.weaponRepository.delete(id);
    }    
}
