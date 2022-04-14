package minigame.minigame.game.events;

import minigame.minigame.configs.Config;
import minigame.minigame.game.Game;
import minigame.minigame.position.PositionManager;
import minigame.minigame.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.teleport(PositionManager.PRE_GAME);

        if (Game.isRunning())
            player.kickPlayer(Config.GAME_RUNNING_MESSAGE);

        Game.setPlayerCount(Bukkit.getOnlinePlayers().size());

        event.setJoinMessage(Placeholder.placeholder(player, Config.JOIN_MESSAGE));

        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            onlinePlayer.playSound(onlinePlayer.getLocation(), Config.JOIN_SOUND, 2, 0.1f);
    }
}
