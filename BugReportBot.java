package com.yourpackage;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugReportBot {

    public static void main(String[] args) throws Exception {
        // Start the Discord bot
        JDA jda = JDABuilder.createDefault(System.getenv("BOT_TOKEN")).build();
        jda.awaitReady(); // Wait for the bot to be ready

        // Start the Spring Boot application
        SpringApplication.run(BugReportBot.class, args);
    }
}
