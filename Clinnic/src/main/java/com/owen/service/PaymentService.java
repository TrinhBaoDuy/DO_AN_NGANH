/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service;

import com.owen.pojo.Payment;
import com.paypal.base.rest.PayPalRESTException;
import java.util.List;

/**
 *
 * @author Trinh Bao Duy
 */
public interface PaymentService {

    List<Payment> getPayments();

    com.paypal.api.payments.Payment createPayment(
            Double total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException;

    public com.paypal.api.payments.Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

}
