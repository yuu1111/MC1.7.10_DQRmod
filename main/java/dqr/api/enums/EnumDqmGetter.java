package dqr.api.enums;

import java.util.Random;
import java.util.TreeMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFishingRod;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQMagicTools;
import dqr.items.magicTool.DqmItemFishingRod;

public class EnumDqmGetter {

	public EnumDqmGetter(){}

	public EnumDqmEndoraParam getEndoraParam(int id)
	{
		EnumDqmEndoraParam[] endoraParam = EnumDqmEndoraParam.values();
		EnumDqmEndoraParam endoraParamMax = null;

		for(int cnt = 0;cnt < endoraParam.length; cnt++)
		{
			if(endoraParam[cnt].getId() == id)
			{
				return endoraParam[cnt];
			}

			if(endoraParam[cnt].getId() == 6)
			{
				endoraParamMax = endoraParam[cnt];
			}
		}

		return endoraParamMax;
	}

	public EnumDqmMobAI getDqmMobAI(int par1)
	{
		EnumDqmMobAI[] data = EnumDqmMobAI.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
	}

    public EnumDqmCasinoPKOdds getCasinoPKOddsFromId(int par1)
    {
    	EnumDqmCasinoPKOdds[] data = EnumDqmCasinoPKOdds.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmCasinoBJOdds getCasinoBJOddsFromId(int par1)
    {
    	EnumDqmCasinoBJOdds[] data = EnumDqmCasinoBJOdds.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmJob getJobFromId(int par1)
    {
    	EnumDqmJob[] data = EnumDqmJob.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return EnumDqmJob.Asobinin;
    }

    public EnumDqmMonsterResist getMonsterResistFromId(int par1)
    {
    	EnumDqmMonsterResist[] data = EnumDqmMonsterResist.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return EnumDqmMonsterResist.SURA;
    }

    public EnumDqmMonsterResist getMonsterResistFromMobname(String par1)
    {
    	try
    	{
	    	EnumDqmMonsterResist[] data = EnumDqmMonsterResist.values();

	    	for(int cnt = 0; cnt < data.length; cnt++)
	    	{
	    		if(data[cnt].getMobname().equalsIgnoreCase(par1))
	    		{
	    			return data[cnt];
	    		}
	    	}
    	}catch (Exception e)
    	{
    		System.out.println("EnumDqmMonsterResist getting error!!");
    	}

    	return null;
    }

    public EnumDqmMonster getMonsterFromName(String par1)
    {
    	EnumDqmMonster ret = null;

    	try
    	{
    		EnumDqmMonster[] data = EnumDqmMonster.values();

	    	for(int cnt = 0; cnt < data.length; cnt++)
	    	{
	    		if(data[cnt].getMobName().equalsIgnoreCase(par1))
	    		{
	    			return data[cnt];
	    		}
	    	}
    	}catch (Exception e)
    	{
    		System.out.println("EnumDqmMonster getting error!!");
    	}

    	return null;
    }

    public TreeMap getSkillW(int wId)
    {
    	//wId : weaponID

    	TreeMap<Integer, EnumDqmSkillW> ret = new TreeMap<Integer, EnumDqmSkillW>();

    	EnumDqmSkillW[] data = EnumDqmSkillW.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getWeaponId() == wId)
    		{
    			ret.put(data[cnt].getCategCode(), data[cnt]);
    		}
    	}

    	return ret;
    }

