package automobile.demo.entity;

import java.util.Date;

public class salesReport {

    private Long saleId;
    private String customerName;
    private String customerEmail;
    private Date saleDate;
    private String carModel;
    private double saleAmount;

    // Constructors
    public salesReport() {}

    public salesReport(Long saleId, String customerName, String customerEmail, String carModel, double saleAmount, Date saleDate) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.carModel = carModel;
        this.saleAmount = saleAmount;
        this.saleDate = saleDate;
    }

    // Getters and Setters
    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
}
