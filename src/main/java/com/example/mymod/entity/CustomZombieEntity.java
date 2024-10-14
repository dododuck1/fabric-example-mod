package com.example.mymod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class CustomZombieEntity extends ZombieEntity {

    public CustomZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundGoal(this, 1.0D)); // ทำให้ Zombie วิ่งเร็ว
        this.goalSelector.add(2, new BreakDoorGoal(this, true)); // ทำลายประตู
    }
}
