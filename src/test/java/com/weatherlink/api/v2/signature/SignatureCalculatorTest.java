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
            int[] stationIds,
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
                        new int[] { 1234, 6789 },
                        "68b3f48d5660926e09b093a6ddb0d98f07dc06215daacbb4e9566339625c6f7d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateNodesSignatureArgumentsProvider")
    void calculateNodesSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateNodesSignature(
                        apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateNodesSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateNodesSignatureWithNodeIdsArgumentsProvider")
    void calculateNodesSignatureWithNodeIds(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            int[] nodeIds,
            String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateNodesSignature(
                        apiKey, apiSecret, apiRequestTimestamp, nodeIds);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateNodesSignatureWithNodeIdsArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        new int[] { 1234, 6789 },
                        "62517e3e306a3f39734fbdb141918edc2f32afc32295035f755984c1cf8cdabf"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateSensorsSignatureArgumentsProvider")
    void calculateSensorsSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateSensorsSignature(
                        apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateSensorsSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateSensorsSignatureWithSensorIdsArgumentsProvider")
    void calculateSensorsSignatureWithSensorIds(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            int[] sensorIds,
            String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateSensorsSignature(
                        apiKey, apiSecret, apiRequestTimestamp, sensorIds);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateSensorsSignatureWithSensorIdsArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        new int[] { 1234, 6789 },
                        "4f66b360a2308e6022b9ed2ce603a4c048cf42a18b43461a42ac80e7b666d10d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateSensorActivitySignatureArgumentsProvider")
    void calculateSensorActivitySignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateSensorActivitySignature(
                        apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateSensorActivitySignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateSensorActivitySignatureWithSensorIdsArgumentsProvider")
    void calculateSensorActivitySignatureWithSensorIds(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            int[] sensorIds,
            String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateSensorActivitySignature(
                        apiKey, apiSecret, apiRequestTimestamp, sensorIds);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateSensorActivitySignatureWithSensorIdsArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        new int[] { 1234, 6789 },
                        "4f66b360a2308e6022b9ed2ce603a4c048cf42a18b43461a42ac80e7b666d10d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateSensorCatalogSignatureArgumentsProvider")
    void calculateSensorCatalogSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateSensorCatalogSignature(
                        apiKey, apiSecret, apiRequestTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateSensorCatalogSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        "6fc5636eeccc766216d14887530b2a4adb7896d289dd710a59db40eacf76069d"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateCurrentSignatureArgumentsProvider")
    void calculateCurrentSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, int stationId, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateCurrentSignature(
                        apiKey, apiSecret, apiRequestTimestamp, stationId);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateCurrentSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        1234,
                        "9a9d74b35761646ebf59856d18cf91c620ea263c67a910a39672d32edadda8c5"));
    }

    // **************************************************

    @ParameterizedTest
    @MethodSource("calculateHistoricSignatureArgumentsProvider")
    void calculateHistoricSignature(
            String apiKey, String apiSecret, long apiRequestTimestamp, int stationId, long startTimestamp, long endTimestamp, String expectedApiSignature)
            throws SignatureException {

        SignatureCalculator signatureCalculator = new SignatureCalculator();
        String apiSignature =
                signatureCalculator.calculateHistoricSignature(
                        apiKey, apiSecret, apiRequestTimestamp, stationId, startTimestamp, endTimestamp);

        Assertions.assertEquals(
                expectedApiSignature, apiSignature, "API signature does not match expected value");
    }

    private static Stream<Arguments> calculateHistoricSignatureArgumentsProvider() {

        return Stream.of(
                Arguments.of(
                        "3l4raa5xl6xcgfkh5r5tdgnvbbb0d0zp",
                        "ooxqc6n6cs4n74zyn6djgsz470bxsho1",
                        1633115254,
                        1234,
                        1633071600,
                        1633158000,
                        "ddfd79473fa8aa7ff918147c4016faa86c18c3a54a9c2bbb632e92bcb09335b1"));
    }
}
