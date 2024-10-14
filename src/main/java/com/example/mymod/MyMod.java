
package com.example.mymod;

import com.example.mymod.item.AK47Item;
import com.example.mymod.item.AmmoItem;
import com.example.mymod.item.M4A1Item;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.example.mymod.entity.CustomZombieEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class MyMod implements ModInitializer {

    public static final EntityType<CustomZombieEntity> CUSTOM_ZOMBIE = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("mymod", "custom_zombie"),
        EntityType.Builder.create(CustomZombieEntity::new, SpawnGroup.MONSTER)
            .setDimensions(0.6F, 1.95F) // ขนาดของ zombie
            .build("custom_zombie")
    );

    @Override
    public void onInitialize() {
        // ลงทะเบียน entity Zombie แบบปรับแต่ง
        Registry.register(Registry.ENTITY_TYPE, new Identifier("mymod", "custom_zombie"), CUSTOM_ZOMBIE);
    }
}

public class MyMod implements ModInitializer {
    public static final Item AK47 = new AK47Item(new Item.Settings().maxCount(1));
    public static final Item M4A1 = new M4A1Item(new Item.Settings().maxCount(1));
    public static final Item AMMO = new AmmoItem(new Item.Settings().maxCount(64)); // กระสุน

    @Override
    public void onInitialize() {
        // ลงทะเบียนปืน
        Registry.register(Registry.ITEM, new Identifier("mymod", "ak47"), AK47);
        Registry.register(Registry.ITEM, new Identifier("mymod", "m4a1"), M4A1);

        // ลงทะเบียนกระสุน
        Registry.register(Registry.ITEM, new Identifier("mymod", "ammo"), AMMO);
    }
  }
