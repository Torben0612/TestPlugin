package com.torben.testplugin;

import net.minecraft.server.v1_16_R3.ItemMapEmpty;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;
import java.util.jar.Attributes;

public class BoostCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player player = (Player) commandSender;

            if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR){

                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 1000, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                item.setItemMeta(meta);
                player.sendMessage("Your Item has added 1024 attack damage");


            }
        }

        return false;
    }
}
