package ninja.skyrocketing.pojo;

import java.math.BigDecimal;

public class OrderGoodsDetail {
    private Integer id;

    private Integer itemid;

    private Integer orderid;

    private Double price;

    private Integer num;

    private Double total;
    
    private Goods goods;
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Goods getGoods() {
        return goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}