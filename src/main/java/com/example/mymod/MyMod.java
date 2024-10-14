package com.example.mymod;

import com.example.mymod.entity.CustomZombieEntity;
import com.example.mymod.item.AK47Item;
import com.example.mymod.item.M4A1Item;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MyMod implements ModInitializer {
    public static final EntityType<CustomZombieEntity> CUSTOM_ZOMBIE = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("mymod", "custom_zombie"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CustomZombieEntity::new)
            .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build()
    );

    public static final Item AK47 = new AK47Item(new Item.Settings().maxCount(1));
    public static final Item M4A1 = new M4A1Item(new Item.Settings().maxCount(1));

    @Override
    public void onInitialize() {
        // ลงทะเบียน Zombie
        Registry.register(Registry.ENTITY_TYPE, new Identifier("mymod", "custom_zombie"), CUSTOM_ZOMBIE);

        // ลงทะเบียนปืนหลายชนิด
        Registry.register(Registry.ITEM, new Identifier("mymod", "ak47"), AK47);
        Registry.register(Registry.ITEM, new Identifier("mymod", "m4a1"), M4A1);
    }
}
