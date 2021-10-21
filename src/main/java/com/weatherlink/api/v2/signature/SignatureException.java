package com.weatherlink.api.v2.signature;

/** Thrown when there is a problem computing an API Signature */
public class SignatureException extends Exception {

  /**
   * Create an instance
   *
   * @param message exception message
   */
  public SignatureException(String message) {

    super(message);
  }
}
