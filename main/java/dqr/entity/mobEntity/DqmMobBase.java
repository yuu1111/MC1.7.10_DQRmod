package dqr.entity.mobEntity;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import dqr.DQR;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMobRoot;
import dqr.api.enums.EnumDqmMobSkilProp;
import dqr.api.enums.EnumDqmMonster;
import dqr.api.enums.EnumDqmMonsterAI;
import dqr.api.enums.EnumDqmMonsterAIrate;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.event.DqrDamageMobEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityBegiragon;
import dqr.entity.magicEntity.magic.MagicEntityBegirama;
import dqr.entity.magicEntity.magic.MagicEntityDebuff;
import dqr.entity.magicEntity.magic.MagicEntityDoruma;
import dqr.entity.magicEntity.magic.MagicEntityGira;
import dqr.entity.magicEntity.magic.MagicEntityGiragureido;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityHyadoB;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeraB;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMeragaiaB;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMeramiB;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityMerazomaB;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.entity.magicEntity.magic.MagicEntityZaki;
import dqr.entity.magicEntity.magicDummy.MagicEntityBuffDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityHoimiDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityMahoimiDummy;
import dqr.entity.mobEntity.ai.EntityAIArrowAttack2;
import dqr.entity.mobEntity.ai.EntityAIAttackOnCollide2;
import dqr.entity.mobEntity.ai.EntityAIAttackOnCollideJump;
import dqr.entity.mobEntity.ai.EntityAIAvoidEntity2;
import dqr.entity.mobEntity.ai.EntityAIBind;
import dqr.entity.mobEntity.ai.EntityAIMagicAttack4;
import dqr.entity.mobEntity.ai.EntityAIMagicBehomara;
import dqr.entity.mobEntity.ai.EntityAIMagicBuff;
import dqr.entity.mobEntity.ai.EntityAIMagicDebuff;
import dqr.entity.mobEntity.ai.EntityAIMagicHoimi;
import dqr.entity.mobEntity.ai.EntityAIMagicMahoimi;
import dqr.entity.mobEntity.ai.EntityAIMagicMegante;
import dqr.entity.mobEntity.ai.EntityAINearestAttackableTarget2;
import dqr.entity.mobEntity.ai.EntityAINearestTargetHeavyFire;
import dqr.entity.mobEntity.ai.EntityAIWatchClosest3;
import dqr.entity.npcEntity.npc.DqmEntityNPCGuntai;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmMobBase extends EntityMob
{
	public EnumDqmMonster monsterType;

	public String MobClassName;
	public String MobName;
	public String MobCateg;
	public int DqmMobEXP;
	public int DqmMobGOLD;
	public double DqmMobHP;
	public int DqmMobMP;
	public int DqmMobMaxMP;
	public double DqmMobPW;
	public int DqmMobDEF;
	//public float SPEED;
	public int XPS;
	public boolean CFIRE;
	public int CPET;
	public boolean CAI;
	public int CTENSEI;
	public int CTENSEIsp;
	public int KougekiPat;
	public String TenseiMob;
	public int TenseiMin;
	public int TenseiMax;
	public EnumDqmMobRoot MobRoot;
	public String KakuseiMob;
	public int DqmMobKaisin = 3;
	public int DqmMobKaisinMin = 2;
	public int DqmMobKaisinMax = 4;

	public int DqmMobMikawasi = 0;

	public int DqmMobTENSEI;

	public EnumDqmMonsterAI mobAI;
	public EnumDqmMonsterAIrate mobAIrate;

	public Hashtable damageHT;

	public boolean MeganteFlg = false;
	public int MeganteCnt = 0;
	public boolean dqmBypassArmor = false;

	public boolean isBind = false;
	public boolean isClearTasks = false;

	protected EntityAIBind aiBind = new EntityAIBind(this);

	Random rand = new Random();

	public boolean noAI = false;

	public boolean isFirstAttack = true;
	public boolean isOverKill = false;
	public float absoluteDam = -1.0F;

	public long skillCoolTime = 0;
	public int skillCoolTimeMin = 10;
	public int skillCoolTimeMax = 15;
	public long skillCoolTimeHeal = 0;
	public int skillCoolTimeHealMin = 60;
	public int skillCoolTimeHealMax = 150;

	public boolean flgSpawnFromSpawner = false;
	public boolean flgGetKaisinDam = false;

	private NBTTagCompound dqrPotionEffects =  new NBTTagCompound();

	public int petRefuseFlg = 0;

	public DqmMobBase(World world, EnumDqmMonster mobType)
	{
		super(world);
		this.monsterType = mobType;
		damageHT = new Hashtable();

		this.MobClassName = this.monsterType.getMobClassName();
		this.MobName = this.monsterType.getMobName();
		this.MobCateg = this.monsterType.getMobCateg();
		this.DqmMobEXP = DQR.funcMob.getCalcEXP(this.monsterType.getEXP());
		this.DqmMobGOLD = DQR.funcMob.getCalcGOLD(this.monsterType.getGOLD());
		//this.DqmMobMP = this.monsterType.getMP();
		this.DqmMobMaxMP = this.monsterType.getMaxMP();
		if(this.monsterType.getMaxMP() != -1)
		{
			this.DqmMobMP = this.monsterType.getMaxMP();
		}
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

		EnumDqmMobSkilProp skillProp = DQR.enumGetter.getEnumDqmMobSkilProp(this.MobName);
		if(skillProp != null)
		{
			//System.out.println("magicPropSet!!");
			skillCoolTimeMin = skillProp.getCoolTimeMin();
			skillCoolTimeMax = skillProp.getCoolTimeMax();
			skillCoolTimeHealMin = skillProp.getCTHealMin();
			skillCoolTimeHealMax = skillProp.getCTHealMax();
		}

		this.experienceValue = this.monsterType.getXPS();
		this.mobAI = this.monsterType.getMonsterAI();
		this.mobAIrate = this.monsterType.getMonsterAIrate();


        tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        //this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        //this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));


		if(this.mobAI.getAvoid() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getAvoid(), new EntityAIAvoidEntity2(this, EntityPlayer.class, (float)this.mobAI.getAvoid(), 1.0D, 2.0D));
		}



        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest3(this, DqmPetBase.class, 3.0F));
        //this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

        if(this.mobAI.getHeavyFire() > 0)
        {
        	this.targetTasks.addTask(2, new EntityAINearestTargetHeavyFire(this, EntityPlayer.class, 20, true));
        	this.targetTasks.addTask(2, new EntityAINearestTargetHeavyFire(this, DqmPetBase.class, 20, true));
        }
        else
        {
        	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget2(this, EntityPlayer.class, 25, true));
        	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget2(this, DqmPetBase.class, 25, true));
        }

        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget2(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget2(this, DqmPetBase.class, 0, true));
		/*
		 * 近接攻撃を行うAIを追加する.
		 * EntityAIAttackOnCollideの引数のうち, 末尾2つは(攻撃距離, ずっと追い続けるかどうか)
		 */

		//this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));

		/*
		 * うろうろ移動するAIの追加
		 */
		this.tasks.addTask(8, new EntityAIWander(this, 1.0D));

		/*
		 * 見回すAIの追加
		 */
		this.tasks.addTask(6, new EntityAILookIdle(this));

		/*
		 * 攻撃されたら反撃するAIを追加する.
		 * EntityAIHurtByTargetの第二引数は反撃時に周りのMobに助けを求めるかどうか
		 */
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		/*
		 * 周囲に特定のEntityがいる場合, ターゲッティングするAI.
		 * EntityAINearestAttackableTargetの最後の引数は視界で遮るかどうか.
		 * trueだとブロックに囲われた(ガラスブロックでも)村人はターゲットにならない.
		 * falseだとどんなブロックに囲まれていようとターゲットにする(ゾンビと同じ).
		 */
		//this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));

        if (world != null && !world.isRemote)
        {
            this.setCombatTask();
            this.noAI = false;
        }

	}

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 2;
    }

    /*
    public void updateEntityActionState()
    {
    	if(DQR.func.isBind(this))
    	{
    		return;
    	}

    	super.updateEntityActionState();
    }

    public void onLivingUpdate()
    {
    	if(DQR.func.isBind(this))
    	{
    		return;
    	}

    	super.onLivingUpdate();
    }
    */

    public void clearTasks()
    {
    	//System.out.println("戦闘モードを解除しました");
    	for(int cnt = 0; cnt < this.tasks.taskEntries.size(); cnt++)
    	{

            EntityAITasks.EntityAITaskEntry entityaitaskentry = (EntityAITasks.EntityAITaskEntry)this.tasks.taskEntries.get(cnt);
            EntityAIBase entityaibase1 = entityaitaskentry.action;
            entityaibase1.resetTask();
            //System.out.println("remove!!" + entityaibase1.toString());
    		this.tasks.removeTask(entityaibase1);
    	}

    	for(int cnt = 0; cnt < this.targetTasks.taskEntries.size(); cnt++)
    	{

            EntityAITasks.EntityAITaskEntry entityaitaskentry = (EntityAITasks.EntityAITaskEntry)this.targetTasks.taskEntries.get(cnt);
            EntityAIBase entityaibase1 = entityaitaskentry.action;
            entityaibase1.resetTask();
            //System.out.println("remove!!" + entityaibase1.toString());
    		this.tasks.removeTask(entityaibase1);
    	}

    	this.tasks.addTask(2, this.aiBind);
    	this.isClearTasks = true;
    }

    public void setDefaultTask()
    {
    	tasks.addTask(1, new EntityAISwimming(this));
    	this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		if(this.mobAI.getAvoid() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getAvoid(), new EntityAIAvoidEntity2(this, EntityPlayer.class, (float)this.mobAI.getAvoid(), 1.0D, 2.0D));
		}

        if(this.mobAI.getHeavyFire() > 0)
        {
        	this.targetTasks.addTask(2, new EntityAINearestTargetHeavyFire(this, EntityPlayer.class, 20, true));
        	this.targetTasks.addTask(2, new EntityAINearestTargetHeavyFire(this, DqmPetBase.class, 20, true));
        }
        else
        {
        	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget2(this, EntityPlayer.class, 25, true));
        	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget2(this, DqmPetBase.class, 25, true));
        }

        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget2(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget2(this, DqmPetBase.class, 0, true));
		/*
		 * 近接攻撃を行うAIを追加する.
		 * EntityAIAttackOnCollideの引数のうち, 末尾2つは(攻撃距離, ずっと追い続けるかどうか)
		 */

		//this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));

		/*
		 * うろうろ移動するAIの追加
		 */
		this.tasks.addTask(8, new EntityAIWander(this, 1.0D));

		/*
		 * 見回すAIの追加
		 */
		this.tasks.addTask(6, new EntityAILookIdle(this));

		/*
		 * 攻撃されたら反撃するAIを追加する.
		 * EntityAIHurtByTargetの第二引数は反撃時に周りのMobに助けを求めるかどうか
		 */
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    public void setCombatTask()
    {
    	//System.out.println("ARROW");
    	if(this.mobAI.getArrow() > 0)
    	{
    		//System.out.println("ARROW");
    		this.tasks.addTask(2, new EntityAIArrowAttack2(this, 1.2D, this.mobAIrate.getArrow(), this.mobAI.getArrow(), 20.0F));
    		//this.tasks.addTask(3, new EntityAIArrowAttack2(this, 1.0D, 20, 60, 15.0F));
    		//this.tasks.removeTask(new EntityAIAttackOnCollide2(this, EntityPlayer.class, 1.5D, true));
    	}else
    	{
    		this.tasks.addTask(1, new EntityAIAttackOnCollide2(this, EntityPlayer.class, 1.5D, true));
    		this.tasks.addTask(1, new EntityAIAttackOnCollide2(this, DqmPetBase.class, 1.5D, true));
    	}

    	if(this.mobAI.getHonoo() > 0)
		{
    		switch(this.mobAI.getHonoo())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getHonoo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hinoiki)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getHonoo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kaeniki)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getHonoo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.HagesiiHonoo)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getHonoo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Syakunetu)); break;
    			case 5:this.tasks.addTask(this.mobAIrate.getHonoo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.RengokuHonoo)); break;
    		}
		}

        if (this.mobAI.getJump() > 0)
        {
        	this.tasks.addTask(1, new EntityAIAttackOnCollideJump(this, EntityPlayer.class, 1.5D, true));
        	this.tasks.addTask(2, new EntityAIAttackOnCollideJump(this, DqmPetBase.class, 1.5D, true));
        }

    	if(this.mobAI.getHubuki() > 0)
		{
    		switch(this.mobAI.getHubuki())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getHubuki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Tumetaiiki)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getHubuki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Koorinoiki)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getHubuki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kogoeruhubuki)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getHubuki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kagayakuiki)); break;
    			case 5:this.tasks.addTask(this.mobAIrate.getHubuki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zettaireido)); break;
    		}
		}

    	if(this.mobAI.getGira() > 0)
		{
    		switch(this.mobAI.getGira())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getGira(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Gira)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getGira(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Begirama)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getGira(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Begiragon)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getGira(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Giragureido)); break;
    		}
		}

		if(this.mobAI.getMera() > 0)
		{
    		switch(this.mobAI.getMera())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getMera(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mera)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getMera(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Merami)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getMera(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Merazoma)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getMera(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Meragaia)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getMera(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mera));
		}

		if(this.mobAI.getIo() > 0)
		{
	   		switch(this.mobAI.getIo())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getIo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Io)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getIo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Iora)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getIo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Ionazun)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getIo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Iogurande)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getIo(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Io));
		}

		if(this.mobAI.getRaidein() > 0)
		{
	   		switch(this.mobAI.getRaidein())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getRaidein(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Raidein)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getRaidein(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Gigadein)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getRaidein(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Minadein)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getRaidein(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Raidein));
		}

		if(this.mobAI.getBagi() > 0)
		{
	   		switch(this.mobAI.getBagi())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getBagi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagi)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getBagi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagima)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getBagi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagikurosu)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getBagi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagimutyo)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getBagi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagi));
		}

		if(this.mobAI.getDoruma() > 0)
		{
	   		switch(this.mobAI.getDoruma())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getDoruma(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Doruma)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getDoruma(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorukuma)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getDoruma(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorumoa)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getDoruma(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorumadon)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getDoruma(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Doruma));
		}

		if(this.mobAI.getHyado() > 0)
		{
	   		switch(this.mobAI.getHyado())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getHyado(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyado)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getHyado(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyadaruko)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getHyado(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahyado)); break;
    			case 4:this.tasks.addTask(this.mobAIrate.getHyado(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahyadodesu)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getHyado(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyado));
		}

		if(this.mobAI.getHoimi() > 0)
		{
	   		switch(this.mobAI.getHoimi())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getHoimi(), new EntityAIMagicHoimi(this, EnumDqmMagic.Hoimi, null)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getHoimi(), new EntityAIMagicHoimi(this, EnumDqmMagic.Behoimi, null)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getHoimi(), new EntityAIMagicHoimi(this, EnumDqmMagic.Behoma, null)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getHoimi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hoimi));
		}

		if(this.mobAI.getZaki() > 0)
		{
			//System.out.println("GetZaki");
	   		switch(this.mobAI.getZaki())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getZaki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaki)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getZaki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaraki)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getZaki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zarakima)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getZaki(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaki));
		}

		if(this.mobAI.getBaikiruto() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getBaikiruto(), new EntityAIMagicBuff(this, EnumDqmMagic.Baikiruto, DQPotionPlus.buffBaikiruto));
		}

		if(this.mobAI.getSukara() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getSukara(), new EntityAIMagicBuff(this, EnumDqmMagic.Sukara, DQPotionPlus.buffSukara));
		}

		if(this.mobAI.getBaha() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getBaha(), new EntityAIMagicBuff(this, EnumDqmMagic.Baha, DQPotionPlus.buffBaha));
		}

		if(this.mobAI.getPiora() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getPiora(), new EntityAIMagicBuff(this, EnumDqmMagic.Piora, DQPotionPlus.buffPiora));
		}

		if(this.mobAI.getMagicbaria() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getMagicbaria(), new EntityAIMagicBuff(this, EnumDqmMagic.Magicbaria, DQPotionPlus.buffMagicBaria));
		}

		if(this.mobAI.getMahokanta() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getMahokanta(), new EntityAIMagicBuff(this, EnumDqmMagic.Mahokanta, DQPotionPlus.buffMahokanta));
		}

		if(this.mobAI.getBomie() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getBomie(), new EntityAIMagicDebuff(this, EnumDqmMagic.Bomie, DQPotionMinus.debuffBomie));
		}

		if(this.mobAI.getRariho() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getRariho(), new EntityAIMagicDebuff(this, EnumDqmMagic.Rariho, DQPotionMinus.debuffRariho));
		}

		if(this.mobAI.getManusa() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getManusa(), new EntityAIMagicDebuff(this, EnumDqmMagic.Manusa, DQPotionMinus.debuffManusa));
		}

		if(this.mobAI.getMahoton() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getMahoton(), new EntityAIMagicDebuff(this, EnumDqmMagic.Mahoton, DQPotionMinus.debuffMahoton));
		}

		if(this.mobAI.getRukani() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getRukani(), new EntityAIMagicDebuff(this, EnumDqmMagic.Rukani, DQPotionMinus.debuffRukani));
		}

		if(this.mobAI.getMedapani() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getMedapani(), new EntityAIMagicDebuff(this, EnumDqmMagic.Medapani, DQPotionMinus.debuffMedapani));
		}

		if(this.mobAI.getHenatosu() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getHenatosu(), new EntityAIMagicDebuff(this, EnumDqmMagic.Henatosu, DQPotionMinus.debuffHenatosu));
		}

		if(this.mobAI.getDivainsuperu() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getDivainsuperu(), new EntityAIMagicDebuff(this, EnumDqmMagic.Divainsuperu, DQPotionMinus.debuffDivainsuperu));
		}

		if(this.mobAI.getRukanan() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getRukanan(), new EntityAIMagicDebuff(this, EnumDqmMagic.Rukanan, DQPotionMinus.debuffRukani));
		}

		if(this.mobAI.getRarihoma() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getRarihoma(), new EntityAIMagicDebuff(this, EnumDqmMagic.Rarihoma, DQPotionMinus.debuffRariho));
		}

		if(this.mobAI.getBomiosu() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getBomiosu(), new EntityAIMagicDebuff(this, EnumDqmMagic.Bomiosu, DQPotionMinus.debuffBomie));
		}

		if(this.mobAI.getSukuruto() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getSukuruto(), new EntityAIMagicBuff(this, EnumDqmMagic.Sukuruto, DQPotionPlus.buffSukara));
		}

		if(this.mobAI.getPiorimu() > 0)
		{
			this.tasks.addTask(this.mobAIrate.getPiorimu(), new EntityAIMagicBuff(this, EnumDqmMagic.Piorimu, DQPotionPlus.buffPiora));
		}

		//DQR.func.debugString("TEST??1", this.getClass());
		if(this.mobAI.getBehomara() > 0)
		{
			//DQR.func.debugString("TEST??2 : " + this.mobAI.getBehomara(), this.getClass());
	   		switch(this.mobAI.getBehomara())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getBehomara(), new EntityAIMagicBehomara(this, EnumDqmMagic.Behomara, null)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getBehomara(), new EntityAIMagicBehomara(this, EnumDqmMagic.Behomazun, null)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getBehomara(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Behomara));
		}

		if(this.mobAI.getMahoimi() > 0)
		{
	   		switch(this.mobAI.getMahoimi())
    		{
    			case 1:this.tasks.addTask(this.mobAIrate.getMahoimi(), new EntityAIMagicMahoimi(this, EnumDqmMagic.Mahoimi, null)); break;
    			case 2:this.tasks.addTask(this.mobAIrate.getMahoimi(), new EntityAIMagicMahoimi(this, EnumDqmMagic.Mahoriku, null)); break;
    			case 3:this.tasks.addTask(this.mobAIrate.getMahoimi(), new EntityAIMagicMahoimi(this, EnumDqmMagic.Mahoizun, null)); break;
    		}
			//this.tasks.addTask(this.mobAIrate.getMahoimi(), new EntityAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahoimi));
		}
    }

	/*
	 * AIを使うかどうか.
	 * 今回は使うのでtrueを返している.
	 */
    /*
	@Override
	public boolean isAIEnabled()
	{
		return this.monsterType.isCAI();
	}
	*/

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	/*
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.monsterType.getSPEED());
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP(this.monsterType.getHP()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(this.monsterType.getPW()));
	}


	@Override
    public int getTotalArmorValue()
    {
        return this.monsterType.getDF();
    }
	*/

	@Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        //return
        long safetyTime = (long)DQR.conf2.spawnTimeDelay;

        //DQR.func.debugString("TIME : " + safetyTime + " / " + this.worldObj.getWorldTime());
        if(this.worldObj.getWorldTime() < safetyTime)
        {
        	//DQR.func.debugString("TIME2 : ");
        	return false;
        }

        return this.worldObj.checkNoEntityCollision(this.boundingBox) &&
          	   this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() &&
          	   !this.worldObj.isAnyLiquid(this.boundingBox) &&
          	   this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

	@Override
    protected boolean func_146066_aG()
    {
        return true;
    }

	/*
	 * 	@Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        //return

        return this.worldObj.checkNoEntityCollision(this.boundingBox) &&
        	   this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() &&
        	   !this.worldObj.isAnyLiquid(this.boundingBox) &&
        	   this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
        	   //this.isValidLightLevel() && super.getCanSpawnHere();
    }
    */

	public void setDamageHT(EntityPlayer ep, float par1, float par2)
	{
    	//System.out.println("DEBUGLINE:" + ep.getCommandSenderName() + "/" + par1 + "/" + this.getHealth());
		float setDam = par1;
		//DQR.func.debugString("DamageHT1:" + setDam);
		if (par1 > par2)
		{
			setDam =par2;
		}

		if(ep != null && damageHT != null && damageHT.containsKey(ep))
		{
			setDam = setDam + (float)damageHT.get(ep);
		}

		if(ep != null && damageHT != null)
		{
			damageHT.put(ep, setDam);
		}
		//damageHT.put(ep, setDam);
		//DQR.func.debugString("DamageHT1:" + setDam + "/" + ep.getDisplayName());
	}

	public void setDamageHT(DqmPetBase ep, float par1, float par2)
	{
    	//System.out.println("DEBUGLINE:" + ep.getCommandSenderName() + "/" + par1 + "/" + this.getHealth());
		float setDam = par1;
		//DQR.func.debugString("DamageHT1:" + setDam);
		if (par1 > par2)
		{
			setDam =par2;
		}

		if(damageHT.containsKey(ep))
		{
			setDam = setDam + (float)damageHT.get(ep);
		}

		//damageHT.put(ep, setDam);
		if(ep != null && damageHT != null)
		{
			damageHT.put(ep, setDam);
		}
		//DQR.func.debugString("DamageHT1:" + setDam + "/" + ep.getDisplayName());
	}

	public void doExpGet()
	{
		Enumeration htKey = damageHT.keys();
		EntityPlayer ep;
		DqmPetBase pet;
		float sharePercent;
		float hitDamage;
		int getExpVal;

        while (htKey.hasMoreElements())
        {
        	Object element = htKey.nextElement();
        	if(element instanceof EntityPlayer)
	        {
	            //ep = (EntityPlayer)element;
				MinecraftServer minecraftserver = MinecraftServer.getServer();
				ep = minecraftserver.getConfigurationManager().func_152612_a(((EntityPlayer) element).getCommandSenderName());

				if(ep != null)
				{
		            //DQR.func.debugString("doExp:" + ep.getDisplayName());
		            hitDamage = (float)damageHT.get(ep);
		            //DQR.func.debugString("doExp2:" + hitDamage);
		            sharePercent = hitDamage * 1000 / this.getMaxHealth();
		            //DQR.func.debugString("doExp3:" + sharePercent);
		            getExpVal = DQR.funcMob.getCalcEXP(this.DqmMobEXP) * (int)(sharePercent + 0.9F) / 1000;
		            //DQR.func.debugString("doExp4:" + getExpVal);
		            ItemStack handItem = null;

		            if(ep.inventory.getCurrentItem() != null)
		            {
		            	handItem = ep.inventory.getCurrentItem();
		            }

		            if(getExpVal < 1)
		            {
		            	getExpVal = 1;
		            }

		            DQR.partyManager.doExpShare(ep, getExpVal);
		            /*
		            getExpVal = getExpVal + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());
		            //DQR.func.debugString("doExp5:" + getExpVal);
		            ExtendedPlayerProperties.get(ep).setJobExp(ExtendedPlayerProperties.get(ep).getJob(), getExpVal);

		            if(DQR.conf.cfg_NoThreadUse == 1)
		            {
		            	ThreadLvUp lvup = new ThreadLvUp(ep);
		            	lvup.start();
		            }else
		            {
		            	NoThreadProcess proc = new NoThreadProcess();
		            	proc.doLevelUp(ep);
		            }
		            */
				}

	        }else if(element instanceof DqmPetBase)
	        {
	            pet = (DqmPetBase)element;
	            //DQR.func.debugString("doExp:" + ep.getDisplayName());
	            hitDamage = (float)damageHT.get(pet);
	            //DQR.func.debugString("doExp2:" + hitDamage);
	            sharePercent = hitDamage * 1000 / this.getMaxHealth();
	            //DQR.func.debugString("doExp3:" + sharePercent);
	            getExpVal = DQR.funcMob.getCalcEXP(this.DqmMobEXP) * (int)(sharePercent + 0.9F) / 1000;
	            //DQR.func.debugString("doExp4:" + getExpVal);
	            //ItemStack handItem = null;

	            /*
	            if(ep.inventory.getCurrentItem() != null)
	            {
	            	handItem = ep.inventory.getCurrentItem();
	            }
	            */
	            if(getExpVal < 1)
	            {
	            	getExpVal = 1;
	            }

	            DQR.partyManager.doExpShare(pet, getExpVal);
	            /*
	            if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
	            {
	            	ep = (EntityPlayer)pet.getOwner();
	            	int tmpExpVal = 0;
	            	if(getExpVal * 0.05F < 1)
	            	{
	            		 tmpExpVal = 1 + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());

	            	}else
	            	{
	            		tmpExpVal = (int)(getExpVal * 0.05F) + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());
	            	}

            		ExtendedPlayerProperties.get(ep).setJobExp(ExtendedPlayerProperties.get(ep).getJob(), tmpExpVal);
    	            //ThreadLvUp lvup = new ThreadLvUp(ep);
    	            //lvup.start();
    	            if(DQR.conf.cfg_NoThreadUse == 1)
    	            {
    	            	ThreadLvUp lvup = new ThreadLvUp(ep);
    	            	lvup.start();
    	            }else
    	            {
    	            	NoThreadProcess proc = new NoThreadProcess();
    	            	proc.doLevelUp(ep);
    	            }
	            }

	            getExpVal = getExpVal + pet.getJobExp(pet.getJob());
	            //DQR.func.debugString("doExp5:" + getExpVal);
	            pet.setJobExp(pet.getJob(), getExpVal);
	            //ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
	            //lvup.start();

	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
		            ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
		            lvup.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doLevelUpPet(pet);
	            }
	            */
	        }

            /*
            if(hitDamage > 0)
            {
            	int getJukurenLv;
            	int getJukurenExp;
            	if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
            									  ExtendedPlayerProperties.get(ep).getWeapon()) > 0)
            	{
	            	getJukurenExp = 1 + ExtendedPlayerProperties.get(ep).getJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon());
	            	ExtendedPlayerProperties.get(ep).setJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon(), getJukurenExp);
            	}else if((handItem != null && (handItem.getItem() instanceof ItemSword || handItem.getItem() instanceof ItemBow)) &&
            			 DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
						 EnumDqmWeapon.DqmVanillaS.getId()) > 0)
				{
					getJukurenExp = 1 + ExtendedPlayerProperties.get(ep).getJukurenExp(EnumDqmWeapon.DqmVanillaS.getId());
					ExtendedPlayerProperties.get(ep).setJukurenExp(EnumDqmWeapon.DqmVanillaS.getId(), getJukurenExp);
				}else if(handItem != null && handItem.getItem() instanceof DqmItemMagicBase)
            	{
            		int[] magicTable = DQR.magicTable.getMagicLvTable(handItem.getItem());
            		if(magicTable != null && magicTable[ExtendedPlayerProperties.get(ep).getJob()] > 0)
            		{
    	            	getJukurenExp = 1 + ExtendedPlayerProperties.get(ep).getJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon());
    	            	ExtendedPlayerProperties.get(ep).setJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon(), getJukurenExp);
            		}
            	}else
            	{
            		if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
            				EnumDqmWeapon.DqmNoHand.getId()) > 0)
					{
						getJukurenExp = 1 + ExtendedPlayerProperties.get(ep).getJukurenExp(EnumDqmWeapon.DqmNoHand.getId());
						ExtendedPlayerProperties.get(ep).setJukurenExp(EnumDqmWeapon.DqmNoHand.getId(), getJukurenExp);
					}
            	}

                ThreadJukurenUp jukurenUp = new ThreadJukurenUp(ep);
                jukurenUp.start();
            }
            */
        }
	}

	public void doGoldGet()
	{
		Enumeration htKey = damageHT.keys();
		EntityPlayer ep;
		DqmPetBase pet;
		float sharePercent;
		float hitDamage;
		int getGoldVal;
        while (htKey.hasMoreElements())
        {
        	Object element = htKey.nextElement();
        	if(element instanceof EntityPlayer)
        	{
	            ep = (EntityPlayer)element;
	            //DQR.func.debugString("doGold:" + ep.getDisplayName());
	            hitDamage = (float)damageHT.get(ep);
	            //DQR.func.debugString("doGold2:" + hitDamage);
	            sharePercent = hitDamage * 1000 / this.getMaxHealth();
	            //DQR.func.debugString("doGold3:" + sharePercent);
	            getGoldVal = this.DqmMobGOLD * (int)(sharePercent + 0.9F) / 1000;
	            //DQR.func.debugString("doGold4:" + sharePercent);
	            if(getGoldVal < 1)
	            {
	            	getGoldVal = 1;
	            }
	            getGoldVal = getGoldVal + ExtendedPlayerProperties.get(ep).getGold();
	            //DQR.func.debugString("doGold5:" + getGoldVal);
	            ExtendedPlayerProperties.get(ep).setGold(getGoldVal);
        	}else if(element instanceof DqmPetBase)
        	{
        		pet = (DqmPetBase)element;
	            hitDamage = (float)damageHT.get(pet);
	            sharePercent = hitDamage * 1000 / this.getMaxHealth();
	            getGoldVal = this.DqmMobGOLD * (int)(sharePercent + 0.9F) / 1000;
	            if(getGoldVal < 1)
	            {
	            	getGoldVal = 1;
	            }

	            if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
	            {
	            	ep = (EntityPlayer)pet.getOwner();

		            getGoldVal = getGoldVal + ExtendedPlayerProperties.get(ep).getGold();
		            //DQR.func.debugString("doGold5:" + getGoldVal);
		            ExtendedPlayerProperties.get(ep).setGold(getGoldVal);
	            }
        	}
        }
	}

	@Override
    public void damageEntity(DamageSource source, float p_70665_2_)
    {
		if(this.getHealth() <= 0.0F || this.isDead)
		{
			//死亡判定
			return;
		}

		EntityLivingBase attacker = null;
		if(source.getEntity() instanceof EntityLivingBase)
		{
			attacker = (EntityLivingBase)source.getEntity();
		}else if(source.getSourceOfDamage() instanceof EntityLivingBase)
		{
			attacker = (EntityLivingBase)source.getSourceOfDamage();
		}


		if(attacker instanceof EntityPlayer)
		{
			int refFlg = ExtendedPlayerProperties.get((EntityPlayer)attacker).getPetRefuse();
			DQR.func.debugString("RefFle : " + refFlg + " / " + this.petRefuseFlg, this.getClass(), 3);
			if(refFlg == 1 && this.petRefuseFlg == 0  && DQR.conf.permPetRefCommand == 1)
			{
				this.petRefuseFlg = 2;
			}else
			{
				if(refFlg == 1 && this.petRefuseFlg == 2)
				{
					;
				}else
				{
					this.petRefuseFlg = 1;
				}
			}
		}
//DQR.func.debugString("damageEntity1:" + this.hurtResistantTime);
		this.absoluteDam = -1.0F;
		boolean skillFlg = false;

		//DQR.func.debugString("damageEntity1:");
    	//System.out.println("testB:" + p_70665_2_);
        //if (!this.isEntityInvulnerable() || source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()))
		if (!this.isEntityInvulnerable())
        {
			DqrDamageMobEvent event = new DqrDamageMobEvent(1, attacker, this, source, skillFlg, p_70665_2_, absoluteDam);
			MinecraftForge.EVENT_BUS.post(event);
			p_70665_2_ = event.retDamage;
			absoluteDam = event.retAbsoluteDamage;

			Item handItem = null;
    		if(source.getEntity() instanceof EntityPlayer)
    		{
    			EntityPlayer ep = (EntityPlayer)source.getEntity();

    			int refFlg2 = ExtendedPlayerProperties.get(ep).getPetRefuse();
    			DQR.func.debugString("RefFle : " + refFlg2 + " / " + this.petRefuseFlg, this.getClass(), 3);
    			if(refFlg2 == 1 && this.petRefuseFlg == 0 && DQR.conf.permPetRefCommand == 1)
    			{
    				this.petRefuseFlg = 2;
    			}else
    			{
    				if(refFlg2 == 1 && this.petRefuseFlg == 2)
    				{
    					;
    				}else
    				{
    					this.petRefuseFlg = 1;
    				}
    			}

    			int weapon = ExtendedPlayerProperties.get(ep).getWeapon();
    			int weaponSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(weapon);
    			int skillPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weapon, weaponSkill);

    			//System.out.println("test1");
    			if(ep.getHeldItem() != null && source.getDamageType().equalsIgnoreCase("player") && !ep.worldObj.isRemote)
    			{
    				handItem = ep.getHeldItem().getItem();
    				if(handItem == DQWeapons.itemMajinnokanaduti)
    				{
    					//System.out.println("test2");
    					if(rand.nextInt(5) == 0)
    					{
    						//System.out.println("test3");
    						source = DQR.damageSource.getPlayerSpecialDamageCri(ep);
	    					this.dqmBypassArmor = true;
	    					source.setDamageBypassesArmor();
    					}else
    					{
    						//System.out.println("test4");
    						this.absoluteDam = 0.0F;
    						p_70665_2_ = 0.0F;
    					}
    					skillFlg = true;
    				}
    			}


//System.out.println("test1:" + p_70665_2_);
    			EnumDqmSkillW skillW = DQR.enumGetter.getSkillW(weapon, weaponSkill);
				if(skillW != null && skillW.getFunc() == 1 && skillW.getRATE() > rand.nextInt(100))
				{
					//System.out.println("test2");
	    			if(weapon == EnumDqmWeapon.DqmBraveSword.getId() && weaponSkill == 8 && skillPerm != 0)
	    			{
	    				//アルテマソード
	    				if(this.MobRoot.getId() == EnumDqmMobRoot.METARU.getId())
	    				{
	    					//System.out.println("test3");
	    					//EnumDqmSkillW skillW = DQR.enumGetter.getSkillW(weapon, weaponSkill);
	    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
	    					this.dqmBypassArmor = true;
	    					source.setDamageBypassesArmor();
	    					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
	    					skillFlg = true;
	    				}
	    			}else if(weapon == EnumDqmWeapon.DqmAxe.getId() && weaponSkill == 6 && skillPerm != 0)
	    			{
	    				//まじん斬り
    					if(rand.nextInt(2) == 0)
    					{
    						source = DQR.damageSource.getPlayerSkillDamageCri(ep);
	    					this.dqmBypassArmor = true;
	    					source.setDamageBypassesArmor();
    					}else
    					{
    						this.absoluteDam = 0.0F;
    						p_70665_2_ = 0.0F;
    					}
    					skillFlg = true;
    					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

	    			}else if(weapon == EnumDqmWeapon.DqmLance.getId() && weaponSkill == 6 && skillPerm != 0)
	    			{
	    				//一閃づき
    					if(rand.nextInt(2) == 0)
    					{
    						source = DQR.damageSource.getPlayerSkillDamageCri(ep);
	    					this.dqmBypassArmor = true;
	    					source.setDamageBypassesArmor();
    					}else
    					{
    						p_70665_2_ = 0.0F;
    					}

    					skillFlg = true;
    					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
	    			}else if(weapon == EnumDqmWeapon.DqmSoroban.getId() && weaponSkill == 3 && skillPerm != 0)
	    			{

	    				//つまづいて転ぶ
						source = DQR.damageSource.getPlayerSkillDamageCri(ep);
    					this.dqmBypassArmor = true;
    					source.setDamageBypassesArmor();

    					p_70665_2_ = p_70665_2_ * 2.0F;
    					skillFlg = true;
    					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

						if(!ep.worldObj.isRemote)
						{
							ItemStack ist = ep.inventory.getCurrentItem();
							ep.inventory.mainInventory[ep.inventory.currentItem] = null;
							ep.dropPlayerItemWithRandomChoice(ist, true);
						}
	    			}
				}
    		}
//DQR.func.debugString("damageEntity2:" + this.hurtResistantTime);
    		if(source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) ||
    		   source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType()))
    		{
    			skillFlg = true;
    			this.dqmBypassArmor = true;
    		}

        	float prevDamage = p_70665_2_;
        	//System.out.println("testC");
        	float prevHp = this.getHealth();
        	//DQR.func.debugString("damageEntity2:" + prevHp + "/" + p_70665_2_);
        	//DQR.func.debugString("DAMTEST1:" + p_70665_2_);
    		DqrDamageMobEvent event2 = new DqrDamageMobEvent(2, attacker, this, source, skillFlg, p_70665_2_, absoluteDam);
    		MinecraftForge.EVENT_BUS.post(event2);
    		p_70665_2_ = event2.retDamage;
    		absoluteDam = event2.retAbsoluteDamage;

            p_70665_2_ = ForgeHooks.onLivingHurt(this, source, p_70665_2_);
            //DQR.func.debugString("DAMTEST2:" + p_70665_2_);
