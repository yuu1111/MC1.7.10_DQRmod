package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityHoimi;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicHoimi extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicHoimi(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

    }


    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		PotionEffect pe;
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

    	if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
    	{

    		if(par3EntityPlayer.isSneaking())
	    	{
	        	MagicEntity magic = null;


	    		if(par1ItemStack.getItem() == DQMagics.itemHoimi)
	    		{
	    	   		magic = new MagicEntityHoimi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

	    		}else if(par1ItemStack.getItem() == DQMagics.itemBehoimi)
	    		{
	    			magic = new MagicEntityHoimi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

	    		}else if(par1ItemStack.getItem() == DQMagics.itemBehoma)
	    		{
	    			magic = new MagicEntityHoimi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

	    		}

	    		if(magic != null)
	    		{
	    			int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

	    			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
	    			{
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}else
	    			{
		    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
		    			{
		    				/*
		    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
		    						        / par1ItemStack.getMaxDamage() * this.getEnumMagic().getAttack() / 100;
		    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
		    				*/
		    				int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
		    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
							        / par1ItemStack.getMaxDamage() *  matk / 100;
		    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
		    				magic.setDamage(attackDam);

		    				if(this.getEnumMagic().getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
		    				{
		    					par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
		    				}else
		    				{
		    					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
		    				}

				    		Random rand_jukuren = new Random();
							if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
							{

								int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
								ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
							}

		    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
		    				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
		    	        	if (!par2World.isRemote)
		    	        	{
		    	        		par2World.spawnEntityInWorld(magic);

		    	        	}
		    			}else
		    			{
		    				magic = null;
		    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
		    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
		    			}
	    			}
	    		}
	    	}else
	    	{
	    		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

				if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
				{
					DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				}else
				{
		    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);


	    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
	    			{
	    				/*
	    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
	    						        / par1ItemStack.getMaxDamage() * this.getEnumMagic().getAttack() / 100;
	    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
	    				*/
	    				int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
	    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
						        / par1ItemStack.getMaxDamage() *  matk / 100;
	    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
	    				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
	    				//magic.setDamage(attackDam);

	    				if(this.getEnumMagic().getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
	    				{
	    					par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
	    				}else
	    				{
	    					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
	    				}
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

	    				if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
	    				{
	    					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
	    				}else
	    				{
	                    	if(par3EntityPlayer.getHealth() + attackDam > par3EntityPlayer.getMaxHealth())
	                    	{
	                    		par3EntityPlayer.setHealth(par3EntityPlayer.getMaxHealth());
	                    	}else
	                    	{
	                    		par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() + (float)attackDam);
	                    	}

		    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.hoimi", 1.0F, 1.0F);
	    				}

			    		Random rand_jukuren = new Random();
						if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
						{

							int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
							ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
						}
	    			}else
	    			{
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
				}
	    	}
    	}else
    	{
    		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	}


        return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.hoimi.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}
    }
}
