package com.xiwen.bookstore.bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:36
 * @Version: 1.0
 */
public class OrderItem {
    private String itemId;
    private String bookName;
    private String price;
    private String imgPath;
    private String itemCount;
    private String itemAmount;
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(String itemId, String bookName, String price, String imgPath, String itemCount, String itemAmount, String orderId) {
        this.itemId = itemId;
        this.bookName = bookName;
        this.price = price;
        this.imgPath = imgPath;
        this.itemCount = itemCount;
        this.itemAmount = itemAmount;
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId='" + itemId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price='" + price + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", itemCount='" + itemCount + '\'' +
                ", itemAmount='" + itemAmount + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
