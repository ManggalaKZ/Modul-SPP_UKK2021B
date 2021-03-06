package com.example.modul_spp_ukk2021.UI.Data.Helper;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMinMax implements InputFilter {

    private int min, max; //paramets that you send to class

    public InputFilterMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            //int input = Integer.parseInt(dest.toString() + source.toString());
            String startString = dest.toString().substring(0, dstart);
            String insert = source.toString();
            String endString = dest.toString().substring(dend);
            String parseThis = startString + insert + endString;
            int input = Integer.parseInt(parseThis);
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
