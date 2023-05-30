package mina.study.domain.owner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mina.study.domain.cat.Cat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cat> cats = new ArrayList<>();

    public Owner(String name) {
        this.name = name;
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

}
