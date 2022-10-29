package cat.kiwi.minecraft.atp.commands

import cat.kiwi.minecraft.atp.ATPPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.io.ByteArrayOutputStream
import java.io.DataOutputStream

class Commands: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val player = sender
            if (args.size == 0) {
                player.sendMessage("Usage: /atp <server>")
                return true
            }
            val serverName = args[0]

            val byteArrayOutputStream = ByteArrayOutputStream()
            val dataOutputStream = DataOutputStream(byteArrayOutputStream)

            dataOutputStream.writeUTF("Connect")
            dataOutputStream.writeUTF(serverName)

            player.sendPluginMessage(ATPPlugin.instance, "BungeeCord", byteArrayOutputStream.toByteArray())
            return true
        }
        return false
    }
}