package dev.dpvb.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class JoinListener implements EventListener {

    @Override
    public void onEvent(GenericEvent genericEvent) {
        if (genericEvent instanceof GuildMemberJoinEvent event) {
            // GIVE NEW MEMBERS A ROLE
            final long FRIEND_OF_SVIN_ROLE = 1059710036751945818L;
            final Role role = event.getGuild().getRoleById(FRIEND_OF_SVIN_ROLE);
            if (role == null) {
                throw new IllegalStateException("FRIEND OF SVIN Role does not exist in this server.");
            }
            final Member member = event.getMember();
            event.getGuild().addRoleToMember(member, role).complete();
            System.out.println("Gave " + member.getEffectiveName() + " Friend of Svin Role.");
        }
    }
}
