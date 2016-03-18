package com.webarch.aaruush13.tiles.domains.xzone;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class AdamVsEvePage extends EventPage {

    public AdamVsEvePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Here is an event that will be \"full of fun and adventure\", to you all not because it is an exciting competition but the age old battle of the sexes... " +
                "WHO IS BETTER? Take your stand.. " +
                "BOYS or the GIRLS?");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Here is an event that will be \"full of fun and adventure\", to you all not because it is an exciting competition but the age old battle of the sexes... " +
                "WHO IS BETTER? Take your stand.. " +
                "BOYS or the GIRLS?");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "1. Participants answering correctly to most number of questions in the first round will qualify to the next round.<br>" +
                "2. This round will test your IQ and awareness of the opposite sex.<br>" +
                "3. Questions will be segregated into 2 parts.<br>" +
                "4. One will consist of questions related to topics which concern men and the other which concern mostly women.<br><br>" +
                "<b>Round 2</b><br>" +
                "(Shortlisted participants = 50).<br>" +
                "1. The second round is all about your fashion quotient.<br>" +
                "2. Participants have to walk down the ramp and introduce themselves in an appealing way in 2 minutes or less.<br>" +
                "3. They will be judged on the basis of their style sense, dressing, confidence and flair on the ramp.<br><br>" +
                "<b>Round 3</b><br>" +
                "( Shortlisted participants = 30)<br>" +
                "1. The 30 contestants will be divided into 3 teams of 10 members each(5 boys & 5 girls).<br>" +
                "2. 3rd round will comprise of 3 games with each team playing the other 2 teams in succession to create a league format.<br><br>" +
                "<b>Games shall be</b><br>" +
                "1. Tug of War<br>" +
                "2. Dodgeball<br>" +
                "3. Bowl out(A simulation of a penalty shootout created for the game of cricket)<br><br>" +
                "<b>Round 4</b><br>" +
                "(Shortlisted participants = 20)<br>" +
                "1. One entire team is eliminated which takes the participant's count to 20.<br>" +
                "2. These 20 will be divided into 5 teams of 4 members(2 girls and 2 boys).<br>" +
                "3. The round will test their co-operation, management and teamwork qualities.<br>" +
                "4. Each team will perform a relay of 4runs (100m sprint – Power Drill- Suicide runs - 100m sprint).<br>" +
                "5. The teams which clocks the best time will proceed.<br>" +
                "6. Out of the 5, 2 teams will go through and 3 will be eliminated.<br><br>" +
                "<b>Round 5</b><br>" +
                "(Shortlisted participants = 8)<br>" +
                "1. 8 members are divided into 4 teams of 2 members(1 girl and 1 boy).<br>" +
                "2. This level tests the co-ordination skills of the contestants.<br>" +
                "3. One member will be blindfolded and the other teammate guides the first through a path filled with paper strips(simulated mines :p) the blindfolded person has to avoid.<br>" +
                "4. Each team should try to run through the obstacle path as fast as they can, but let's not forget.<br>" +
                "5. You step on the mines and you face the music.<br>" +
                "6. Time penalty of 20 seconds.<br>" +
                "7. The team with the worst timing is eliminated leaving behind 3 boys and 3 girls.<br><br>" +
                "<b>Round 6</b><br>" +
                "(Shortlisted participants = 6)<br>" +
                "1. 2 final teams are made of 3 members each.<br>" +
                "2. 3 girls against 3 boys! Buckle up, Pull your socks and fasten your seat belts.<br>" +
                "3. This is the final round standing between you and the title.<br>" +
                "4. The final face off is a series of Best of 11 tasks(each being completed within 10 minutes).<br>" +
                "5. The team which wins 6 games first shall be declared as the champion team.<br>" +
                "6. The games shall be easy and can be contested by boys and girls with the same efficiency.<br>" +
                "7. All they require is focus, calmness, presence of mind and patience."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Anuj Sharda</b><br>" +
                "anujsharda1905@gmail.com<br>" +
                "+91-97899 84885<br><br>" +
                "<b>Ashwin Jindal</b><br>" +
                "ashwinjindal007@gmail.com<br>" +
                "+91-81446 98578<br><br>" +
                "<b>Mohit Chauhan</b><br>" +
                "mohitchauhan10@gmail.com<br>" +
                "+91-76676 05594<br><br>" +
                "<b>Yogesh Thakur</b><br>" +
                "Yogesh1793thakur@gmail.com<br>" +
                "+91-99629 40067<br><br>" +
                "<b>Darshan Singh</b><br>" +
                "Darshans534@gmail.com<br>" +
                "+91-96770 21780<br><br>" +
                "<b>Yogita Sadhwani</b><br>" +
                "yogitasadhwani@yahoo.com<br>" +
                "+91-87545 06982"));
    }

}