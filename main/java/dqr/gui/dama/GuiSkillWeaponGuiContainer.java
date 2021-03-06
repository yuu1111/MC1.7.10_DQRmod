package dqr.gui.dama;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiSkillWeaponGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/guiSkillWeapon.png");
    private static final ResourceLocation texture3 = new ResourceLocation("dqr","textures/gui/widgets2.png");
    private int weaponID = -1;
    private EntityPlayer player;
    public GuiSkillWeaponGuiContainer(EntityPlayer ep)
    {
        super(new GuiSkillWeaponContainer(ep));
        this.weaponID = ExtendedPlayerProperties.get(ep).getWeapon();
        this.ySize = 42;
        this.xSize = 194;
        this.player = ep;
    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
        //描画する文字, X, Y, 色
    	if(this.player.worldObj.isRemote && weaponID != -1)
    	{
    		this.fontRendererObj.drawString(I18n.format("msg.Dama3.guiTitle.txt", new Object[]{I18n.format("gui.weapon." + weaponID)}), 8, 6, 4210752);
    	}
        //this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int weaponID = ExtendedPlayerProperties.get(player).getWeapon();
        int wSetSkill = ExtendedPlayerProperties3.get(player).getWeaponSkillSet(weaponID);
        int perm = ExtendedPlayerProperties3.get(player).getWeaponSkillPermission(weaponID, wSetSkill);
        if(wSetSkill > -1 && perm > 0)
        {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL11.GL_BLEND);
	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.mc.getTextureManager().bindTexture(texture3);
			this.drawTexturedModalRect(k + 8 + (wSetSkill * 18), 18 + l, 0, 146, 16, 16);
        }
    }
}
