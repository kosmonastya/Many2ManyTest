package com.kosmolobster.mytestapp.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.kosmolobster.mytestapp.R;


public final class UiUtils {

    public static void showAlertDialog(Context context,
                                       final int messageId,
                                       final MyCallback callbackYes,
                                       final MyCallback callbackNo) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.oww));
        builder.setMessage(context.getResources().getString(messageId));

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (callbackYes != null) {
                    callbackYes.doCallback();
                }
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (callbackNo != null) {
                    callbackNo.doCallback();
                }
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showToast(Context context, int messageId) {
        Toast.makeText(context, messageId,
                Toast.LENGTH_LONG).show();
    }
}
