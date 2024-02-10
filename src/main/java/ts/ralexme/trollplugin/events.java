package ts.ralexme.trollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class events implements Listener {

    // Variable for storing a plugin instance
    private TrollPlugin plugin;

    // A constructor that accepts an instance of a plugin
    public events(TrollPlugin plugin) {
        this.plugin = plugin;
    }

    //-------------------- Explode on MESSAGE -------------------------
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage(); //getting player message
        Player player = event.getPlayer(); //getting the player
        World world = player.getWorld(); //getting the world where is player

        if(!player.hasPermission("troll.use.trollmessage")){
            player.sendMessage(ChatColor.RED + "You must have permission to explode :3");
        }

        // Making sure that the message string is not equal to null
        if (message != null && message.contains(TrollPlugin.getInstance().getConfig().getString("troll_message"))) {
            double x = player.getLocation().getX();
            double y = player.getLocation().getY();
            double z = player.getLocation().getZ();

            // using "plugin"  than  "new TrollPlugin()"
            Bukkit.getScheduler().runTask(plugin, new Runnable() { //synchronization
                @Override
                public void run() {                  //power    //fire     //break block
                    world.createExplosion(x, y, z, 4.0f, false, false);
                }
            });
        }
    }
    //--------------------/Explode on MESSAGE --------------------------

    //for new event
}
