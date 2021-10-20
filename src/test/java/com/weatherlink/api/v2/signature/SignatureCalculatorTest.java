package com.weatherlink.api.v2.signature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignatureCalculatorTest {

    @Test
    void calculateStationsSignature() throws SignatureException {

        /*
        for this test we will use the following fictitious API credentials
        and pretend the API request is being made at
        2021-10-01 12:07:34 America/Los_Angeles which translates to a
        Unix timestamp of 1633115254
         */
        String apiKey = "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp";
        String apiSecret = "ooxqc6n6cs4n74zyn6djgsz470bxsho1";
        long apiRequestTimestamp = 1633115254;

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature = signatureCalculator.calculateStationsSignature(apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals("6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069da", "API signature does not match expected value");
    }
}
