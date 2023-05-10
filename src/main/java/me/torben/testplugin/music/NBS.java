package me.torben.testplugin.music;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.torben.testplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class NBS implements CommandExecutor {

    private Main main;

    public NBS(Main main){
        this.main = main;
    }

    // This method is called when the /playnbs command is executed
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length != 1) {
                sender.sendMessage("Usage: /playnbs <song name>");
                return false;
            }
            String songName = args[0];
            // Load the NBS file for the song
            File songFile = new File(main.getDataFolder(), songName + ".nbs");
            if (!songFile.exists()) {
                sender.sendMessage("Song not found.");
                return true;
            }
            Song song = NBSDecoder.parse(songFile);
            // Create a new SongPlayer and start playing the song
            SongPlayer songPlayer = new RadioSongPlayer(song);
            songPlayer.addPlayer(player);
            songPlayer.setPlaying(true);
            sender.sendMessage("Playing song '" + songName + "'.");
        } else {
            sender.sendMessage("This command can only be run by a player.");
        }
        return true;
    }
}
