package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "kill")
@Permission("kkrpro.tools.kill")
public class KillCommand {

    public final MessageConfig config;

    public KillCommand(MessageConfig config) {
        this.config = config;
    }

    @Execute
    void executeKill(@Context Player player, @Arg Player target) {
        player.sendMessage(ChatUtil.fixColor(config.KillMessage.replace("{target}", target.getName())));
        target.setHealth(0);
    }

}
