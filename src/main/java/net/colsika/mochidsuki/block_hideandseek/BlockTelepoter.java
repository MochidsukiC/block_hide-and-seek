package net.colsika.mochidsuki.block_hideandseek;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockTelepoter extends BukkitRunnable {
    @Override
    public void run() {
        for(Player player : Block_hide_and_seek.plugin.getServer().getOnlinePlayers()){
            if(player.getInventory().getItemInMainHand().getType())
        }
    }
}
