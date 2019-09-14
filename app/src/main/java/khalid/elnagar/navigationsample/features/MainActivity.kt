package khalid.elnagar.navigationsample.features

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder
import khalid.elnagar.navigationsample.R
import khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.feed_screen.boat_screen.BoatFragmentArgs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendFakeNotification()
    }

    private fun sendFakeNotification() {
        val notificationManger =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", importance)
            notificationManger.createNotificationChannel(channel)
        }

        val args = BoatFragmentArgs(3).toBundle()
        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.boatFragment)
            .setArguments(args)
            .createPendingIntent()

        val notification = Notification.Builder(this)
            .setContentTitle("Now on sale!")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.speed_boat_blue)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            notification.setChannelId("channel0")

        notificationManger.notify(0, notification.build())
    }
}

