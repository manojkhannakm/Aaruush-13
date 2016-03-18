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

public class HackTrackPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("As information security increasingly becoming a boardroom level concern, training and certification are becoming increasingly important for candidates and companies. " + "With a promising novel initiative on the cards, This year TechDefence and aaruush 13 decided to extend & prospectus of Hack Track - Hands on Workshop on Ethical Hacking and Information Security in association with Sunny Vaghela, Director & CTO of TechDefence across India.");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_hacktrack);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("<b>Level 1</b><br>" +
                "Wireless and Web application security<br>" +
                "Android hacking and security<br>" +
                "Google & email hacking<br>" +
                "Cyber forensics<br>" +
                "Investigation methodologies<br><br>" +
                "<b>Level 2</b><br>" +
                "Info gathering using Linux<br>" +
                "Windows memory management<br>" +
                "Assembly language basics<br>" +
                "Buffer overflows<br>" +
                "Metasploitframe work<br><br>" +
                "<b>Registration Fee: </b>Rs 900/- per individual, Includes(teaching + certificate)<br>" +
                "<b>Date: </b>18th & 19th SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Sivareddy</b><br>" +
                "Workshop Coordinator<br>" +
                "aaruushworkshop13@gmail.com<br>" +
                "+91-80562 86291<br><br>" +
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