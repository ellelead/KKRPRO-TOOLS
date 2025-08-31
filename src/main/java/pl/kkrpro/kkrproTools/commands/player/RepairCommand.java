package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "repair")
@Permission("kkrpro.tools.repair")
public class RepairCommand {

    public final MessageConfig config;

    public RepairCommand(MessageConfig config) {
        this.config = config;
    }

    @Execute
    void executeRepair(@Context Player player) {
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()) {
            player.sendMessage(ChatUtil.fixColor(config.RepairAirMessage));
            return;
        }

        ItemMeta meta = item.getItemMeta();
        if (meta instanceof Damageable damageable) {
            damageable.setDamage(0);
            item.setItemMeta(damageable);
            player.sendMessage(ChatUtil.fixColor(config.RepairSuccesMessage));
        } else {
            player.sendMessage(ChatUtil.fixColor(config.RepairNothingMessage));
        }
    }

    @Execute(name = "all")
    @Permission("kkrpro.tools.repair.all")
    void executeRepairAll(@Context Player player) {
        Inventory inventory = player.getInventory();
        int repairedItems = 0;

        for (ItemStack item : inventory.getContents()) {
            if (item == null || item.getType().isAir()) {
                continue;
            }

            ItemMeta meta = item.getItemMeta();
            if (meta instanceof Damageable damageable) {
                if (damageable.hasDamage()) {
                    damageable.setDamage(0);
                    item.setItemMeta(damageable);
                    repairedItems++;
                }
            }
        }

        if (repairedItems > 0) {
            player.sendMessage(ChatUtil.fixColor(config.RepairAllSuccesMessage
                    .replace("{amount}", String.valueOf(repairedItems))));
        } else {
            player.sendMessage(ChatUtil.fixColor(config.RepairAllNothingMessage));
        }
    }
}
