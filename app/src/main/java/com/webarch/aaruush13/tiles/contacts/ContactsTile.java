package com.webarch.aaruush13.tiles.contacts;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class ContactsTile extends Tile {

    public ContactsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Contacts", 1, 1, Color.parseColor("#669900"), Color.parseColor("#99CC00"), R.drawable.contact_icon);

        setFlipTiles(new int[]{
                R.drawable.people_mohit,
                R.drawable.people_umashankar,
                R.drawable.people_sneha,
                R.drawable.people_arvind,
                R.drawable.people_saurabh,
                R.drawable.people_nikita,
                R.drawable.people_shankar,
                R.drawable.people_kshitij,
                R.drawable.people_malvika,
                R.drawable.people_pranshu,
                R.drawable.people_vignesh,
                R.drawable.people_jay,
                R.drawable.people_anurag,
                R.drawable.people_ashutosh,
                R.drawable.people_arun
        }, false, false);

        addTileScreenPage("Contacts", ContactsPage.class, new String[]{
                "General",
                "Mohit Kumar Maroti",
                "Kasaraneni Uma Sankar",
                "Public relations",
                "Sneha Shankar",
                "Arvind Vasudevan",
                "Sponsorship",
                "Saurabh Singh",
                "Nikita Rathi",
                "Workshops",
                "Palle Shankarananda Reddy",
                "Event organizers",
                "Kshitij Narang",
                "Malvika Chandhok",
                "Hospitality",
                "Pranshu Kumar",
                "C. Vignesh",
                "Ambassadors",
                "Jay Sharma",
                "Kuruba Anurag Sagar",
                "Technical assistance",
                "Ashutosh Agrawal",
                "Arun Iyer"
        });
    }

}