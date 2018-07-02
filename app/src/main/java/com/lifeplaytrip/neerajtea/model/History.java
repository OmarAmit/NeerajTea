package com.lifeplaytrip.neerajtea.model;

/**
 * Created by user on 1/9/2018.
 */

public class History {
    private String product_discription;
    private String product_name;
    private int product_id;
    private String product_status;
    private String product_image;
    private String product_price;
    private int payment_id;
    private String product_quantity, product_created, product_deliver, user_name, user_phone, user_address;

    public History(String product_discription, String product_name, int product_id, String product_image, String product_price, int payment_id, String product_status, String product_quantity, String product_created, String product_deliver, String user_name, String user_phone, String user_address) {
        this.product_discription = product_discription;
        this.product_name = product_name;
        this.product_id = product_id;
        this.product_image = product_image;
        this.product_price = product_price;
        this.payment_id = payment_id;
        this.product_status = product_status;
        this.product_quantity = product_quantity;
        this.product_created = product_created;
        this.product_deliver = product_deliver;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_address = user_address;
    }

    public String getProduct_discription() {
        return product_discription;
    }

    public void setProduct_discription(String product_discription) {
        this.product_discription = product_discription;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }



    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_created() {
        return product_created;
    }

    public void setProduct_created(String product_created) {
        this.product_created = product_created;
    }

    public String getProduct_deliver() {
        return product_deliver;
    }

    public void setProduct_deliver(String product_deliver) {
        this.product_deliver = product_deliver;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}