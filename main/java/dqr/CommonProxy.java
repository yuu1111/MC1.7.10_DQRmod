package dqr;

import java.io.File;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dqr.entity.magicEntity.MagicRegister;
import dqr.entity.mobEntity.MobRegister;
import dqr.entity.mobEntity.MobSpawnRegister;
import dqr.entity.petEntity.PetRegister;
import dqr.entity.throwingEntity.ThrowingRegister;
import dqr.gui.farmBook.GuiFarmBookContainer;

public class CommonProxy implements IGuiHandler
{

	public File getDir()
	{
		return new File(".");
	}

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == DQR.conf.GuiID_FarmBook) {
            return new GuiFarmBookContainer(x, y, z);
        }
        return null;
    }

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void registerClientInfo(){}

    public void registers(){
    	new MobRegister();
    	new MobSpawnRegister();
    	new MagicRegister();
    	new ThrowingRegister();
    	new PetRegister();
    	//new BlockTileEntityRegister();

    }

    public EntityPlayer getEntityPlayerInstance() {return null;}

    public void registerGUI(){}


    public int getNewRenderType()
    {
    	return -1;
    }

    public void registersItemRender(){

    }
}