    public EnumDqmSkillW getSkillW(int wId, int categId)
    {

    	EnumDqmSkillW[] data = EnumDqmSkillW.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getWeaponId() == wId && data[cnt].getCategCode() == categId)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmMobRoot getMobRootFromName(String par1)
    {
    	EnumDqmMobRoot[] data = EnumDqmMobRoot.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getName().equalsIgnoreCase(par1))
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmMobCateg getMobCategFromName(String par1)
    {
    	EnumDqmMobCateg[] data = EnumDqmMobCateg.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getName().equalsIgnoreCase(par1))
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmMobCateg getMobCategFromId(int Id)
    {
    	EnumDqmMobCateg[] data = EnumDqmMobCateg.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == Id)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmMobRoot getMobRootFromHIdCateg(int hCateg, int hId)
    {
    	EnumDqmMobRoot[] data = EnumDqmMobRoot.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getHaigouId() ==hId && data[cnt].getHaigouCateg() == hCateg)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmPetHaigouSP getEnumDqmPetHaigouSPFromName(String pat1, String pat2)
    {
    	EnumDqmPetHaigouSP[] data = EnumDqmPetHaigouSP.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getPar1().equalsIgnoreCase(pat1) &&
    		   data[cnt].getPar2().equalsIgnoreCase(pat2))
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmPet getEnumDqmPetFromName(String name)
    {
    	EnumDqmPet ret = null;

    	EnumDqmPet[] data = EnumDqmPet.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getPetname().equalsIgnoreCase(name))
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public EnumDqmPet[] getHaigouPetList(EnumDqmMobRoot par1, EnumDqmMobCateg par2)
    {
    	EnumDqmPet[] ret = null;
    	EnumDqmPet[] data = EnumDqmPet.values();
    	EnumDqmMobCateg mob2 = par2;
    	int resultCnt = 0;

    	while(resultCnt == 0 && mob2.getId() >= 0)
    	{
	    	for(int cnt = 0; cnt < data.length; cnt++)
	    	{
	    		if(data[cnt].getPetcateg().equalsIgnoreCase(mob2.getName()) &&
	    			data[cnt].getPetroot().equalsIgnoreCase(par1.getName()))
	    		{
	    			resultCnt++;
	    		}
	    	}

	    	if(resultCnt == 0)
	    	{
	    		mob2 = this.getMobCategFromId(mob2.getId() - 1);
	    	}
    	}

    	if(resultCnt > 0)
    	{
    		ret = new EnumDqmPet[resultCnt];
    		resultCnt = 0;
    		for(int cnt = 0; cnt < data.length; cnt++)
        	{
        		if(data[cnt].getPetcateg().equalsIgnoreCase(mob2.getName()) &&
        			data[cnt].getPetroot().equalsIgnoreCase(par1.getName()))
        		{
        			ret[resultCnt] = data[cnt];
        			resultCnt++;
        		}
        	}

    		return ret;
    	}else
    	{
    		return null;
    	}
    }

