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

@Command(name = "workbench" , aliases = "crafting")
@Permission("kkrpro.tools.workbench")
public class WorkBenchCommand {

    private final Main plugin;
    public final MessageConfig config;

    public WorkBenchCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeWorkBench(@Context Player player) {
        Inventory workbench = Bukkit.createInventory(null, InventoryType.WORKBENCH);
        player.openInventory(workbench);
        player.sendMessage(ChatUtil.fixColor(config.CraftingMessage));
    }

}
