package com.webarch.aaruush13.tiles.domains.praesentatio;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class PaperPresentationPage extends EventPage {

    public PaperPresentationPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("If you have an apple and I have an apple and we exchange these apples then you and I will still each have one apple. " + "But if you have an idea and I have an idea and we exchange these ideas, then each of us will have two ideas. - George Bernard Shaw");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Aaruush's attempt to encourage the efforts of those who would like to \"ideate\" for a better future, Paper Presentation provides an ideal platform for the thinkers of this generation. " +
                "For those who wish to voice their innovative ideas in an effective manner, we provide an opportunity to network, compete and grow with the best. " +
                "Hone your technical and presentation skills at our launch pad for students to discuss the emerging technology issues, explore a variety of perspectives and probable solutions. " +
                "After all, the best designs of today's technology started as mere blueprints, so who knows where yours might take you.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>School of Computing - Topics</b><br>" +
                "Web security<br>" +
                "Database management<br>" +
                "Web service ontology<br>" +
                "Cloud computing<br>" +
                "Artificial Intelligence<br>" +
                "Image processing<br>" +
                "MANET<br>" +
                "ADOCH net source<br>" +
                "Expert system<br><br>" +
                "<b>School of Mechanical - Topics</b><br>" +
                "Advances in manufacturing technology<br>" +
                "Alternative fuels<br>" +
                "CAD/CAM/CAE/CIM<br>" +
                "CFD-Computational Fluid Dynamics<br>" +
                "Hybrid vehicles<br>" +
                "Cryogenics<br>" +
                "Finite Element Analysis<br>" +
                "Nano materials and technology<br>" +
                "Propulsion Systems<br>" +
                "Advances in tribology<br><br>" +
                "<b>School of Electrical & Electronics - Topics</b><br>" +
                "Smart Grid<br>" +
                "Recent Advancements in power electronic converters and drives<br>" +
                "Application of digital control techniques for electrical engineering applications<br>" +
                "Deregulation of power sector<br>" +
                "Nano-electronic devices<br>" +
                "MEMS<br>" +
                "Embedded Wireless Sensor networks<br>" +
                "Optoelectronic devices<br>" +
                "VLSI and microelectronics<br>" +
                "Communication systems<br><br>" +
                "<b>School of Bio Engineering - Topics</b><br>" +
                "Biodegradable implants for bone repair<br>" +
                "Bio-surfactants<br>" +
                "Plant-made vaccines for humans and animals<br>" +
                "Gene-environment interactions in major depressive disorder<br>" +
                "Ovarian aging and infertility<br>" +
                "Quantum dot technology in flow cytometry<br>" +
                "Microbe-microbe interactions in mixed culture food fermentations<br>" +
                "Role of p450 in autoimmune disorder<br>" +
                "Therapeutic advances in cancer<br><br>" +
                "<b>School of Civil - Topics</b><br>" +
                "Green buildings<br>" +
                "Earthquake resistant Structures<br>" +
                "Modern Construction and rehabilitation techniques<br>" +
                "Design of bridges<br>" +
                "Concrete prepared with new inclusions and replacements<br>" +
                "Sustainable waste management – a war on waste<br>" +
                "Design of tall buildings<br>" +
                "Ground improvement techniques<br>" +
                "Geosynthetics in pavement design<br>" +
                "Rain water harvest and artificial recharging techniques<br><br>" +
                "<b>Important Dates</b><br>" +
                "9th September 2013: Last date for full paper submission<br>" +
                "11th September 2013: Intimation of selected participants<br>"));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Both Author and Co-author must be bona-fide students of a University/College.<br>" +
                "* The registration for the paper will be done on the day of event in case the paper reaches the final presentation stage. Both the participants have to register for the event. Even if one of the authors is not able to attend the presentation, the other has to register on his behalf.<br>" +
                "* There are no registrations required to be done during full paper submission stage.<br>" +
                "* Certificates will be issued only to those participants, who have presented their paper in the final round and also have registered for the event.<br>" +
                "* Prizes will be given to the best paper presentations based on the criteria decided by the judges.<br>" +
                "* Submit the abstract along with full paper in standard format.<br>" +
                "* Only one paper per author is permitted.<br>" +
                "* Mail your full papers to the respective School Of Engineering mail Ids provided along with the Schools of Engineering on or before 04/09/2013. Mail IDs are provided below.<br>" +
                "* You are required to MENTION 'THE NAME OF THE TOPIC' in the subject of your mail. Also your attachment file should be saved as the name as your topic and nothing else.<br>" +
                "* Mention Your Name, Year, Course, College/University, Phone Number and Mail ID both in the mail and the attachment file.<br>" +
                "* Intimation about the selection of paper will be given through mail latest by 11/09/2013.<br>" +
                "* The full length papers must be submitted in IEEE format and should not exceed 6 pages.<br>" +
                "* Decision of judges shall be final and it will be binding to all.<br>" +
                "* If a participant does not follow any of the rules his/her paper will be disqualified. For further details mail your enquiry at praesentatio@aaruush.net."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>School of Computing</b><br>" +
                "<b>Neha</b><br>" +
                "II Year, Information Technology<br>" +
                "computing.aaruush@gmail.com<br>" +
                "+91-95000 89284<br><br>" +
                "<b>School of Mechanical</b><br>" +
                "<b>Smith Srinivasan</b><br>" +
                "II Year, Mechanical Engineering<br>" +
                "mechanical.aaruush@gmail.com<br>" +
                "+91-78118 45119<br><br>" +
                "<b>School of Electrical & Electronics</b><br>" +
                "<b>Pavani</b><br>" +
                "II Year, Electronics & Electrical Engineering<br>" +
                "electrical.aaruush@gmail.com<br>" +
                "+91-87544 21872<br><br>" +
                "<b>School of Bio Engineering</b><br>" +
                "<b>Tulika Baranwal</b><br>" +
                "II Year, Mechanical Engineering<br>" +
                "bio.aaruush@gmail.com<br>" +
                "+91-97910 85602<br><br>" +
                "<b>School of Civil</b><br>" +
                "<b>Kartik</b><br>" +
                "III Year, Civil Engineering<br>" +
                "civil.aaruush@gmail.com<br>" +
                "+91-94457 78296"));
    }

}