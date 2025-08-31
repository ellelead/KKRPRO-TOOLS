package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "enderchest" , aliases = "ec")
@Permission("kkrpro.tools.enderchest")
public class EnderChestCommand {

    private final Main plugin;
    public final MessageConfig config;

    public EnderChestCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeEnderChest(@Context Player player) {
        Inventory ec = Bukkit.createInventory(null, InventoryType.ENDER_CHEST);
        player.openInventory(ec);
        player.sendMessage(ChatUtil.fixColor(config.EnderChestMessage));
    }
}
