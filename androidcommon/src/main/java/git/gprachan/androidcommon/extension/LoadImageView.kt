package git.gprachan.androidcommon.extension

import android.graphics.BitmapFactory
import android.os.StrictMode
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import git.gprachan.androidcommon.R
import java.io.IOException
import java.io.InputStream
import java.net.URL


fun ImageView.load(
    url: String?, @DrawableRes placeholder: Int = R.drawable.ic_android_black_24dp,
    @DrawableRes errorImage: Int = R.drawable.ic_android_black_24dp
) {
    val requestOptions = RequestOptions().placeholder(placeholder).error(errorImage)
    Glide.with(context)
        .setDefaultRequestOptions(requestOptions)
        .load(url)
        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
        .into(this)
}

fun ImageView.loadNonCache(
    url: String?, @DrawableRes placeholder: Int = R.drawable.ic_android_black_24dp,
    @DrawableRes errorImage: Int = R.drawable.ic_android_black_24dp
) {
    val requestOptions = RequestOptions().placeholder(placeholder).error(errorImage)
    Glide.with(context)
        .setDefaultRequestOptions(requestOptions)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .into(this)
}

fun String.urlToDrawable() {
    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
    StrictMode.setThreadPolicy(policy)
    try {
        val url = URL(this)
        BitmapFactory.decodeStream(url.content as InputStream)
    } catch (e: IOException) {

    }
}