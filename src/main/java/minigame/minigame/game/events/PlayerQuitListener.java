package minigame.minigame.game.events;

import minigame.minigame.configs.Config;
import minigame.minigame.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    void onQuit(PlayerQuitEvent event) {
        if(Game.isRunning()) Bukkit.broadcastMessage(Config.QUIT_MESSAGE);
    }
}
