package helpers;

import java.util.List;

public class CountryCodesHelper {

    public boolean checkAllCodes (List<String> codes) {
        boolean result = true;

        for (String code : codes) {
            if (! (code.equals("ru") || code.equals("kg") || code.equals("kz") || code.equals("cz"))) {
                result = false;
                break;
            }
            else continue;
        }

        return result;
    }

    public boolean checkRuCodes (List<String> codes) {
        boolean result = true;

        for (String code : codes) {
            if (! code.equals("ru")) {
                result = false;
                break;
            }
            else continue;
        }

        return result;
    }

    public boolean checkKzCodes (List<String> codes) {
        boolean result = true;

        for (String code : codes) {
            if (! code.equals("kz")) {
                result = false;
                break;
            }
            else continue;
        }

        return result;
    }

    public boolean checkCzCodes (List<String> codes) {
        boolean result = true;

        for (String code : codes) {
            if (! code.equals("cz")) {
                result = false;
                break;
            }
            else continue;
        }

        return result;
    }

    public boolean checkKgCodes (List<String> codes) {
        boolean result = true;

        for (String code : codes) {
            if (! code.equals("kg")) {
                result = false;
                break;
            }
            else continue;
        }

        return result;
    }
}
