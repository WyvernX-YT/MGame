package minigame.minigame.cmd;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public abstract class Command {

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String permission;
    @Setter
    @Getter
    private String[] aliases;
    @Setter
    @Getter
    private String description;

    public abstract void init();


    public abstract void execute(Player player, ArrayList <String> args);
}
