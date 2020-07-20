package ca.uottawa.csi5389.vrhotel.dao;

import java.util.HashMap;
import java.util.Map;

import ca.uottawa.csi5389.vrhotel.R;

/**
 * VRItem is function to:
 * 1. store many local data.
 * 2. use functions to get these data by creating the New Object.
 */
public class VRItem {

    public static int exchangeNameForId(String name) {
        for (int i = 0; i < stringHotelName.length; i++) {
            if (stringHotelName[i].equals(name)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static final String[] stringHotelName = new String[]{
            "Roomy Hotel",
            "Brighton Lakeside Hotel",
            "Laville Resort Villas",
            "Elegance Hotel",
            "Envy Hotel",
            "Airport Express Hotel"
    };

    private static final String[] stringbasicHotelDescription = new String[]{
            "Roomy Hotel understands that comfortable rooms need to be large enough in space, allowing free movements of your guests. If you want to have a good rest during your vacation, stay with Roomy so your rest will not be disrupted by lack of free space in your room and hotel areas.",

            "Simple, minimalistic, yet cozy and comfortable hotel located next to the island’s lake! Featuring rooms with the beautiful view of the lake, allowing you to relax while looking at the beautiful view!",

            "Comfortable and clean resort villas to stay with your entire family or with your friends. Conveniently located a walk-able distance away from the island’s beach. The entire resort is also family-friendly.",

            "Elegance Hotel features elegantly designed and furnished rooms – innovative and fun designs that will inspire and rejuvenate guests during their stay.",

            "Envy hotel features great service and great price for your vacation. A price, deal, service, and experience that others will be envious of. In addition, the hotel also located in a convenient area with nearby facilities and spots to visit!",

            "Airport Express Hotel features a location close to the island’s airport, and has the best deals around the area according to our customers. Equipped with soundproof walls and windows, the rooms will not get noisy despite the close proximity to the airport. Convenient location, yet comfortable rest for the guests. The hotel is especially ideal for layovers, so you can stay close to the airport."
    };

    private static final Map<Integer, Integer[]> mapHotelLatitudeandLongitude = new HashMap<Integer, Integer[]>() {{
        put(1, new Integer[]{78, 151});

        put(2, new Integer[]{-33, 151});

        put(3, new Integer[]{35, 139});

        put(4, new Integer[]{43, 79});

        put(5, new Integer[]{48, 123});

        put(6, new Integer[]{22, 114});
    }};

    private static final String[] getStringHotelAddress = new String[]{
            "64 Yawns Road",
            "25 Lakeview Drive",
            "36 Beachside Road",
            "95 Burrows Road",
            "128 Boulder Way",
            "360 Airport Way",
    };

    private static final String[] stringHotelDescription = new String[]{
            "Roomy Hotel understands that comfortable rooms need to be large enough in space, allowing free movements of your guests. If you want to have a good rest during your vacation, stay with Roomy so your rest will not be disrupted by lack of free space in your room and hotel areas.\n" +
                    "\n" +
                    "With rooms large enough for a party of 4 guests or more, the hotel also features multiple showers in the bathroom, which allows guests to use the bathroom at the same time without waiting for one another. Save more time for what actually matters during your vacation.",

            "Simple, minimalistic, yet cozy and comfortable hotel located next to the island’s lake! Featuring rooms with the beautiful view of the lake, allowing you to relax while looking at the beautiful view!\n" +
                    "\n" +
                    "In addition, the location of the hotel also allows you to visit other point-of-interests of the island easily.\n" +
                    "\n" +
                    "The hotel also boasts a restaurant that is always open for breakfast, lunch, and dinner; serving different kind of style from all around the world each day – food loved by locals and tourists alike!",

            "Comfortable and clean resort villas to stay with your entire family or with your friends. Conveniently located a walk-able distance away from the island’s beach. The entire resort is also family-friendly.\n" +
                    "\n" +
                    "Featuring kitchen and dining table in each villa, which allows guests to cook for themselves should they desire to. A hotel restaurant is also available for guests who would prefer to taste local-style dishes.\n" +
                    "\n" +
                    "Book now for your next vacation to the island to have an accommodation close to the island’s beach!",

            "Elegance Hotel features elegantly designed and furnished rooms – innovative and fun designs that will inspire and rejuvenate guests during their stay.\n" +
                    "\n" +
                    "The hotel also features a cozy restaurant, which welcomes guests to grab delicious prepared-on-the-spot meals, and various drinks from all over the world. Reservations to throw parties in parts of the restaurant are also welcome!\n" +
                    "\n" +
                    "Located in the island’s central area, providing convenience to guests who would like to travel around the island, no matter the destination. Book now and get ready for an unforgettable elegant stay in the island!",

            "Envy hotel features great service and great price for your vacation. A price, deal, service, and experience that others will be envious of. In addition, the hotel also located in a convenient area with nearby facilities and spots to visit!\n" +
                    "\n" +
                    "Aside from the hotel’s great service and price, the hotel also prides itself in being environmentally friendly! Everything in the room is cleaned and processed with environmentally-friendly materials, which are not only friendly to the environment, but also will not affect your health since everything is natural.\n" +
                    "\n" +
                    "Book with the hotel now for great price, great service, and natural rooms.",

            "Airport Express Hotel features a location close to the island’s airport, and has the best deals around the area according to our customers. Equipped with soundproof walls and windows, the rooms will not get noisy despite the close proximity to the airport. Convenient location, yet comfortable rest for the guests. The hotel is especially ideal for layovers, so you can stay close to the airport.\n" +
                    "\n" +
                    "The hotel also provides free facilities for its guests, such as the free hotel shuttle to-and-from the airport, free internet, and free boarding pass printing at the lobby. With the facilities included in the stay, the hotel makes it a good choice for those who are just arriving or about to leave the island."
    };

    private static final Integer[] imagegroup = {
            R.drawable.hotel1,
            R.drawable.hotel2,
            R.drawable.hotel3,
            R.drawable.hotel4,
            R.drawable.hotel5,
            R.drawable.hotel6
    };

    private static final String[] imagegroupII = {
            R.drawable.hotel1 + "",
            R.drawable.hotel2 + "",
            R.drawable.hotel3 + "",
            R.drawable.hotel4 + "",
            R.drawable.hotel5 + "",
            R.drawable.hotel6 + ""
    };

    private static final int[] topImageforHotel1 =
            {R.drawable.hotel1a, R.drawable.hotel1b, R.drawable.hotel1c, R.drawable.hotel1d, R.drawable.hotel1e, R.drawable.hotel1f, R.drawable.hotel1g};

    private static final int[] topImageforHotel2 =
            {R.drawable.hotel2a, R.drawable.hotel2b, R.drawable.hotel2c, R.drawable.hotel2d, R.drawable.hotel2e, R.drawable.hotel2f, R.drawable.hotel2g, R.drawable.hotel2h};

    private static final int[] topImageforHotel3 =
            {R.drawable.hotel3a, R.drawable.hotel3b, R.drawable.hotel3c, R.drawable.hotel3d, R.drawable.hotel3e, R.drawable.hotel3f, R.drawable.hotel3g};

    private static final int[] topImageforHotel4 =
            {R.drawable.hotel4a, R.drawable.hotel4b, R.drawable.hotel4c, R.drawable.hotel4d, R.drawable.hotel4e, R.drawable.hotel4f, R.drawable.hotel4g};

    private static final int[] topImageforHotel5 =
            {R.drawable.hotel5a, R.drawable.hotel5b, R.drawable.hotel5c, R.drawable.hotel5d, R.drawable.hotel5e, R.drawable.hotel5f, R.drawable.hotel5g};

    private static final int[] topImageforHotel6 =
            {R.drawable.hotel6a, R.drawable.hotel6b, R.drawable.hotel6c, R.drawable.hotel6d, R.drawable.hotel6e, R.drawable.hotel6f, R.drawable.hotel6g, R.drawable.hotel6h};

    //Get images for different rooms in different hotel from assets
    public final String[] getImageforHotel1Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel1Lobby1/";
        String[] result = new String[9];
        while (i < 9) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel1Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel1Room/";
        String[] result = new String[29];
        while (i < 29) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel2Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel2Lobby1/";
        String[] result = new String[17];
        while (i < 17) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel2Dining1() {
        int i = 0;
        String front = "file:///android_asset/Hotel2Dining1/";
        String[] result = new String[19];
        while (i < 19) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel2Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel2Room/";
        String[] result = new String[27];
        while (i < 27) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel3Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel3Lobby1/";
        String[] result = new String[7];
        while (i < 7) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel3Dining1() {
        int i = 0;
        String front = "file:///android_asset/Hotel3Dining1/";
        String[] result = new String[10];
        while (i < 10) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel3Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel3Room/";
        String[] result = new String[32];
        while (i < 32) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel4Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel4Lobby1/";
        String[] result = new String[7];
        while (i < 11) {
            result[i] = front + (i + 11) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel4Dining1() {
        int i = 0;
        String front = "file:///android_asset/Hotel4Dining1/";
        String[] result = new String[15];
        while (i < 15) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel4Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel4Room/";
        String[] result = new String[23];
        while (i < 23) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel5Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel5Lobby1/";
        String[] result = new String[10];
        while (i < 10) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel5Dining1() {
        int i = 0;
        String front = "file:///android_asset/Hotel5Dining1/";
        String[] result = new String[10];
        while (i < 10) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel5Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel5Room/";
        String[] result = new String[26];
        while (i < 26) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel6Lobby1() {
        int i = 0;
        String front = "file:///android_asset/Hotel6Lobby1/";
        String[] result = new String[12];
        while (i < 12) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel6Dining1() {
        int i = 0;
        String front = "file:///android_asset/Hotel6Dining1/";
        String[] result = new String[12];
        while (i < 12) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String[] getImageforHotel6Room() {
        int i = 0;
        String front = "file:///android_asset/Hotel6Room/";
        String[] result = new String[28];
        while (i < 28) {
            result[i] = front + (i + 1) + ".png";
            i++;
        }
        return result;
    }

    public final String hotelList(int position, int roomNumber) {
        String result = "";
        if (position == 1) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel1VRImage";
                    break;
                case 2:
                    result = "Hotel1Room";
                    break;
                case 3:
                    result = "Hotel1Lobby1";
                    break;
                case 4:
                    result = "Hotel1Dining1";
                    break;
                default:
            }
        } else if (position == 2) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel2VRImage";
                    break;
                case 2:
                    result = "Hotel2Room";
                    break;
                case 3:
                    result = "Hotel2Lobby1";
                    break;
                case 4:
                    result = "Hotel2Dining1";
                    break;
                default:
            }
        } else if (position == 3) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel3VRImage";
                    break;
                case 2:
                    result = "Hotel3Room";
                    break;
                case 3:
                    result = "Hotel3Lobby1";
                    break;
                case 4:
                    result = "Hotel3Dining1";
                    break;
                default:
            }
        } else if (position == 4) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel4VRImage";
                    break;
                case 2:
                    result = "Hotel4Room";
                    break;
                case 3:
                    result = "Hotel4Lobby1";
                    break;
                case 4:
                    result = "Hotel4Dining1";
                    break;
                default:
            }
        } else if (position == 5) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel5VRImage";
                    break;
                case 2:
                    result = "Hotel5Room";
                    break;
                case 3:
                    result = "Hotel5Lobby1";
                    break;
                case 4:
                    result = "Hotel5Dining1";
                    break;
                default:
            }
        } else if (position == 6) {
            switch (roomNumber) {
                case 1:
                    result = "Hotel6VRImage";
                    break;
                case 2:
                    result = "Hotel6Room";
                    break;
                case 3:
                    result = "Hotel6Lobby1";
                    break;
                case 4:
                    result = "Hotel6Dining1";
                    break;
                default:
            }
        }
        return result;
    }

