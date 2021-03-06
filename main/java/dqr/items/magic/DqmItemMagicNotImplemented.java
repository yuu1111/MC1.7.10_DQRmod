package dqr.items.magic;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.enums.EnumDqmMagic;
import dqr.items.base.DqmItemMagicBase;

public class DqmItemMagicNotImplemented extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";
    public DqmItemMagicNotImplemented(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);
    }

    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

        return par1ItemStack;
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	p_77624_3_.add(I18n.format("dqm.magicinfo.noimplemented"));
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    }
}
