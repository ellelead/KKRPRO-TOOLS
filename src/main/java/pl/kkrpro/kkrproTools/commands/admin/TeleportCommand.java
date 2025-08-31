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

@Command(name = "teleport" , aliases = "tp")
@Permission("kkrpro.tools.teleport")
public class TeleportCommand {

    private final Main plugin;
    public final MessageConfig config;

    public TeleportCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeTeleport(@Context Player player, @Arg Player target) {

        player.teleport(target);
        player.sendMessage(ChatUtil.fixColor(config.PlayerTeleportMessage.replace("{target}", target.getName())));

        target.teleport(player);
        player.sendMessage(ChatUtil.fixColor(config.TargetTeleportMessage.replace("{target}", target.getName())));
    }

}
