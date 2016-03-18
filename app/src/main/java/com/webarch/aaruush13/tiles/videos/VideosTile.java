package com.webarch.aaruush13.tiles.videos;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.activities.MainActivity;
import com.webarch.aaruush13.components.Tile;

import java.util.List;

public class VideosTile extends Tile {

    public VideosTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Videos", 2, 1, Color.parseColor("#9933CC"), Color.parseColor("#C58BE2"), R.drawable.videos_icon);

        ImageView liveTileImageView = new ImageView(getContext());
        liveTileImageView.setImageResource(R.drawable.videos_live_tile);
        liveTileImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        setLiveTiles(new View[]{liveTileImageView}, false, false);
    }

    @Override
    public void openTileScreen(boolean quickOpen) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:tSb2PL7KlDU"));
        List<ResolveInfo> resolveInfos = getContext().getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfos.size() == 0) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=tSb2PL7KlDU"));
        }
        getContext().startActivity(intent);

        aaruush13.mainActivity.setState(MainActivity.State.MainScreen);
    }

}