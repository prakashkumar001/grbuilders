package com.site.siteproject.utils;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Creative IT Works on 20-Dec-17.
 */

public class GlobalClass extends Application {
    private Typeface normalFont;
    private Typeface boldFont;



    // -- Fonts --TextView //
    public void setTypeface(TextView textView) {
        if(textView != null) {
            if(textView.getTypeface() != null && textView.getTypeface().isBold()) {
                textView.setTypeface(getBoldFont());
            } else {
                textView.setTypeface(getNormalFont());
            }
        }
    }


    // -- Fonts --  RadioButton//
    public void setTypeface(RadioButton textView) {
        if(textView != null) {
            if(textView.getTypeface() != null && textView.getTypeface().isBold()) {
                textView.setTypeface(getBoldFont());
            } else {
                textView.setTypeface(getNormalFont());
            }
        }
    }

    // -- Fonts -- Button//
    public void setTypeface(Button textView) {
        if(textView != null) {
            if(textView.getTypeface() != null && textView.getTypeface().isBold()) {
                textView.setTypeface(getBoldFont());
            } else {
                textView.setTypeface(getNormalFont());
            }
        }
    }

    private Typeface getNormalFont() {
        if(normalFont == null) {
            normalFont = Typeface.createFromAsset(getAssets(),"font/YanoneKaffeesatz-Regular.otf");
        }
        return this.normalFont;
    }

    private Typeface getBoldFont() {
        if(boldFont == null) {
            boldFont = Typeface.createFromAsset(getAssets(),"font/YanoneKaffeesatz-Bold.otf");
        }
        return this.boldFont;
    }
}
