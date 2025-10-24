package Assignment18.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor       // إنشاء الكونستركتور الفارغ
@AllArgsConstructor      // إنشاء الكونستركتور بكامل المعطيات
public class Tag {
    private Integer id;
    private String name;
}
