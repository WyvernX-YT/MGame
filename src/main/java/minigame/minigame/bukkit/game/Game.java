package minigame.minigame.game;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game {

    @Setter
    private static boolean isRunning = false;

    @Getter
    @Setter
    public static int playerCount = 0;


    private static ArrayList<Player> players = new ArrayList<>();

    public static boolean isRunning() {
        return isRunning;
    }

    public static void onStart() {
        players.addAll(Bukkit.getOnlinePlayers());

    }
}
