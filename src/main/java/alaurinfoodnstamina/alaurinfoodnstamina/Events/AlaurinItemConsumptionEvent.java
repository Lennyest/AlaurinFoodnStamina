/*
 * Copyright (c) 2018. Laleem/Lenny
 */

package alaurinfoodnstamina.alaurinfoodnstamina.Events;

import alaurinfoodnstamina.alaurinfoodnstamina.AlaurinFoodnStamina;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class AlaurinItemConsumptionEvent implements Listener {

    @EventHandler
    public void playerEat(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();

        switch (event.getItem().getType()) {
            case POTION:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.getInstance().getConfigCFG().get("Consumables.Potion"));
                player.sendMessage(" test: " + (int) AlaurinFoodnStamina.getInstance().getConfigCFG().get("Consumables.Potion"));
                break;
            case GRILLED_PORK:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.getInstance().getConfigCFG().get("Consumables.GrilledPorkchop"));
                player.sendMessage(ChatColor.GREEN + "Test!");
                break;
        }

    }

}
