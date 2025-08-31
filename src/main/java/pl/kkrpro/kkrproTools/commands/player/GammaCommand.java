package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "gamma")
@Permission("kkrpro.tools.gamma")
public class GammaCommand {

    private final Main plugin;
    public final MessageConfig config;

    public GammaCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute
    void executeGamma(@Context Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION , -1 , 6000));
        player.sendMessage(ChatUtil.fixColor(config.GammaMessage));
    }
}
