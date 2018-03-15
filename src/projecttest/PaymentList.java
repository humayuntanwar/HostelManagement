/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

/**
 *
 * @author Humayun
 */
public class PaymentList extends RecordList {

    public PaymentList(int sizeIn) {
        super(sizeIn);
    }

    public Payment getPayment(int monthIn) {
        if (monthIn < 1 || monthIn > getTotal()) {
            return null;
        } else {
            return (Payment) getItem(monthIn);
        }
    }

    public double calculateTotalPaid() {
        double totalPaid = 0;
        for (int i = 1; i <= getTotal(); i++) {
            totalPaid += getPayment(i).getAmount();
        }
        return totalPaid;
    }

}
