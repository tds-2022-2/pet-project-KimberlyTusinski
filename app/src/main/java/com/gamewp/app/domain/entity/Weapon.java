package com.gamewp.app.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Weapon extends Base {
    @ApiModelProperty(value = "name", example = "Akuoumaru")
    private String name;

    @ApiModelProperty(value = "type", example = "Claymore")
    private String type;
    
    @ApiModelProperty(value = "rarity", example = "4")
    private int rarity;
    
    @ApiModelProperty(value = "baseAttack", example = "42")
    private int baseAttack;
    
    @ApiModelProperty(value = "subStat", example = "ATK")
    private String subStat;
    
    @ApiModelProperty(value = "passiveName", example = "Watatsumi Wavewalker")
    private String passiveName;
    
    @ApiModelProperty(value = "passiveDesc", example = "For every point of the entire party's combined maximum Energy capacity, the Elemental Burst DMG of the character equipping this weapon is increased by 0.12/0.15/0.18/0.21/0.24%. A maximum of 40/50/60/70/80% increased Elemental Burst DMG can be achieved this way.")
    private String passiveDesc;
    
    @ApiModelProperty(value = "location", example = "Gacha")
    private String location;
    
    @ApiModelProperty(value = "ascensionMaterial", example = "distantant-sea")
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
