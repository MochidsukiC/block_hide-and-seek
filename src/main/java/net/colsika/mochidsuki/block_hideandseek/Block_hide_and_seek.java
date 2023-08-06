package net.colsika.mochidsuki.block_hideandseek;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashSet;

public final class Block_hide_and_seek extends JavaPlugin {

    static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

class BlockList{
    static HashSet<Material> blocks = new HashSet<>();
}
