package pl.kkrpro.kkrproTools.commands.player;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.conifg.PluginConfig;
import pl.kkrpro.kkrproTools.gui.KoszGui;

@Command(name = "kosz")
@Permission("kkrpro.tools.kosz")
public class KoszCommand {

    public final PluginConfig pluginConfig;

    public KoszCommand(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @Execute
    void executeKosz(@Context Player player) {
        KoszGui KoszGui = new KoszGui(pluginConfig.KoszGuiName, pluginConfig.Slots);
        KoszGui.show(player);
    }

}
