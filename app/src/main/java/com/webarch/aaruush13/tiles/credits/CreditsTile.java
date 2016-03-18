package com.webarch.aaruush13.tiles.credits;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class CreditsTile extends Tile {

    public CreditsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Credits", 1, 1, Color.parseColor("#FF8A00"), Color.parseColor("#FFBD21"), R.drawable.credits_icon);

        setFlipTiles(new int[]{
                R.drawable.people_mohit,
                R.drawable.people_umashankar,
                R.drawable.people_ranjith,
                R.drawable.people_manideep,
                R.drawable.people_sneha,
                R.drawable.people_arvind,
                R.drawable.people_pranshu,
                R.drawable.people_vignesh,
                R.drawable.people_jay,
                R.drawable.people_anurag,
                R.drawable.people_abhiram,
                R.drawable.people_aman,
                R.drawable.people_saurabh,
                R.drawable.people_nikita,
                R.drawable.people_shankar,
                R.drawable.people_malvika,
                R.drawable.people_kshitij,
                R.drawable.people_nandini,
                R.drawable.people_jyotirmoy,
                R.drawable.people_arshad,
                R.drawable.people_niharika,
                R.drawable.people_arun,
                R.drawable.people_anoop,
                R.drawable.people_venkat,
                R.drawable.people_sriharsha,
                R.drawable.people_ashutosh,
                R.drawable.people_neelabh,
                R.drawable.people_aakash,
                R.drawable.people_anirudh,
                R.drawable.people_arnab,
                R.drawable.people_manoj,
                R.drawable.people_monik,
                R.drawable.people_punit,
                R.drawable.people_rishabh,
                R.drawable.people_rakshit,
                R.drawable.people_shekhar,
                R.drawable.people_sandeep,
                R.drawable.people_shreya
        }, false, false);

        addTileScreenPage("Patrons", PatronsPage.class, new String[]{
                "Dr. C. Muthamizhchelvan",
                "Prof. A. Rathinam",
                "Prof. V. M. Ponniah",
                "Mr. V. Thirumurugan"
        });
        addTileScreenPage("Core team", CoreTeamPage.class, new String[]{
                "Mohit Kumar Maroti",
                "Kasaraneni Uma Sankar",
                "Ranjith Kumar Reddy",
                "Shivanathuni Manideep",
                "Sneha Sankar",
                "Arvind Vasudevan",
                "Pranshu Kumar",
                "C. Vignesh",
                "Jay Sharma",
                "Kuruba Anurag Sagar",
                "Abhiram Natrajan",
                "Aman Kumar",
                "Saurabh Singh",
                "Nikita Rathi",
                "Palle Shankarananda Reddy",
                "Malvika Chandhok",
                "Kshitij Narang",
                "Nandini Ravichandran",
                "Jyotirmoy Mohapatra",
                "Mohammad Arshad Zubair",
                "Niharika Katiki",
                "Arun Iyer",
                "Naga Sai Anoop Ainapurapu",
                "Sai Venkat Vanka",
                "V. S. Sriharsha Sivanapalli",
                "Ashutosh Agarwal"
        });
        addTileScreenPage("Credits", CreditsPage.class, new String[]{
                "Ashutosh Agarwal",
                "Arun Iyer",
                "Neelabh Pandey",
                "Aakash Patel",
                "Anirudh Mani",
                "Arnab Kundu",
                "Manoj Khanna",
                "Monik Reddy",
                "Punit Gupta",
                "Rishabh Gupta",
                "Rakshit Tanti",
                "Shekhar Singh",
                "Sandeep Agrawal",
                "Shreya Chakroborthy"
        });
    }

}