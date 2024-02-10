package ts.ralexme.trollplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class TrollPlugin extends JavaPlugin {
    public static final String ANSI_RED = "\u001B[31m";
    private static TrollPlugin instance; //instance for config and others
    FileConfiguration config; //for config
    File cfile;  //for config

    @Override
    public void onEnable() {
        //-------------------------- ENABLING --------------------------
        getServer().getLogger().info(ANSI_RED + "TrollPlugin by RalexME - Successfully enabled");
        //--------------------------/ENABLING --------------------------

        //-------------------------- NOW FOR CONFIG --------------------------
        instance = this; //instance for config and others
        saveDefaultConfig(); //config.yml
        config = getConfig(); //config
        cfile = new File(getDataFolder(), "config.yml"); //getting config.yml
        //-------------------------- /NOW FOR CONFIG --------------------------

        //--------------------------- FUNCTIONS --------------------------------

        //Register events file
        Bukkit.getPluginManager().registerEvents(new events(this), this); // Передаем экземпляр плагина
        //---------------------------/FUNCTIONS --------------------------------
    }

    @Override
    public void onDisable() {
        //-------------------------- DISABLING --------------------------
        getServer().getLogger().info(ANSI_RED + "TrollPlugin by RalexME - Successfully disabled");
        //--------------------------/DISABLING --------------------------
    }

    public static TrollPlugin getInstance() {
        return instance; //returning instance(public)
    }
}



