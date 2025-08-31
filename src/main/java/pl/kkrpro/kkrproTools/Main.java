package pl.kkrpro.kkrproTools;

import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import dev.rollczi.litecommands.bukkit.LiteBukkitMessages;
import dev.rollczi.litecommands.message.LiteMessages;
import dev.rollczi.litecommands.time.DurationParser;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kkrpro.kkrproTools.commands.admin.*;
import pl.kkrpro.kkrproTools.commands.player.*;
import pl.kkrpro.kkrproTools.conifg.MessageConfig;
import pl.kkrpro.kkrproTools.conifg.PluginConfig;

import java.io.File;
import java.time.Duration;
import java.util.logging.Level;


public final class Main extends JavaPlugin {

    private static Main main;
    private LiteCommands<?> liteCommands;
    private MessageConfig config;
    private PluginConfig pluginConfig;


    @Override
    public void onEnable() {

        main = this;
        getDataFolder().mkdirs();
        loadConfigMessage();
        loadConfigPlugin();

        this.liteCommands = LiteBukkitFactory.builder(this)
                .commands(
                        new TeleportCommand(this, this.config),
                        new ReloadCommand(this, this.config),
                        new AlertCommand(this, this.config),
                        new GiveCommand(this, this.config),
                        new EnchantCommand(this, this.config),
                        new InvseeCommand(this, this.config),
                        new GameModeCommand(this, this.config),
                        new FlyCommand(this, this.config),
                        new ClearInventoryCommand(this, this.config),
                        new WorkBenchCommand(this, this.config),
                        new HealCommand(this, this.config),
                        new GammaCommand(this, this.config),
                        new FeedCommand(this, this.config),
                        new RepairCommand(this.config),
                        new EnderChestCommand(this, this.config),
                        new AnvilCommand(this, this.config),
                        new KoszCommand(this.pluginConfig),
                        new MsgCommand(this.config),
                        new HelpopCommand(this.config)
                )
                .message(LiteBukkitMessages.PLAYER_NOT_FOUND, input -> "&cNie znaleziono gracza o nicku &4" + input)
                .message(LiteBukkitMessages.INVALID_USAGE, input -> "&cKomenda nie istnieje lub nie masz do niej dostępu!")
                .message(LiteBukkitMessages.MISSING_PERMISSIONS, input -> "&cNie masz permisji do tej komendy!")
                .message(LiteMessages.COMMAND_COOLDOWN, ((invocation, cooldownState) -> {
                    Duration duration = cooldownState.getRemainingDuration();
                    String formattedTime = DurationParser.DATE_TIME_UNITS.format(duration);
                    return "&cMusisz poczekać &4" + formattedTime + " &cprzed następnym użyciem";
                }))
                .build();
        getLogger().info("Plugin " + getName() + " został włączony!");

    }
    @Override
    public void onDisable() {
        getLogger().info("Plugin " + getName() + " został wyłączony!");
    }

    public void loadConfigMessage() {
        try {
            this.config = ConfigManager.create(MessageConfig.class, it -> {
                it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
                it.withBindFile(new File(getDataFolder(), "message.yml"));
                it.saveDefaults();
                it.load(true);
            });
            getLogger().info("[#] Załadowano message.yml");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Wystapil blad podczas ladowania config.yml", e);
            getPluginLoader().disablePlugin(this);
        }
    }
    public void loadConfigPlugin() {
        this.pluginConfig = ConfigManager.create(PluginConfig.class, it -> {
            it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
            it.withBindFile(new File(getDataFolder(), "config.yml"));
            it.saveDefaults();
            it.load(true);
        });
        getLogger().info("[#] Załadowano config.yml");
    }

    public void reloadAll() {
        try {
            this.config.load(true);
            this.pluginConfig.load(true);
            getLogger().info("Przeładowano message.yml i config.yml");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Błąd w przeładowaniu");
        }
    }

    public static Main getMain() {
        return main;
    }

    public MessageConfig messageConfig() {
        return this.config;
    }
}
