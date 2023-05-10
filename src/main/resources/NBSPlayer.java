import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.torben.testplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class NBSPlayer implements CommandExecutor {
    private Main main;

    public NBSPlayer(Main main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            RadioSongPlayer rsp = new RadioSongPlayer(NBSDecoder.parse(new File(main.getDataFolder(), "Higher.nbs")));
            rsp.addPlayer(player);
            rsp.setPlaying(true);
            player.sendMessage(ChatColor.GREEN + "Now Playing Higher by Tobu");
        }

            return false;
    }
}