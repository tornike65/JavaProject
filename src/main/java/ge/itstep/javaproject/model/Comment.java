package ge.itstep.javaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private  Integer Id;
    private  Integer product_id;
    private LocalDateTime create_date;
    private String comment_text;
}
