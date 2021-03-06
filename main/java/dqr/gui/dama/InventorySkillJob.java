package dqr.gui.dama;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.DQR;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmStatus;
import dqr.dataTable.FuncJobSkillData;
import dqr.playerData.ExtendedPlayerProperties;

public class InventorySkillJob implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    //private ItemStack currentItem;
    private ItemStack[] items;
    private int jobId = -1;

    public InventorySkillJob(EntityPlayer ep, int par1)
    {

    	//int job = ExtendedPlayerProperties.get(ep).getJob();
    	int job = par1;
    	this.jobId = par1;
    	if(job != -1)
    	{
	    	int jobLv =  ExtendedPlayerProperties.get(ep).getJobLv(job);

	    	//int[] skillSet = ExtendedPlayerProperties3.get(ep).getJobSkillSetA2(job);

	    	EnumDqmStatus[] jobSkillCateg = FuncJobSkillData.getJobSkillCateg(job);

	    	int[] jobSkillParam = FuncJobSkillData.getJobSkillParam(job);
	    	int maxCount = FuncJobSkillData.getSkillMaxCount(jobLv);

	        //InventorySize
	        items = new ItemStack[18 + DQR.enumGetter.getJobSPSkillCounterJ2(job) + DQR.enumGetter.getJobSPSkillCounterAllJ(job)];

	        //DQR.func.debugString("GuiDebug : 7 / " + this.buttonList.size() + " / " + this.page + " / " + this.maxPage, this.getClass(), 4);

	        if(maxCount > 0 && par1 != -1)
	        {

	        	for(int cnt = 0; cnt < maxCount; cnt++)
	        	{
	        		items[cnt] = new ItemStack(jobSkillCateg[cnt].getSymbolItem(), 1);

	        		NBTTagCompound nbt = items[cnt].getTagCompound();
	        		if(nbt == null)
	            	{
	            		nbt = new NBTTagCompound();
	            	}

	        		nbt.setInteger("jobId", job);
	        		nbt.setInteger("categNum", cnt);
	        		nbt.setInteger("statusId", jobSkillCateg[cnt].getId());
	        		nbt.setInteger("statusParam", jobSkillParam[cnt]);

	        		nbt.setInteger("needSP", FuncJobSkillData.getNeedSP(cnt));

	        		items[cnt].setTagCompound(nbt);
	        		items[cnt].setStackDisplayName("dqm.skill.JSkill_" + jobSkillCateg[cnt].getName() + ".name");
	        		//items[cnt].setStackDisplayName("dqm.skill." + skillEnum.getName() + ".name");

	        		if(cnt >= 8)
	        		{
	        			break;
	        		}
	        	}
	        }

	    	int[] jobSkillParam2 = FuncJobSkillData.getJobSkillParam2(job);
	    	int maxCount2 = FuncJobSkillData.getSkillMaxCount2(jobLv);

	    	if(maxCount2 > 0 && par1 != -1)
	    	{
				for(int cnt = 0; cnt < maxCount2; cnt++)
				{
					items[cnt + 9] = new ItemStack(jobSkillCateg[cnt].getSymbolItem(), 1);

					NBTTagCompound nbt = items[cnt + 9].getTagCompound();
					if(nbt == null)
					{
						nbt = new NBTTagCompound();
					}

					nbt.setInteger("jobId", job);
					nbt.setInteger("categNum", cnt + 9);
					nbt.setInteger("statusId", jobSkillCateg[cnt].getId());
					nbt.setInteger("statusParam", jobSkillParam2[cnt]);

					nbt.setInteger("needSP", FuncJobSkillData.getNeedSP(cnt));
					nbt.setInteger("allFlg", 1);

					items[cnt + 9].setTagCompound(nbt);
					items[cnt + 9].setStackDisplayName("dqm.skill.JSkill_" + jobSkillCateg[cnt].getName() + ".name");
					//items[cnt].setStackDisplayName("dqm.skill." + skillEnum.getName() + ".name");

					if(cnt >= 8)
					{
						break;
					}
				}
	    	}

	    	int categCnt = 18;
	    	if(par1 != -1)
	    	{
	    		//DQR.func.debugString("TEST5 : " + job + " / " + DQR.enumGetter.getJobSPSkillCounterJ(job));
				for(int cnt = 0; cnt < DQR.enumGetter.getJobSPSkillCounterJ2(job); cnt++)
				{
					EnumDqmSkillJ skill = DQR.enumGetter.getSkillJ2(job, cnt);
					ItemStack itemSkill = new ItemStack(DQR.func.getJobSPSkillItemFromJobId(job), 1);
					//DQR.func.debugString("TEST1 : " + cnt);

					if(skill.getNeedlv() <= jobLv)
					{
						items[cnt + 18] = itemSkill;

						NBTTagCompound nbt = items[cnt + 18].getTagCompound();
						if(nbt == null)
						{
							nbt = new NBTTagCompound();
						}

						//DQR.func.debugString("TEST2 : " + skill.getNeedlv() + " / " + jobLv);

						//DQR.func.debugString("TEST3");

						/*
						nbt.setInteger("jobId", job);
						nbt.setInteger("categNum", cnt + 9);
						nbt.setInteger("statusId", jobSkillCateg[cnt].getId());
						nbt.setInteger("statusParam", jobSkillParam2[cnt]);
						*/
		            	nbt.setInteger("isJobSkill", 1);
		            	nbt.setInteger("jobId", job);
		            	nbt.setInteger("categNum", categCnt);
		            	nbt.setInteger("activeSkill", skill.getActiveskill());
		            	nbt.setInteger("skillIdx", skill.getIdx());
		            	nbt.setInteger("skillId", skill.getId());


						nbt.setInteger("needSP", skill.getNeedsp());
						//nbt.setInteger("allFlg", 1);

						items[cnt + 18].setTagCompound(nbt);
						items[cnt + 18].setStackDisplayName("dqm.skill.JSkill_" + skill.getJob() + "_" + skill.getIdx() + ".name");
						//items[cnt].setStackDisplayName("dqm.skill." + skillEnum.getName() + ".name");
						categCnt = categCnt + 1;
					}

				}


				int addCount = 0;
				for(int cnt = 0; cnt < DQR.enumGetter.getJobSPSkillCounterJ(job); cnt++)
				{
					//DQR.
					EnumDqmSkillJ skill = DQR.enumGetter.getSkillAllJ(job, cnt);
					ItemStack itemSkill = new ItemStack(DQR.func.getJobSPSkillItemFromJobId(job), 1);
					//DQR.func.debugString("TEST_A : " + cnt);

					if(skill != null && skill.getNeedlv() <= jobLv)
					{
						items[addCount + 18 + DQR.enumGetter.getJobSPSkillCounterJ2(job)] = itemSkill;

						NBTTagCompound nbt = items[addCount + 18 + DQR.enumGetter.getJobSPSkillCounterJ2(job)].getTagCompound();
						if(nbt == null)
						{
							nbt = new NBTTagCompound();
						}

						//DQR.func.debugString("TEST2 : " + skill.getNeedlv() + " / " + jobLv);

						//DQR.func.debugString("TEST3");

						/*
						nbt.setInteger("jobId", job);
						nbt.setInteger("categNum", cnt + 9);
						nbt.setInteger("statusId", jobSkillCateg[cnt].getId());
						nbt.setInteger("statusParam", jobSkillParam2[cnt]);
						*/
		            	nbt.setInteger("isJobSkill", 2);
		            	nbt.setInteger("jobId", job);
		            	nbt.setInteger("categNum", categCnt);
		            	nbt.setInteger("activeSkill", skill.getActiveskill());
		            	nbt.setInteger("skillIdx", skill.getIdx());
		            	nbt.setInteger("skillId", skill.getId());


						nbt.setInteger("needSP", skill.getNeedsp_All());
						//nbt.setInteger("allFlg", 1);

						items[addCount + 18 + DQR.enumGetter.getJobSPSkillCounterJ2(job)].setTagCompound(nbt);
						items[addCount + 18 + DQR.enumGetter.getJobSPSkillCounterJ2(job)].setStackDisplayName("dqm.skill.JSkill_" + skill.getJob() + "_" + skill.getIdx() + ".name");
						//items[cnt].setStackDisplayName("dqm.skill." + skillEnum.getName() + ".name");
						addCount = addCount+ 1;
						categCnt = categCnt + 1;
					}

				}
	    	}
    	}else
    	{
    		items = new ItemStack[0];
    	}

    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
    	if(slot >= items.length)
    	{
    		return null;
    	}else
    	{
    		return items[slot];
    	}
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.items[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.items[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.items[p_70298_1_];
                this.items[p_70298_1_] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.items[p_70298_1_].splitStack(p_70298_2_);

                if (this.items[p_70298_1_].stackSize == 0)
                {
                    this.items[p_70298_1_] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.items[p_70304_1_] != null)
        {
            ItemStack itemstack = this.items[p_70304_1_];
            this.items[p_70304_1_] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.items[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return "InventoryItem";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return true;
    }

    /*
        Containerが開かれたタイミングでItemStackの持っているNBTからアイテムを読み込んでいる
     */
    @Override
    public void openInventory()
    {
    	/*
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");

        for(int i = 0; i < tags.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
            int slot = tagCompound.getByte("Slot");
            if(slot >= 0 && slot < items.length)
            {
                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        */
    }

    /*
        Containerを閉じるときに保存
     */
    @Override
    public void closeInventory()
    {
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte)i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }
        //ItemStack result = new ItemStack(currentItem.getItem(), 1);
        //result.setTagCompound(new NBTTagCompound());
        //result.getTagCompound().setTag("Items", tagList);

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

    public int getJobId()
    {
    	return this.jobId;
    }

}
