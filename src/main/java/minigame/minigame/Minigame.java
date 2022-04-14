package minigame.minigame;

import lombok.SneakyThrows;
import minigame.minigame.cmd.Command;
import minigame.minigame.cmd.CommandManager;
import minigame.minigame.position.PositionManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

public final class Minigame extends JavaPlugin {

    public static Minigame instance;
    public static Reflections r = new Reflections();

    public static World world = Bukkit.getWorld("world");

    @SneakyThrows
    @Override
    public void onEnable() {
        initManagers();
        register();
    }

    @Override
    public void onDisable() {
    }

    private void initManagers() {
        PositionManager.init();CommandManager.init();

    }

    @SneakyThrows
    @Override
    public void onLoad() {
        instance = this;
    }

    private void register() throws InstantiationException, IllegalAccessException {
        for(Class<?extends Listener> c : r.getSubTypesOf(Listener.class)) {
            Bukkit.getPluginManager().registerEvents(c.newInstance(), this);
        }
        for(Class<?extends Command> c : r.getSubTypesOf(Command.class)) {

            CommandManager.registerCommand(c.newInstance().getName(), c);
        }
    }
}
