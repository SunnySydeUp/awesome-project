package com.sunnysydeup.awesomeproject.models;

import android.support.annotation.ColorRes;

/**
 * The palette for a navigation item containing the background colour of the {@link
 * android.support.v7.widget.CardView} and it's text colour.
 */
public class NavigationPaletteItem {
    /**
     * The background colour for the card.
     */
    @ColorRes
    public int backgroundColour;
    /**
     * Text colour to use for the navigation title so it doesn't clash with the background colour.
     */
    @ColorRes
    public int textColour;

    public NavigationPaletteItem(int backgroundColour, int textColour) {
        this.backgroundColour = backgroundColour;
        this.textColour = textColour;
    }
}
