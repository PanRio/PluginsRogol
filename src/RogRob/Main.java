
package RogRob;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    ItemStack compass;

    @Override
    public void onEnable() {

        Bukkit.getServer().getPluginManager().registerEvents(this, this);


        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "ChestOpener");
        compass.setItemMeta(meta);
        compass = new ItemStack(Material.RABBIT_HIDE);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("getkey"))
        {
            player.getInventory().addItem(new ItemStack(compass));
            player.sendMessage(ChatColor.GREEN + "Dostales kompass otwierania skrzyni");
        }

        return super.onCommand(sender, command, label, args);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if(player.getItemOnCursor().equals(compass))
        {
            player.sendMessage(ChatColor.BLUE + "Otwierasz Skrzynie Wirtualna");
        }
    }
}

