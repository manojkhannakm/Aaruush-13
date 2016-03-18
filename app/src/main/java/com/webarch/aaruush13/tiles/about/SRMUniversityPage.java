package com.webarch.aaruush13.tiles.about;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.TileScreenPage;

public class SRMUniversityPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = (ScrollView) inflater.inflate(R.layout.about_srmuniversity, container, false);

        ((TextView) scrollView.findViewById(R.id.about_srmuniversity_text)).setText("     " + Html.fromHtml("<p>Started in 1985, and now ranked among the top universities in India, SRM University provides a wide range of undergraduate, postgraduate and doctoral programmes in the fields of Engineering, Management, Medicine and Health Sciences and Science and Humanities.</p>") +
                "     " + Html.fromHtml("<p>The large 600 acres campus includes state of the art facilities including world class libraries, Wi-Fi Campus, a 5000 capacity AC auditorium, online smart classrooms, Hostels with premium facilities, and endless convenience on campus including bookstores, gym, prayer halls and ATMs.</p>") +
                "     " + Html.fromHtml("<p>The collaborations with world renowned universities like MIT, Carnegie Mellon, UC Davis, Warwick help us to improve the curriculum and global standards.</p>") +
                "     " + Html.fromHtml("<p>The University has accreditions from the national agencies like the UGC, AICTE and boasts a 'A' grade from the NAAC. Some of the courses additionally have an ABET accrediton while others have applied for the same.</p>") +
                "     " + Html.fromHtml("<p>SRM encourages the students to employ a research oriented methodology and thus has numerous teams working on reputed projects like the SRM SAT and many more participating in wide range of competitions like the FSAE, BAJA, CANSAT, Shell Eco Marathon, Robocon to name a few.</p>") +
                "     " + Html.fromHtml("The University justifies its moto to \"Learn Leap and Lead\" as it provides an exemplary support in the form of well versed faculty, state of the art laboratories, global exposure and a research conducive environment."));

        setSearchScrollView(scrollView);
        addSearchTag("srm", 0);
        addSearchTag("university", 0);
        addSearchTag("campus", 25);
        addSearchTag("research", 100);

        return scrollView;
    }

}