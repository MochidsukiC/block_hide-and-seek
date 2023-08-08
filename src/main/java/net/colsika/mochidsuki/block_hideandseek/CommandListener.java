package net.colsika.mochidsuki.block_hideandseek;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

public class CommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        World world;
        try {
            world = ((Player)commandSender).getWorld();
        }catch (Exception e){
            try{
                world = ((Block)commandSender).getWorld();
            }catch (Exception exception){
                return false;
            }
        }


        if(command.getName().equalsIgnoreCase("bhs")){
            if(args[0].equalsIgnoreCase("start")){
                for(Material material : BlockList.blocks){

                    FallingBlock entity = world.spawnFallingBlock(new Location(world,0,-80,0), material.createBlockData());
                    entity.setGravity(false);
                    ArmorStand armorStand = (ArmorStand) world.spawnEntity(new Location(world,0,-80,0),EntityType.ARMOR_STAND);
                    armorStand.addPassenger(entity);
                    armorStand.setInvisible(true);
                    armorStand.setGravity(false);
                    BlockList.blockEntity.put(material,armorStand);
                    BlockList.matching = true;
                    new BlockTelepoter().runTaskTimer(Block_hide_and_seek.plugin,0,1);
                }
            } else if (args[0].equalsIgnoreCase("stop")) {
                BlockList.matching=false;
            }
        }
        BlockList.matchWorld = world;
        return true;
    }
}
