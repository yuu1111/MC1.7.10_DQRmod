package dqr.keyHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import dqr.DQR;

public class KeyInputHandler {
    //キーが“押された時”に呼ばれる。“押しっぱなし”の判定は別途用意する必要あり。
    @SubscribeEvent
    public void KeyHandlingEvent(KeyInputEvent event) {

    	/*
    	GameSettings settings = Minecraft.getMinecraft().gameSettings;
    	System.out.println("AAAAAAAAA");
    	if(settings != null && settings.keyBindSneak.isPressed())
    	{
    		System.out.println("BBBBBBBB");
    		EntityPlayer ep = Minecraft.getMinecraft().thePlayer;


    		if(ExtendedPlayerProperties3.get(ep).tooltipInfoFlg)
    		{
    			System.out.println("TEST!!!!!!!!!!!!!");
    		}else
    		{
    			System.out.println("TEST???????????");
    		}
    	}
    	*/


    	if (DQR.CLKeyBind.keyGuiPositionMode.isPressed()) {
    		DQR.conf.guiPositionMode = DQR.conf.guiPositionMode == 0? 1: 0;

    		DQR.conf.setCLGuiPos1(DQR.conf.CLGuiPos1, DQR.conf.CLGuiPos1X, DQR.conf.CLGuiPos1Y);
    		DQR.conf.setCLGuiPos2(DQR.conf.CLGuiPos2, DQR.conf.CLGuiPos2X, DQR.conf.CLGuiPos2Y);
    		DQR.conf.setCLGuiArmorPos(DQR.conf.CLGuiArmorPos, DQR.conf.CLGuiArmorPosX, DQR.conf.CLGuiArmorPosY);
    		DQR.conf.setCLGuiLogPos(DQR.conf.CLGuiLogPos, DQR.conf.CLGuiLogPosX, DQR.conf.CLGuiLogPosY);
    		DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
    		DQR.conf.setCLGuiBuffBarPos(DQR.conf.CLGuiBuffBarPos, DQR.conf.CLGuiBuffBarPosX, DQR.conf.CLGuiBuffBarPosY);
    		DQR.conf.setCLGuiBuffBar2Pos(DQR.conf.CLGuiBuffBar2Pos, DQR.conf.CLGuiBuffBar2PosX, DQR.conf.CLGuiBuffBar2PosY);
    		DQR.conf.setCLGuiBuffBar3Pos(DQR.conf.CLGuiBuffBar3Pos, DQR.conf.CLGuiBuffBar3PosX, DQR.conf.CLGuiBuffBar3PosY);
    		DQR.conf.setCLGuiPartyPos(DQR.conf.CLGuiPartyPos, DQR.conf.CLGuiPartyPosX, DQR.conf.CLGuiPartyPosY, DQR.conf.CLGuiPartyReturnLine);
    		DQR.conf.setCLGuiBuffBar(DQR.conf.CLGuiBuffBarMode, DQR.conf.CLGuiBuffBarDispAreaHeight);
    		DQR.conf.setCLGuiBuffBar3(DQR.conf.CLGuiBuffBarMode, DQR.conf.CLGuiBuffBarDispAreaHeight);
    	}

    	if(DQR.conf.guiPositionTarget ==4 && DQR.conf.guiPositionMode == 1)
    	{
        	if(DQR.CLKeyBind.keyScrollUp.isPressed())
        	{
        		DQR.loglog.scroll(4);
        		//System.out.println("TEST???????????");
        	}
        	if(DQR.CLKeyBind.keyScrollDown.isPressed())
        	{
        		DQR.loglog.scroll(-4);
        		//System.out.println("TEST!!!!!!!!!");
        	}
        	if(DQR.CLKeyBind.keyLogDel.isPressed())
        	{
        		DQR.loglog.clearChatMessages();
        		//System.out.println("TEST!!!!!!!!!");
        	}
    	}

    	if(DQR.conf.guiPositionTarget ==6 && DQR.conf.guiPositionMode == 1)
    	{
        	if(DQR.CLKeyBind.keyScrollUp.isPressed())
        	{
        		DQR.conf.CLGuiBuffBarDispAreaHeight = DQR.conf.CLGuiBuffBarDispAreaHeight + DQR.conf.guiPositionSpeed;
        		//System.out.println("TEST???????????");
        	}
        	if(DQR.CLKeyBind.keyScrollDown.isPressed())
        	{
        		DQR.conf.CLGuiBuffBarDispAreaHeight = DQR.conf.CLGuiBuffBarDispAreaHeight - DQR.conf.guiPositionSpeed;
        		if(DQR.conf.CLGuiBuffBarDispAreaHeight < 25)
        		{
        			DQR.conf.CLGuiBuffBarDispAreaHeight = 25;
        		}
        		//System.out.println("TEST!!!!!!!!!");
        	}

        	if(DQR.CLKeyBind.keyBuffVisMode.isPressed())
        	{
        		if(DQR.conf.CLGuiBuffBarMode == 0)
        		{
        			DQR.conf.CLGuiBuffBarMode = 1;
        		}else
        		{
        			DQR.conf.CLGuiBuffBarMode = 0;
        		}
        		//System.out.println("TEST!!!!!!!!!");
        	}
    	}

    	if(DQR.conf.guiPositionTarget ==9 && DQR.conf.guiPositionMode == 1)
    	{
        	if(DQR.CLKeyBind.keyScrollUp.isPressed())
        	{
        		DQR.conf.CLGuiBuffBar3DispAreaHeight = DQR.conf.CLGuiBuffBar3DispAreaHeight + DQR.conf.guiPositionSpeed;
        		//System.out.println("TEST???????????");
        	}
        	if(DQR.CLKeyBind.keyScrollDown.isPressed())
        	{
        		DQR.conf.CLGuiBuffBar3DispAreaHeight = DQR.conf.CLGuiBuffBar3DispAreaHeight - DQR.conf.guiPositionSpeed;
        		if(DQR.conf.CLGuiBuffBar3DispAreaHeight < 25)
        		{
        			DQR.conf.CLGuiBuffBar3DispAreaHeight = 25;
        		}
        		//System.out.println("TEST!!!!!!!!!");
        	}

        	if(DQR.CLKeyBind.keyBuffVisMode.isPressed())
        	{
        		if(DQR.conf.CLGuiBuffBar3Mode == 0)
        		{
        			DQR.conf.CLGuiBuffBar3Mode = 1;
        		}else
        		{
        			DQR.conf.CLGuiBuffBar3Mode = 0;
        		}
        		//System.out.println("TEST!!!!!!!!!");
        	}
    	}

    	if (DQR.CLKeyBind.keyGuiPositionSpeed.isPressed()) {
    		//GUI位置調整 移動速度変更
    		switch(DQR.conf.guiPositionSpeed)
    		{
    			case 1: DQR.conf.guiPositionSpeed = 5; break;
    			case 5: DQR.conf.guiPositionSpeed = 10; break;
    			case 10: DQR.conf.guiPositionSpeed = 50; break;
    			case 50: DQR.conf.guiPositionSpeed = 100; break;
    			case 100: DQR.conf.guiPositionSpeed = 1; break;
    			default: DQR.conf.guiPositionSpeed = 1; break;
    		}
    	}

        if (DQR.CLKeyBind.keyGuiPlayerData.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiVis1 = DQR.conf.CLGuiVis1==0? 1 : 0;
        		DQR.conf.cfg_gui.get("HP/MP PlayerDataGUI","GUI Visible", DQR.conf.CLGuiVis1 ,"0=false 1=true").set(DQR.conf.CLGuiVis1);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=1)
        		{
        			DQR.conf.guiPositionTarget = 1;
        		}else
        		{
        			DQR.conf.CLGuiPos1 = DQR.conf.CLGuiPos1 == 15? 1 :DQR.conf.CLGuiPos1 + 1;
        			DQR.conf.CLGuiPos1X = 0;
        			DQR.conf.CLGuiPos1Y = 0;

        			//DQR.conf.setCLGuiPos1(DQR.conf.CLGuiPos1, DQR.conf.CLGuiPos1X, DQR.conf.CLGuiPos1Y);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiPlayerStatus.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiVis2 = DQR.conf.CLGuiVis2==0? 1 : 0;
        		DQR.conf.cfg_gui.get("PlayerStatusGUI","GUI Visible", DQR.conf.CLGuiVis2 ,"0=false 1=true").set(DQR.conf.CLGuiVis2);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=2)
        		{
        			DQR.conf.guiPositionTarget = 2;
        		}else
        		{
        			DQR.conf.CLGuiPos2 = DQR.conf.CLGuiPos2 == 15? 1 :DQR.conf.CLGuiPos2 + 1;
        			DQR.conf.CLGuiPos2X = 0;
        			DQR.conf.CLGuiPos2Y = 0;
        			//DQR.conf.setCLGuiPos2(DQR.conf.CLGuiPos2, DQR.conf.CLGuiPos2X, DQR.conf.CLGuiPos2Y);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiArmorStatus.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiArmorVis = DQR.conf.CLGuiArmorVis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("ArmotStatusGUI","GUI Visible", DQR.conf.CLGuiArmorVis ,"0=false 1=true").set(DQR.conf.CLGuiArmorVis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=3)
        		{
        			DQR.conf.guiPositionTarget = 3;
        		}else
        		{
        			DQR.conf.CLGuiArmorPos = DQR.conf.CLGuiArmorPos == 15? 1 :DQR.conf.CLGuiArmorPos + 1;
        			DQR.conf.CLGuiArmorPosX = 0;
        			DQR.conf.CLGuiArmorPosY = 0;
        			//DQR.conf.setCLGuiArmorPos(DQR.conf.CLGuiArmorPos, DQR.conf.CLGuiArmorPosX, DQR.conf.CLGuiArmorPosY);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiLog.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiLogVis = DQR.conf.CLGuiLogVis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlayLogGUI","GUI Visible", DQR.conf.CLGuiLogVis ,"0=false 1=true").set(DQR.conf.CLGuiLogVis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=4)
        		{
        			DQR.conf.guiPositionTarget = 4;
        		}else
        		{
        			DQR.conf.CLGuiLogPos = DQR.conf.CLGuiLogPos == 15? 1 :DQR.conf.CLGuiLogPos + 1;
        			DQR.conf.CLGuiLogPosX = 0;
        			DQR.conf.CLGuiLogPosY = 0;
        			//DQR.conf.setCLGuiLogPos(DQR.conf.CLGuiLogPos, DQR.conf.CLGuiLogPosX, DQR.conf.CLGuiLogPosY);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiSubpoints.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiSubpointsVis = DQR.conf.CLGuiSubpointsVis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlaySubpointsGUI","GUI Visible", DQR.conf.CLGuiSubpointsVis ,"0=false 1=true").set(DQR.conf.CLGuiSubpointsVis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=5)
        		{
        			DQR.conf.guiPositionTarget = 5;
        		}else
        		{
        			DQR.conf.CLGuiSubpointsPos = DQR.conf.CLGuiSubpointsPos == 15? 1 :DQR.conf.CLGuiSubpointsPos + 1;
        			DQR.conf.CLGuiSubpointsPosX = 0;
        			DQR.conf.CLGuiSubpointsPosY = 0;
        			//DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiBuffBar.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiBuffBarVis = DQR.conf.CLGuiBuffBarVis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlayPotionEffectTimeGUI","GUI Visible", DQR.conf.CLGuiBuffBarVis ,"0=false 1=true").set(DQR.conf.CLGuiBuffBarVis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=6)
        		{
        			DQR.conf.guiPositionTarget = 6;
        		}else
        		{
        			DQR.conf.CLGuiBuffBarPos = DQR.conf.CLGuiBuffBarPos == 15? 1 :DQR.conf.CLGuiBuffBarPos + 1;
        			DQR.conf.CLGuiBuffBarPosX = 0;
        			DQR.conf.CLGuiBuffBarPosY = 0;
        			//DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
        		}
        	}
        }

        /*
        if (DQR.CLKeyBind.keyGuiBuffBar3.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiBuffBar3Vis = DQR.conf.CLGuiBuffBar3Vis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlayJobSkillTimeGUI","GUI Visible", DQR.conf.CLGuiBuffBar3Vis ,"0=false 1=true").set(DQR.conf.CLGuiBuffBar3Vis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=9)
        		{
        			DQR.conf.guiPositionTarget = 9;
        		}else
        		{
        			DQR.conf.CLGuiBuffBar3Pos = DQR.conf.CLGuiBuffBar3Pos == 15? 1 :DQR.conf.CLGuiBuffBar3Pos + 1;
        			DQR.conf.CLGuiBuffBar3PosX = 0;
        			DQR.conf.CLGuiBuffBar3PosY = 0;
        			//DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
        		}
        	}
        }
        */

        if (DQR.CLKeyBind.keyGuiBuffBar2.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiBuffBar2Vis = DQR.conf.CLGuiBuffBar2Vis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlayJobSkillCoolTimeGUI","GUI Visible", DQR.conf.CLGuiBuffBar2Vis ,"0=false 1=true").set(DQR.conf.CLGuiBuffBar2Vis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=8)
        		{
        			DQR.conf.guiPositionTarget = 8;
        		}else
        		{
        			DQR.conf.CLGuiBuffBar2Pos = DQR.conf.CLGuiBuffBar2Pos == 15? 1 :DQR.conf.CLGuiBuffBar2Pos + 1;
        			DQR.conf.CLGuiBuffBar2PosX = 0;
        			DQR.conf.CLGuiBuffBar2PosY = 0;
        			//DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiParty.isPressed()) {
        	if(DQR.conf.guiPositionMode == 0)
        	{
        		DQR.conf.CLGuiPartyVis = DQR.conf.CLGuiPartyVis==0? 1 : 0;
        		DQR.conf.cfg_gui.get("GamePlayPotionEffectTimeGUI","GUI Visible", DQR.conf.CLGuiPartyVis ,"0=false 1=true").set(DQR.conf.CLGuiPartyVis);
        		DQR.conf.cfg_gui.save();
        	}else
        	{
        		if(DQR.conf.guiPositionTarget !=7)
        		{
        			DQR.conf.guiPositionTarget = 7;
        		}else
        		{
        			DQR.conf.CLGuiPartyPos = DQR.conf.CLGuiPartyPos == 15? 1 :DQR.conf.CLGuiPartyPos + 1;
        			DQR.conf.CLGuiPartyPosX = 0;
        			DQR.conf.CLGuiPartyPosY = 0;
        			//DQR.conf.setCLGuiSubpointsPos(DQR.conf.CLGuiSubpointsPos, DQR.conf.CLGuiSubpointsPosX, DQR.conf.CLGuiSubpointsPosY);
        		}
        	}
        }



        if (DQR.CLKeyBind.keyGuiPartyPlus.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		System.out.println("TEST1");
        		if(DQR.conf.guiPositionTarget == 7)
        		{
        			DQR.conf.CLGuiPartyReturnLine = DQR.conf.CLGuiPartyReturnLine + 1;
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiPartyMinus.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		System.out.println("TEST2");
        		if(DQR.conf.guiPositionTarget == 7)
        		{
        			if(DQR.conf.CLGuiPartyReturnLine < 2)
        			{
        				DQR.conf.CLGuiPartyReturnLine = 1;
        			}else
        			{
        				DQR.conf.CLGuiPartyReturnLine = DQR.conf.CLGuiPartyReturnLine - 1;
        			}
        		}
        	}
        }


        if (DQR.CLKeyBind.keyGuiPositionUP.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		switch(DQR.conf.guiPositionTarget)
        		{
        			case 0: break;
        			case 1: DQR.conf.CLGuiPos1Y = DQR.conf.CLGuiPos1Y - DQR.conf.guiPositionSpeed; break;
        			case 2: DQR.conf.CLGuiPos2Y = DQR.conf.CLGuiPos2Y - DQR.conf.guiPositionSpeed;break;
        			case 3: DQR.conf.CLGuiArmorPosY = DQR.conf.CLGuiArmorPosY - DQR.conf.guiPositionSpeed;break;
        			case 4: DQR.conf.CLGuiLogPosY = DQR.conf.CLGuiLogPosY - DQR.conf.guiPositionSpeed;break;
        			case 5: DQR.conf.CLGuiSubpointsPosY = DQR.conf.CLGuiSubpointsPosY - DQR.conf.guiPositionSpeed;break;
        			case 6: DQR.conf.CLGuiBuffBarPosY = DQR.conf.CLGuiBuffBarPosY - DQR.conf.guiPositionSpeed;break;
        			case 7: DQR.conf.CLGuiPartyPosY = DQR.conf.CLGuiPartyPosY - DQR.conf.guiPositionSpeed;break;
        			case 8: DQR.conf.CLGuiBuffBar2PosY = DQR.conf.CLGuiBuffBar2PosY - DQR.conf.guiPositionSpeed;break;
        			case 9: DQR.conf.CLGuiBuffBar3PosY = DQR.conf.CLGuiBuffBar3PosY - DQR.conf.guiPositionSpeed;break;
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiPositionDOWN.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		switch(DQR.conf.guiPositionTarget)
        		{
        			case 0: break;
        			case 1: DQR.conf.CLGuiPos1Y = DQR.conf.CLGuiPos1Y + DQR.conf.guiPositionSpeed; break;
        			case 2: DQR.conf.CLGuiPos2Y = DQR.conf.CLGuiPos2Y + DQR.conf.guiPositionSpeed;break;
        			case 3: DQR.conf.CLGuiArmorPosY = DQR.conf.CLGuiArmorPosY + DQR.conf.guiPositionSpeed;break;
        			case 4: DQR.conf.CLGuiLogPosY = DQR.conf.CLGuiLogPosY + DQR.conf.guiPositionSpeed;break;
        			case 5: DQR.conf.CLGuiSubpointsPosY = DQR.conf.CLGuiSubpointsPosY + DQR.conf.guiPositionSpeed;break;
        			case 6: DQR.conf.CLGuiBuffBarPosY = DQR.conf.CLGuiBuffBarPosY + DQR.conf.guiPositionSpeed;break;
        			case 7: DQR.conf.CLGuiPartyPosY = DQR.conf.CLGuiPartyPosY + DQR.conf.guiPositionSpeed;break;
        			case 8: DQR.conf.CLGuiBuffBar2PosY = DQR.conf.CLGuiBuffBar2PosY + DQR.conf.guiPositionSpeed;break;
        			case 9: DQR.conf.CLGuiBuffBar3PosY = DQR.conf.CLGuiBuffBar3PosY + DQR.conf.guiPositionSpeed;break;
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiPositionLEFT.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		switch(DQR.conf.guiPositionTarget)
        		{
        			case 0: break;
        			case 1: DQR.conf.CLGuiPos1X = DQR.conf.CLGuiPos1X - DQR.conf.guiPositionSpeed; break;
        			case 2: DQR.conf.CLGuiPos2X = DQR.conf.CLGuiPos2X - DQR.conf.guiPositionSpeed;break;
        			case 3: DQR.conf.CLGuiArmorPosX = DQR.conf.CLGuiArmorPosX - DQR.conf.guiPositionSpeed;break;
        			case 4: DQR.conf.CLGuiLogPosX = DQR.conf.CLGuiLogPosX - DQR.conf.guiPositionSpeed;break;
        			case 5: DQR.conf.CLGuiSubpointsPosX = DQR.conf.CLGuiSubpointsPosX - DQR.conf.guiPositionSpeed;break;
        			case 6: DQR.conf.CLGuiBuffBarPosX = DQR.conf.CLGuiBuffBarPosX - DQR.conf.guiPositionSpeed;break;
        			case 7: DQR.conf.CLGuiPartyPosX = DQR.conf.CLGuiPartyPosX - DQR.conf.guiPositionSpeed;break;
        			case 8: DQR.conf.CLGuiBuffBar2PosX = DQR.conf.CLGuiBuffBar2PosX - DQR.conf.guiPositionSpeed;break;
        			case 9: DQR.conf.CLGuiBuffBar3PosX = DQR.conf.CLGuiBuffBar3PosX - DQR.conf.guiPositionSpeed;break;
        		}
        	}
        }

        if (DQR.CLKeyBind.keyGuiPositionRIGHT.isPressed()) {
        	if(DQR.conf.guiPositionMode == 1)
        	{
        		switch(DQR.conf.guiPositionTarget)
        		{
        			case 0: break;
        			case 1: DQR.conf.CLGuiPos1X = DQR.conf.CLGuiPos1X + DQR.conf.guiPositionSpeed; break;
        			case 2: DQR.conf.CLGuiPos2X = DQR.conf.CLGuiPos2X + DQR.conf.guiPositionSpeed;break;
        			case 3: DQR.conf.CLGuiArmorPosX = DQR.conf.CLGuiArmorPosX + DQR.conf.guiPositionSpeed;break;
        			case 4: DQR.conf.CLGuiLogPosX = DQR.conf.CLGuiLogPosX + DQR.conf.guiPositionSpeed;break;
        			case 5: DQR.conf.CLGuiSubpointsPosX = DQR.conf.CLGuiSubpointsPosX + DQR.conf.guiPositionSpeed;break;
        			case 6: DQR.conf.CLGuiBuffBarPosX = DQR.conf.CLGuiBuffBarPosX + DQR.conf.guiPositionSpeed;break;
        			case 7: DQR.conf.CLGuiPartyPosX = DQR.conf.CLGuiPartyPosX + DQR.conf.guiPositionSpeed;break;
        			case 8: DQR.conf.CLGuiBuffBar2PosX = DQR.conf.CLGuiBuffBar2PosX + DQR.conf.guiPositionSpeed;break;
        			case 9: DQR.conf.CLGuiBuffBar3PosX = DQR.conf.CLGuiBuffBar3PosX + DQR.conf.guiPositionSpeed;break;
        		}
        	}
        }
    }
}
