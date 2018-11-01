package com.example.anslo.mkulimaapp.Data;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Paul Mburu on 11/1/18.
 */

public class Tools {
    public static int dpToPx(Context c, int dp) {
        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
