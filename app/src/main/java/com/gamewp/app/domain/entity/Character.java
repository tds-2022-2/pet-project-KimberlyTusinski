package com.gamewp.app.domain.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class Character extends Base {
    @ApiModelProperty(value = "name", example = "Albedo")
    private String name;
    
    @ApiModelProperty(value = "title", example = "Kreideprinz")
    private String title;
    
    @ApiModelProperty(value = "vision", example = "Geo")
    private String vision;

    @ApiModelProperty(value = "weapon", example = "Sword")
    private String weapon;
    
    @ApiModelProperty(value = "nation", example = "Mondstadt")
    private String nation;

    @ApiModelProperty(value = "rarity", example = "5")
    private int rarity;
    
    @ApiModelProperty(value = "birthday", example = "2004-09-13")
    private LocalDate birthday;

    @JsonIgnore
    private byte[] img;
    
    public Character() {
        super.generateUUID();
    }
    
    public byte[] getImg() {
        return this.img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
