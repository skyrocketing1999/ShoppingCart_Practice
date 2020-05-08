package ninja.skyrocketing.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderid;

    private Integer userid;

    private double total;

    private Integer paytype;

    private Integer status;

    private String shipname;

    private String shipcode;

    private Date createtime;

    private Date closetime;

    private Integer addressid;

    private String orderno;
    
    private User user;
    
    private UserAddress userAddress;
    
    private List<OrderGoodsDetail> orderGoodsDetail;
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public UserAddress getUserAddress() {
        return userAddress;
    }
    
    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
    
    public List<OrderGoodsDetail> getOrderGoodsDetails() {
        return orderGoodsDetail;
    }
    
    public void setOrderGoodsDetails(List<OrderGoodsDetail> orderGoodsDetails) {
        this.orderGoodsDetail = orderGoodsDetails;
    }
    
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getShipcode() {
        return shipcode;
    }

    public void setShipcode(String shipcode) {
        this.shipcode = shipcode == null ? null : shipcode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }
}