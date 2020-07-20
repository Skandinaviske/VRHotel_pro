package ca.uottawa.csi5389.vrhotel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UnityLauncher {

    public static String[] sceneNames = {"Hotel1BathRoom", "Hotel1Lobby1", "Hotel1Room1", "Hotel1Room2", "Hotel1WashRoom",
            "Hotel2Dining1", "Hotel2Lobby1", "Hotel2Room1", "Hotel2Room2", "Hotel3Dining1", "Hotel3Lobby1", "Hotel3Room1", "Hotel3Room2",
            "Hotel4Dining1", "Hotel4Lobby1", "Hotel4Room1", "Hotel4Room2", "Hotel5Lobby1", "Hotel5Restaurant", "Hotel5Room1", "Hotel5Room2",
            "Hotel6Lobby1", "Hotel6Restaurant", "Hotel6Room1", "Hotel6Room2"};

    public static void goToUnityUsingID(int positionId, int gridId, Context context) {
        switch (positionId) {
            case 1:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel1Lobby1", context);
                        break;
                    case 1:
                        goToUnity("Hotel1BathRoom", context);
                        break;
                    case 2:
                        goToUnity("Hotel1Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel1Room2", context);
                        break;
                    case 4:
                        goToUnity("Hotel1WashRoom", context);
                        break;
                }
                break;
            case 2:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel2Dining1", context);
                        break;
                    case 1:
                        goToUnity("Hotel2Lobby1", context);
                        break;
                    case 2:
                        goToUnity("Hotel2Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel2Room2", context);
                        break;
                }
                break;
            case 3:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel3Dining1", context);
                        break;
                    case 1:
                        goToUnity("Hotel3Lobby1", context);
                        break;
                    case 2:
                        goToUnity("Hotel3Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel3Room2", context);
                        break;
                }
                break;
            case 4:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel4Dining1", context);
                        break;
                    case 1:
                        goToUnity("Hotel4Lobby1", context);
                        break;
                    case 2:
                        goToUnity("Hotel4Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel4Room2", context);
                        break;
                }
                break;
            case 5:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel5Restaurant", context);
                        break;
                    case 1:
                        goToUnity("Hotel5Lobby1", context);
                        break;
                    case 2:
                        goToUnity("Hotel5Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel5Room2", context);
                        break;
                }
                break;
            case 6:
                switch (gridId) {
                    case 0:
                        goToUnity("Hotel6Restaurant", context);
                        break;
                    case 1:
                        goToUnity("Hotel6Lobby1", context);
                        break;
                    case 2:
                        goToUnity("Hotel6Room1", context);
                        break;
                    case 3:
                        goToUnity("Hotel6Room2", context);
                        break;
                }
                break;
        }
    }

    static void goToUnity(String sceneName, Context context) {
        // uncomment to debug: Toast.makeText(context, sceneName, Toast.LENGTH_LONG).show();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("ca.uottawa.csi5389.hotelvrproject");
        intent.putExtra("sceneToLaunch", sceneName);
        try {
            context.startActivity(intent);  // will crash if VR package is not installed
        } catch (Exception e) {
            Toast.makeText(context, "The Unity VR component does not appear to be installed. Please install it then try again,", Toast.LENGTH_LONG).show();
        }
    }
}
