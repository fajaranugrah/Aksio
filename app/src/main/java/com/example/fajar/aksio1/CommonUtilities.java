package com.example.fajar.aksio1;

import android.content.Context;
import android.content.Intent;

/**
 * Created by fajar on 07/05/2016.
 */
public class CommonUtilities {

    // give your server registration url here
    static final String SERVER_URL = "http://aplikasiakur.hol.es/register.php";
    static final String SERVER_URL_INPUT = "http://aplikasiakur.hol.es/input_nilai.php";

    // Google project id
    static final String SENDER_ID = "626776755825";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "Remainder Message";

    static final String DISPLAY_MESSAGE_ACTION =
            "com.example.fajar.aksio1.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message";

    /**
     * Notifies UI to display a message.
     * <p>
     * This method is defined in the common helper because it's used both by
     * the UI and the background service.
     *
     * @param context application's context.
     * @param message message to be displayed.
     */
    static void displayMessage(Context context, String message) {
        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
}
