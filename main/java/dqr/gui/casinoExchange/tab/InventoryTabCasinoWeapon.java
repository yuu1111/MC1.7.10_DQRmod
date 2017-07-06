package dqr.gui.casinoExchange.tab;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQWeapons;
import dqr.gui.medalKing.tab.AbstractTab;
import dqr.packetMessage.MessageServerGuiId;

public class InventoryTabCasinoWeapon  extends AbstractTab {

	private static Minecraft mc = FMLClientHandler.instance().getClient();

	@Override
	public void onTabClicked() {
		//System.out.println("click" + DQR.conf.GuiID_MKWeapon);
		PacketHandler.INSTANCE.sendToServer(new MessageServerGuiId(DQR.conf.GuiID_CEWeapon));
		//mc.thePlayer.openGui(DQR.instance, DQR.conf.GuiID_MKWeapon, mc.thePlayer.worldObj, (int)mc.thePlayer.posX, (int)mc.thePlayer.posY, (int)mc.thePlayer.posZ);
		//SSPacketHandler.INSTANCE.sendToServer(new PacketGuiId(200));
		//mc.thePlayer.openGui(SextiarySector.instance, 200, mc.thePlayer.worldObj, (int)mc.thePlayer.posX, (int)mc.thePlayer.posY, (int)mc.thePlayer.posZ);
	}

	@Override
	public ItemStack getItemStack() {
		return new ItemStack(DQWeapons.itemRotonoturugi, 1);
	}

	@Override
	public boolean shouldAddToList() {
		return true;
	}

	@Override
	public String getTabName() {
		return "dqm.guin.tab.medalking.weapons";
	}

}
