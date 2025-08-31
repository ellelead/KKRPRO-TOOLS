package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.cooldown.Cooldown;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "anvil")
@Permission("kkrpro.tools.anvil")
public class AnvilCommand {

    private final Main plugin;
    public final MessageConfig config;

    public AnvilCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeAnvil(@Context Player player) {
        Inventory anvil = Bukkit.createInventory(null, InventoryType.ANVIL);
        player.openInventory(anvil);
        player.sendMessage(ChatUtil.fixColor(config.AnvilMessage));
    }

}
