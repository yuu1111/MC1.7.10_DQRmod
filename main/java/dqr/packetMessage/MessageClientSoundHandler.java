package dqr.packetMessage;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;

public class MessageClientSoundHandler implements IMessageHandler<MessageClientSound, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageClientSound message, MessageContext ctx) {
        //クライアントへ送った際に、EntityPlayerインスタンスはこのように取れる。
    	Random rand = new Random();
    	EntityPlayer player = DQR.proxy.getEntityPlayerInstance();

        byte pat = message.data;

        switch(pat)
        {
        	case 0:player.worldObj.playSoundAtEntity(player, "dqr:player.levelup", 1.0F, 1.0F); break;
        	case 1:player.worldObj.playSoundAtEntity(player, "dqr:player.skillup", 1.0F, 1.0F); break;
        	case 2:player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F); break;
        	case 3:player.worldObj.playSoundAtEntity(player, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
        }

        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        //EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        //Do something.
        return null;//本来は返答用IMessageインスタンスを返すのだが、旧来のパケットの使い方をするなら必要ない。
    }
}
