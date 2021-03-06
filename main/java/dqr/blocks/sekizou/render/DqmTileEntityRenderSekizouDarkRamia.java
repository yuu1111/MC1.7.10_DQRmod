package dqr.blocks.sekizou.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizou;
import dqr.entity.mobEntity.model.DqmModelRamia;

@SideOnly(Side.CLIENT)
public class DqmTileEntityRenderSekizouDarkRamia extends DqmTileEntityRenderSekizou
{
    //モデル
    private DqmModelRamia model = new DqmModelRamia();

    private float fixA = 0;
    private float fixB = 1.7F;
    private float fixC = 0;
    private float fixD = 1.7F;
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Sekihi.png");

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        //エンティティ
    	DqmTileEntitySekizou var9 = (DqmTileEntitySekizou)var1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + (1.5F * fixB) + fixA, (float)var6 + 0.5F);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

        if (var9.getBlockMetadata() == 1)
        {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var9.getBlockMetadata() == 2)
        {
            GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var9.getBlockMetadata() == 3)
        {
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
        }

        //テクスチャー
        this.bindTexture(DqmMobTexture);

        GL11.glPushMatrix();
        this.model.modelRender((0.0625F * fixD) + fixC);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
