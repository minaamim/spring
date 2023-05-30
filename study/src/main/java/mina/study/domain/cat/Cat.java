package mina.study.domain.cat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mina.study.domain.owner.Owner;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    Owner owner;

    public Cat(String name) {
        this.name = name;
    }
}
