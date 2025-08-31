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

@Command(name = "invsee")
@Permission("kkrpro.tools.invsee")
public class InvseeCommand {

    private final Main plugin;
    public final MessageConfig config;

    public InvseeCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeInvsee(@Context Player player , @Arg Player target) {

        player.openInventory(target.getInventory());
        player.sendMessage(ChatUtil.fixColor(config.InvseeMessage.replace("{target}", target.getName())));
    }
}
