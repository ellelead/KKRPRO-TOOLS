package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "feed")
@Permission("kkrpro.tools.feed")
public class FeedCommand {

    private final Main plugin;
    public final MessageConfig config;

    public FeedCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeFeed(@Context Player player) {
        player.setFoodLevel(20);
        player.sendMessage(ChatUtil.fixColor(config.FeedMessage));
    }

}
