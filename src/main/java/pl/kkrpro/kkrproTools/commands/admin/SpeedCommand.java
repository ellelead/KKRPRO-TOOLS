package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "speed")
@Permission("kkrpro.tools.speed")
public class SpeedCommand {

    public final MessageConfig config;

    public SpeedCommand(MessageConfig config) {
        this.config = config;
    }

    @Execute
    void executeSpeed(@Context Player player, @Arg int speedlevel) {
        if (speedlevel < 1 || 9 > speedlevel) {
            player.sendMessage(ChatUtil.fixColor(config.SpeedMessage));
            return;
        }
        player.removePotionEffect(PotionEffectType.SPEED);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,  6000 , speedlevel -1));

        player.sendMessage(ChatUtil.fixColor(config.SpeedSetMessage.replace("{level}", String.valueOf(speedlevel))));
    }

}
