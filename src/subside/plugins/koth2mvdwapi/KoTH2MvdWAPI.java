package subside.plugins.koth2mvdwapi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import subside.plugins.koth.adapter.KothHandler;
import subside.plugins.koth.adapter.TimeObject;

public class KoTH2MvdWAPI extends JavaPlugin {
    @Override
    public void onEnable(){
        if(!Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")){
            this.setEnabled(false);
            Bukkit.getLogger().severe("-------------------------------");
            Bukkit.getLogger().severe("MVdW Placeholder API Not found!");
            Bukkit.getLogger().severe("-------------------------------");
            return;
        }

        
        // KoTH LOCATION
        // KoTH Name
        PlaceholderAPI.registerPlaceholder(this, "koth_name", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getName();
            }
        });
        // KoTH X
        PlaceholderAPI.registerPlaceholder(this, "koth_x", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getMiddle().getBlockX()+"";
            }
        });
        // KoTH Y
        PlaceholderAPI.registerPlaceholder(this, "koth_y", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getMiddle().getBlockY()+"";
            }
        });
        // KoTH Z
        PlaceholderAPI.registerPlaceholder(this, "koth_z", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getMiddle().getBlockZ()+"";
            }
        });
        // KoTH Z
        PlaceholderAPI.registerPlaceholder(this, "koth_world", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getMiddle().getWorld().getName();
            }
        });
        
        // Loot Location
        // KoTH Loot
        PlaceholderAPI.registerPlaceholder(this, "koth_loot_name", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getLootChest();
            }
        });
        // Loot X
        PlaceholderAPI.registerPlaceholder(this, "koth_loot_x", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                Location loc = KothHandler.getInstance().getRunningKoth().getKoth().getLootPos();
                if(loc != null){
                    return loc.getBlockX()+"";
                }
                return "";
            }
        });
        // Loot Y
        PlaceholderAPI.registerPlaceholder(this, "koth_loot_y", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                Location loc = KothHandler.getInstance().getRunningKoth().getKoth().getLootPos();
                if(loc != null){
                    return loc.getBlockY()+"";
                }
                return "";
            }
        });
        // Loot Z
        PlaceholderAPI.registerPlaceholder(this, "koth_loot_z", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                Location loc = KothHandler.getInstance().getRunningKoth().getKoth().getLootPos();
                if(loc != null){
                    return loc.getBlockZ()+"";
                }
                return "";
            }
        });
        // Loot World
        PlaceholderAPI.registerPlaceholder(this, "koth_loot_world", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                Location loc = KothHandler.getInstance().getRunningKoth().getKoth().getLootPos();
                if(loc != null){
                    return loc.getWorld().getName();
                }
                return "";
            }
        });

        // Player in area
        PlaceholderAPI.registerPlaceholder(this, "koth_player_inarea", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                if(KothHandler.getInstance().getRunningKoth().getKoth().isInArea(event.getOfflinePlayer())){
                    return "True";
                }
                return "False";
            }
        });
        
        
        // Time objects
        // Seconds left
        PlaceholderAPI.registerPlaceholder(this, "koth_time_secondsleft", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getSecondsLeft();
            }
        });
        
        // Minutes left
        PlaceholderAPI.registerPlaceholder(this, "koth_time_minutesleft", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getMinutesLeft();
            }
        });
        
        
        // Seconds capped
        PlaceholderAPI.registerPlaceholder(this, "koth_time_secondscapped", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getSecondsCapped();
            }
        });
        
        // Minutes capped
        PlaceholderAPI.registerPlaceholder(this, "koth_time_minutescapped", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getMinutesCapped();
            }
        });


        // Seconds left
        PlaceholderAPI.registerPlaceholder(this, "koth_time_secondsleft", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getSecondsLeft();
            }
        });

        // Time left formatted
        PlaceholderAPI.registerPlaceholder(this, "koth_time_leftformatted", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getTimeLeftFormatted();
            }
        });
        // Time capped formatted
        PlaceholderAPI.registerPlaceholder(this, "koth_time_cappedformatted", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getTimeCappedFormatted();
            }
        });

        // Total seconds left 
        PlaceholderAPI.registerPlaceholder(this, "koth_time_totalsecondsleft", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getTotalSecondsLeft();
            }
        });
        // Total seconds capped 
        PlaceholderAPI.registerPlaceholder(this, "koth_time_totalsecondscapped", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getTotalSecondsCapped();
            }
        });
        // Length in minutes
        PlaceholderAPI.registerPlaceholder(this, "koth_time_lengthinminutes", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getLengthInMinutes();
            }
        });
        // Length in seconds
        PlaceholderAPI.registerPlaceholder(this, "koth_time_lengthinseconds", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                
                return ""+KothHandler.getInstance().getRunningKoth().getTimeObject().getLengthInSeconds();
            }
        });
        //

        // Last winner
        PlaceholderAPI.registerPlaceholder(this, "koth_lastwinner", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                if(KothHandler.getInstance().getRunningKoth().getKoth().getLastWinner() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getKoth().getLastWinner().getName();
            }
        });
        // Length in minutes
        PlaceholderAPI.registerPlaceholder(this, "koth_currentcapper", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                if(KothHandler.getInstance().getRunningKoth() == null) return null;
                if(KothHandler.getInstance().getRunningKoth().getCapper() == null) return null;
                
                return KothHandler.getInstance().getRunningKoth().getCapper().getName();
            }
        });
        
        // Koth Time to next event
        PlaceholderAPI.registerPlaceholder(this, "koth_nextevent", new PlaceholderReplacer(){
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent event){
                return TimeObject.getTimeTillNextEvent();
            }
        });

    }
}
