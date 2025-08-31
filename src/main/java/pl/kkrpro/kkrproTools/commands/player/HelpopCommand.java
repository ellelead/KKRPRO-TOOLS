package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "helpop")
public class HelpopCommand {

    public final MessageConfig config;

    public HelpopCommand(MessageConfig config) {
        this.config = config;
    }

    @Execute
    void executeHelpop(@Context Player player, @Arg String[] args) {
        String message = String.join(" ", args);
        player.sendMessage(ChatUtil.fixColor(config.HelpopPlayerMessage.replace("{message}", message)));

        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.hasPermission("kkrpro.tools.helpop")) {
                online.sendMessage(ChatUtil.fixColor(
                        config.HelpopAdmMessage
                                .replace("{player}", player.getName())
                                .replace("{message}", message)
                ));
            }
        }
    }
}