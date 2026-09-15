package com.tonyb.mobarena.mobs;

public enum MobInit {

    LIGHTNING_ZOMBIE(new LightningZombie());

    private final CustomMob mob;

    MobInit(CustomMob mob) {
        this.mob = mob;
    }

    public CustomMob getMob() {
        return mob;
    }
}