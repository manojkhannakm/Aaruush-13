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

public class MobileBotrixPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("Mobile robots are a major focus of current research and almost every major university has one or more labs that focus on mobile robot research. " +
                "Mobile robots are also found in industry, military and security environments. " +
                "This year, we are bringing this trend of mobile robotics to AARUUSH'13 by associating with Technophilia Systems and Robotics and Computer Applications Institute of U.S.A.");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_mobile_botrix);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("<b>Details on microcontroller</b><br>" +
                "Application of microcontrollers and embedded C in industry, military, medical, home appliances, home-automation etc<br>" +
                "Programming the microcontroller using embedded C<br>" +
                "Interfacing and controlling various devices like keypad/push button switches, LEDs, buzzer, motors etc with microcontroller<br>" +
                "Making of various types of robots, their algorithms and coding<br>" +
                "Developing wireless control on the robot using Mobile Phone/making mobile phone controlled robots and many more...<br><br>" +
                "<b>KIT DETAILS(Contents in the CD)</b><br>" +
                "Microcontroller development board<br>" +
                "Mobile Phone Control/DTMF module<br>" +
                "3.5mm Universal Audio connector<br>" +
                "USB cable<br>" +
                "A set of robotic chassis<br>" +
                "Geared DC motor<br>" +
                "Molded plastic Wheels with rubber grip<br>" +
                "Ball caster with 360 degree freedom<br>" +
                "Batteries for power supply<br>" +
                "Nut, Bolt, L-Clamp, Screw driver & Battery connectors<br><br>" +
                "<b>Registration Fee: </b>Rs 4800/- (team of max 4), Includes(teaching + certificate)<br>" +
                "<b>Date: </b>15th & 16th SEPTEMBER 2013"));

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