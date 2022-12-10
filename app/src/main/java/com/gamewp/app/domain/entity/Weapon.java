package com.gamewp.app.domain.entity;

public class Weapon extends Base {
    private String name;
    private String type;
    private int rarity;
    private int baseAttack;
    private String subStat;
    private String passiveName;
    private String passiveDesc;
    private String location;
    private String ascensionMaterial;

    public Weapon() {
        super.generateUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public String getSubStat() {
        return subStat;
    }

    public void setSubStat(String subStat) {
        this.subStat = subStat;
    }

    public String getPassiveName() {
        return passiveName;
    }

    public void setPassiveName(String passiveName) {
        this.passiveName = passiveName;
    }

    public String getPassiveDesc() {
        return passiveDesc;
    }

    public void setPassiveDesc(String passiveDesc) {
        this.passiveDesc = passiveDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAscensionMaterial() {
        return ascensionMaterial;
    }

    public void setAscensionMaterial(String ascensionMaterial) {
        this.ascensionMaterial = ascensionMaterial;
    }
}
