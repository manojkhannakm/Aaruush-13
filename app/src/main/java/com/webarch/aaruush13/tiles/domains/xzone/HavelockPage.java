package com.webarch.aaruush13.tiles.domains.xzone;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class HavelockPage extends EventPage {

    public HavelockPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("They say innovations are necessary for humans so by keeping this in mind we are innovating a much more entertaining and enlightening saga of TECHIES in a comprehensive way, by introducing HAVELOKK. " +
                "As we expect that every individual has no limits, HAVELOKK gives you a perfect path to test the limits of an individual and make him/her to reach to an infinite level. " +
                "The event consist of rounds comprising of tasks and objectives which will rendezvous the participants to the road to finale. " +
                "The event consists of 2 teams guided by the two X-TECHIES winners as their leaders. " +
                "Each team will compete with each other in the finale and a winner will be announced.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "They say innovations are necessary for humans so by keeping this in mind we are innovating a much more entertaining and enlightening saga of TECHIES in a comprehensive way, by introducing HAVELOKK. " +
                "As we expect that every individual has no limits, HAVELOKK gives you a perfect path to test the limits of an individual and make him/her to reach to an infinite level. " +
                "The event consist of rounds comprising of tasks and objectives which will rendezvous the participants to the road to finale. " +
                "The event consists of 2 teams guided by the two X-TECHIES winners as their leaders. " +
                "Each team will compete with each other in the finale and a winner will be announced.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - DIG THE MUD</b><br>" +
                "Come and show your off ground skills by taking up the challenge of putting yourself up in the barren mud and take up your limits to pull you......your troops out of the narrow escape.<br><br>" +
                "<b>Round 2 - KICK ASS</b><br>" +
                "Are you the lion who hunts in the dark and who Senses his prey and enjoys his glory? Here comes the next challenge for you. Face your fear of heights and walk the final path of your success.<br><br>" +
                "<b>Round 3 - TRY OR DIE</b><br>" +
                "To achieve an objective successfully an act of valour, of facing uncertainty is very helpful...Thus we give you a chance to conquer yourself over others by converting uncertainty to a certain object.<br><br>" +
                "<b>Round 4 - TROUBLE THROUGH PEBBLE</b><br>" +
                "The different types of apes, rocks and stones are supposed to be a helpful and key element for humans.But this time we humans are creating these objects into agents of havoc and make others face them through their path and face the challenge given."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Varun Misra</b><br>" +
                "varun.misra6@gmail.com<br>" +
                "8056005768<br><br>" +
                "<b>Harshit Singh</b><br>" +
                "gehlot.harshitsingh@gmail.com<br>" +
                "8754554157<br><br>" +
                "<b>Himanshu Keshwani</b><br>" +
                "Himanshu.2819@gmail.com<br>" +
                "9962237667<br><br>" +
                "<b>Shivam</b><br>" +
                "Shivam.cansat@gmail.com<br>" +
                "9543105030<br><br>" +
                "<b>Ishaan</b><br>" +
                "ishanchourey@live.com<br>" +
                "8122342034"));
    }

}