package dqr.gui.petStatus.tab;


import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQMiscs;
import dqr.packetMessage.MessageServerGuiId;

public class InventoryTabPetStatus  extends AbstractTab {

	private static Minecraft mc = FMLClientHandler.instance().getClient();

	@Override
	public void onTabClicked() {
		//System.out.println("click" + DQR.conf.GuiID_MKArmor);
		PacketHandler.INSTANCE.sendToServer(new MessageServerGuiId(DQR.conf.GuiID_PetStatus));
		//mc.thePlayer.openGui(DQR.instance, DQR.conf.GuiID_MKArmor, mc.thePlayer.worldObj, (int)mc.thePlayer.posX, (int)mc.thePlayer.posY, (int)mc.thePlayer.posZ);
		//SSPacketHandler.INSTANCE.sendToServer(new PacketGuiId(200));
		//mc.thePlayer.openGui(SextiarySector.instance, 200, mc.thePlayer.worldObj, (int)mc.thePlayer.posX, (int)mc.thePlayer.posY, (int)mc.thePlayer.posZ);
	}

	@Override
	public ItemStack getItemStack() {
		return new ItemStack(DQMiscs.itemMagicbook3, 1);
	}

	@Override
	public boolean shouldAddToList() {
		return true;
	}

	@Override
	public String getTabName() {
		return "dqm.guin.tab.petstatus.status";
	}

}
