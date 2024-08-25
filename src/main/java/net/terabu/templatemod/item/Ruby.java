package net.terabu.templatemod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.terabu.templatemod.TemplateMod;

public class Ruby extends Item{
    public Ruby(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.addVelocity(0, 2, 0);
        ItemStack stack = user.getStackInHand(hand);


        return TypedActionResult.success(stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity p = context.getPlayer();
        ItemStack stack = context.getStack();
        p.dropItem(stack,true);
        p.setStackInHand(context.getHand(), ItemStack.EMPTY);
        return ActionResult.SUCCESS;
    }
}
