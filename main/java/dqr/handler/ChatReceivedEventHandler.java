package dqr.handler;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.enums.EnumDqmMessageConv;

public class ChatReceivedEventHandler {
	@SubscribeEvent
	public void onClientChatReceivedEvent(ClientChatReceivedEvent event) {

		String chatMessage = "";

        if (event.message != null)
        {
        	if(event.message.getFormattedText().length() <= 8)
        	{
        		chatMessage = event.message.getFormattedText() + "        ";
        	}else
        	{
        		chatMessage = event.message.getFormattedText();
        	}

        	if(chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getStartS()) >= 0)
        	{
        		int startPos = chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getStartS());
        		int endPos = chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getEndS());

        		if(startPos < endPos)
        		{
        			String mobName = chatMessage.substring(startPos, endPos + EnumDqmMessageConv.MonsterName.getEndLength());
        			//System.out.println(mobName);
        			String mobNameFix = I18n.format(("entity." + mobName + ".name")
        											 .replace(EnumDqmMessageConv.MonsterName.getStartS(),"")
        											 .replace(EnumDqmMessageConv.MonsterName.getEndS(), "")
        											);
        			chatMessage = chatMessage.replace(mobName, mobNameFix);
        			//System.out.println(mobName + "/" + mobNameFix);
        		}
        	}
        	if(chatMessage.indexOf(EnumDqmMessageConv.JobName.getStartS()) >= 0)
        	{
        		int startPos = chatMessage.indexOf(EnumDqmMessageConv.JobName.getStartS());
        		int endPos = chatMessage.indexOf(EnumDqmMessageConv.JobName.getEndS());

        		if(startPos < endPos)
        		{
        			String mobName = chatMessage.substring(startPos, endPos + EnumDqmMessageConv.JobName.getEndLength());
//        			System.out.println(mobName);
        			String mobNameFix = I18n.format(("main.job." + mobName)
        											 .replace(EnumDqmMessageConv.JobName.getStartS(),"")
        											 .replace(EnumDqmMessageConv.JobName.getEndS(), "")
        											);
        			chatMessage = chatMessage.replace(mobName, mobNameFix);
//        			System.out.println(mobName + "/" + mobNameFix);
        		}
        	}


        	if(DQR.conf.CLGuiLogVis == 1 || DQR.conf.CLGuiLogWindowOff == 0)
        	{
	        	if (chatMessage.indexOf("<") == -1 && chatMessage.indexOf(">") == -1 && !(chatMessage.indexOf("!player.") >= 0))
	        	{
	        		//DQR.proxy.SetChatLogMessage(event.message);
	        		//event.setCanceled(true);

	        		//System.out.println("通過B");
	    	    	if (DQR.dqmLog[0] == "")
	    	    	{
	    	    		DQR.dqmLog[0] = chatMessage;
	    	    	}else if (DQR.dqmLog[1] == "")
	    	    	{
	    	    		DQR.dqmLog[1] = chatMessage;
	    	    	}else if (DQR.dqmLog[2] == "")
	    	    	{
	    	    		DQR.dqmLog[2] = chatMessage;
	    	    	}else if (DQR.dqmLog[3] == "")
	    	    	{
	    	    		DQR.dqmLog[3] = chatMessage;
	    	    	}else if (DQR.dqmLog[4] == "")
	    	    	{
	    	    		DQR.dqmLog[4] = chatMessage;
	    	    	}else if (DQR.dqmLog[5] == "")
	    	    	{
	    	    		DQR.dqmLog[5] = chatMessage;
	    	    	}else if (DQR.dqmLog[6] == "")
	    	    	{
	    	    		DQR.dqmLog[6] = chatMessage;
	    	    	}else if (DQR.dqmLog[7] == "")
	    	    	{
	    	    		DQR.dqmLog[7] = chatMessage;
	    	    	}else
	    	    	{
		    			DQR.dqmLog[0] = DQR.dqmLog[1];
		    			DQR.dqmLog[1] = DQR.dqmLog[2];
		    			DQR.dqmLog[2] = DQR.dqmLog[3];
		    			DQR.dqmLog[3] = DQR.dqmLog[4];
		    			DQR.dqmLog[4] = DQR.dqmLog[5];
		    			DQR.dqmLog[5] = DQR.dqmLog[6];
		    			DQR.dqmLog[6] = DQR.dqmLog[7];
		    			DQR.dqmLog[7] = chatMessage;
	    	    	}

	    	    	event.setCanceled(true);
	        	}
        	}else if(DQR.conf.CLGuiLogWindowOff == 1)
        	{
        		event.message = new ChatComponentTranslation(chatMessage,new Object[] {});
        	}

        	if(chatMessage.substring(0, 8).equalsIgnoreCase("!player."))
			{
        		//System.out.println("DEBUGLINE:");
        		event.message = new ChatComponentTranslation(chatMessage.replace("!player.", ""),new Object[] {});
			}else if(DQR.conf.CLGuiLogWindowOff == 2)
        	{
        		event.setCanceled(true);
        	}

        }
	}
}
