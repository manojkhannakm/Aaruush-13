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

public class WebpreneurPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("In today's corporate world, web design is an important aspect for every IT professional. " +
                "Web designing skill is something that every company demands because it can complete large sums of work in a short period of time with very little input. " +
                "Apart from that entrepreneurship skill is a must for every individual working in under a business. " +
                "In other words, the newest trend in the IT industry is a fusion of design and entrepreneurship skills. " +
                "This year we bring to you Webpreneurs in association with Nurture Talent - India's 1st institute for entrepreneurs.");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_webpreneur);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("Idea Generation<br>" +
                "The Essential Web Development Skills<br>" +
                "Introduction PHP and MySQL<br>" +
                "Content Management Systems<br>" +
                "Hacking Word press<br>" +
                "Case Studies<br>" +
                "Internet Marketing<br>" +
                "Elevator Pitch and Competition<br><br>" +
                "<b>Registration Fee: </b>Rs 1000/- per individual, Includes(teaching + certificate)<br>" +
                "<b>Date: </b>20th & 21st SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Priya</b><br>" +
                "Workshop Coordinator<br>" +
                "aaruushworkshop13@gmail.com<br>" +
                "+91-98845 27029<br><br>" +
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