package com.containers.model;

public enum DamageTypeEnum {

    BENT("BT"), BROKEN("BR"), CRACKED("CR"), HOLE("H"), MISSING("M"), BRUISE("B"), CUT("C"), DENT("D"), LOOSE("L"), RUSTY("R");

    private String damageSymbol;

    public String getDamageSymbol() {
        return this.damageSymbol;
    }

    DamageTypeEnum(String damageSymbol) {
        this.damageSymbol = damageSymbol;
    }
}
