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
        setItem(11, new ItemBuilder(Material.MAGMA_CREAM).name(ChatColor.YELLOW + "Fire resistance").addLore("Turn on or off the asset").build());
        setItem(12, new ItemBuilder(Material.SUGAR).name(ChatColor.AQUA + "Speed").addLore("Turn on or off the asset").build());
        setItem(13, new ItemBuilder(Material.BLAZE_POWDER).name(ChatColor.RED + "Strenght").addLore("Turn on or off the asset").build());
        setItem(14, new ItemBuilder(Material.FEATHER).name(ChatColor.WHITE + "NoFall").addLore("Turn on or off the asset").build());
        setItem(15, new ItemBuilder(Material.SPIDER_EYE).name(ChatColor.LIGHT_PURPLE + "NoDebuff").addLore("Turn on or off the asset").build());


    }


    @Override
    protected void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        switch (e.getCurrentItem().getType()) {
            case MAGMA_CREAM:
                if (player.hasPermission("asset.fire")) {
                    if (player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                        player.sendMessage("Asset disable");
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                        player.sendMessage("Asset enable");
                        player.closeInventory();
                    }
                }
                break;
            case SUGAR:
                if (player.hasPermission("asset.speed")) {
                    if (player.hasPotionEffect(PotionEffectType.SPEED)) {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.sendMessage("Asset disable");
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                        player.sendMessage("Asset enable");
                        player.closeInventory();
                    }
                }
                break;
            case BLAZE_POWDER:
                if (player.hasPermission("asset.strenght")) {
                    if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                        player.sendMessage("Asset disable");
                        player.closeInventory();
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                        player.sendMessage("Asset enable");
                        player.closeInventory();
                    }
                }
                break;
            case FEATHER:
               if (player.hasPermission("asset.nofall")) {
                   if (plugin.getNoFallList().contains(player.getUniqueId())) {
                       player.sendMessage("Asset disable");
                       plugin.getNoFallList().remove(player.getUniqueId());
                       player.closeInventory();
                   } else {
                       player.sendMessage("Asset enable");
                       plugin.getNoFallList().add(player.getUniqueId());
                       player.closeInventory();
                   }
               }

                break;
            case SPIDER_EYE:
                if(player.hasPermission("asset.nodebuff")){
                    if(plugin.getNoDebuffList().contains(player.getUniqueId())){
                        player.sendMessage("Asset disable");
                        plugin.getNoDebuffList().remove(player.getUniqueId());
                        player.closeInventory();

                    }else {
                        player.sendMessage("Asset enable");
                        plugin.getNoDebuffList().add(player.getUniqueId());
                        player.closeInventory();
                    }
                }
        }
    }
}


