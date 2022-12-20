package model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "alat")
public class Alat extends PanacheEntity {

    private String namaAlat;

    private Long stock;

    private Double price;

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
