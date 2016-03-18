package com.webarch.aaruush13.tiles.workshops;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.components.TileScreenPage;

public class BridgeDesignPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("Bridge Design is one of the oldest topics of Civil Engineering. " +
                "You will be introduced to various types of bridges and moving loads. " +
                "This workshop gives you a unique opportunity to experience a hands-on feel of a Civil Engineering project. " +
                "Participants will design and fabricate their own bridge and test for the maximum load. " +
                "The bridge model made by them can take up to 1000 times the self weight. " +
                "You don't believe that is possible? Participating in our workshops will make you believe that it is possible!");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_bridge_design);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("Interactive lecture sessions with good multimedia content<br>" +
                "Hands-on practical sessions on CAD based bridge design, fabrication and testing<br>" +
                "Self-fabricated and tested for maximum load model by each team<br>" +
                "Different types of bridge design techniques<br>" +
                "Current industry methods used in bridge design<br>" +
                "Group discussion to encourage innovation<br>" +
                "Certificate issued to all participants<br>" +
                "Merit certificate to the best design team<br>" +
                "Merit certificate to best fabrication team<br>" +
                "Merit certificate to any innovative design<br>" +
                "Names of the award winners is put permanently on our website<br>" +
                "Career guidance and Counseling by IIT alumni<br>" +
                "Interview tips and also help to face interview with confidence<br>" +
                "Workshop conducted by IIT Civil Engineering graduates<br><br>" +
                "<b>Registration Fee: </b>Rs 900/- per indvidual, Includes(teaching + certificate)<br>" +
                "<b>Date: </b>18th & 19th SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Chanakya</b><br>" +
                "Workshop Coordinator<br>" +
                "aaruushworkshop13@gmail.com<br>" +
                "+91-97908 32245<br><br>" +
                "<b>Shankar</b><br>" +
                "Workshop Organizer<br>" +
                "workshops@aaruush.net<br>" +
                "+91-95660 39599"));

        workshopCollapsibleView.addPanel("Register", Html.fromHtml("You can also deposit (Registration Fee + 25 INR (processing fee) in following account<br> " +
                "Bank: SBI(State Bank of India)<br>" +
                "Branch: Gandhi Road(Karimnagar)<br>" +
                "A/C No.: 20138135909<br>" +
                "Name: Shivanathuni Manideep<br>" +
                "IFSC Code: SBIN0013339<br><br>" +
                "Then Mail or Message us the deposition details(From Name, Date, Amount and Ref. Number given upon deposition) along with Your Details (Name, Email, Mobile, College) to workshops@aaruush.net or +91-98842 11649<br><br>" +
                "You can also take the DD in favor of Aaruush payable at Chennai and send it to the following address<br>" +
                "P. Shankarananda Reddy<br>" +
                "Workshops Organizer<br>" +
                "The Aaruush Room,<br>" +
                "Main Campus, SRM University<br>" +
                "Kattankulathur<br>" +
                "Chennai - 603203"));

        return workshopScrollView;
    }

}