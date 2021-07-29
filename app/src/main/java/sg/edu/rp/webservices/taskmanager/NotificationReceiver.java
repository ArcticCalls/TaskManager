package sg.edu.rp.webservices.taskmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {
    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel("default", "Default Channel",
                    NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("This is for default notification");
            notificationManager.createNotificationChannel(channel);
        }

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity (context, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle("Feeling Good Lyrics");
        bigText.bigText("Birds flying high, you know how I feel" + "\nSun in the sky, you know how I feel" + "\nReeds driftin' on by, you know how I feel" + "\nIt's a new dawn, it's a new day, it's a new life for me" + "\nYeah~~ \nIt's a new dawn, it's a new day, it's a new life for me" + "\nOooooh... \nAnd I'm feeling good");
        builder.setContentTitle("Feeling Good Lyrics");
        builder.setContentText("Birds flying high, you know how I feel");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setStyle(bigText);
        builder.setAutoCancel(true);
        builder.setLights(Color.GREEN, 400,500);
        builder.setVibrate(new long[] {0, 1000, 200, 1000});
        Notification n = builder.build();
        notificationManager.notify(123, n);
    }
}