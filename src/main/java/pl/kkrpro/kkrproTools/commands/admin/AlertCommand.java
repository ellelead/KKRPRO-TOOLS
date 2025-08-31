package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "alert")
@Permission("kkrpro.tools.alert")
public class AlertCommand {

    private final Main plugin;
    public final MessageConfig config;

    public AlertCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute(name = "title")
    public void executeAlert(@Context Player player, @Arg String[] args) {
        String message = build(args);
        AlertMessage(message);
    }
    @Execute(name = "bc")
    public void executeBc(@Context Player player, @Arg String[] args)  {
        String message = build(args);
        String prefix = config.BcMessage;
        Bukkit.broadcastMessage(ChatUtil.fixColor(prefix + message));
    }

    private String build(String[] args) {
        return ChatColor.translateAlternateColorCodes('&', String.join(" ", args));
    }

    private void AlertMessage(String message) {
        String prefix = config.TitleMessage;
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendTitle(ChatUtil.fixColor(prefix), ChatUtil.fixColor(message),10, 70, 20);
        }
    }
}
