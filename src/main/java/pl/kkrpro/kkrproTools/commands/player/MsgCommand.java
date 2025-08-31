package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "msg")
@Permission("kkrpro.tools.msg")
public class MsgCommand {

    public final MessageConfig config;

    public MsgCommand(MessageConfig config) {
        this.config = config;
    }


    @Execute
    void executeMsg(@Context Player player, @Arg Player target, @Arg String[] args) {

        String message = String.join(" ", args);

        player.sendMessage(ChatUtil.fixColor(config.PlayerMsgMessage.replace("{target}", target.getName()).replace("{message}", message)));

        target.sendMessage(ChatUtil.fixColor(config.TargetMsgMessage.replace("{player}" , player.getName()).replace("{message}", message)));
    }

}