//DQR.func.debugString("damageEntity3:" + p_70665_2_);
    		DqrDamageMobEvent event3 = new DqrDamageMobEvent(3, attacker, this, source, skillFlg, p_70665_2_, absoluteDam);
    		MinecraftForge.EVENT_BUS.post(event3);
    		p_70665_2_ = event3.retDamage;
    		absoluteDam = event3.retAbsoluteDamage;

            if (p_70665_2_ <= 0) return;


    		p_70665_2_ = this.applyArmorCalculations(source, p_70665_2_);
//DQR.func.debugString("damageEntity3:" + this.hurtResistantTime);
//DQR.func.debugString("damageEntity3A:" + p_70665_2_);
            //DQR.func.debugString("DAMTEST3:" + p_70665_2_);
            p_70665_2_ = this.applyPotionDamageCalculations(source, p_70665_2_);
            //DQR.func.debugString("DAMTEST4:" + p_70665_2_);
            //DQR.func.debugString("DAMTEST2:" + p_70665_2_);
            //スキルダメージ加算
            //if(!skillFlg && !source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()))
//DQR.func.debugString("damageEntity3B:" + p_70665_2_);
            if(!skillFlg && !DQR.damageSource.isDqmSkillDamage(source) && !DQR.damageSource.isDqmSpecialDamage(source))
            {
            	//System.out.println("testA");
            	p_70665_2_ = DQR.calcDamage.applyDamageBoost(p_70665_2_, this, source, prevDamage);
            }

