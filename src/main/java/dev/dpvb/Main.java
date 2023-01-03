package dev.dpvb;

import dev.dpvb.listeners.JoinListener;
import dev.dpvb.listeners.ReadyListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Dotenv dotenv = Dotenv.load();
        final String token = dotenv.get("TOKEN");
        final JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new ReadyListener(), new JoinListener())
                .build();

        jda.awaitReady();
    }
}