	public EnumDqmAccessory getAccessoryParam(Item par1)
	{
		if(par1 == DQAccessories.itemSuraimupiasu)
		{
			return EnumDqmAccessory.SURAIMUPIASU;
		}else if(par1 == DQAccessories.itemKinnopiasu)
		{
			return EnumDqmAccessory.KINNOPIASU;
		}else if(par1 == DQAccessories.itemBerupiasu)
		{
			return EnumDqmAccessory.BERUPIASU;
		}else if(par1 == DQAccessories.itemHosinopiasu)
		{
			return EnumDqmAccessory.HOSINOPIASU;
		}else if(par1 == DQAccessories.itemKirapiasu2)
		{
			return EnumDqmAccessory.KIRAPIASU2;
		}else if(par1 == DQAccessories.itemAkumanopiasu)
		{
			return EnumDqmAccessory.AKUMANOPIASU;
		}else if(par1 == DQAccessories.itemMahounopiasu)
		{
			return EnumDqmAccessory.MAHOUNOPIASU;
		}else if(par1 == DQAccessories.itemTensinopiasu)
		{
			return EnumDqmAccessory.TENSINOPIASU;
		}else if(par1 == DQAccessories.itemHosifurupiasu)
		{
			return EnumDqmAccessory.HOSIFURUPIASU;
		}else if(par1 == DQAccessories.itemHosifurupiasu2)
		{
			return EnumDqmAccessory.HOSIFURUPIASU2;
		}else if(par1 == DQAccessories.itemHosinokubikazari)
		{
			return EnumDqmAccessory.HOSINOKUBIKAZARI;
		}else if(par1 == DQAccessories.itemRakkipendanto)
		{
			return EnumDqmAccessory.RAKKIPENDANTO;
		}else if(par1 == DQAccessories.itemKataminokubikazari)
		{
			return EnumDqmAccessory.KATAMINOKUBIKAZARI;
		}else if(par1 == DQAccessories.itemSingonnojuzu)
		{
			return EnumDqmAccessory.SINGONNOJUZU;
		}else if(par1 == DQAccessories.itemSinigaminokubikazari)
		{
			return EnumDqmAccessory.SINIGAMINOKUBIKAZARI;
		}else if(par1 == DQAccessories.itemSeijukunokubikazari)
		{
			return EnumDqmAccessory.SEIJUKUNOKUBIKAZARI;
		}else if(par1 == DQAccessories.itemHosizoranokubikazari)
		{
			return EnumDqmAccessory.HOSIZORANOKUBIKAZARI;
		}else if(par1 == DQAccessories.itemHosizoranokubikazari2)
		{
			return EnumDqmAccessory.HOSIZORANOKUBIKAZARI2;
		}else if(par1 == DQAccessories.itemHosizoranokubikazari3)
		{
			return EnumDqmAccessory.HOSIZORANOKUBIKAZARI3;
		}else if(par1 == DQAccessories.itemHosizoranokubikazari4)
		{
			return EnumDqmAccessory.HOSIZORANOKUBIKAZARI4;
		}else if(par1 == DQAccessories.itemGoldburesuretto)
		{
			return EnumDqmAccessory.GOLDBURESURETTO;
		}else if(par1 == DQAccessories.itemHosifuru)
		{
			return EnumDqmAccessory.HOSIFURU;
		}else if(par1 == DQAccessories.itemIyasinoudewa)
		{
			return EnumDqmAccessory.IYASINOUDEWA;
		}else if(par1 == DQAccessories.itemMamorinoudewa)
		{
			return EnumDqmAccessory.MAMORINOUDEWA;
		}else if(par1 == DQAccessories.itemMamorinoudewa2)
		{
			return EnumDqmAccessory.MAMORINOUDEWA2;
		}else if(par1 == DQAccessories.itemMamorinoudewa3)
		{
			return EnumDqmAccessory.MAMORINOUDEWA3;
		}else if(par1 == DQAccessories.itemMamorinoudewa4)
		{
			return EnumDqmAccessory.MAMORINOUDEWA4;
		}else if(par1 == DQAccessories.itemGouketunoudewa)
		{
			return EnumDqmAccessory.GOUKETUNOUDEWA;
		}else if(par1 == DQAccessories.itemGouketunoudewa2)
		{
			return EnumDqmAccessory.GOUKETUNOUDEWA2;
		}else if(par1 == DQAccessories.itemGouketunoudewa3)
		{
			return EnumDqmAccessory.GOUKETUNOUDEWA3;
		}else if(par1 == DQAccessories.itemGouketunoudewa4)
		{
			return EnumDqmAccessory.GOUKETUNOUDEWA4;
		}else if(par1 == DQAccessories.itemGoldring)
		{
			return EnumDqmAccessory.GOLDRING;
		}else if(par1 == DQAccessories.itemHaramotiYubiwa)
		{
			return EnumDqmAccessory.HARAMOTIYUBIWA;
		}else if(par1 == DQAccessories.itemHaraherazuYubiwa)
		{
			return EnumDqmAccessory.HARAHERAZUYUBIWA;
		}else if(par1 == DQAccessories.itemHayatenoring)
		{
			return EnumDqmAccessory.HAYATENORING;
		}else if(par1 == DQAccessories.itemGinnoyubiwa)
		{
			return EnumDqmAccessory.GINNOYUBIWA;
		}else if(par1 == DQAccessories.itemInotinoyubiwa)
		{
			return EnumDqmAccessory.INOTINOYUBIWA;
		}else if(par1 == DQAccessories.itemTikaranoyubiwa)
		{
			return EnumDqmAccessory.TIKARANOYUBIWA;
		}else if(par1 == DQAccessories.itemFurubitaring)
		{
			return EnumDqmAccessory.FURUBITARING;
		}else if(par1 == DQAccessories.itemMegaminoyubiwa)
		{
			return EnumDqmAccessory.MEGAMINOYUBIWA;
		}else if(par1 == DQAccessories.itemInorinoyubiwa)
		{
			return EnumDqmAccessory.INORINOYUBIWA;
		}else if(par1 == DQAccessories.itemSuparing)
		{
			return EnumDqmAccessory.SUPARING;
		}else if(par1 == DQAccessories.itemSosararing)
		{
			return EnumDqmAccessory.SOSARARING;
		}else if(par1 == DQAccessories.itemHagennoring)
		{
			return EnumDqmAccessory.HAGENNORING;
		}else if(par1 == DQAccessories.itemHagennoring2)
		{
			return EnumDqmAccessory.HAGENNORING2;
		}else if(par1 == DQAccessories.itemHadokunoring)
		{
			return EnumDqmAccessory.HADOKUNORING;
		}else if(par1 == DQAccessories.itemHadokunoring2)
		{
			return EnumDqmAccessory.HADOKUNORING2;
		}else if(par1 == DQAccessories.itemMangetunoring)
		{
			return EnumDqmAccessory.MANGETUNORING;
		}else if(par1 == DQAccessories.itemMangetunoring2)
		{
			return EnumDqmAccessory.MANGETUNORING2;
		}else if(par1 == DQAccessories.itemRiseinoring)
		{
			return EnumDqmAccessory.RISEINORING;
		}else if(par1 == DQAccessories.itemRiseinoring2)
		{
			return EnumDqmAccessory.RISEINORING2;
		}else if(par1 == DQAccessories.itemMayokenoseiin)
		{
			return EnumDqmAccessory.MAYOKENOSEIIN;
		}else if(par1 == DQAccessories.itemMamorinorubi)
		{
			return EnumDqmAccessory.MAMORINORUBI;
		}else if(par1 == DQAccessories.itemTikaranorubi)
		{
			return EnumDqmAccessory.TIKARANORUBI;
		}else if(par1 == DQAccessories.itemAkumanotatu)
		{
			return EnumDqmAccessory.AKUMANOTATU;
		}else if(par1 == DQAccessories.itemRyuunouroko)
		{
			return EnumDqmAccessory.RYUUNOUROKO;
		}else if(par1 == DQAccessories.itemRoiyarubajjji)
		{
			return EnumDqmAccessory.ROIYARUBAJJJI;
		}else if(par1 == DQAccessories.itemIkarinotatu)
		{
			return EnumDqmAccessory.IKARINOTATU;
		}else if(par1 == DQAccessories.itemIkarinotatu2)
		{
			return EnumDqmAccessory.IKARINOTATU2;
		}else if(par1 == DQAccessories.itemIkarinotatu3)
		{
			return EnumDqmAccessory.IKARINOTATU3;
		}else if(par1 == DQAccessories.itemIkarinotatu4)
		{
			return EnumDqmAccessory.IKARINOTATU4;
		}else if(par1 == DQAccessories.itemSaikyounoakasi)
		{
			return EnumDqmAccessory.SAIKYOUNOAKASI;
		}else if(par1 == DQAccessories.itemKawanotate)
		{
			return EnumDqmAccessory.KAWANOTATE;
		}else if(par1 == DQAccessories.itemUrokonotate)
		{
			return EnumDqmAccessory.UROKONOTATE;
		}else if(par1 == DQAccessories.itemSuraimutorei)
		{
			return EnumDqmAccessory.SURAIMUTOREI;
		}else if(par1 == DQAccessories.itemSeidounotate)
		{
			return EnumDqmAccessory.SEIDOUNOTATE;
		}else if(par1 == DQAccessories.itemHaganenotate)
		{
			return EnumDqmAccessory.HAGANENOTATE;
		}else if(par1 == DQAccessories.itemHowaitosirudo)
		{
			return EnumDqmAccessory.HOWAITOSIRUDO;
		}else if(par1 == DQAccessories.itemHonoonotate)
		{
			return EnumDqmAccessory.HONOONOTATE;
		}else if(par1 == DQAccessories.itemKoorinotate)
		{
			return EnumDqmAccessory.KOORINOTATE;
		}else if(par1 == DQAccessories.itemMahounotate)
		{
			return EnumDqmAccessory.MAHOUNOTATE;
		}else if(par1 == DQAccessories.itemOogasirudo)
		{
			return EnumDqmAccessory.OOGASIRUDO;
		}else if(par1 == DQAccessories.itemPuratinasirudo)
		{
			return EnumDqmAccessory.PURATINASIRUDO;
		}else if(par1 == DQAccessories.itemFuujinnnotate)
		{
			return EnumDqmAccessory.FUUJINNNOTATE;
		}else if(par1 == DQAccessories.itemMikagaminotate)
		{
			return EnumDqmAccessory.MIKAGAMINOTATE;
		}else if(par1 == DQAccessories.itemTikaranotate)
		{
			return EnumDqmAccessory.TIKARANOTATE;
		}else if(par1 == DQAccessories.itemMetarukingnotate)
		{
			return EnumDqmAccessory.METARUKINGNOTATE;



		}else if(par1 == DQAccessories.itemTenkuunotate)
		{
		return EnumDqmAccessory.TENKUUNOTATE;
		}else if(par1 == DQAccessories.itemRotonotate)
		{
		return EnumDqmAccessory.ROTONOTATE;
		}else if(par1 == DQAccessories.itemSabitatate)
		{
		return EnumDqmAccessory.SABITATATE;
		}else if(par1 == DQAccessories.itemMegaminotate)
		{
		return EnumDqmAccessory.MEGAMINOTATE;
		}else if(par1 == DQAccessories.itemUroborosunotate)
		{
		return EnumDqmAccessory.UROBOROSUNOTATE;
		}else if(par1 == DQAccessories.itemFuujinnnotate2)
		{
			return EnumDqmAccessory.FUUJINNNOTATE2;
		}else if(par1 == DQAccessories.itemFuujinnnotate3)
		{
			return EnumDqmAccessory.FUUJINNNOTATE3;
		}
		return null;
	}

