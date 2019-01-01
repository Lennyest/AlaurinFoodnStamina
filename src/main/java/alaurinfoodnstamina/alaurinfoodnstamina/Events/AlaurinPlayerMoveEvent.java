/*
 * Copyright (c) 2018. Laleem/Lenny
 */

package alaurinfoodnstamina.alaurinfoodnstamina.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AlaurinPlayerMoveEvent implements Listener {

    public int percent(int currentValue, int maxValue) {
        float percent = ((float) currentValue / maxValue) * 100;
        return (int) percent;
    }

    @EventHandler
    public void playerCheckMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        /*
        if ((int) AlaurinFoodnStamina.getInstance().getConfigCFG().get("FoodPercentage") <= percent(player.getFoodLevel(), 20)) {
            if ((boolean) AlaurinFoodnStamina.getInstance().getConfigCFG().get("YouNeedToEatChat")) {
                player.sendMessage(AlaurinFoodnStamina.getInstance().getConfigCFG().get("YouNeedToEatMessage").toString());
            }
            if ((boolean) AlaurinFoodnStamina.getInstance().getConfigCFG().get("YouNeedToEatHotbar")) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent( AlaurinFoodnStamina.getInstance().getConfigCFG().get("YouNeedToEatMessage").toString()));
            }
        }

        if ((int) AlaurinFoodnStamina.getInstance().getConfigCFG().get("AmountToCrouch")
                <= percent(player.getFoodLevel(), 20) && (boolean) AlaurinFoodnStamina.getInstance().getConfigCFG().get("Slowness")) {
            player.setSneaking(true);
        }
        */
    }

}
