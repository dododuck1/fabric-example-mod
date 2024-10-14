
package com.example.mymod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GunItem extends Item {

    protected int maxAmmo; // จำนวนกระสุนสูงสุดที่ปืนรองรับ

    public GunItem(Settings settings, int maxAmmo) {
        super(settings);
        this.maxAmmo = maxAmmo;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        // ตรวจสอบว่าผู้เล่นมี Ammo อยู่ใน inventory หรือไม่
        boolean hasAmmo = user.getInventory().contains(new ItemStack(MyMod.AMMO));

        if (hasAmmo) {
            // ถ้ามี ammo ยิง
            user.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F); // เสียงยิง

            // Logic การยิง เช่น spawn ลูกไฟ
            // user.getWorld().spawnEntity(ลูกไฟหรือโปรเจคไทล์อื่นๆ)

            // ลดจำนวนกระสุนใน inventory
            removeAmmo(user);

            return TypedActionResult.success(stack);
        } else {
            // ถ้าไม่มี ammo แสดงข้อความหรือเสียงเตือน
            user.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F); // เสียงเตือนกระสุนหมด
            return TypedActionResult.fail(stack);
        }
    }

    private void removeAmmo(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack itemStack = player.getInventory().getStack(i);
            if (itemStack.getItem() == MyMod.AMMO) {
                itemStack.decrement(1); // ลดจำนวนกระสุน
                break;
            }
        }
    }
}
