package alaurinfoodnstamina.alaurinfoodnstamina;

import alaurinfoodnstamina.alaurinfoodnstamina.Events.AlaurinItemConsumptionEvent;
import alaurinfoodnstamina.alaurinfoodnstamina.Events.AlaurinPlayerMoveEvent;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class AlaurinFoodnStamina extends JavaPlugin {

    public static File configFile;
    public static FileConfiguration configCFG = new YamlConfiguration();
    //Ususally don't use static here, bad habit.
    //Make the instance
    @Getter
    private static AlaurinFoodnStamina instance;


    @Override
    public void onEnable() {
        createConfig();
        getServer().getPluginManager().registerEvents(new AlaurinItemConsumptionEvent(), this);
        getServer().getPluginManager().registerEvents(new AlaurinPlayerMoveEvent(), this);
    }

    @Override
    public void onDisable() {
        //To avoid memory leaks. If you don't do this, make it a habit.
        instance = null;
    }

    private void createConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        configFile = new File(getDataFolder() + File.separator + "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }

        configCFG = new YamlConfiguration();

        try {
            configCFG.load(configFile);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
