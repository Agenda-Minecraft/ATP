package cat.kiwi.minecraft.atp

import cat.kiwi.minecraft.atp.commands.Commands
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.messaging.PluginMessageListener

class ATPPlugin:JavaPlugin(), PluginMessageListener {
    companion object {
        lateinit var instance: ATPPlugin
    }
    override fun onEnable() {
        instance = this
        this.server.messenger.registerOutgoingPluginChannel(this, "BungeeCord");

        logger.info("Atp is enabled!")
        getCommand("atp")?.setExecutor(Commands())
    }

    override fun onDisable() {
        //make sure to unregister the registered channels in case of a reload
        this.server.messenger.unregisterOutgoingPluginChannel(this);
        this.server.messenger.unregisterIncomingPluginChannel(this);
        logger.info("Atp is disabled!")
    }

    override fun onPluginMessageReceived(channel: String, player: Player, message: ByteArray) {
    }

}