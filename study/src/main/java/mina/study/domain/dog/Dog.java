package mina.study.domain.dog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mina.study.domain.owner.Owner;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private Long id;

    String name;

}
