package com.webarch.aaruush13.tiles.workshops;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.components.TileScreenPage;

public class TransformerBotixPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("TransformerBot is a Robotics workshop which combines different technologies together. " + "This workshop aims at giving an opportunity to the budding engineers to take a stand in the field of Robotics through the development of a walking Robot, 2-wheel self balancing Robot which can transform itself autonomously either from walking to 2-wheel self-balancing or vice-versa.");

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("1. Introduction to Robotics<br>" +
                "2. Types of Legged Robots and Mechanical Model<br>" +
                "3. Mechanical Structure<br>" +
                "4. Introduction to AVR microcontroller<br>" +
                "5. Exploring Analog to Digital Converter (ADC) feature of AVR & writing program for it<br>" +
                "6. Test run of the Transformer<br><br>" +
                "<b>KIT DETAILS</b><br>" +
                "1.Microcontroller development board<br>" +
                "2. USB cable (1)<br>" +
                "3. Geared DC motors (5)<br>" +
                "4. Transformer bot chassis assembling parts (1set)<br>" +
                "5. Plastic wheel with rubber grip (2)<br>" +
                "6. Analog Optical Sensors (2)<br>" +
                "7. 9v Battery (3)<br>" +
                "8. Battery snapper (2)<br>" +
                "9. Sensor cable (2)<br>" +
                "10. Screw driver (1)<br>" +
                "11. Nut-Bolt pouch (1)<br>" +
                "12. CD containing study materials, sample code, software etc (1)<br><br>" +
                "<b>Registration Fee: </b>Rs 4800/- (team of max 4), Includes(teaching + certificate)<br>" +
                "<b>Date: </b>18th & 19th SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Bharat</b><br>" +
                "Workshop Coordinator<br>" +
                "aaruushworkshop13@gmail.com<br>" +
                "+91-87545 60663<br><br>" +
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