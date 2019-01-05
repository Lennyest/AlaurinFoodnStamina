package alaurinfoodnstamina.alaurinfoodnstamina.Events;

import alaurinfoodnstamina.alaurinfoodnstamina.AlaurinFoodnStamina;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AlaurinItemConsumptionEvent implements Listener {

    @EventHandler
    public void playerEat(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();

        switch (event.getItem().getType()) {
            case POTION:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Potion"));
                break;
            case PORK:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Pork"));
                break;
            case GRILLED_PORK:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.GrilledPorkchop"));
                break;
            case POTATO:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Potato"));
                break;
            case BAKED_POTATO:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedPotato"));
                break;
            case MUTTON:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Mutton"));
                break;
            case COOKED_MUTTON:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedMutton"));
                break;
            case COOKED_BEEF:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedBeef"));
                break;
            case RAW_BEEF:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Beef"));
                break;
            case BREAD:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Bread"));
                break;
            case CARROT_ITEM:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Carrot"));
                break;
            case MELON:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Melon"));
                break;
            case GOLDEN_APPLE:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.GoldenApple"));
                break;
            case MUSHROOM_SOUP:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.MushroomSoup"));
                break;
            case APPLE:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Apple"));
                break;
            case RAW_FISH:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Fish"));
                break;
            case COOKED_FISH:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedFish"));
                break;
            case COOKIE:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Cookie"));
                break;
            case PUMPKIN_PIE:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.PumpkinPie"));
                break;
            case RABBIT:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Rabbit"));
                break;
            case COOKED_RABBIT:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedRabbit"));
                break;
            case RAW_CHICKEN:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.Chicken"));
                break;
            case COOKED_CHICKEN:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.CookedChicken"));
                break;
            case RABBIT_STEW:
                player.setFoodLevel(player.getFoodLevel() + (int) AlaurinFoodnStamina.configCFG.get("Consumables.RabbitStew"));
                break;
            case MILK_BUCKET:
                if (player.hasPotionEffect(PotionEffectType.SLOW)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2));
                }
                break;
        }


    }

}