	public EnumDqmFishingRate getFishingRateFromRodType(Item item)
	{
		if(item == DQMagicTools.itemDqrFishRod_Diamond)
		{
			return EnumDqmFishingRate.DIAMOND_ROD;
		}else if(item == DQMagicTools.itemDqrFishRod_Oriharukon)
		{
			return EnumDqmFishingRate.ORIHARUKON_ROD;
		}else if(item == DQMagicTools.itemDqrFishRod_Roto)
		{
			return EnumDqmFishingRate.ROTO_ROD;
		}else if(item == DQMagicTools.itemDqrFishRod_Densetu)
		{
			return EnumDqmFishingRate.DENSETU_ROD;
		}

		return EnumDqmFishingRate.VANILLA_ROD;
	}

	public EnumDqmFishingCateg getFishingCategFromRandom(Item item)
	{
		//System.out.println("TEST1");
		if(item instanceof DqmItemFishingRod || item instanceof ItemFishingRod)
		{
			int[] VanillaRod = {6, 5, 6, 16, 66, 316, 0, 316};
			int[] DiamondRod = {4, 5, 6, 16, 66, 266, 0, 266};
			int[] OriharukonRod = {3, 20, 35, 45, 95, 245, 0, 245};
			int[] RotoRod = {2, 25, 45, 65, 95, 175, 0, 175};
			int[] DensetuRod = {1, 1, 2, 3, 4, 9, 0, 9};

			int[] rotPat = null;
			Random rand = new Random();

			//System.out.println("TEST2");
			if(item == DQMagicTools.itemDqrFishRod_Diamond)
			{
				rotPat = DiamondRod;
				//System.out.println("RodType0");
			}else if(item == DQMagicTools.itemDqrFishRod_Oriharukon)
			{
				rotPat = OriharukonRod;
				//System.out.println("RodType1");
			}else if(item == DQMagicTools.itemDqrFishRod_Roto)
			{
				rotPat = RotoRod;
				//System.out.println("RodType2");
			}else if(item == DQMagicTools.itemDqrFishRod_Densetu)
			{
				rotPat = DensetuRod;
				//System.out.println("RodType3");
			}else if(item instanceof ItemFishingRod)
			{
				rotPat = VanillaRod;
				//System.out.println("RodType4");
			}

			//System.out.println("TEST3");
			if(rotPat != null)
			{
				//System.out.println("TEST4 : " + rotPat[0] + " / " + rotPat[1]);
				if(rand.nextInt(rotPat[0]) == 0)
				{
					//System.out.println("TEST5");
					rand = new Random();
					int categRand = rand.nextInt(rotPat[7]);

					if(categRand < rotPat[1])
					{
						return EnumDqmFishingCateg.DQWEAPON;
					}else if(categRand < rotPat[2])
					{
						return EnumDqmFishingCateg.DQMAGIC;
					}else if(categRand < rotPat[3])
					{
						return EnumDqmFishingCateg.DQEMB;
					}else if(categRand < rotPat[4])
					{
						return EnumDqmFishingCateg.DQORE;
					}else if(categRand < rotPat[5])
					{
						return EnumDqmFishingCateg.DQMISC;
					}else if(categRand < rotPat[6])
					{
						return EnumDqmFishingCateg.DQACC;
					}
				}else
				{
					return EnumDqmFishingCateg.VANILLA_FISH;
				}
			}

			//System.out.println("TEST6");
		}
		//System.out.println("TEST7");

		return null;
	}

