package dqr.thread;

import net.minecraft.entity.player.EntityPlayer;
import dqr.DQR;

public class ThreadJukurenUp extends Thread{
	private EntityPlayer ep;
	private int weaponId = -1;
	private int recalcFlg = 0;

	public ThreadJukurenUp(EntityPlayer player)
	{
		this.ep = player;
	}

	public ThreadJukurenUp(EntityPlayer player, int recalcFlg, int weaponId)
	{
		this.ep = player;
		this.weaponId = weaponId;
		this.recalcFlg = recalcFlg;
	}

	public void run()
	{
		//DQR.func.jukurenUpProcessMain(ep);
		DQR.func.jukurenUpProcessMain(ep, recalcFlg, weaponId);
		/*
		boolean flg = true;
		int epLv = ExtendedPlayerProperties.get(this.ep).getJukurenLv(ExtendedPlayerProperties.get(this.ep).getWeapon());
		int epEXP = ExtendedPlayerProperties.get(this.ep).getJukurenExp(ExtendedPlayerProperties.get(this.ep).getWeapon());

		for (int i = 0; i < 20; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 10 && epEXP >= DQR.exp.getJukurenNextExp(epLv))
			{
				//String weaponName = I18n.format("gui.weapon." + ExtendedPlayerProperties.get(this.ep).getWeapon());
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(this.ep).setJukurenLv(ExtendedPlayerProperties.get(this.ep).getWeapon(), epLv);

				int jukurenWP = ExtendedPlayerProperties.get(this.ep).getJukurenWP(ExtendedPlayerProperties.get(this.ep).getWeapon());

				switch(epLv)
				{
					case 2: jukurenWP = jukurenWP + 15; break;
					case 3: jukurenWP = jukurenWP + 25; break;
					case 4: jukurenWP = jukurenWP + 35; break;
					case 5: jukurenWP = jukurenWP + 45;  break;
					case 6: jukurenWP = jukurenWP + 55; break;
					case 7: jukurenWP = jukurenWP + 65; break;
					case 8: jukurenWP = jukurenWP + 75; break;
					case 9: jukurenWP = jukurenWP + 85; break;
					case 10: jukurenWP = jukurenWP + 100; break;
				}

				ExtendedPlayerProperties.get(this.ep).setJukurenWP(ExtendedPlayerProperties.get(this.ep).getWeapon(), jukurenWP);
				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {weaponName, epLv}));
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {
						new ChatComponentTranslation("gui.weapon." + ExtendedPlayerProperties.get(this.ep).getWeapon()), epLv}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.skillup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)1), (EntityPlayerMP)ep);
				flg = false;

				//外部からの干渉用
				DqmJukurenUpEvent event = new DqmJukurenUpEvent(this.ep, ExtendedPlayerProperties.get(this.ep).getWeapon(), epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					break;
				}
			}

			if(flg)
			{
				break;
			}
		}
		*/
	}
}
