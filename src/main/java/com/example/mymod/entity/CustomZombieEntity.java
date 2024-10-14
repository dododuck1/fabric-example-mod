package com.example.mymod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;

public class CustomZombieEntity extends ZombieEntity {

    public CustomZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        // เพิ่มความเร็วและพลังชีวิต
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.35); // เร็วขึ้น
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(50.0); // เพิ่มพลังชีวิต
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        
        // Zombie สามารถทำลายบล็อกได้ (ตัวอย่างทำลายบล็อกที่เป็นดิน)
        BlockPos blockPos = this.getBlockPos().down();
        if (this.world.getBlockState(blockPos).getBlock() == Blocks.DIRT) {
            this.world.breakBlock(blockPos, true);
        }
        
        // Logic ปีนบันได
        if (this.isClimbing()) {
            this.setVelocity(this.getVelocity().add(0, 0.2, 0)); // ปีนเร็วขึ้น
        }
    }

    // Logic การปีนบันได
    @Override
    public boolean isClimbing() {
        return this.isTouchingWater() || this.world.getBlockState(this.getBlockPos().up()).isOf(Blocks.LADDER);
    }

    // กำหนดพลังแบบสุ่ม
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        // สุ่มค่าพลัง
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(this.random.nextDouble() * 10.0 + 5.0);
    }
}
