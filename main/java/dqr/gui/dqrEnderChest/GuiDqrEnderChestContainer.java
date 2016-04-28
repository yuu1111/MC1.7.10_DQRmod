package dqr.gui.dqrEnderChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.blocks.chest.InventoryDqmEnderChest;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest;
import dqr.playerData.ExtendedPlayerProperties2;

public class GuiDqrEnderChestContainer extends Container
{
    private InventoryDqmEnderChest inventory;

    public GuiDqrEnderChestContainer(EntityPlayer ep)
    {
    	//System.out.println("isRemote:" + ep.worldObj.isRemote);
    	InventoryPlayer inventoryPlayer = ep.inventory;
    	//System.out.println("TESTAAA");
        //inventory = new InventoryPetInventory(ExtendedPlayerProperties3.get(inventoryPlayer.player).getStatusPet());
    	inventory = new InventoryDqmEnderChest(ep);

        DqmTileEntityEnderChest tileentityenderchest = ExtendedPlayerProperties2.get(ep).getEnderChestEntity();
        //System.out.println("TESTCCC");
        inventory.func_146031_a(tileentityenderchest);
        inventory.openInventory();

        //int i = 2 * 18 + 2;
        int i = 2 * 18 + 1;

        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int j = 6; j < 17; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + 14 + (18 * 9) + k * 18, 18 + (j - 6) * 18));
            }
        }


        /*
        for (int k = 0; k < 3; ++k)
        {
            this.addSlotToContainer(new Slot(inventory, 18 + k, 8 + k * 18, 24 + 0 * 18));
        }
        */

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotDqrEnderChest(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotDqrEnderChest(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }


    }

    /*
        Containerが開いてられるか
     */
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < this.inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            //シフトクリック時に、このアイテムだったら動かさない。
            /*
            else if(slot.getStack() != null && slot.getStack().getItem() == InventoryItemCore.instance.inventoryItem)
            {
                return null;
            }
            */
            else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /*
        Containerを閉じるときに呼ばれる
     */
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.inventory.closeInventory();
    }
}