    //Return the group of the hotel names.
    public final String[] getHotelName() {
        return stringHotelName;
    }

    //Return the group of the hotel descriptions.
    public final String[] getHotelDescription() {
        return stringHotelDescription;
    }

    //Return the group of the brief hotel descriptions.
    public final String[] getStringbasicHotelDescription() {
        return stringbasicHotelDescription;
    }

    //Return the group of the images for Myadapter to set them on the MainActivity.
    public final Integer[] getImagegroup() {
        return imagegroup;
    }

    public final String[] getImagegroupII() {
        return imagegroupII;
    }

    //Return the group of the top images for different hotels.
    public final int[] getTopImageforHotel1() {
        return topImageforHotel1;
    }

    public final int[] getTopImageforHotel2() {
        return topImageforHotel2;
    }

    public final int[] getTopImageforHotel3() {
        return topImageforHotel3;
    }

    public final int[] getTopImageforHotel4() {
        return topImageforHotel4;
    }

    public final int[] getTopImageforHotel5() {
        return topImageforHotel5;
    }

    public final int[] getTopImageforHotel6() {
        return topImageforHotel6;
    }

    //Return the group of hotel address.
    public final String[] getStringHotelAddress() {
        return getStringHotelAddress;
    }

    //Map the hotel with their latitude and longitude.
    public final Map<Integer, Integer[]> getMapHotelLatitudeandLongitude() {
        return mapHotelLatitudeandLongitude;
    }

    //Get the hotel string lists from the assets.
    public final String getHotelList(int position, int roomNumber) {
        return hotelList(position, roomNumber);
    }

}
