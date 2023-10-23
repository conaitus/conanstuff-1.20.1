package com.conaitus.conanstuff.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class IronDetectorItem extends Item {
    public IronDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuebleBlock(state)){

                    player.sendMessage(Text.literal("Found " + state.getBlock().asItem().getName().getString() +
                            " at (" + positionClicked.down(i).getX() + ", " + positionClicked.down(i).getY() + ", " + positionClicked.down(i).getZ() + ")"), false);

                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.literal("No Iron Found!"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }

    private boolean isValuebleBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE);
    }
}
