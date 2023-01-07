package me.iswikzzz.atouts.listerner;

import me.iswikzzz.atouts.Atouts;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

public class NoDebuffListener implements Listener {

    private final Atouts plugin;

    public NoDebuffListener (Atouts plugin){
        this.plugin=plugin;
    }

    @EventHandler
    public void onSplash(PotionSplashEvent e){
        e.getAffectedEntities().stream()
                .filter(livingEntity -> livingEntity instanceof Player)
                .forEach(p ->{
                    Potion potion = Potion.fromItemStack(e.getPotion().getItem());
                    PotionEffectType potionEffectType = potion.getType().getEffectType();

                    if(plugin.getNoDebuffList().contains(p.getUniqueId()) && plugin.getBannedPotions().contains(potionEffectType.getName()) ){
                        e.setCancelled(true);
                    }
                });

}}
