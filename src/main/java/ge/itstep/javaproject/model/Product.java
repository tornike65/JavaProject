package ge.itstep.javaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double price;
    private String img_url;
    private int category_id;

    public Product(String name, Double price, String img_url, int category_id) {
        this.name = name;
        this.price = price;
        this.img_url = img_url;
        this.category_id = category_id;
    }
}
