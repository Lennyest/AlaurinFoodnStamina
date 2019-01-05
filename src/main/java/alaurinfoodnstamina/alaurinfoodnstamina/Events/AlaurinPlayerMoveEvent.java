
package alaurinfoodnstamina.alaurinfoodnstamina.Events;

import alaurinfoodnstamina.alaurinfoodnstamina.AlaurinFoodnStamina;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AlaurinPlayerMoveEvent implements Listener {

    //Made these final, do a test.
    //Should be fine.
    private final String YouNeedToEatChat = ChatColor.translateAlternateColorCodes('&', AlaurinFoodnStamina.configCFG.get("YouNeedToEatMessage").toString());
    private final String YouNeedToEatBar = ChatColor.translateAlternateColorCodes('&', AlaurinFoodnStamina.configCFG.get("YouNeedToEatMessage").toString());

    @EventHandler
    public void playerCheckMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }

        if (player.hasPermission("AlaurinFoodnStamina.BYPASS")) {
            return;
        }

        if ((boolean) AlaurinFoodnStamina.configCFG.get("Slowness")) {
            if (player.getFoodLevel() < (int) AlaurinFoodnStamina.configCFG.get("AmountToCrouch")) {

                if ((boolean) AlaurinFoodnStamina.configCFG.get("YouNeedToEatHotbar")) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            new TextComponent(YouNeedToEatBar));
                } else if ((boolean) AlaurinFoodnStamina.configCFG.get("YouNeedToEatChat")) {
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(AlaurinFoodnStamina.getInstance(), () ->
                            player.sendMessage(YouNeedToEatChat), 1440L, 1L);
                }

                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2));

            } else if (player.getFoodLevel() > (int) AlaurinFoodnStamina.configCFG.get("AmountToCrouch")) {

                if ((boolean) AlaurinFoodnStamina.configCFG.get("YouNeedToEatHotbar")) {
                    //Remove the action bar instantly vvvv
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            new TextComponent(""));
                    player.removePotionEffect(PotionEffectType.SLOW);
                }

                player.removePotionEffect(PotionEffectType.SLOW);

            }
        }
    }
}