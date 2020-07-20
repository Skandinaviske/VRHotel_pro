package ca.uottawa.csi5389.vrhotel.utils;

import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;

import java.util.Locale;

/**
 * Application is to initialize the gallery.
 */

//Reference:https://github.com/yanzhenjie/Album
public class Application extends android.app.Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;

            Album.initialize(AlbumConfig.newBuilder(this)
                    .setAlbumLoader(new MediaLoader())
                    .setLocale(Locale.getDefault())
                    .build()
            );
        }
    }

    public static Application getInstance() {
        return instance;
    }
}
