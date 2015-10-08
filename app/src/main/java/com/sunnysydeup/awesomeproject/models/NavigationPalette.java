package com.sunnysydeup.awesomeproject.models;

import android.content.Context;

import com.sunnysydeup.awesomeproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Palette Generator
 */
public class NavigationPalette {
    private static NavigationPalette instance;
    private List<NavigationPaletteItem> palettes;

    private NavigationPalette(Context context) {
        generatePalette(context);
    }

    private void generatePalette(Context context) {
        if (palettes == null) {
            palettes = new ArrayList<>();
            palettes.add(new NavigationPaletteItem(R.color.palette_red, android.R.color.white));
            palettes.add(new NavigationPaletteItem(R.color.palette_blue, android.R.color.white));
            palettes.add(new NavigationPaletteItem(R.color.palette_green, R.color.primary_text));
            palettes.add(new NavigationPaletteItem(R.color.primary, R.color.primary_text));
            palettes.add(new NavigationPaletteItem(R.color.accent, R.color.primary_text));
        }
    }

    public static NavigationPalette getInstance(Context context) {
        if (instance == null) {
            instance = new NavigationPalette(context);
        }
        return instance;
    }

    /**
     * Generate a random palette.
     *
     * @return a {@link NavigationPaletteItem} which contains a background colour and text colour to
     * use.
     */
    public NavigationPaletteItem generate() {
        Random random = new Random();
        return palettes.get(random.nextInt(palettes.size()));
    }
}
