package me.iswikzzz.atouts;

import me.iswikzzz.atouts.commands.AssetCommand;
import me.iswikzzz.atouts.libs.FastInvManager;
import me.iswikzzz.atouts.listerner.NoDebuffListener;
import me.iswikzzz.atouts.listerner.NoFallListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public final class Atouts extends JavaPlugin {


    private final ArrayList<UUID> noFallList = new ArrayList<>();
    private final ArrayList<UUID> noDebuffList = new ArrayList<>();
    private final List<String> bannedPotions  = new ArrayList<>(Arrays.asList("POISON","SLOW","WEAKNESS"));


    @Override
    public void onEnable() {
        getCommand("atouts").setExecutor(new AssetCommand());
        FastInvManager.register(this);
        Bukkit.getPluginManager().registerEvents(new NoFallListener(this),this);
        Bukkit.getPluginManager().registerEvents(new NoDebuffListener(this),this);
    }

    public ArrayList<UUID> getNoFallList() {
        return noFallList;
    }

    public ArrayList<UUID> getNoDebuffList() {
        return noDebuffList;
    }

    public List<String> getBannedPotions() {
        return bannedPotions;
    }



    }



