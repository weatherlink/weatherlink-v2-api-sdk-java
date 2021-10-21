package com.weatherlink.api.v2.signature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SignatureCalculatorTest {

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateStationsSignatureArgumentsProvider")
    void calculateStationsSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateStationsSignature(
                        apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateStationsSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateStationsSignatureWithStationIdsArgumentsProvider")
    void calculateStationsSignatureWithStationIds(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            String stationIds,
            String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateStationsSignature(
                        apiKey, apiSecret, apiRequestTimestamp, stationIds);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateStationsSignatureWithStationIdsArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "1234,6789",
                        "68b3f48d5660926e09b093a6ddb0d98f07dc06215daacbb4e9566339625c6f7d"));
    }
}
