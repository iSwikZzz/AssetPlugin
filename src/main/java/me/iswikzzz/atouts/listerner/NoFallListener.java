package me.iswikzzz.atouts.listerner;

import me.iswikzzz.atouts.Atouts;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoFallListener implements Listener {

    private final Atouts plugin;

     public NoFallListener(Atouts plugin){
          this.plugin=plugin;
     }


    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

        Entity entity = event.getEntity();

        if (plugin.getNoFallList().contains(entity.getUniqueId())){
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                event.setCancelled(true);
            }
        }
    }
}