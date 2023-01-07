package me.iswikzzz.atouts.gui;

import me.iswikzzz.atouts.Atouts;
import me.iswikzzz.atouts.libs.FastInv;
import me.iswikzzz.atouts.libs.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AssetGui extends FastInv {

    Atouts plugin = Atouts.getPlugin(Atouts.class);


    public AssetGui() {

        super(27, ChatColor.RED + "Atouts");

        setItems(getBorders(), new ItemBuilder(Material.STAINED_GLASS_PANE).data(14).name(" ").build());
        setItem(plugin.getConfig().getInt("fire.slot"), new ItemBuilder(Material.getMaterial(plugin.getConfig().getString("fire.material"))).name(plugin.getConfig().getString("fire.name")).addLore("Turn on or off the asset").build());
        setItem(plugin.getConfig().getInt("speed.slot"), new ItemBuilder(Material.getMaterial(plugin.getConfig().getString("speed.material"))).name(plugin.getConfig().getString("speed.name")).addLore("Turn on or off the asset").build());
        setItem(plugin.getConfig().getInt("strenght.slot"), new ItemBuilder(Material.getMaterial(plugin.getConfig().getString("strenght.material"))).name(plugin.getConfig().getString("strenght.name")).addLore("Turn on or off the asset").build());
        setItem(plugin.getConfig().getInt("nofall.slot"), new ItemBuilder(Material.getMaterial(plugin.getConfig().getString("nofall.material"))).name(plugin.getConfig().getString("nofall.name")).addLore("Turn on or off the asset").build());
        setItem(plugin.getConfig().getInt("nodebuff.slot"), new ItemBuilder(Material.getMaterial(plugin.getConfig().getString("nodebuff.material"))).name(plugin.getConfig().getString("nodebuff.name")).addLore("Turn on or off the asset").build());


    }


    @Override
    protected void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        switch (e.getCurrentItem().getType()) {
            case MAGMA_CREAM:
                ;
                if (player.hasPermission("asset.fire")) {
                    if (player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                        player.sendMessage(plugin.getConfig().getString("off-message"));
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                        player.sendMessage(plugin.getConfig().getString("on-message"));
                        player.closeInventory();
                    }
                }
                break;
            case SUGAR:
                if (player.hasPermission("asset.speed")) {
                    if (player.hasPotionEffect(PotionEffectType.SPEED)) {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.sendMessage(plugin.getConfig().getString("off-message"));
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                        player.sendMessage(plugin.getConfig().getString("on-message"));
                        player.closeInventory();
                    }
                }
                break;
            case BLAZE_POWDER:
                if (player.hasPermission("asset.strenght")) {
                    if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                        player.sendMessage(plugin.getConfig().getString("off-message"));
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                        player.sendMessage(plugin.getConfig().getString("on-message"));
                        player.closeInventory();
                    }
                }
                break;
            case FEATHER:
               if (player.hasPermission("asset.nofall")) {
                   if (plugin.getNoFallList().contains(player.getUniqueId())) {
                       player.sendMessage(plugin.getConfig().getString("off-message"));
                       plugin.getNoFallList().remove(player.getUniqueId());
                       player.closeInventory();
                   } else {
                       player.sendMessage(plugin.getConfig().getString("on-message"));
                       plugin.getNoFallList().add(player.getUniqueId());
                       player.closeInventory();
                   }
               }

                break;
            case SPIDER_EYE:
                if(player.hasPermission("asset.nodebuff")){
                    if(plugin.getNoDebuffList().contains(player.getUniqueId())){
                        player.sendMessage(plugin.getConfig().getString("off-message"));
                        plugin.getNoDebuffList().remove(player.getUniqueId());
                        player.closeInventory();

                    }else {
                        player.sendMessage(plugin.getConfig().getString("on-message"));
                        plugin.getNoDebuffList().add(player.getUniqueId());
                        player.closeInventory();
                    }
                }
        }
    }
}


