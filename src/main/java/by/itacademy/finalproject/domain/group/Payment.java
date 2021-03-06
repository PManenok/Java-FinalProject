package by.itacademy.finalproject.domain.group;

import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;

import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private int amount;

    public Payment() {
    }

    public Payment(LocalDate date, int amount) throws FutureDateTimeException {
        if (date.isAfter(LocalDate.now()))
            throw new FutureDateTimeException("Date is in future!");
        this.date = date;
        this.amount = amount;
    }

    public Payment(Payment payment) {
        this.date = LocalDate.of(payment.date.getYear(), payment.date.getMonth(), payment.date.getDayOfMonth());
        this.amount = payment.amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setDate(LocalDate date) {
        if (date.isAfter(LocalDate.now()))
            throw new FutureDateTimeException("Date is in future!");
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    public String getDateAsString() {
        return DateTimeFormat.D_M_YYYY_DASH.getFormat().format(date);
    }

    @Override
    public String toString() {
        return DateTimeFormat.DD_MM_YYYY_DASH.getFormat().format(date) + " Paid: " + amount;
    }
}
