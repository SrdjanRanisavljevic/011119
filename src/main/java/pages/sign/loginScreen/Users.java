package pages.sign.loginScreen;

import java.util.ArrayList;
import java.util.Arrays;

public class Users {

    private final String prodUser = "echosign.igor+prod@gmail.com";

    public String getProdUser() {
        return prodUser;
    }

    private final ArrayList<String> shardCodes = new ArrayList<>(

            Arrays.asList("NA1", "NA12", "NA13", "NA14", "NA15",
                    "NA1B",
                    "NA2",
                    "NA2B",
                    "NA3",
                    "NA3B",
                    "EU1",
                    "EU1B",
                    "EU2",
                    "EU2B",
                    "JP1",
                    "JP1B",
                    "IN1",
                    "IN1B",
                    "AU1",
                    "AU1B"));


    private final ArrayList<String> userNames = new ArrayList<>(

            Arrays.asList("echosign.mtest.na1+2@gmail.com",
                    "echosign.mtest.na1+4@gmail.com",
                    "echosign.mtest.na1+5@gmail.com",
                    "echosign.mtest.na1+6@gmail.com",
                    "echosign.mtest.na1+7@gmail.com",
                    "echosign.mtest.na1+3@gmail.com",

                    "echosign.mtest.na2@gmail.com",
                    "echosign.mtest.na2+1@gmail.com",

                    "echosign.mtest.na3@gmail.com",
                    "echosign.mtest.na3+1@gmail.com",

                    "echosign.mtest.eu1@gmail.com",
                    "echosign.mtest.eu1+1@gmail.com",

                    "echosign.mtest.eu2@gmail.com",
                    "echosign.mtest.eu2+1@gmail.com",

                    "echosign.mtest.jp1@gmail.com",
                    "echosign.mtest.jp1+1@gmail.com",

                    "echosign.mtest.in1@gmail.com",
                    "echosign.mtest.in1+1@gmail.com",

                    "echosign.mtest.au1@gmail.com",
                    "echosign.mtest.au1+1@gmail.com"));


    public String getUser(String shardCode) {
        for (int i = 0; i < shardCodes.size(); i++) {
            if (shardCodes.get(i).equalsIgnoreCase(shardCode)) {
                return userNames.get(i);
            }
        }
        return null;
    }
}
