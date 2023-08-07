package net.colsika.mochidsuki.block_hideandseek;

import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Warden;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public final class Block_hide_and_seek extends JavaPlugin {

    static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        //config
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        Config config1 = new Config(this);
        config1.load();

        //command
        getCommand("bhs").setExecutor(new CommandListener());

        BlockList.matching = false;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

class BlockList{
    static HashSet<Material> blocks = new HashSet<>();
    static HashMap<Material, Entity> blockEntity = new HashMap<>();
    static boolean matching;
    static World matchWorld;
}
