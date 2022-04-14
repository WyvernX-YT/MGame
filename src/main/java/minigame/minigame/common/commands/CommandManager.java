package minigame.minigame.cmd;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommandManager implements Listener {

    private static final HashMap<String, Class< ? extends Command>> cmdMap = new HashMap<>();

    public static void init() {
        for(Class <? extends Command> c : cmdMap.values()) {
            try {
                Command command = c.newInstance();

                if(command.getAliases().length > 0) {
                    for(String s : command.getAliases()) {
                        cmdMap.put(s, c);
                    }
                }

            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerCommand(String name, Class< ? extends Command> c) {
        cmdMap.put(name, c);
    }


    @EventHandler
    void onCommand(PlayerCommandPreprocessEvent event) throws InstantiationException, IllegalAccessException {
        Player player = event.getPlayer();
        String fullCommand = event.getMessage();
        ArrayList<String> args = new ArrayList <>(Arrays.asList(fullCommand.split(" ")));
        String command = args.get(0);
        args.remove(0);

        Command c = null;
        if(cmdMap.containsKey(command))
            c = cmdMap.get(command).newInstance();
            c.init();
            if(player.hasPermission(c.getPermission()))
                c.execute(player, args);

    }
}
