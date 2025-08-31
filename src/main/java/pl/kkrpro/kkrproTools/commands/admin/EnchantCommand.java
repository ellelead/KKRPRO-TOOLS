package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "enchant")
@Permission("kkrpro.tools.enchant")
public class EnchantCommand {

    private final Main plugin;
    public final MessageConfig config;

    public EnchantCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeTest(@Context Player player, @Arg String enchantName, @Arg int level) {
        Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(enchantName.toLowerCase()));
        if (enchantment == null) {
            player.sendMessage(ChatUtil.fixColor("&cNie znaleziono enchantu: " + enchantName));
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()) {
            player.sendMessage(ChatUtil.fixColor(config.AirMessage));
            return;
        }

        item.addUnsafeEnchantment(enchantment, level);
        player.sendMessage(ChatUtil.fixColor(
                config.EnchantMessage
                        .replace("{enchant}", enchantment.getKey().getKey())
                        .replace("{level}", String.valueOf(level))
        ));
    }
}