//さみだれづきBugFix
//            if(p_70665_2_ < 0.0F || this.isDead)
            if(this.getHealth() < 0.0F || this.isDead)
            {
            	this.isOverKill = true;
            	//死亡判定
            	return;
            }

            if(p_70665_2_ == -1.0f)
            {
            	return;
            }
    		DqrDamageMobEvent event4 = new DqrDamageMobEvent(4, attacker, this, source, skillFlg, p_70665_2_, absoluteDam);
    		MinecraftForge.EVENT_BUS.post(event4);
    		p_70665_2_ = event4.retDamage;
    		absoluteDam = event4.retAbsoluteDamage;
//            DQR.func.debugString("damageEntity4:" + this.hurtResistantTime);
//DQR.func.debugString("damageEntity3C:" + p_70665_2_);
            if(this.absoluteDam >= 0.0f && !this.flgGetKaisinDam)
            {
            	p_70665_2_ = this.absoluteDam;
            }

            flgGetKaisinDam = false;
//fqw^fvt0iq,^tgv0
//DQR.func.debugString("damageEntity3D:" + p_70665_2_);
            //ダメージ0の場合にランダムで補正
            if(0.0F < p_70665_2_  && p_70665_2_ < 1.0F)
            {
            	if(rand.nextInt(5) == 0)
            	{
            		p_70665_2_ = rand.nextFloat() * 2 + 1.0F;
            	}else
            	{
            		p_70665_2_ = 0.0F;
            	}
            }

