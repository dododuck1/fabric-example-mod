package com.example.mymod;

import com.example.mymod.item.AK47Item;
import com.example.mymod.item.AmmoItem;
import com.example.mymod.item.M4A1Item;
import com.example.mymod.entity.CustomZombieEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class MyMod implements ModInitializer {

    // การลงทะเบียน Custom Zombie
    public static final EntityType<CustomZombieEntity> CUSTOM_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier("mymod", "custom_zombie"),
        EntityType.Builder.create(CustomZombieEntity::new, SpawnGroup.MONSTER)
            .setDimensions(0.6F, 1.95F) // ขนาดของ zombie
            .build("custom_zombie")
    );

    // การลงทะเบียนปืนและกระสุน
    public static final Item AK47 = new AK47Item(new Item.Settings().maxCount(1));
    public static final Item M4A1 = new M4A1Item(new Item.Settings().maxCount(1));
    public static final Item AMMO = new AmmoItem(new Item.Settings().maxCount(64)); // กระสุน

    @Override
    public void onInitialize() {
        // ลงทะเบียน Custom Zombie
        Registry.register(Registries.ENTITY_TYPE, new Identifier("mymod", "custom_zombie"), CUSTOM_ZOMBIE);

        // ลงทะเบียนปืน
        Registry.register(Registries.ITEM, new Identifier("mymod", "ak47"), AK47);
        Registry.register(Registries.ITEM, new Identifier("mymod", "m4a1"), M4A1);

        // ลงทะเบียนกระสุน
        Registry.register(Registries.ITEM, new Identifier("mymod", "ammo"), AMMO);
    }
}
