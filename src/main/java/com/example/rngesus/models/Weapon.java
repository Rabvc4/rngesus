package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.DamageType;
import com.example.rngesus.models.enumerations.ItemType;
import com.example.rngesus.models.enumerations.WeaponProficiency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Weapon extends Item {

    @Column
    private String meleeDamage;

//    @Column
//    private String rangedDamage;
//
//    @Column
//    private Integer modifier;
//
//    private Integer maximumRange;
//    private Integer minimumRange;
//
//    @Column(nullable = false)
//    private DamageType meleeDamageType;
//
//    @Column(nullable = false)
//    private DamageType rangedDamageType;
//
//    private WeaponProficiency weaponProficiency;

    public Weapon() {
        this.setType(ItemType.WEAPON);

    }

}
