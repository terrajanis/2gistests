package tests;

import helpers.CountryCodesHelper;
import helpers.NameHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    Properties properties = new Properties();
    CountryCodesHelper ccHelper = new CountryCodesHelper();
    NameHelper nameHelper = new NameHelper();

    {
        try {
            properties.load(new FileInputStream("src/test/resources/local.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String baseUrl = properties.getProperty("baseUrl");




}
