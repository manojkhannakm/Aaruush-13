package com.webarch.aaruush13.tiles.domains.magefficie;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class MagefficiePage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("MAGEFFICIE's events test the business and managerial skills of the participant. " + "Crisis aversion, management, corporate strategy building and business planning form the basics of this domain.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Niharika Katiki</b><br>" +
                "Event Manager, Magefficie<br>" +
                "magefficie@aaruush.net<br>" +
                "+91-96000 49465"));

        addEventPage(new CorporateChanakyaPage(getActivity(), "Corporate Chanakya"));
        addEventPage(new MarketMayhemPage(getActivity(), "Market Mayhem"));
        addEventPage(new SuccessSutraPage(getActivity(), "Success Sutra"));
        addEventPage(new TolMolKeBolPage(getActivity(), "Tol Mol Ke Bol"));

        return relativeLayout;
    }

}