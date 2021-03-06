package dqr.entity.mobEntity.monsterTensei;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmMonster;

public class DqmEntityMaaburun extends DqmMobBaseTensei
{

	public DqmEntityMaaburun(World world)
	{
		super(world, EnumDqmMonster.MAABURUN );

		//this.monsterType = EnumDqmMonster.MAABURUN;

		/*
		this.MobClassName = this.monsterType.getMobClassName();
		this.MobName = this.monsterType.getMobName();
		this.MobCateg = this.monsterType.getMobCateg();
		this.DqmMobEXP = DQR.funcMob.getCalcEXP(this.monsterType.getEXP());
		this.DqmMobGOLD = DQR.funcMob.getCalcGOLD(this.monsterType.getGOLD());
		this.DqmMobMP = this.monsterType.getMP();
		this.DqmMobPW = DQR.funcMob.getCalcPW(this.monsterType.getPW());
		this.DqmMobDEF = this.monsterType.getDF();
		this.CFIRE = this.monsterType.isCFIRE();
		this.CPET = this.monsterType.getCPET();
		this.CAI = this.monsterType.isCAI();
		this.CTENSEI = this.monsterType.getCTENSEI();
		this.CTENSEIsp = DQR.funcMob.getCalcTENSEIsp(this.monsterType.getCTENSEIsp());
		this.KougekiPat = this.monsterType.getKougekiPat();
		this.TenseiMob = this.monsterType.getTenseiMob();
		this.TenseiMin = this.monsterType.getTenseiMin();
		this.TenseiMax = this.monsterType.getTenseiMax();
		this.MobRoot = this.monsterType.getMobRoot();
		this.KakuseiMob = this.monsterType.getKakuseiMob();


		this.experienceValue = this.monsterType.getXPS();
		*/

	}

	/*
	 * AIを使うかどうか.
	 * 今回は使うのでtrueを返している.
	 */
	@Override
	public boolean isAIEnabled()
	{
		return EnumDqmMonster.MAABURUN.isCAI();
	}

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(DQR.funcMob.getCalcSPEED(EnumDqmMonster.MAABURUN.getSPEED()));
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP(EnumDqmMonster.MAABURUN.getHP()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(EnumDqmMonster.MAABURUN.getPW()));
	}

	@Override
    public int getTotalArmorValue()
    {
        return EnumDqmMonster.MAABURUN.getDF();
    }



	@Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (DQR.funcMob.getCalcDROP(4, 1))
        {
            this.dropItem(DQMiscs.itemNage, 1);
        }
        if (DQR.funcMob.getCalcDROP(4, 1))
        {
            this.dropItem(DQMiscs.itemTume, 1);
        }
        if (DQR.funcMob.getCalcDROP(8, 1))
        {
            this.dropItem(Items.ender_eye, 1);
        }
        if (DQR.funcMob.getCalcDROP(4, 1))
        {
            this.dropItem(Items.ender_pearl, 1);
        }
        if (DQR.funcMob.getCalcDROP(1, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal5, 1);
        }
        if (DQR.funcMob.getCalcDROP(5, 1))
        {
            this.dropItem(DQWeapons.itemKoorinotume, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemSeinarusizuku, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemSinkanohiseki, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemRyuunohizake, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemTensinosoma, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemKenjanoseisui, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemUraminohouju, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQIngots.itemMisriru2, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQIngots.itemTaiyounoisi2, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQIngots.itemOriharukon2, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemGenmaseki, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemPisaronotamasii, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemMahounokagi, 1);
        }
        if (DQR.funcMob.getCalcDROP(50, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(50, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori0, 1);
        }
        if (DQR.funcMob.getCalcDROP(100, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori1, 1);
        }
        if (DQR.funcMob.getCalcDROP(200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori2, 1);
        }
        if (DQR.funcMob.getCalcDROP(400, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori3, 1);
        }
        if (DQR.funcMob.getCalcDROP(800, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori4, 1);
        }
        if (DQR.funcMob.getCalcDROP(1600, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori5, 1);
        }
        if (DQR.funcMob.getCalcDROP(3200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori6, 1);
        }
        if (DQR.funcMob.getCalcDROP(6400, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori7, 1);
        }
        if (DQR.funcMob.getCalcDROP(12800, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori8, 1);
        }
        if (DQR.funcMob.getCalcDROP(25600, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori9, 1);
        }
        if (DQR.funcMob.getCalcDROP(51200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori10, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakabuto, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakabuto, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakote, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakutu, 1);
        }
    }
}

