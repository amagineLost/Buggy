package com.yourpackage;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.EmbedBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bug-report")
public class BugReportController {

    @PostMapping
    public String handleBugReport(@RequestBody BugReport bugReport) {
        TextChannel channel = BugReportBot.jda.getTextChannelById(System.getenv("CHANNEL_ID"));
        if (channel != null) {
            channel.sendMessageEmbeds(
                new EmbedBuilder()
                    .setTitle("Bug Report")
                    .addField("Reporter", bugReport.getReporter(), false)
                    .addField("Description", bugReport.getDescription(), false)
                    .addField("Timestamp", bugReport.getTimestamp(), false)
                    .setColor(0x7289DA)
                    .build()
            ).queue();
            return "Bug report sent successfully!";
        }
        return "Failed to send bug report.";
    }
}