//DQR.func.debugString("damageEntity5:" + this.hurtResistantTime);
            /////////////////////////////////
//DQR.func.debugString("DAMTEST3:" + p_70665_2_);

            p_70665_2_ = DQR.calcDamage.applyDamageResistMagic(p_70665_2_, this, source);

            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - this.getAbsorptionAmount(), 0.0F);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - p_70665_2_));


            /////////////////////////////////
//DQR.func.debugString("damageEntity4:" + p_70665_2_);

            if(handItem == DQWeapons.itemMetarukingnoturugi && p_70665_2_ < 1.0F)
            {
            	p_70665_2_ = 1.0F;
            }

            if (p_70665_2_ != 0.0F)
            {
                float f2 = this.getHealth();

        		DqrDamageMobEvent event5 = new DqrDamageMobEvent(5, attacker, this, source, skillFlg, p_70665_2_, absoluteDam);
        		MinecraftForge.EVENT_BUS.post(event5);
        		p_70665_2_ = event5.retDamage;

                this.setHealth(f2 - p_70665_2_);
                this.func_110142_aN().func_94547_a(source, f2, p_70665_2_);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - p_70665_2_);
                //DQR.func.debugString("damageEntity5:");
            }

//DQR.func.debugString("damageEntity5:" + this.hurtResistantTime);

            //こっからは経験値計算してるとこ
            if(source!= null)
            {
            	//DQR.func.debugString("damageEntity6:");
            	if(source.getEntity() instanceof EntityPlayer)
            	{
	            	EntityPlayer ep = (EntityPlayer)source.getEntity();
	            	//DQR.func.debugString("damageEntity7:" + ep.getDisplayName());
	            	setDamageHT(ep, p_70665_2_, prevHp);

					if(!ep.worldObj.isRemote)
					{
						//System.out.println(this.getEntityString());

						//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {this.getCommandSenderName(), (int)p_70665_2_}));
						//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));

						//if(DQR.conf.damageDigits)
						//System.out.println("TEST" + DQR.conf.damageDigits);
						//System.out.println("TEST" + DQR.conf.damageDigits);
						if (DQR.conf.damageDigits == 1)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						}
						/*
						if(DQR.conf.damageDigits == 1)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else if(DQR.conf.damageDigits == 2)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage3.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}
						*/
					}

					//Block blc = ep.worldObj.getBlock((int)(ep.posX + 0.5), (int)ep.posY - 1, (int)(ep.posZ + 0.5));
					//blc.getUnlocalizedName()
					//System.out.println("DEBUGLINE1:" + ep.worldObj.getBlock((int)(ep.posX + 0.5), (int)ep.posY - 1, (int)(ep.posZ + 0.5)).getUnlocalizedName());
					//if(ep.worldObj.getBlock((int)(ep.posX + 0.5), (int)ep.posY - 1, (int)(ep.posZ + 0.5)).getUnlocalizedName() == Block.getBlockFromName("grass").getUnlocalizedName())
					//{
					//System.out.println("DEBUGLINE:");
					//}
					//ep.worldObj.getBlock(0, 0, 0).removedByPlayer(ep.worldObj, ep, (int)ep.posX, (int)ep.posY - 1, (int)ep.posZ);
					//ep.worldObj.func_147480_a((int)ep.posX, (int)ep.posY - 1, (int)ep.posZ, true);
            	}else if(source.getSourceOfDamage() instanceof EntityPlayer)
            	{
            		EntityPlayer ep = (EntityPlayer)source.getSourceOfDamage();
	            	setDamageHT(ep, p_70665_2_, prevHp);

					if(!ep.worldObj.isRemote)
					{
						if (DQR.conf.damageDigits == 1)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						}
						//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
					}

            	}else if(source.getEntity() instanceof DqmPetBase || source.getEntity() instanceof DqmEntityNPCGuntai)
            	{
            		EntityTameable pet = (EntityTameable)source.getSourceOfDamage();
	            	//setDamageHT(pet, p_70665_2_, prevHp);

	            	EntityPlayer ep = (EntityPlayer)pet.getOwner();

					String petName = " ";

					if(source.getEntity() instanceof DqmPetBase)
					{
						setDamageHT((DqmPetBase)pet, p_70665_2_, prevHp);
						if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase("") && pet.getCustomNameTag().length() > 0)
						{
							//カスタム無しならnullになる
							petName = pet.getCustomNameTag();
						}else
						{
							petName = pet.getCommandSenderName();
						}
					}else
					{
						setDamageHT((EntityPlayer)(pet.getOwner()), p_70665_2_, prevHp);
						petName = pet.getCommandSenderName();
						//petName ="WORRIOR";
					}

					if(!pet.worldObj.isRemote)
						{
						//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						if (DQR.conf.damageDigits == 1)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2P.txt",new Object[] {petName, EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else
						{
							if(ep != null)
							{
								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamageP.txt",new Object[] {petName, EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
							}
						}
					}

            	}else if(source.getSourceOfDamage() instanceof DqmPetBase || source.getSourceOfDamage() instanceof DqmEntityNPCGuntai)
            	{
            		EntityTameable pet = (EntityTameable)source.getSourceOfDamage();
	            	//setDamageHT(pet, p_70665_2_, prevHp);

	            	EntityPlayer ep = (EntityPlayer)pet.getOwner();

					String petName = "";

					if(source.getSourceOfDamage() instanceof DqmPetBase)
					{
						setDamageHT((DqmPetBase)pet, p_70665_2_, prevHp);
			        	if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase("") && pet.getCustomNameTag().length() > 0)
			        	{
			        		//カスタム無しならnullになる
			        		petName = pet.getCustomNameTag();
			        	}else
			        	{
			        		petName = pet.getCommandSenderName();
			        	}
					}else
					{
						setDamageHT((EntityPlayer)pet.getOwner(), p_70665_2_, prevHp);
						petName = pet.getCommandSenderName();
					}

					if(!pet.worldObj.isRemote && ep != null)
					{
						//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						if (DQR.conf.damageDigits == 1)
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2P.txt",new Object[] {petName, EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
						}else
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamageP.txt",new Object[] {petName, EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						}
					}

            	}else if(source.getEntity() instanceof EntityArrow)
            	{
            		EntityArrow arrow = (EntityArrow)source.getEntity();
            		if(arrow.shootingEntity instanceof EntityPlayer)
            		{
	            		EntityPlayer ep = (EntityPlayer)arrow.shootingEntity;
		            	setDamageHT(ep, p_70665_2_, prevHp);

						if(!ep.worldObj.isRemote)
						{
							if (DQR.conf.damageDigits == 1)
							{
								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), p_70665_2_}));
							}else
							{
								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
							}
							//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + this.getEntityString() + EnumDqmMessageConv.MonsterName.getEndS(), (int)p_70665_2_}));
						}
            		}else if(arrow.shootingEntity instanceof DqmPetBase)
            		{
                		DqmPetBase ep = (DqmPetBase)arrow.shootingEntity;
    	            	setDamageHT(ep, p_70665_2_, prevHp);
            		}

            	}else
            	{
            		//System.out.println("TEST");
            	}

				if(!this.worldObj.isRemote && p_70665_2_ <= 0.0F)
				{
					this.worldObj.playSoundAtEntity(this, "dqr:player.miss", 1.0F, 1.0F);
				}
            }

            this.dqmBypassArmor = false;
        }
    }

	@Override
    public boolean attackEntityAsMob(Entity p_70652_1_)
    {

		//PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return false;
		}

		Random rand = new Random();

        if (this.mobAI.getJump() > 0)
        {
            //if (par2 > 2.0F && par2 < 8.0F && this.rand.nextInt(5) == 0)
        	if (this.rand.nextInt(5) == 0)
            {
                if (this.onGround)
                {
                    double var4 = p_70652_1_.posX - this.posX;
                    double var6 = p_70652_1_.posZ - this.posZ;
                    float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
                    this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.1D * this.mobAIrate.getJump();
                    this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.1D * this.mobAIrate.getJump();
                    this.motionY = 0.1D * this.mobAI.getJump();
                }
            }
        }

		if(p_70652_1_ != null && p_70652_1_ instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)p_70652_1_;

			if(this.mobAI.getHeavyFire() > 0 && !ep.capabilities.isCreativeMode)
			{
				DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 60, this.mobAI.getHeavyFire()));
			}

	        if(this.mobAI.getPoison() > 0 && !ep.capabilities.isCreativeMode)
	        {
        		if(rand.nextInt(this.mobAIrate.getPoison()) == 0)
        		{
        			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.potionPoison.id, rand.nextInt(this.mobAIrate.getPoisonTimeMax()) + this.mobAIrate.getPoisonTimeMin(), mobAI.getPoison() - 1));
        		}
	        }
	        if(this.mobAI.getPoisonX() > 0 && !ep.capabilities.isCreativeMode)
	        {
        		if(rand.nextInt(this.mobAIrate.getPoisonX()) == 0)
        		{
        			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.potionPoisonX.id, rand.nextInt(this.mobAIrate.getPoisonXTimeMax()) + this.mobAIrate.getPoisonXTimeMin(), mobAI.getPoisonX()));
        		}
	        }
		}

		return super.attackEntityAsMob(p_70652_1_);
    }

	@Override
    protected void attackEntity(Entity par1Entity, float par2)
    {

		//PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		Random rand = new Random();

        if (this.mobAI.getJump() > 0)
        {
            //if (par2 > 2.0F && par2 < 8.0F && this.rand.nextInt(5) == 0)
        	if (this.rand.nextInt(5) == 0)
            {
                if (this.onGround)
                {
                    double var4 = par1Entity.posX - this.posX;
                    double var6 = par1Entity.posZ - this.posZ;
                    float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
                    this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.1D * this.mobAIrate.getJump();
                    this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.1D * this.mobAIrate.getJump();
                    this.motionY = 0.1D * this.mobAI.getJump();
                }
            }
            else
            {
                super.attackEntity(par1Entity, par2);
            }
        }else
        {
        	super.attackEntity(par1Entity, par2);
        }

		if(this.mobAI.getHeavyFire() > 0)
		{
			if(par1Entity instanceof EntityPlayer )
			{
				EntityPlayer ep = (EntityPlayer)par1Entity;
				if(!ep.capabilities.isCreativeMode)
				{
					DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 60, this.mobAI.getHeavyFire()));
				}
			}
		}
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
		//PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
    	if(DQR.func.isBind(this))
		{
			return;
		}

        EntityArrow entityarrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
        //int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        //int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        entityarrow.setDamage(this.DqmMobPW);
        entityarrow.shootingEntity = this;

        /*
        if (i > 0)
        {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0)
        {
            entityarrow.setKnockbackStrength(j);
        }
        */

        /*
        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
        {
            entityarrow.setFire(100);
        }
        */

        if(!this.worldObj.isRemote)
        {
        	this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        }
        this.worldObj.spawnEntityInWorld(entityarrow);
    }

    public void attackEntityWithBagi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


		//int[] magicParam = DQR.magicTable.getMagicParam(this);
		MagicEntityBagi[] magic = null;

    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvS = 0;
    	int needLvK = 100;
    	int hitCnt = 0;
		*/
		if(grade == EnumDqmMagic.Bagi)
		{

			magic = new MagicEntityBagi[3];
			//for(int cnt = 0;cnt < 1; cnt++)
			//{
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
			}
			//}
			/*
	   		minusMP = 3;
	   		minusDam = 100;
	   		needLvS = 11;
	   		//needLvK = 8;
	   		 */

		}else if(grade == EnumDqmMagic.Bagima)
		{
			grade = EnumDqmMagic.Bagima;
			magic = new MagicEntityBagi[3];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvS = 22;
	   		//needLvK = 18;
			*/
		}else if(grade == EnumDqmMagic.Bagikurosu)
		{
			grade = EnumDqmMagic.Bagikurosu;
			magic = new MagicEntityBagi[5];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[3] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
			magic[4] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
			}

			/*
	   		minusMP = 12;
	   		minusDam = 200;
	   		needLvS = 38;
	   		//needLvK = 31;
			*/
		}else if(grade == EnumDqmMagic.Bagimutyo)
		{
			grade = EnumDqmMagic.Bagimutyo;
			magic = new MagicEntityBagi[5];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[3] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
			magic[4] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 21;
	   		minusDam = 300;
	   		needLvS = 63;
	   		*/
	   		//needLvK = 58;

		}

		if(magic != null)
		{

			if(this.DqmMobMP >= grade.getMP() || this.DqmMobMaxMP == -1 || DQR.debug > 0)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{
    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;

				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithBehomara(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	DQR.func.debugString("TEST", this.getClass());
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return ;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		if(this.DqmMobMP < grade.getMP() &&  this.DqmMobMaxMP != -1)
		{
			if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.DqmMobMP = this.DqmMobMP - grade.getMP();
		}


		//this.addPotionEffect(new PotionEffect(this.pot.id, grade.getAttack(), 0));
		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
		//this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
		int attackDam = grade.getAttack();

		if(this.isPotionActive(DQPotionPlus.buffMahokanta))
		{
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
		}else
		{
        	if(this.getHealth() + attackDam > this.getMaxHealth())
        	{
        		this.setHealth(this.getMaxHealth());
        	}else
        	{
        		this.setHealth(this.getHealth() + (float)attackDam);
        	}
        	if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
		}



        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
        		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(10.0D, 5.0D, 10.0D));

        if (list != null && !list.isEmpty())
        {
        	for (int n = 0 ; n < list.size() ; n++)
        	{
        		Entity target = (Entity)list.get(n);

        		if (target != null && target instanceof EntityLivingBase && !(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
        		{
    				attackDam = grade.getAttack();

    				EntityLivingBase elb = (EntityLivingBase)target;

                	PotionEffect pe2 = null;
            		pe2 = elb.getActivePotionEffect(DQPotionPlus.buffMahokanta);

            		if(pe2 != null)
            		{
                    	if(this.getHealth() + attackDam > this.getMaxHealth())
                    	{
                    		this.setHealth(this.getMaxHealth());
                    	}else
                    	{
                    		this.setHealth(this.getHealth() + (float)attackDam);
                    	}
                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
                    	this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
            		}
            		else
            		{
            			if(elb.getHealth() > 0)
            			{
	                    	if(elb.getHealth() + attackDam > elb.getMaxHealth())
	                    	{
	                    		elb.setHealth(elb.getMaxHealth());
	                    	}else
	                    	{
	                    		elb.setHealth(elb.getHealth() + (float)attackDam);
	                    	}
	                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.hoimi", 1.0F, 1.0F);
            			}
            		}

        		}
        	}
        }
    }

    public void attackEntityWithBuff(EntityLivingBase p_82196_1_, float p_82196_2_, Potion pot, EnumDqmMagic grade, int tag, DqmMobBase tagMob)
    {
    	PotionEffect pe;

		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


		if(this.DqmMobMP < grade.getMP() && this.DqmMobMaxMP != -1)
		{
			if(!this.worldObj.isRemote && DQR.conf.offMobNotEnoughMP > 0) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.DqmMobMP = this.DqmMobMP - grade.getMP();
		}


		if(grade == EnumDqmMagic.Sukuruto || grade == EnumDqmMagic.Fubaha ||grade == EnumDqmMagic.Piorimu)
		{
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
			if(this.isPotionActive(DQPotionPlus.buffMahokanta))
			{
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
			}else
			{
				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
			}

            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
            		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(10.0D, 5.0D, 10.0D));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{
            		Entity target = (Entity)list.get(n);

            		if(target != null && target instanceof EntityLivingBase && !(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
            		{
            			EntityLivingBase elb = (EntityLivingBase)target;
            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
            			{
            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
            				this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
            			}else
            			{
            				DQR.func.addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.up", 1.0F, 1.0F);
            			}
            		}
            	}
            }

            return;
		}else if(tag == 0)
    	{
        	MagicEntityBuffDummy magic = null;

        	magic = new MagicEntityBuffDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

    		if(magic != null)
    		{
    			//int epMP = ExtendedPlayerProperties.get(this).getMP();

				magic.setDamage(0);
				//magic.setPotionEffect(new PotionEffect(pot.id, grade.getAttack(), 1));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);


	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}

	        	if(tagMob != null)
	        	{
	        		if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        		{
	        			if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
	        			DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 1));
	        			this.playSound("dqr:player.up", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}else{
	        			DQR.func.addPotionEffect2(tagMob, new PotionEffect(pot.id, grade.getAttack(), 1));
	        			if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.up", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}
	        	}
	        }
    	}else
    	{
    		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
    		if(this.isPotionActive(DQPotionPlus.buffMahokanta))
    		{
    			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
    		}else
    		{
    			DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 1));
    			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
    		}
    	}
    }

    public void attackEntityWithDebuff(EntityLivingBase p_82196_1_, float p_82196_2_, Potion pot, EnumDqmMagic grade, EntityPlayer tagMob)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


		if(this.DqmMobMP < grade.getMP() && this.DqmMobMaxMP != -1)
		{
			if(!this.worldObj.isRemote && DQR.conf.offMobNotEnoughMP > 0) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.25F, 1.0F);
			return;
		}else
		{
			DqmMobMP = DqmMobMP - grade.getMP();
		}


		if(grade == EnumDqmMagic.Rukanan || grade == EnumDqmMagic.Rarihoma ||grade == EnumDqmMagic.Bomiosu ||
		   grade == EnumDqmMagic.Rariho || grade == EnumDqmMagic.Manusa || grade == EnumDqmMagic.Mahoton ||
		   grade == EnumDqmMagic.Medapani || grade == EnumDqmMagic.Divainsuperu)
		{
    		//this.addPotionEffect(new PotionEffect(this.pot.id, grade.getAttack(), 0));
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
			//this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);

            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(tagMob,
            		tagMob.boundingBox.addCoord(tagMob.motionX, tagMob.motionY, tagMob.motionZ).expand(10.0D, 5.0D, 10.0D));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{
            		Entity target = (Entity)list.get(n);

            		if (target != null && target instanceof EntityLivingBase && target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse)
            		{
            			Random rand = new Random();
            			int ratePer = rand.nextInt(100);
            			//System.out.println(grade.getRate() + "/" + ratePer);
            			if(ratePer < grade.getRate())
            			{
	            			EntityLivingBase elb = (EntityLivingBase)target;
	            			if(elb instanceof EntityPlayer && ((EntityPlayer)elb).capabilities.isCreativeMode)
	            			{
	            				//クリエの場合無効
	            				;
	            			}else
	            			{
		            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
		            			{
		            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
		            				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.down", 1.0F, 1.0F);
		            			}else
		            			{
		            				DQR.func.addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.down", 1.0F, 1.0F);
		            			}
	            			}
            			}
            		}
            	}
            }

            return;
		}else
    	{
			MagicEntityDebuff magic = null;

        	magic = new MagicEntityDebuff(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

    		if(magic != null)
    		{
    			//int epMP = ExtendedPlayerProperties.get(this).getMP();

				magic.setDamage(0);
				magic.setRate(grade.getRate());
				magic.setPotionEffect(new PotionEffect(pot.id, grade.getAttack(), 1));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}
	        }
    	}

    }

    public void attackEntityWithDoruma(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{

			return;
		}



    	MagicEntity[] magic = null;
    	Random rand = new Random();
    	int frame = 0;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/


		if(grade == EnumDqmMagic.Doruma)
		{
			magic = new MagicEntity[5];
			for(int cnt = 1;cnt < 5; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
			}

			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Dorukuma)
		{
			magic = new MagicEntity[8];
			for(int cnt = 1;cnt < 8; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Dorumoa)
		{
			magic = new MagicEntity[16];
			for(int cnt = 1;cnt < 16; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;

			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Dorumadon)
		{
			magic = new MagicEntity[32];
			for(int cnt = 1;cnt < 32; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;

			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}

		magic[0] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		magic[0].shootingEntity = this;
		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{


			if(this.DqmMobMP >= grade.getMP() || this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithGira(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Gira)
		{

			magic = new MagicEntity[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityGira(this.worldObj, this, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 2;
	   		minusDam = 100;
	   		needLvM = 9;
	   		needLvK = 12;
	   		*/

		}else if(grade == EnumDqmMagic.Begirama)
		{
			magic = new MagicEntity[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityBegirama(this.worldObj, this, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 5;
	   		minusDam = 150;
	   		needLvM = 23;
	   		needLvK = 23;
	   		*/

		}else if(grade == EnumDqmMagic.Begiragon)
		{
			magic = new MagicEntity[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityBegiragon(this.worldObj, this, 1.5F, 1.0F, (float)(-3 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 10;
	   		minusDam = 200;
	   		needLvM = 38;
	   		needLvK = 35;
	   		*/

		}else if(grade == EnumDqmMagic.Giragureido)
		{
			magic = new MagicEntity[9];
			for(int cnt = 0;cnt < 9; cnt++)
			{
				magic[cnt] = new MagicEntityGiragureido(this.worldObj, this, 1.5F, 1.0F, (float)(-4 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 18;
	   		minusDam = 300;
	   		needLvM = 67;
	   		needLvK = 63;
	   		*/

		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			if(this.DqmMobMP >= grade.getMP() || this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}

		}
    }

    public void attackEntityWithHoimi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade, int tag, DqmMobBase tagMob)
    {

    	if(tag == 1)
    	{
    		if(DQR.debug == 4){System.out.println("attackEntityWithHoimi 1");}
	    	MagicEntity magic = null;
			PotionEffect pe;
			pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
			if(pe != null && !this.worldObj.isRemote)
			{
				return;
			}
			//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
			//if(pe != null && !this.worldObj.isRemote)
			if(DQR.func.isBind(this))
			{
				return;
			}

    		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);


			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();

				this.DqmMobMP = this.DqmMobMP -grade.getMP();
				//magic.setDamage(attackDam);


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

				if(this.isPotionActive(DQPotionPlus.buffMahokanta))
				{
					if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
				}else
				{
	            	if(this.getHealth() + attackDam > this.getMaxHealth())
	            	{
	            		this.setHealth(this.getMaxHealth());
	            	}else
	            	{
	            		this.setHealth(this.getHealth() + (float)attackDam);
	            	}

	            	if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
				}
			}else
			{
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
				return;
			}

    	}else
	    {
    		if(DQR.debug == 4){System.out.println("attackEntityWithHoimi 2");}
	    	MagicEntity magic = null;
			PotionEffect pe;
			pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
			if(pe != null && !this.worldObj.isRemote)
			{
				return;
			}
			//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
			//if(pe != null && !this.worldObj.isRemote)
			if(DQR.func.isBind(this))
			{
				return;
			}

		   	magic = new MagicEntityHoimiDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


			if(magic != null)
			{


				if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
				{
					int attackDam = grade.getAttack();

					//magic.setDamage(attackDam);


					if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
					this.DqmMobMP = this.DqmMobMP - grade.getMP();
		        	if (!this.worldObj.isRemote)
		        	{
		        		this.worldObj.spawnEntityInWorld(magic);
		        	}


	        		if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        		{
	                	if(this.getHealth() + attackDam > this.getMaxHealth())
	                	{
	                		this.setHealth(this.getMaxHealth());
	                	}else
	                	{
	                		this.setHealth(this.getHealth() + (float)attackDam);
	                	}
	                	if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
	                	this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}else
	        		{
	        			if(tagMob.getHealth() > 0)
	        			{
		                	if(tagMob.getHealth() + attackDam > tagMob.getMaxHealth())
		                	{
		                		tagMob.setHealth(tagMob.getMaxHealth());
		                	}else
		                	{
		                		tagMob.setHealth(tagMob.getHealth() + (float)attackDam);
		                	}
		                	if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        			}
	        		}
				}else
				{
					magic = null;
					if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
				}
			}
	    }
    }

    public void attackEntityWithHyado(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;

		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


    	MagicEntityHyado[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Hyado)
		{
			magic = new MagicEntityHyado[1];
			for(int cnt = 0;cnt < 1; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(0);
			}

			/*
	   		minusMP = 3;
	   		minusDam = 100;
	   		needLvM = 5;
	   		needLvK = 8;
	   		*/

		}else if(grade == EnumDqmMagic.Hyadaruko)
		{
			magic = new MagicEntityHyado[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(1);
			}

			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvM = 18;
	   		needLvK = 18;
	   		*/

		}else if(grade == EnumDqmMagic.Mahyado)
		{
			magic = new MagicEntityHyado[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-30.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(2);
			}
			/*
	   		minusMP = 11;
	   		minusDam = 200;
	   		needLvM = 34;
	   		needLvK = 31;
	   		*/

		}else if(grade == EnumDqmMagic.Mahyadodesu)
		{
			magic = new MagicEntityHyado[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(3);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 300;
	   		needLvM = 63;
	   		needLvK = 58;
	   		*/

		}


		if(magic != null)
		{

			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}

    }

    public void attackEntityWithIo(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntityIo[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Io)
		{
			magic = new MagicEntityIo[8];
			for(int cnt = 0;cnt < 8; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-135.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}

			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Iora)
		{
			magic = new MagicEntityIo[8];
			for(int cnt = 0;cnt < 8; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-135.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Ionazun)
		{
			magic = new MagicEntityIo[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Iogurande)
		{
			magic = new MagicEntityIo[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		magic[cnt].setWorldFlg(this.isSneaking());
    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithMahoimi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade, DqmMobBase tagMob)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntity magic = null;


	   	//magic = new MagicEntityMahoimi(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		magic = new MagicEntityMahoimiDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


		if(magic != null)
		{


			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();
				//magic.setDamage(attackDam);


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				DqmMobMP = DqmMobMP - grade.getMP();
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}

	        	if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        	{
	        		if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
        			this.DqmMobMP = this.DqmMobMP + attackDam;
        			if(!this.worldObj.isRemote) this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        	}else
	        	{
	        		tagMob.DqmMobMP = tagMob.DqmMobMP + attackDam;
	        		if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        	}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithMera(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	*/

		if(grade == EnumDqmMagic.Mera)
		{
	   		magic = new MagicEntityMera(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
	   		magic.shootingEntity = this;

	   		((MagicEntityMera) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
	   		/*
	   		minusMP = 2;
	   		minusDam = 100;
	   		needLvM = 3;
	   		needLvK = 5;
	   		*/

		}else if(grade == EnumDqmMagic.Merami)
		{
			magic = new MagicEntityMerami(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			((MagicEntityMerami) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 5;
	   		minusDam = 150;
	   		needLvM = 15;
	   		needLvK = 15;
	   		*/


		}else if(grade == EnumDqmMagic.Merazoma)
		{
			magic = new MagicEntityMerazoma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			((MagicEntityMerazoma) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 10;
	   		minusDam = 200;
	   		needLvM = 29;
	   		needLvK = 25;
	   		*/

		}else if(grade == EnumDqmMagic.Meragaia)
		{
			magic = new MagicEntityMeragaia(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			((MagicEntityMeragaia) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 18;
	   		minusDam = 300;
	   		needLvM = 55;
	   		needLvK = 49;
	   		*/

		}

		if(magic != null)
		{


			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();

				magic.setDamage(attackDam);

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithRaidein(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Raidein)
		{
			magic = new MagicEntity[1];
			for(int cnt = 0;cnt < 1; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
				magic[cnt].shootingEntity = this;
			}

			/*
	   		minusMP = 3;
	   		minusDam = 100;
	   		needLvM = 5;
	   		needLvK = 8;
	   		*/

		}else if(grade == EnumDqmMagic.Gigadein)
		{
			magic = new MagicEntity[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F, 1);
				magic[cnt].shootingEntity = this;
			}

			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvM = 18;
	   		needLvK = 18;
	   		*/

		}else if(grade == EnumDqmMagic.Minadein)
		{
			magic = new MagicEntity[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-90.0F + (45.0F * cnt)), 0.0F, 2);
				magic[cnt].shootingEntity = this;
			}
			/*
	   		minusMP = 11;
	   		minusDam = 200;
	   		needLvM = 34;
	   		needLvK = 31;
	   		*/

		}


		if(magic != null)
		{

			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{
				int attackDam = grade.getAttack();


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.DqmMobMP = this.DqmMobMP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithZaki(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}



		MagicEntityZaki[] magic = null;

		if(grade == EnumDqmMagic.Zaki)
		{
			magic = new MagicEntityZaki[1];
			magic[0] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
		}else if(grade == EnumDqmMagic.Zaraki)
		{
			magic = new MagicEntityZaki[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
			}
		}else if(grade == EnumDqmMagic.Zarakima)
		{
			magic = new MagicEntityZaki[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				magic[cnt].setBoxHit(3);
			}

		}

		//System.out.println("TEST MP : " + this.DqmMobMP + " : " + grade.getMP() + " : " + this.DqmMobMaxMP);
		if(this.DqmMobMP < grade.getMP() && this.DqmMobMaxMP != -1)
		{
			if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.DqmMobMP = this.DqmMobMP - grade.getMP();
		}
		//System.out.println("TEST MPX");
    	//magic = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F,   0.0F, 0.0F);

		if(magic != null)
		{
			//System.out.println("TEST MPR : " + magic.length);
			//int epMP = ExtendedPlayerProperties.get(this).getMP();

			for(int cnt = 0; cnt < magic.length; cnt ++ )
			{
				magic[cnt].setDamage(0);
				magic[cnt].setRate(grade.getRate());
				//magic[cnt].setRate(90);
				//magic.setPotionEffect(new PotionEffect(this.pot.id, grade.getAttack(), 0));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

	        	}
			}
        }
    }


    public void attackEntityWithHonoo(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

       	PotionEffect pe;

		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Hinoiki)
		{
			magic = new MagicEntityMeraB[1];
			magic[0] = new MagicEntityMeraB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
			((MagicEntityMeraB) magic[0]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Kaeniki)
		{
			magic = new MagicEntityMeramiB[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityMeramiB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				((MagicEntityMeramiB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.HagesiiHonoo)
		{
			magic = new MagicEntityMeramiB[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityMeramiB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				((MagicEntityMeramiB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Syakunetu)
		{
			magic = new MagicEntityMerazomaB[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityMerazomaB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				((MagicEntityMerazomaB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}else if(grade == EnumDqmMagic.RengokuHonoo)
		{
			magic = new MagicEntityMeragaiaB[32];
			for(int cnt = 0;cnt < 32; cnt++)
			{
				magic[cnt] = new MagicEntityMeragaiaB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				((MagicEntityMeragaiaB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/
		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			int attackDam = grade.getAttack();

			//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

    		for(int cnt = 0; cnt < magic.length; cnt++)
    		{
				magic[cnt].setDamage(attackDam);
	        	if (!this.worldObj.isRemote)
	        	{
	        		//magic[cnt].setWorldFlg(this.isSneaking());
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);
	        	}
    		}

		}
    }

    public void attackEntityWithFubuki(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
       	PotionEffect pe;

		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntityHyadoB[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Tumetaiiki)
		{
			magic = new MagicEntityHyadoB[1];
			magic[0] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
			if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[0].setWorldFlg(0);
			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Koorinoiki)
		{
			magic = new MagicEntityHyadoB[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(1);
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Kogoeruhubuki)
		{
			magic = new MagicEntityHyadoB[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(2);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Kagayakuiki)
		{
			magic = new MagicEntityHyadoB[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(3);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}else if(grade == EnumDqmMagic.Zettaireido)
		{
			magic = new MagicEntityHyadoB[32];
			for(int cnt = 0;cnt < 32; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(4);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/
		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			int attackDam = grade.getAttack();

			//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

    		for(int cnt = 0; cnt < magic.length; cnt++)
    		{
				magic[cnt].setDamage(attackDam);
	        	if (!this.worldObj.isRemote)
	        	{
	        		//magic[cnt].setWorldFlg(this.isSneaking());
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);
	        	}
    		}

		}
    }

    public void attackEntityWithRangedAttack2(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
        EntitySnowball entitysnowball = new EntitySnowball(this.worldObj, this);
        double d0 = p_82196_1_.posX - this.posX;
        double d1 = p_82196_1_.posY + (double)p_82196_1_.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
        double d2 = p_82196_1_.posZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        entitysnowball.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        if(!this.worldObj.isRemote) this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entitysnowball);
    }

    public boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.mobAI.getTeleport();
        double d1 = this.posY + (double)(this.rand.nextInt(3));
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.mobAI.getTeleport();
        return this.teleportTo(d0, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    public boolean teleportToEntity(Entity p_70816_1_)
    {
        Vec3 vec3 = Vec3.createVectorHelper(this.posX - p_70816_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
        return this.teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    public boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_)
    {
        EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_, p_70825_3_, p_70825_5_, 0);
        if (MinecraftForge.EVENT_BUS.post(event)){
            return false;
        }
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = event.targetX;
        this.posY = event.targetY;
        this.posZ = event.targetZ;
        boolean flag = false;
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                Block block = this.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }


            if (flag1)
            {
                //this.setPosition(this.posX, this.posY, this.posZ);
            	this.setPosition(i, j, k);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (int l = 0; l < short1; ++l)
            {
                double d6 = (double)l / ((double)short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }

            if(!this.worldObj.isRemote) this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            if(!this.worldObj.isRemote) this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
    	if(this.getHealth() <= 0.0F || this.isDead)
    	{
    		//死亡判定
    		this.setDead();
    		return false;
    	}
    	if(this.mobAI.getTeleport() > 0)
    	{
    		/*
	        if (this.isEntityInvulnerable())
	        {
	            return false;
	        }
	        else
	        {

	            if (p_70097_1_ instanceof EntityDamageSource && p_70097_1_.getEntity() instanceof EntityPlayer)
	            {
	                //this.isAggressive = true;
	            }

	            if (p_70097_1_ instanceof EntityDamageSourceIndirect)
	            {
	                //this.isAggressive = false;

	                for (int i = 0; i < 64; ++i)
	                {
	                    if (this.teleportRandomly())
	                    {
	                        return true;
	                    }
	                }

	                return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	            }
	            else
	            {
	                return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	            }
	        }
	        */

            int ran2 = rand.nextInt(2);

            if (p_70097_1_ != null && ran2 == 0)
            {
                teleportRandomly();
            }

            if (this.isEntityInvulnerable())
            {
                return false;
            }
            else if (this.attackEntityFrom2(p_70097_1_, p_70097_2_))
            {
                Entity var3 = p_70097_1_.getEntity();

                if (this.riddenByEntity != var3 && this.ridingEntity != var3)
                {
                    if (var3 != this)
                    {
                        this.entityToAttack = var3;
                    }

                    return true;
                }
                else
                {
                    if (!(p_70097_1_.isFireDamage()))
                    {
                        if (!(this.isPotionActive(Potion.poison)))
                        {
                            if (p_70097_1_.fallingBlock != null)
                            {
                                this.heal(+10);
                                teleportRandomly();
                            }
                        }
                    }

                    return true;
                }
            }
            else
            {
                return false;
            }
    	}else
    	{
    		//DQR.func.debugString("SamidareDEBUG1");
            if (this.isEntityInvulnerable())
            {
            	//DQR.func.debugString("SamidareDEBUG2");
                return false;
            }
            else if (this.attackEntityFrom2(p_70097_1_, p_70097_2_))
            {
            	//DQR.func.debugString("SamidareDEBUG3");
                Entity entity = p_70097_1_.getEntity();

                if (this.riddenByEntity != entity && this.ridingEntity != entity)
                {
                    if (entity != this)
                    {
                        this.entityToAttack = entity;
                    }

                    return true;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
    	}
    }


    public void onUpdate()
    {

    	/*
    	if(DQR.func.isBind(this))
    	{
    		//System.out.println("BIND?" + this.isClearTasks);
    	}
    	*/

    	if(DQR.func.isBind(this))
    	{
    		this.setAttackTarget(null);
    	}

    	if(DQR.func.isBind(this) && !this.isClearTasks)
    	{
    		//System.out.println("BIND!!!");

    		this.clearTasks();
    		this.isClearTasks = true;
    	}else if(!DQR.func.isBind(this) && this.isClearTasks)
    	{
    		//System.out.println("CLEAR0");
    		this.tasks.removeTask(this.aiBind);

    		//if(this.worldObj != null && !this.worldObj.isRemote)
    		//{
    			this.setDefaultTask();
    			this.setCombatTask();
    			this.isClearTasks = false;
    			//System.out.println("CLEAR");
    		//}
    	}


		PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);

    	if(this.mobAI.getMegante() > 0 && pe == null)
    	{
	        if (this.isEntityAlive() && !this.worldObj.isRemote)
	        {
	        	if(MeganteFlg)
	        	{
	            	//System.out.println("TEST" + MeganteCnt);
	            	if(MeganteCnt == 0)
	            	{
	            		if(!this.worldObj.isRemote) this.playSound("creeper.primed", 1.0F, 0.5F);
	            	}else if(MeganteCnt > 20)
	            	{
	            		boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
	            		float explodeRadius = (float)(rand.nextInt(this.mobAI.getMegante() / 2) + this.mobAI.getMegante() / 2);
	            		if(DQR.conf.magicSpMegante == 0)
	            		{
	            			flag = false;
	            		}

	            		if(!this.worldObj.isRemote)
	            		{
		            		//if
		            		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, explodeRadius, flag);


		            		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)5.0F, flag);
		            		this.setDead();
	            		}
	            		//Block test = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ).;
	            	}
	        		MeganteCnt++;
	        	}else
	        	{
	        		if(this.getHealth() < this.getMaxHealth() * 15 / 100)
	        		{
	        			this.tasks.addTask(this.mobAIrate.getMegante(), new EntityAIMagicMegante(this));
	        			//this.tasks.addTask(1, new EntityAIMagicMegante(this));
	        		}
	        	}
	        }
    	}

        super.onUpdate();
    }

    public void setMegante()
    {
    	MeganteFlg = true;
    }

    public void onDeath(DamageSource p_70645_1_)
    {
    	Random rand = new Random();

        super.onDeath(p_70645_1_);

        PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);

        if(this.mobAI.getMegante() > 0 && this.MeganteFlg == false && pe == null)
        {
        	if(rand.nextInt(10) == 0){
        		boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
        		float explodeRadius = (float)(rand.nextInt(this.mobAI.getMegante() / 2) + this.mobAI.getMegante() / 2);
        		if(DQR.conf.magicSpMegante == 0)
        		{
        			flag = false;
        		}

        		if(!this.worldObj.isRemote)
        		{
        			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, explodeRadius, flag);
        		}
        	}
        }
    }

    @Override
    public void fall(float p_70069_1_) {}

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);

        //p_70014_1_.setInteger("DqmMobMP", this.DqmMobMP);
        //p_70014_1_.setInteger("DqmMobMaxMP", this.DqmMobMaxMP);
        p_70014_1_.setInteger("MeganteCnt", this.MeganteCnt);
        p_70014_1_.setBoolean("MeganteFlg", this.MeganteFlg);
        p_70014_1_.setBoolean("IsBind", this.isBind);
        p_70014_1_.setBoolean("IsClearTasks", this.isClearTasks);
        p_70014_1_.setBoolean("NoAI", this.noAI);
        p_70014_1_.setBoolean("IsFirstAttack", this.isFirstAttack);
        p_70014_1_.setBoolean("FlgSpawnFromSpawner", this.flgSpawnFromSpawner);
        p_70014_1_.setTag("dqrPotionEffects", dqrPotionEffects);
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);

        //this.DqmMobMP = p_70037_1_.getInteger("DqmMobMP");
        //this.DqmMobMaxMP = p_70037_1_.getInteger("DqmMobMaxMP");
        this.MeganteCnt = p_70037_1_.getInteger("MeganteCnt");
        this.MeganteFlg = p_70037_1_.getBoolean("MeganteFlg");
        this.isBind = p_70037_1_.getBoolean("IsBind");
        this.isClearTasks = p_70037_1_.getBoolean("IsClearTasks");
        this.noAI = p_70037_1_.getBoolean("NoAI");
        this.isFirstAttack = p_70037_1_.getBoolean("IsFirstAttack");
        this.flgSpawnFromSpawner = p_70037_1_.getBoolean("FlgSpawnFromSpawner");
        dqrPotionEffects = p_70037_1_.getCompoundTag("dqrPotionEffects");
    }

    public boolean isValidLightLevel2(int par1)
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        int l = this.worldObj.getBlockLightValue(i, j, k);

        if (this.worldObj.isThundering())
        {
            int i1 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            l = this.worldObj.getBlockLightValue(i, j, k);
            this.worldObj.skylightSubtracted = i1;
        }

        return l < par1;
    }








    public boolean attackEntityFrom2(DamageSource p_70097_1_, float p_70097_2_)
    {
    	//DQR.func.debugString("SamidareDEBUG4");
        if(this.getHealth() <= 0.0F || this.isDead)
        {
        	//DQR.func.debugString("SamidareDEBUG_A10");
        	//死亡判定
        	this.setDead();
        	return false;
        }

    	//DQR.func.debugString("attackEntityFrom2");
        if (ForgeHooks.onLivingAttack(this, p_70097_1_, p_70097_2_)) return false;
        if (this.isEntityInvulnerable())
        {
        	//DQR.func.debugString("SamidareDEBUG_A11");
            return false;
        }
        else if (this.worldObj.isRemote)
        {
        	//DQR.func.debugString("SamidareDEBUG_A12");
            return false;
        }
        else
        {
        	//DQR.func.debugString("SamidareDEBUG_A10");
        	//DQR.func.debugString("SamidareDEBUG5");
            this.entityAge = 0;

    		EntityLivingBase attacker = null;
    		if(p_70097_1_.getEntity() instanceof EntityLivingBase)
    		{
    			attacker = (EntityLivingBase)p_70097_1_.getEntity();
    		}else if(p_70097_1_.getSourceOfDamage() instanceof EntityLivingBase)
    		{
    			attacker = (EntityLivingBase)p_70097_1_.getSourceOfDamage();
    		}


    		if(attacker instanceof EntityPlayer)
    		{
    			int refFlg = ExtendedPlayerProperties.get((EntityPlayer)attacker).getPetRefuse();
    			DQR.func.debugString("RefFle : " + refFlg + " / " + this.petRefuseFlg, this.getClass(), 3);
    			if(refFlg == 1 && this.petRefuseFlg == 0  && DQR.conf.permPetRefCommand == 1)
    			{
    				this.petRefuseFlg = 2;
    			}else
    			{
    				if(refFlg == 1 && this.petRefuseFlg == 2)
    				{
    					;
    				}else
    				{
    					this.petRefuseFlg = 1;
    				}
    			}
    		}

            if (this.getHealth() <= 0.0F)
            {
                return false;
            }
            else if (p_70097_1_.isFireDamage() && this.isPotionActive(Potion.fireResistance))
            {
                return false;
            }
            else
            {
            	//DQR.func.debugString("SamidareDEBUG6");
                if ((p_70097_1_ == DamageSource.anvil || p_70097_1_ == DamageSource.fallingBlock) && this.getEquipmentInSlot(4) != null)
                {
                    this.getEquipmentInSlot(4).damageItem((int)(p_70097_2_ * 4.0F + this.rand.nextFloat() * p_70097_2_ * 2.0F), this);
                    p_70097_2_ *= 0.75F;
                }

                this.limbSwingAmount = 1.5F;
                boolean flag = true;

                //DQR.func.debugString("SamidareDEBUG7");
                //if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0F  && !p_70097_1_.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()))
                if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0F)
                {
                	//DQR.func.debugString("SamidareDEBUG7_A");
                	//DQR.func.debugString("TEST_NUMBER1 : " + this.hurtResistantTime + "/" + this.maxHurtResistantTime);
                    if(this.getHealth() <= 0.0F || this.isDead)
                    {
                    	//死亡判定
                    	//DQR.func.debugString("SamidareDEBUG8_A : " + this.getHealth() + " / " + this.isDead);
                    	return false;
                    }

                    if (p_70097_2_ <= this.lastDamage)
                    {
                    	//DQR.func.debugString("SamidareDEBUG8_B : " + p_70097_2_ + " / " + this.lastDamage);
                        return false;
                    }

                    //System.out.println("TEST1");
                    this.damageEntity(p_70097_1_, p_70097_2_ - this.lastDamage);
                    if(isOverKill)
                    {
                    	//DQR.func.debugString("SamidareDEBUG8_C");
                    	return false;
                    }
                    this.lastDamage = p_70097_2_;
                    flag = false;
//rgweygwerguy5
                }
                else
                {
                	//DQR.func.debugString("SamidareDEBUG7_B");
                	//DQR.func.debugString("TEST_NUMBER2 : " + this.hurtResistantTime + "/" + this.maxHurtResistantTime);
                	//System.out.println("TEST2");
                    this.lastDamage = p_70097_2_;
                    this.prevHealth = this.getHealth();
                    this.hurtResistantTime = this.maxHurtResistantTime;
                    this.damageEntity(p_70097_1_, p_70097_2_);
                    if(isOverKill)
                    {
                    	return false;
                    }
                    this.hurtTime = this.maxHurtTime = 10;
                }


                //DQR.func.debugString("SamidareDEBUG8");
                this.attackedAtYaw = 0.0F;
                Entity entity = p_70097_1_.getEntity();

                if (entity != null)
                {
                	//DQR.func.debugString("SamidareDEBUG9");
                    if (entity instanceof EntityLivingBase)
                    {
                        this.setRevengeTarget((EntityLivingBase)entity);
                    }

                    if (entity instanceof EntityPlayer)
                    {
                        this.recentlyHit = 100;
                        this.attackingPlayer = (EntityPlayer)entity;
                    }else if(entity instanceof DqmPetBase && ((DqmPetBase)entity).isTamed())
                    {
                    	this.recentlyHit = 100;

                    }else if (entity instanceof net.minecraft.entity.passive.EntityTameable)
                    {
                        net.minecraft.entity.passive.EntityTameable entitywolf = (net.minecraft.entity.passive.EntityTameable)entity;

                        if (entitywolf.isTamed())
                        {
                            this.recentlyHit = 100;
                            this.attackingPlayer = null;
                        }
                    }else if(entity instanceof MagicEntity)
                    {
                    	//System.out.println("TEST111");
                    	MagicEntity magic = (MagicEntity)entity;
                    	//System.out.println("TEST222" + magic.shootingEntity.getCommandSenderName());
                    	if(magic.shootingEntity instanceof EntityPlayer)
                    	{
                    		//System.out.println("TEST222");
                    		this.recentlyHit = 100;
                            this.attackingPlayer = (EntityPlayer)magic.shootingEntity;
                    	}
                    }
                }

                if (flag)
                {
                	//DQR.func.debugString("SamidareDEBUG10");
                    this.worldObj.setEntityState(this, (byte)2);

                    if (p_70097_1_ != DamageSource.drown)
                    {
                        this.setBeenAttacked();
                    }

                    if (entity != null)
                    {
                        double d1 = entity.posX - this.posX;
                        double d0;

                        for (d0 = entity.posZ - this.posZ; d1 * d1 + d0 * d0 < 1.0E-4D; d0 = (Math.random() - Math.random()) * 0.01D)
                        {
                            d1 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.attackedAtYaw = (float)(Math.atan2(d0, d1) * 180.0D / Math.PI) - this.rotationYaw;
                        this.knockBack(entity, p_70097_2_, d1, d0);
                    }
                    else
                    {
                        this.attackedAtYaw = (float)((int)(Math.random() * 2.0D) * 180);
                    }
                }

                String s;

                if (this.getHealth() <= 0.0F)
                {
                	//DQR.func.debugString("SamidareDEBUG11");
                    s = this.getDeathSound();

                    if (flag && s != null)
                    {
                    	if(!this.worldObj.isRemote) this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
                    }

                    this.onDeath(p_70097_1_);
                }
                else
                {
                	//DQR.func.debugString("SamidareDEBUG12");
                    s = this.getHurtSound();

                    if (flag && s != null)
                    {
                    	if(!this.worldObj.isRemote) this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
                    }
                }

                return true;
            }
        }
    }

    public String getEntityStringForce()
    {
    	return this.getEntityString();
    }

    /*
    protected int getExperiencePoints(EntityPlayer p_70693_1_)
    {
    	System.out.println("TEST : " + this.getCommandSenderName());
    	return this.experienceValue;
    }
    */

    /*
    protected void onDeathUpdate()
    {
        ++this.deathTime;
        //System.out.println("TEST1 : " + this.getCommandSenderName());

        if (this.deathTime == 20)
        {
            int i;

            //if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && this.func_146066_aG() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot"))
            if (!this.worldObj.isRemote  && this.func_146066_aG() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot"))
            {
            	//System.out.println("TEST2 : " + this.getCommandSenderName());
                i = this.getExperiencePoints(this.attackingPlayer);

                while (i > 0)
                {
                    int j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }

            this.setDead();
            //System.out.println("TEST3 : " + this.getCommandSenderName());
            for (i = 0; i < 20; ++i)
            {
                double d2 = this.rand.nextGaussian() * 0.02D;
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d2, d0, d1);
            }
        }
    }
    */

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        //this.playSound("mob.zombie.step", 0.15F, 1.0F);
    	//this.playSound("mob.zombie.step", 0.15F, 1.0F);
    	if(DQR.conf.offMobStepSound == 1)
    	{
    		Block.SoundType soundtype = p_145780_4_.stepSound;
    		this.playSound(soundtype.getStepResourcePath(), soundtype.getVolume() * 0.3F, soundtype.getPitch() * 0.75F);
    	}
    }


    public NBTTagCompound getDqrPotionEffectsSet() {
    	if(dqrPotionEffects == null){dqrPotionEffects = new NBTTagCompound();}
        return dqrPotionEffects;
    }
    public void setDqrPotionEffectsSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.dqrPotionEffects = par1;
    	}else
    	{
    		this.dqrPotionEffects = new NBTTagCompound();
    	}
    }
    public void removeDqrPotionEffects(String key) {
    	this.dqrPotionEffects.removeTag(key);
    }


    public long getJobSPSkillDuration(int job, int idx) {
        //return fixJobSPSkillDuration.getLong("jobSPSkillDuration" + "_" + job  + "_" + idx);
    	NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag("JSkill" + "_" + job  + "_" + idx);
    	if(nbt != null && nbt.hasKey("duration"))
    	{
    		long duration = nbt.getLong("duration") - this.worldObj.getWorldTime();

    		if(duration > 0)
    		{
    			return duration;
    		}else
    		{
    			return 0L;
    		}

    	}else
    	{
    		return 0L;
    	}
    }
    public void setJobSPSkillDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 0);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }
    public void setDebuffDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 1);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }


    public void refreshDqrPotionEffects(long wt)
    {
    	Set nbtSet = this.dqrPotionEffects.func_150296_c();

    	Iterator ite = nbtSet.iterator();
    	List<String> lst = new ArrayList<String>();
    	while(ite.hasNext())
    	{
    		Object obj = ite.next();
    		if(obj instanceof String)
    		{
    			NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag((String)obj);
    			if(nbt != null)
    			{
    				if(nbt.hasKey("duration"))
    				{
	        			long fixTime = nbt.getLong("duration");
	        			if(fixTime < wt)
	        			{
	        				lst.add((String)obj);
	        				//this.jobSPSkillDuration.removeTag((String)obj);
	        			}
    				}else
    				{
    					lst.add((String)obj);
    				}
    			}

    			//String name = (String)obj;
    			//System.out.println("TEST : " + name);
    		}
    	}

    	for(int cnt = 0; cnt < lst.size(); cnt++)
    	{
    		this.dqrPotionEffects.removeTag(lst.get(cnt));
    	}
    }

    public void setDqrPotionEffects(String key, NBTTagCompound nbt)
    {
    	this.dqrPotionEffects.setTag(key, nbt);
    }

    public NBTTagCompound getDqrPotionEffects(String key)
    {
    	return (NBTTagCompound)this.dqrPotionEffects.getTag(key);
    }
}

