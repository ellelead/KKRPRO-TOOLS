package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "tools")
@Permission("kkrpro.tools.reload")
public class ReloadCommand {

    private final Main plugin;
    public final MessageConfig config;

    public ReloadCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute(name = "reload")
    void executeReload(@Context Player player) {
        plugin.reloadAll();
        player.sendMessage(ChatUtil.fixColor(config.ReloadMessage));
    }
}
