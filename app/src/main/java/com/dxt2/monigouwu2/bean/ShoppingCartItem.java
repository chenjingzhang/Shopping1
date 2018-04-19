package com.dxt2.monigouwu2.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
//标签里面的属性name的值就是以后生成的数据库的表的名字
@Table(name = "shoppingCart")
public class ShoppingCartItem implements Serializable{
    //bean里面的属性需要加上@Column标签，这样这个标签的name属性的值会对应数据库里面的表的字段。
    //实体bean中必须有一个主键，如果没有主键，表以后不会创建成功
    //isId这个属性代表的是该属性是不是表的主键
    @Column(name = "_id", isId = true)
    int id;
    @Column(name = "description")
    String description;
    @Column(name = "price")
    String price;
    @Column(name = "imgUrl")
    String imgUrl;
    @Column(name = "num")
    int num;
    @Column(name = "sourceId")
    private String sourceId;

    public ShoppingCartItem(String description, String price, String imgUrl, int num, String sourceId) {
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.num = num;
        this.sourceId = sourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", num=" + num +
                ", sourceId='" + sourceId + '\'' +
                '}';
    }
}
