package projects.parkingLot.models;

import projects.parkingLot.enums.PaymentMode;
import projects.parkingLot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double amount;
    private String txn_ref_num;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Bill bill;
    private LocalDateTime paymentTime;

    public Payment() {
    }

    public Payment(double amount, String txn_ref_num, PaymentStatus paymentStatus, PaymentMode paymentMode, Bill bill, LocalDateTime paymentTime) {
        this.amount = amount;
        this.txn_ref_num = txn_ref_num;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;
        this.bill = bill;
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public String getTxn_ref_num() {
        return txn_ref_num;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public Bill getBill() {
        return bill;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTxn_ref_num(String txn_ref_num) {
        this.txn_ref_num = txn_ref_num;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
