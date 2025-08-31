package pl.kkrpro.kkrproTools.commands.admin;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import pl.kkrpro.kkrproTools.Main;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.utils.ChatUtil;

@Command(name = "gamemode" , aliases = "gm")
@Permission("kkrpro.tools.gamemode")
public class GameModeCommand {

    private final Main plugin;
    public final MessageConfig config;

    public GameModeCommand(Main plugin, MessageConfig config) {
        this.plugin = plugin;
        this.config = config;
    }

    @Execute(name = "survival")
    void GameModeSurvival(@Context Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(ChatUtil.fixColor(config.GameModeSurvivalMessage));
    }
    @Execute(name = "creative")
    void GameModeCreative(@Context Player player) {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(ChatUtil.fixColor(config.GameModeCreativeMessage));
    }
    @Execute(name = "adventure")
    void GameModeAdventure(@Context Player player) {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(ChatUtil.fixColor(config.GameModeAdventureMessage));
    }
    @Execute(name = "spectator")
    void GameModeSpectator(@Context Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(ChatUtil.fixColor(config.GameModeSpectatorMessage));
    }
}