	public EnumDqmMobSkilProp getEnumDqmMobSkilProp(String par1)
	{
		EnumDqmMobSkilProp[] data = EnumDqmMobSkilProp.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getName().equalsIgnoreCase(par1))
    		{
    			return data[cnt];
    		}
    	}
		return null;
	}
	public EnumDqmShopPrice getEnumDqmShopPriceRandom(int grade2)
	{
		Random rand = new Random();
		EnumDqmShopPrice[] data = EnumDqmShopPrice.values();
		int counter = 0;

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getGrade2() == grade2 || grade2 == 6)
    		{
    			counter++;
    		}
    	}

    	EnumDqmShopPrice[] data2 = new EnumDqmShopPrice[counter];
    	counter = 0;
    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getGrade2() == grade2 || grade2 == 6)
    		{
    			data2[counter] = data[cnt];
    			counter++;
    		}
    	}

    	if(data2 != null && data2.length > 0)
    	{
    		return data2[rand.nextInt(counter)];
    	}
		return null;
	}


	public EnumDqmJob[] getDqmJobsArray()
	{
		EnumDqmJob[] array = new EnumDqmJob[EnumDqmJob.values().length];
		EnumDqmJob[] data = EnumDqmJob.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		array[data[cnt].getJobOrderId()] = data[cnt];
    	}

		return array;
	}

    public EnumDqmSkillJ getSkillJ2(int job, int idx)
    {
    	EnumDqmSkillJ ret = null;
    	EnumDqmSkillJ[] data = EnumDqmSkillJ.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getJob() == job && data[cnt].getIdx() == idx &&  data[cnt].getNeedsp() > -1)
    		{
    			return data[cnt];
    		}
    	}

    	return ret;
    }

    public EnumDqmSkillJ getSkillJ(int job, int idx)
    {
    	EnumDqmSkillJ ret = null;
    	EnumDqmSkillJ[] data = EnumDqmSkillJ.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getJob() == job && data[cnt].getIdx() == idx)
    		{
    			return data[cnt];
    		}
    	}

    	return ret;
    }

    public EnumDqmSkillJ getSkillAllJ(int job, int idx)
    {
    	EnumDqmSkillJ ret = null;
    	EnumDqmSkillJ[] data = EnumDqmSkillJ.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getJob() == job && data[cnt].getIdx() == idx && data[cnt].getNeedsp_All() > -1)
    		{
    			return data[cnt];
    		}
    	}

    	return ret;
    }

    public EnumDqmSkillJ[] getSkillAllJfromJob(int job)
    {
    	EnumDqmSkillJ[] ret = null;
    	EnumDqmSkillJ[] data = EnumDqmSkillJ.values();
    	int counter = 0;

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getJob() == job && data[cnt].getNeedsp_All() > -1)
    		{
    			counter = counter + 1;
    		}
    	}

    	ret = new EnumDqmSkillJ[counter];
    	int regCount = 0;
    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getJob() == job && data[cnt].getNeedsp_All() > -1)
    		{
    			ret[regCount] = data[cnt];
    			regCount = regCount + 1;
    		}
    	}

    	return ret;
    }

	public int getJobSPSkillCounterJ(int job)
	{
		EnumDqmSkillJ[] skills = EnumDqmSkillJ.values();
		int ret = 0;

	   	for(int cnt = 0; cnt < skills.length; cnt++)
    	{
	   		if(skills[cnt].getJob() == job)
	   		{
	   			ret = ret + 1;
	   		}
    	}

		return ret;
	}

	public int getJobSPSkillCounterJ2(int job)
	{
		EnumDqmSkillJ[] skills = EnumDqmSkillJ.values();
		int ret = 0;

	   	for(int cnt = 0; cnt < skills.length; cnt++)
    	{
	   		if(skills[cnt].getJob() == job &&  skills[cnt].getNeedsp() > -1)
	   		{
	   			ret = ret + 1;
	   		}
    	}

		return ret;
	}

	public int getJobSPSkillCounterAllJ(int job)
	{
		EnumDqmSkillJ[] skills = EnumDqmSkillJ.values();
		int ret = 0;

	   	for(int cnt = 0; cnt < skills.length; cnt++)
    	{
	   		if(skills[cnt].getJob() == job && skills[cnt].getNeedsp_All() > -1)
	   		{
	   			ret = ret + 1;
	   		}
    	}

		return ret;
	}
}
