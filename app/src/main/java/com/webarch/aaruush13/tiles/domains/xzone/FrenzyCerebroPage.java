package com.webarch.aaruush13.tiles.domains.xzone;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class FrenzyCerebroPage extends EventPage {

    public FrenzyCerebroPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("A person's intelligence quotient, skills and knowledge can only be calculated through an assessment of his mental, physical and situation based problem solving attitude. " +
                "Our event Frenzy Cerebro takes into consideration all the qualities of an aspiring mind and tests him and his abilities to their utmost. " +
                "The domain XZONE comprises of unconventional interests so thus our event. " +
                "We bring to you a unique yet classic mixture of quizzes, brain storming, teamwork and gaming abilities.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "A person's intelligence quotient, skills and knowledge can only be calculated through an assessment of his mental, physical and situation based problem solving attitude. " +
                "Our event Frenzy Cerebro takes into consideration all the qualities of an aspiring mind and tests him and his abilities to their utmost. " +
                "The domain XZONE comprises of unconventional interests so thus our event. " +
                "We bring to you a unique yet classic mixture of quizzes, brain storming, teamwork and gaming abilities.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "<b>1: SHAKE SOME VEINS</b><br>" +
                "1. This round includes a normal test where questions related to famous cartoons and games will be given to the participants on a paper/sheet and all the questions will be MCQ.<br>" +
                "2. PARTICIPANTS BEFORE GOING TO PRELIMS 2 WILL BE ASKED TO FORM A TEAM OF 2 MEMBERS EACH, FAILING WHICH THEY WILL BE ALLOTED A RANDOM PARTNER.<br><br>" +
                "<b>2: ARRANGE THE FRAME</b><br>" +
                "1. In this round a shuffled video will be played to the participants.<br>" +
                "2. They would be asked to guess the right sequence and 3 more questions related to the video will be asked.<br><br>" +
                "<b>Round 2</b><br>" +
                "1. PICK THE STICKS: In this round one of the participant will guide his/her blind folded partner to pick the stick of the allotted colour. They will be given plus points for picking the correct stick and negative points for picking the wrong sticks.<br>" +
                "2. THE LONGEST RUNNER: Game QWOP, teams which will score /cross more distance in a given time will go in next round.<br>" +
                "3.QUICK FIRE: In this, the teams getting selected after the gaming round would have to face some rapid fire questions(based on common sense).<br><br>" +
                "<b>FINALE 1 - PICTURE CHEST</b><br>" +
                "1. This round will comprise of a mixture of a Treasure Hunt and a Jigsaw quiz.<br>" +
                "2. The image of a famous personality will be broken into 6 pieces.<br>" +
                "3. The teams will be provided with a Photoshop screen with one part of the image followed by a question.<br>" +
                "4. The answer to the question will have the hint for the name of the directory and the folder where the next part is present.<br>" +
                "5. The participants will be asked to copy paste the image in the Photoshop screen and guess the final personality.<br>" +
                "6. The judging criteria will be the time take.<br>" +
                "7. Top 3 teams will go for the final round.<br>" +
                "8. BEFORE FINALE 2 PARTICIPANTS WILL BE ASKED TO PLAY INDIVIUALLY. SO IN THE FINALE ROUND, 6 PARTICIPANTS WILL BE PLAYING.<br><br>" +
                "</b>FINALE 2 - PARK THE CAR</b><br>" +
                "1. In this round, a story will be narrated to the participants.<br>" +
                "2. Participants will be provided with a remote control car and a cardboard maze with multiple destination points.<br>" +
                "3. They will start from the initial point and will reach the final destination by guessing the climax of the story.<br>" +
                "4. The participant reaching first will be the winner."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Somesh</b><br>" +
                "someshkeswani@gmail.com<br>" +
                "+91-94440 77197<br><br>" +
                "<b>Surana</b><br>" +
                "yashsurana06@gmail.com<br>" +
                "+91-78068 04232<br><br>" +
                "<b>Sanket</b><br>" +
                "sketkar03@gmail.com<br>" +
                "+91-87545 86744<br><br>" +
                "<b>Srishti</b><br>" +
                "+91-81442 63753<br><br>" +
                "<b>Deepali</b><br>" +
                "+91-99629 39424<br><br>" +
                "<b>Surbhi</b><br>" +
                "+91-99626 18425"));
    }

}