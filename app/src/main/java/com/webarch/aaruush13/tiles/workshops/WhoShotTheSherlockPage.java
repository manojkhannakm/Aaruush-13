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

public class WhoShotTheSherlockPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("Introduction to Forensics, Presentation with different fields of forensics. " +
                "What are Fingerprints, Development Methods and Techniques, Lab Activity developing Fingerprints. " +
                "What are Footprints, Development Methods and Techniques, Lab Activity – Footwear Casting. " +
                "Anthropology is a fast growing field of forensics that has found its applications in different areas of crime investigation, case studies, archeology etc. " +
                "Psychology is an applied discipline that mainly concentrates on studying the mental functions and behavior of a human being. " +
                "This year, we are conducting a workshop that covers all the recent trends of investigation, anthropology and psychology.");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_who_shot_the_sherlock);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("Forensic Anthropology Introduction<br>" +
                "Field Exercise – How Skeletal remains are searched for, sketching and collecting evidence<br>" +
                "Fingerprint Introduction<br>" +
                "Fingerprint Activity<br>" +
                "Case Study<br>" +
                "Footwear Introduction<br>" +
                "Footwear Lab Activity<br>" +
                "Forensic Anthropology Introduction<br>" +
                "Field Exercise – How Skeletal remains are searched for, sketching and collecting evidence<br>" +
                "Forensic Psychology Introduction<br><br>" +
                "<b>Registration Fee: </b>Rs 600/- per individual, Includes(teaching + certificate)<br>" +
                "<b>Date: </b>20th & 21st SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Mahesh</b><br>" +
                "Workshop Coordinator<br>" +
                "aaruushworkshop13@gmail.com<br>" +
                "+91-98842 11649<br><br>" +
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