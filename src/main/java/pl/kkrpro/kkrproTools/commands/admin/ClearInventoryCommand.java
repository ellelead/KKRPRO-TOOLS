package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "clear")
@Permission("kkrpro.tools.clear")
public class ClearInventoryCommand {

    private final Main plugin;
    public final MessageConfig config;

    public ClearInventoryCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeClearInventory(@Context Player player , @Arg Player target) {
        player.sendMessage(ChatUtil.fixColor(config.ClearMessage.replace("{target}", target.getName())));
        target.getInventory().clear();
    }

}
