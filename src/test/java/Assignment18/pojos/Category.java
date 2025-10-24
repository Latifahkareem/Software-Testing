package Assignment18.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor       // لإنشاء الكونستركتور الفارغ
@AllArgsConstructor      // لإنشاء الكونستركتور بكامل المعطيات
public class Category {
    private long id;
    private String name;
}
