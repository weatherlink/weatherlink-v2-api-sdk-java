package com.weatherlink.api.v2.signature;

import com.weatherlink.api.v2.utils.Constants;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignatureCalculator {

  private static final String MAC_ALGORITHM = "HmacSHA256";

  public String calculateStationsSignature(
      String apiKey, String apiSecret, long apiRequestTimestamp) throws SignatureException {

    HashMap<String, String> parametersToHash = new HashMap<>();
    parametersToHash.put(Constants.Parameters.API_KEY, apiKey);
    parametersToHash.put(
        Constants.Parameters.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
    return calculateSignature(apiSecret, parametersToHash);
  }

  public String calculateStationsSignature(
      String apiKey, String apiSecret, long apiRequestTimestamp, String stationIds)
      throws SignatureException {

    HashMap<String, String> parametersToHash = new HashMap<>();
    parametersToHash.put(Constants.Parameters.API_KEY, apiKey);
    parametersToHash.put(
        Constants.Parameters.API_REQUEST_TIMESTAMP, String.valueOf(apiRequestTimestamp));
    parametersToHash.put(Constants.Parameters.STATION_IDS, stationIds);
    return calculateSignature(apiSecret, parametersToHash);
  }

  private String calculateSignature(String apiSecret, Map<String, String> parametersToHash)
      throws SignatureException {

    String stringToHash = "";
    if (parametersToHash != null) {
      stringToHash =
          parametersToHash.entrySet().stream()
              .sorted(Comparator.comparing(Map.Entry::getKey))
              .map(entry -> entry.getKey() + entry.getValue())
              .collect(Collectors.joining());
    }

    Mac mac = null;
    try {
      mac = Mac.getInstance(MAC_ALGORITHM);
    } catch (NoSuchAlgorithmException ex) {
      throw new SignatureException("MAC Algorithm " + MAC_ALGORITHM + " is not available");
    }
    SecretKeySpec secretKeySpec =
        new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), MAC_ALGORITHM);
    try {
      mac.init(secretKeySpec);
    } catch (InvalidKeyException ex) {
      throw new SignatureException("MAC Algorithm " + MAC_ALGORITHM + " secret key is invalid");
    }
    byte[] apiSignatureBytes = mac.doFinal(stringToHash.getBytes(StandardCharsets.UTF_8));
    String apiSignatureString = convertByteArrayToHexString(apiSignatureBytes).toLowerCase();

    return apiSignatureString;
  }

  private String convertByteArrayToHexString(byte[] array) {

    StringBuilder builder = new StringBuilder(array.length * 2);
    for (byte b : array) {
      builder.append(String.format("%02x", b));
    }
    return builder.toString();
  }
}
