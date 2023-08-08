package net.colsika.mochidsuki.block_hideandseek;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockTelepoter extends BukkitRunnable {
    @Override
    public void run() {
        if(BlockList.matching) {
            for (Player player : Block_hide_and_seek.plugin.getServer().getOnlinePlayers()) {
                if (BlockList.blocks.contains(player.getInventory().getItemInMainHand().getType())) {
                    Material item = player.getInventory().getItemInMainHand().getType();
                    String command = String.format("tp %s %s %s %s", BlockList.blockEntity.get(item).getUniqueId(), player.getLocation().getX(), player.getLocation().getY() - 1.482, player.getLocation().getZ());
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2, 0, true, true));
                }
            }
        }else {
            for(Material material : BlockList.blocks){
                BlockList.blockEntity.get(material).teleport(new Location(BlockList.matchWorld,0,-20,0));;
            }
            cancel();
        }
    }
}
