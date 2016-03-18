package com.webarch.aaruush13.tiles.domains.bluebook;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class PapyrusPage extends EventPage {

    public PapyrusPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Papyrus is a platform to test your creativity, technical and marketing skills to produce a cost effective, green paper from junk. " + "It gives one the opportunity to help in laying the foundation to a greener and more sustainable tomorrow.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Papyrus literally means \"paper\" in ancient Egyptian. " + "Going with its literal meaning, Papyrus provides a platform to test ones creativity, technical and marketing skills to produce a cost effective, eco-friendly paper from junk.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "The first round consists of a written test comprising of a set objective questions and a crossword puzzle based on the Basic Sciences (physics, chemistry), technology and history related to paper manufacture and general knowledge.<br><br>" +
                "<b>Round 2</b><br>" +
                "The participants will be shown a video clip for a short duration. A distracting audio will be played in the background. " +
                "Then a set of questions based on the clip and its content will be asked. " +
                "The contestants will also be asked to write 3 short but crisp points about what they saw in the clip.<br><br>" +
                "<b>Round 3</b><br>" +
                "In this round, the finalists have to make paper from used paper. " +
                "A choice of paper would be given to them such as used A4 sheets, newspapers, cardboard. " +
                "The finalists will have to buy the raw materials using the points allotted to them taking into consideration their performance in the previous rounds. " +
                "The pulp has to be made by blending the paper, simultaneously adding the required chemicals to improve its quality. " +
                "The paper will then have to be formed over the mesh and dried in an oven."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Somnath Sharma</b><br>" +
                "ssharmaji890@gmail.com<br>" +
                "+91-97898 27446<br><br>" +
                "<b>Aritra Mukherjee</b><br>" +
                "mukherjee.aritra007@gmail.com<br>" +
                "+91-90032 56259<br><br>" +
                "<b>Stephy Biju</b><br>" +
                "meetstephy@gmail.com<br>" +
                "+91-89394 04324"));
    }

}