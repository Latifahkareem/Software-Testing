package Assignment18.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor       // ينشئ الكونستركتور الفارغ
@AllArgsConstructor      // ينشئ الكونستركتور بكامل المعطيات
public class Pet {
    private long id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status; // available, pending, sold
}
