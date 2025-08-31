package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "heal")
@Permission("kkrpro.tools.heal")
public class HealCommand {

    private final Main plugin;
    public final MessageConfig config;

    public HealCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeHeal(@Context Player player) {
        player.setHealth(20);
        player.sendMessage(ChatUtil.fixColor(config.HealMessage));
    }

}
