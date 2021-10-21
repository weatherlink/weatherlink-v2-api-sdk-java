package com.weatherlink.api.v2.signature;

import com.weatherlink.api.v2.utils.ParameterNames;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API Signature calculator utility
 */
public class SignatureCalculator {

    private static final String MAC_ALGORITHM = "HmacSHA256";

    /**
     * Default constructor
     */
    public SignatureCalculator() {

    }

    /**
     * Compute the API Signature for an API call to <code>/stations</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateStationsSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/stations/{station-ids}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param stationIds          comma delimited list of up to 100 station ID numbers
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateStationsSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            String stationIds) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.STATION_IDS, stationIds);
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/nodes</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateNodesSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/nodes/{node-ids}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param nodeIds             comma delimited list of up to 100 node ID numbers
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateNodesSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            String nodeIds) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.NODE_IDS, nodeIds);
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/sensors</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateSensorsSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/sensors/{sensor-ids}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param sensorIds           comma delimited list of up to 100 sensor ID numbers
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateSensorsSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            String sensorIds) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.SENSOR_IDS, sensorIds);
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/sensor-activity</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateSensorActivitySignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/sensor-activity/{sensor-ids}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param sensorIds           comma delimited list of up to 100 sensor ID numbers
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateSensorActivitySignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            String sensorIds) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.SENSOR_IDS, sensorIds);
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/sensor-catalog</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateSensorCatalogSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/current/{station-id}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param stationId           the station ID
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateCurrentSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            int stationId) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.STATION_ID, String.valueOf(stationId));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * Compute the API Signature for an API call to <code>/historic/{station-id}</code> given the specific parameters
     *
     * @param apiKey              the API Key
     * @param apiSecret           the API Secret
     * @param apiRequestTimestamp the Unix timestamp for when the API request is being made
     * @param stationId           the station ID
     * @param startTimestamp      the Unix timestamp marking the beginning of the time window for the data requested
     * @param endTimestamp        the Unix timestamp marking the end of the time window for the data requested
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    public String calculateHistoricSignature(
            String apiKey,
            String apiSecret,
            long apiRequestTimestamp,
            int stationId,
            long startTimestamp,
            long endTimestamp) throws SignatureException {

        HashMap<String, String> parametersToHash = new HashMap<>();
        parametersToHash.put(ParameterNames.API_KEY, apiKey);
        parametersToHash.put(ParameterNames.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
        parametersToHash.put(ParameterNames.STATION_ID, String.valueOf(stationId));
        parametersToHash.put(ParameterNames.START_TIMESTAMP, String.valueOf(startTimestamp));
        parametersToHash.put(ParameterNames.END_TIMESTAMP, String.valueOf(endTimestamp));
        return calculateSignature(apiSecret, parametersToHash);
    }

    /**
     * General API Signature calculation method
     *
     * @param apiSecret        the API Secret
     * @param parametersToHash map of all other parameters
     * @return the API Signature
     * @throws SignatureException if there is a problem utilizing the HmacSHA256 algorithm
     */
    private String calculateSignature(
            String apiSecret,
            Map<String, String> parametersToHash) throws SignatureException {

        String stringToHash = "";
        if (parametersToHash != null) {
            stringToHash = parametersToHash.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(entry -> entry.getKey() + entry.getValue()).collect(Collectors.joining());
        }

        Mac mac = null;
        try {
            mac = Mac.getInstance(MAC_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            throw new SignatureException("MAC Algorithm " + MAC_ALGORITHM + " is not available");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), MAC_ALGORITHM);
        try {
            mac.init(secretKeySpec);
        } catch (InvalidKeyException ex) {
            throw new SignatureException("MAC Algorithm " + MAC_ALGORITHM + " secret key is invalid");
        }
        byte[] apiSignatureBytes = mac.doFinal(stringToHash.getBytes(StandardCharsets.UTF_8));
        String apiSignatureString = convertByteArrayToHexString(apiSignatureBytes).toLowerCase();

        return apiSignatureString;
    }

    /**
     * Convert the given byte array to a hex encoded string
     *
     * @param array byte array to encode as a hex string
     * @return hex encoded string representation of the given byte array
     */
    private String convertByteArrayToHexString(byte[] array) {

        StringBuilder builder = new StringBuilder(array.length * 2);
        for (byte b : array) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
