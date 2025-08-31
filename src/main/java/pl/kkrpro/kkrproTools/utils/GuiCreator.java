package pl.kkrpro.kkrproTools.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pl.kkrpro.kkrproTools.Main;

public abstract class GuiCreator implements InventoryHolder {

    public static Main main = Main.getMain();

    protected Inventory inv;
    private String title;
    private int size;

    public GuiCreator(String title, int slots) {
        this.title = title;

        if (slots < 9 || slots > 54 || slots % 9 != 0) {
            slots = 54;
        }

        this.size = slots;
        this.inv = Bukkit.createInventory(this, this.size, ChatUtil.fixColor(title));
    }

    public void setItem(int i, ItemStack itemStack) {
        this.inv.setItem(i - 1, itemStack);
    }

    @Override
    public Inventory getInventory() {
        return this.inv;
    }

    public void setContents(Player p) {}

    public ItemStack getItemStack(int slot) {
        return this.inv.getItem(slot - 1);
    }

    public void show(Player p) {
        if (this.inv != null) {
            setContents(p);
        }
        p.openInventory(this.inv);
    }

    public void show(Player p, String title) {
        this.title = title;

        this.inv = Bukkit.createInventory(this, this.size, ChatUtil.fixColor(title));
        if (this.inv != null) {
            setContents(p);
        }
        p.openInventory(this.inv);
    }

    public Inventory getInv() {
        return this.inv;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    public void handleCloseAction(InventoryCloseEvent e) {}

    public abstract void handleClickAction(InventoryClickEvent event);
}
