package com.example.mymod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GunItem extends Item {

    protected int ammo; // จำนวนกระสุน

    public GunItem(Settings settings, int ammo) {
        super(settings);
        this.ammo = ammo;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (ammo > 0) {
            ammo--; // ลดจำนวนกระสุน
            // ยิง logic สำหรับการยิง
            user.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F); // เล่นเสียง

            // เพิ่ม logic สำหรับการยิง
            // (เช่น spawn ลูกไฟหรือกระสุน)

            return TypedActionResult.success(stack);
        }

        // เล่นเสียงหรือแสดงข้อความเมื่อกระสุนหมด
        return TypedActionResult.fail(stack);
    }
}
