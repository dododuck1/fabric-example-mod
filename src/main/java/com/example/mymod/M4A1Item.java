package com.example.mymod.item;

public class M4A1Item extends GunItem {

    public M4A1Item(Settings settings) {
        super(settings, 30); // M4A1 ยิงได้ 30 นัด
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // สามารถปรับการยิงให้เร็วขึ้นที่นี่
        // เช่น เพิ่มจำนวนการยิงต่อคลิก
        return super.use(world, user, hand);
    }
}
