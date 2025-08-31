package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.optional.OptionalArg;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "give")
@Permission("kkrpro.tools.give")
public class GiveCommand {

    private final Main plugin;
    public final MessageConfig config;

    public GiveCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @SuppressWarnings("DataFlowIssue")
    @Execute
    void executeGive(@Context Player player, @Arg("nick") Player target , @Arg("item") Material item, @OptionalArg("amount") Integer amount) {
        if (amount == null) {
            amount = 1;
        }
        target.getInventory().addItem(new ItemStack(item , amount));
        player.sendMessage(ChatUtil.fixColor(
                config.GiveMessage
                        .replace("{target}", target.getName())
                        .replace("{amount}", String.valueOf(amount))
                        .replace("{item}", item.name())
        ));
    }
}
