package dqr.entity.mobEntity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import dqr.entity.mobEntity.model.DqmModelBiped;

public class DqmRenderBiped extends RenderLiving
{
	/*
	 * テクスチャへのResourceLocationを設定する.
	 */
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Biped.png");

	public DqmRenderBiped()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new DqmModelBiped(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1EntityLiving) {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		return this.DqmMobTexture;
	}
}
