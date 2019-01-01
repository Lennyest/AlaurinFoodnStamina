package alaurinfoodnstamina.alaurinfoodnstamina;

import alaurinfoodnstamina.alaurinfoodnstamina.Events.AlaurinItemConsumptionEvent;
import alaurinfoodnstamina.alaurinfoodnstamina.Events.AlaurinPlayerMoveEvent;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class AlaurinFoodnStamina extends JavaPlugin {

    private static AlaurinFoodnStamina instance;
    public static AlaurinFoodnStamina getInstance() {
        return instance;
    }

    public FileConfiguration getConfigCFG() {
        return configCFG;
    }

    private File configFile;
    private FileConfiguration configCFG = new YamlConfiguration();

/*    public int amountToCrouch = (int) configCFG.get("AmountToCrouch");
    public int percentage = (int) configCFG.get("FoodPercentage");*/




    @Override
    public void onEnable() {
        createConfig();
        getServer().getPluginManager().registerEvents(new AlaurinItemConsumptionEvent(), this);
        getServer().getPluginManager().registerEvents(new AlaurinPlayerMoveEvent(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void createConfig() {
        //Try, old was without the File.seperator
        configFile = new File(getDataFolder() + File.separator + "config.yml");
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            saveResource("config.yml", true);
        }
        configCFG = new YamlConfiguration();
        try {
            configCFG.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
