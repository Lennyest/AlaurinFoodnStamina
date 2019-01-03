package alaurinfoodnstamina.alaurinfoodnstamina.LennyLib;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class LennyLib {

    public static void tell(CommandSender toWhom, String message) {
        toWhom.sendMessage(colorize(message));
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}