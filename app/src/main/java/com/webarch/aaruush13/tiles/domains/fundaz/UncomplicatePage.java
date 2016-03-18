package com.webarch.aaruush13.tiles.domains.fundaz;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class UncomplicatePage extends EventPage {

    public UncomplicatePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("\"Uncomplicate\" dwells into the world of Puzzles. " +
                "Complications are ever-present, and simplifying things is the world's most enticing mandate. " +
                "It is a \"trip into the scourge of logic and science\" and to come out triumphant from the mists of confusion.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "\"Uncomplicate\" dwells into the world of Puzzles. " +
                "Complications are ever-present, and simplifying things is the world's most enticing mandate. " +
                "It is a \"trip into the scourge of logic and science\" and to come out triumphant from the mists of confusion.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Cryptex Unbound</b><br>" +
                "Participants have to solve the cryptogram given in this round and solve for the two sentences given.<br><br>" +
                "<b>Round 2 - Scrambler</b><br>" +
                "Participants have to unscramble a set of words. " +
                "The alphabets have to be filled in the blanks provided. " +
                "Specific boxes will be highlighted. " +
                "Using the highlighted alphabets, one has to make a word to get the answer to the question given.<br><br>" +
                "<b>Round 3 - Linked In</b><br>" +
                "Contestants are given a set of three pictures, and by seeing those they have to think of the common link between them.<br><br>" +
                "<b>Round 4 - La Apodosis</b><br>" +
                "This is the culmination of the trip into the mists of the complicated. This round has two subdivisions<br>" +
                "<b>Devi God</b>" +
                "Here, one participant is given four clues one by one to guess about the gadget. With every additional clue, marks given falls in place.<br>" +
                "<b>Unveil</b>" +
                "The participants need to answer domain based questions so as to reveal the jigsaw and henceforth answer the question associated with the question."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Anuj Bahl</b><br>" +
                "anujbahl34@gmail.com<br>" +
                "+91-99629 40021<br><br>" +
                "<b>S. G. Dastidar</b><br>" +
                "thunderlossf@gmail.com<br>" +
                "+91-98846 78563<br><br>" +
                "<b>Sayak Ray</b><br>" +
                "sayak.ray03@gmail.com<br>" +
                "+91-99629 40234<br><br>" +
                "<b>Vaibhavi Nakhasi</b><br>" +
                "vb.sweet@gmail.com<br>" +
                "+91-99626 21864"));
    }

}