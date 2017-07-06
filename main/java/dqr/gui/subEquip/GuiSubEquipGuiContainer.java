package dqr.gui.subEquip;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import tconstruct.client.tabs.AbstractTab;
import tconstruct.client.tabs.TabRegistry;
import cpw.mods.fml.common.Loader;

public class GuiSubEquipGuiContainer extends InventoryEffectRenderer {

    protected static final ResourceLocation field_147001_a = new ResourceLocation("dqr:textures/gui/inventory_dqr.png");
    private boolean initWithPotion;

    /** x size of the inventory window in pixels. Defined as  float, passed as int */
    private float xSizeFloat;
    /** y size of the inventory window in pixels. Defined as  float, passed as int. */
    private float ySizeFloat;
    private int potionOffsetLast;
    private static final String __OBFID = "CL_00000761";

    public GuiSubEquipGuiContainer(EntityPlayer p_i1094_1_) {
        super(new GuiSubEquipContainer(p_i1094_1_.inventory, p_i1094_1_));
        this.allowUserInput = true;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            //this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initGui() {
        this.buttonList.clear();

        super.initGui();

        //int cornerX = this.guiLeft;

        //int cornerY = this.guiTop;
        this.guiLeft = (this.width - this.xSize) / 2;
		this.guiLeft += this.getPotionOffset();
		this.potionOffsetLast = getPotionOffsetNEI();

        int cornerX = this.guiLeft;
        int cornerY = this.guiTop;
        /*
        if (TabRegistry.hasPotion()) //!mc.thePlayer.getActivePotionEffects().isEmpty())
        {
            cornerX = 160 + (this.width - this.xSize - 200) / 2;
        } else {
            cornerX = (this.width - this.xSize) / 2;
        }
        */
        cornerX += TabRegistry.getPotionOffset();

        //TabRegistry.updateTabValues(cornerX, cornerY, TabPlayerSubEquip.class);
        TabRegistry.updateTabValues(cornerX, cornerY, TabPlayerSubEquip.class);
        TabRegistry.addTabsToList(this.buttonList);

        //this.buttonList.add(new GuiButton(0, this.guiLeft + 10, this.guiTop + 71, 7, 7, ""));
        //this.buttonList.add(new GuiButton(1, this.guiLeft + 51, this.guiTop + 71, 7, 7, ""));
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        //this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 86, 16, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
		int newPotionOffset = this.getPotionOffsetNEI();
		if (newPotionOffset < this.potionOffsetLast)
		{
	    	int diff = newPotionOffset - this.potionOffsetLast;
	    	this.potionOffsetLast = newPotionOffset;
	    	this.guiLeft += diff;
			for (int k = 0; k < this.buttonList.size(); ++k)
	        {
	        	GuiButton b = (GuiButton) this.buttonList.get(k);
	        	if (!(b instanceof AbstractTab)) b.xPosition += diff;
	        }
		}
        super.drawScreen(par1, par2, par3);
        this.xSizeFloat = par1;
        this.ySizeFloat = par2;
    }
    /*
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
        this.xSizeFloat = p_73863_1_;
        this.ySizeFloat = p_73863_2_;
    }
    */

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(this.field_147001_a);
        int k = this.guiLeft;
        int l = this.guiTop;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        func_147046_a(k + 33, l + 75, 29, k + 51 - this.xSizeFloat, l + 75 - 50 - this.ySizeFloat, this.mc.thePlayer);
    }

    public static void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_) {


    	/*
			p_147046_5_ =
    	 */
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(p_147046_0_, p_147046_1_, 50.0F);
        GL11.glScalef((-p_147046_2_), p_147046_2_, p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = p_147046_5_.renderYawOffset;
        float f3 = p_147046_5_.rotationYaw;
        float f4 = p_147046_5_.rotationPitch;
        float f5 = p_147046_5_.prevRotationYawHead;
        float f6 = p_147046_5_.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float) Math.atan(p_147046_4_ / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_147046_5_.renderYawOffset = (float) Math.atan(p_147046_3_ / 40.0F) * 20.0F;
        p_147046_5_.rotationYaw = (float) Math.atan(p_147046_3_ / 40.0F) * 40.0F;
        p_147046_5_.rotationPitch = -((float) Math.atan(p_147046_4_ / 40.0F)) * 20.0F;
        p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
        p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
        GL11.glTranslatef(0.0F, p_147046_5_.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p_147046_5_.renderYawOffset = f2;
        p_147046_5_.rotationYaw = f3;
        p_147046_5_.rotationPitch = f4;
        p_147046_5_.prevRotationYawHead = f5;
        p_147046_5_.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    @Override
    protected void actionPerformed(GuiButton p_146284_1_) {
        if (p_146284_1_.id == 0) {
            this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
        }

        if (p_146284_1_.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
        }
    }

	public int getPotionOffset()
	{
		// If at least one potion is active...
		if (!Minecraft.getMinecraft().thePlayer.getActivePotionEffects().isEmpty())
		{
			this.initWithPotion = true;
			return 60 + getPotionOffsetNEI();
		}

		// No potions, no offset needed
		this.initWithPotion = false;
		return 0;
	}

	public int getPotionOffsetNEI()
	{
		if (this.initWithPotion && Loader.isModLoaded("NotEnoughItems"))
		{
			try
			{
				// Check whether NEI is hidden and enabled
				Class<?> c = Class.forName("codechicken.nei.NEIClientConfig");
				Object hidden = c.getMethod("isHidden").invoke(null);
				Object enabled = c.getMethod("isEnabled").invoke(null);
				if (hidden instanceof Boolean && enabled instanceof Boolean)
				{
					if ((Boolean)hidden || !((Boolean)enabled))
					{
						// If NEI is disabled or hidden, offset the tabs by the standard 60
						return 0;
					}
					//Active NEI undoes the standard potion offset
					return -60;
				}
			}
			catch (Exception e)
			{
			}
		}
		//No NEI, no change
		return 0;
	}
}
