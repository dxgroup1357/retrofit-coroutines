package com.mytasklist.androidandkotlinweekly.viewextenstion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import java.io.File
import java.util.*

inline fun <reified T : Any> Activity.startNewActivity(
    options: Bundle? = null,
    resultLauncher: ActivityResultLauncher<Intent>,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    resultLauncher.launch(intent)
}

inline fun <reified T : Any> Context.startNewActivityWithResult(
    options: Bundle? = null,
    resultLauncher: ActivityResultLauncher<Intent>,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    resultLauncher.launch(intent)
}

inline fun <reified T : Any> Context.startNewActivity(
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)

//mUri: Uri, resultLauncher: ActivityResultLauncher<Intent>
inline fun Context.capturePhoto(onCallback: (mUri: Uri, intent: Intent) -> Unit) {
    val capturedImage = File(externalCacheDir, "${Date().time}.jpg")
    if (capturedImage.exists()) {
        val boolean = capturedImage.delete()
    }
    capturedImage.createNewFile()
    val mUri = if (Build.VERSION.SDK_INT >= 24) {
        FileProvider.getUriForFile(
            this, "com.joyide.horizon.provider",
            capturedImage
        )

    } else {
        Uri.fromFile(capturedImage)
    }

    val intent = Intent("android.media.action.IMAGE_CAPTURE")
    intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri)
    onCallback(mUri, intent)
}

inline fun Context.capturePhoto(onCallback: (mUri: Uri, intent: Intent, file: File) -> Unit) {
    val capturedImage = File(externalCacheDir, "${Date().time}.jpeg")
    if (capturedImage.exists()) {
        val boolean = capturedImage.delete()
    }
    capturedImage.createNewFile()
    val mUri = if (Build.VERSION.SDK_INT >= 24) {
        FileProvider.getUriForFile(
            this, "$packageName.provider",
            capturedImage
        )

    } else {
        Uri.fromFile(capturedImage)
    }

    val intent = Intent("android.media.action.IMAGE_CAPTURE")
    intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri)
    onCallback(mUri, intent, capturedImage)
}

fun Context?.isInterNetCheck(): Boolean {
    this?.apply {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }
    return false
}

fun Context.getDrawableBitmap(resId: Int): Bitmap? {
    return AppCompatResources.getDrawable(this, resId)?.toBitmap()
}






