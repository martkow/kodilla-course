package com.kodilla.kodilla.good.patterns2.facade.api;

/**
 * The first class we will create is the OrderProcessingException class.
 * We will also define string constants in it,
 * which we will use to communicate the descriptions of possible exceptions:
 */
public class OrderProcessingException extends Exception {
    public static final String ERR_NOT_AUTHORISED = "User is not authorised";
    public static final String ERR_PAYMENT_REJECTED = "Payment was rejected";
    public static final String ERR_VERIFICATION_ERROR = "Verification error";
    public static final String ERR_SUBMITTING_ERROR = "Cannot submit order";

    public OrderProcessingException(String message) {
        super(message);
    }
}
