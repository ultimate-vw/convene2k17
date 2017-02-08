package yalantis.com.sidemenu.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

//import com.flavienlaurent.discrollview.R;
import com.flavienlaurent.discrollview.lib.Discrollvable;

/**
 *
 */
public class DiscrollvablePurpleLayout3 extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollvablePurpleLayout";


    private View mPurpleView7;
    private View mPurpleView8;


    private float mPurpleView7TranslationX;
    private float mPurpleView8TranslationX;



    public DiscrollvablePurpleLayout3(Context context) {
        super(context);
    }

    public DiscrollvablePurpleLayout3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollvablePurpleLayout3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


        mPurpleView7 = findViewById(R.id.purpleView7);
        mPurpleView7TranslationX = mPurpleView7.getTranslationX();
        mPurpleView8 = findViewById(R.id.purpleView8);
        mPurpleView8TranslationX = mPurpleView8.getTranslationX();


    }

    @Override
    public void onResetDiscrollve() {

        mPurpleView7.setAlpha(0);
        mPurpleView8.setAlpha(0);


        mPurpleView7.setTranslationX(mPurpleView7TranslationX);
        mPurpleView8.setTranslationX(mPurpleView8TranslationX);



    }

    @Override
    public void onDiscrollve(float ratio) {
        if(ratio <= 0.5f) {

            mPurpleView8.setTranslationX(0);
            mPurpleView8.setAlpha(0.0f);
            float rratio = ratio / 0.5f;

            mPurpleView7.setTranslationX(mPurpleView7TranslationX * (1 - rratio));
            mPurpleView7.setAlpha(rratio);



        } else {

            mPurpleView7.setTranslationX(0);
            mPurpleView7.setAlpha(1.0f);

            float rratio = (ratio - 0.5f) / 0.5f;

            mPurpleView8.setTranslationX(mPurpleView8TranslationX * (1 - rratio));
            mPurpleView8.setAlpha(rratio);

        }
    }
}
