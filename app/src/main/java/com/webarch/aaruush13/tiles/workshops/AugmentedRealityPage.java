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

public class AugmentedRealityPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView workshopScrollView = (ScrollView) inflater.inflate(R.layout.workshops_workshop, container, false);

        ((TextView) workshopScrollView.findViewById(R.id.workshops_workshop_introduction)).setText("Augmented reality (AR) is a live, direct or indirect, view of a physical, real-world environment whose elements are augmented by computer-generated sensory input such as sound, video, graphics or GPS data. " +
                "With AR technology (e.g. adding computer vision and object recognition) the information about the surrounding real world of the user becomes interactive and digitally manipulable. " +
                "Artificial information about the environment and its objects can be overlaid on the real world.");

        ((ImageView) workshopScrollView.findViewById(R.id.workshops_workshop_powered_by)).setImageResource(R.drawable.workshops_augmented_reality);

        CollapsibleView workshopCollapsibleView = (CollapsibleView) workshopScrollView.findViewById(R.id.workshops_workshop_details);

        workshopCollapsibleView.addPanel("Details", Html.fromHtml("Introduction to JAVA<br>" +
                "Programming Syntax<br>" +
                "Getting Started with Processing<br>" +
                "NyARToolkit library<br>" +
                "GS Video Plugin<br>" +
                "Creating Shapes<br>" +
                "Overview on OpenGL<br>" +
                "Different AR degrees<br>" +
                "Overview on Tool Kit<br>" +
                "Overlaying 2D & 3D Surfaces<br>" +
                "Color Space Conversions<br>" +
                "Recognizing Different Patterns<br>" +
                "Overlaying Videos & Images<br>" +
                "QR Code(quick response)<br>" +
                "Note on Hiro, Kanji markers<br>" +
                "3D Element on different markers<br>" +
                "Text on markers<br>" +
                "Animating the Text<br>" +
                "Responsive AR<br>" +
                "3D Element with Animation<br><br>" +
                "<b>KIT DETAILS(Contents in the CD)</b><br>" +
                "NYART Tool kit &AR IDE<br>" +
                "Plugins<br>" +
                "AR Markers<br>" +
                "Post workshop material<br><br>" +
                "<b>Registration Fee: </b>Rs 1000/- per individual, Includes(teaching + certificate)<br>" +
                "<b>Date: </b>20th & 21st SEPTEMBER 2013"));

        workshopCollapsibleView.addPanel("FAQ", Html.fromHtml("1. Who can attend the workshop?<br>" +
                "- Students from any branch who have passion to learn new creative things.<br><br>" +
                "2. Do I need to have any pre knowledge?<br>" +
                "- Everything will be taught from the scratch and explained.<br><br>" +
                "3. How do I register for workshop?<br>" +
                "- You can register in at registration in KTR campus or you can send us DD in favour of AARUUSH payable at Chennai<br><br>" +
                "4. What would be the Workshop Venue?<br>" +
                "- Would be announced on our website http://www.aaruush.net and we will message you.<br><br>" +
                "5. How does the workshop helpful to me?<br>" +
                "- You can gain an excellent knowledge on Augmented reality. You will receive a certificate from \"BOTRIO LABS\" which will be helpful further."));

        workshopCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Vinod</b><br>" +
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