package cc.anjun.girl.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Data
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    @Min(value = 18, message = "未成年不能入内")
    private Integer age;
    private String cupSize;
}
