package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "fly")
@Permission("kkrpro.tools.fly")
public class FlyCommand {

    private final Main plugin;
    public final MessageConfig config;

    public FlyCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeFly(@Context Player player) {

        boolean canFly = !player.getAllowFlight();
        player.setAllowFlight(canFly);

        if (canFly) {
            player.sendMessage(ChatUtil.fixColor(config.FlyOnMessage));
        } else {
            player.setFlying(false);
            player.sendMessage(ChatUtil.fixColor(config.FlyOffMessage));
            }
        }
    }
