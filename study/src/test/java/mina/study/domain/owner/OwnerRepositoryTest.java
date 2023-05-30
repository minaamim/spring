package mina.study.domain.owner;

import mina.study.domain.cat.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OwnerRepositoryTest {

    @Autowired
    OwnerRepository ownerRepository;


    @BeforeEach
    public void setUp(){
        List<Owner> owners = new ArrayList<>();
        for(int i=0;i<10;i++){
            Owner owner = new Owner("집사"+i);
            owner.addCat(new Cat("고양이"+i));
            owners.add(owner);
            System.out.println(owner.getName()+"의 고양이 개수 : "+owner.getCats().size());
        }
        ownerRepository.saveAll(owners);

//        Owner owner = new Owner("1");
//        for(int i = 0; i < 10; i++) {
//            owner.addCat(new Cat("cat" + i));
//        }
//        ownerRepository.save(owner);
    }

    @Test
    @Transactional
    void getOwner() {
        long startTime = System.currentTimeMillis();

        System.out.println("=====start============================================");

//        Owner findOwner = ownerRepository.findById(1L).orElseThrow(RuntimeException::new);
        Owner temp = ownerRepository.findByName("집사0").orElseThrow(RuntimeException::new);

        System.out.println("=====end==============================================");
        System.out.println("ownerName: " + temp.getName());
        System.out.println("catSize: " + temp.getCats().size() + " !!!!!!!!!!!!!");

        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime + "ms");
    }

    @Test
    @Transactional
    void getCats() {

        long startTime = System.currentTimeMillis();

        System.out.println("==========start==================================");

        List<Owner> owners = ownerRepository.findAll();

        System.out.println("==========end==================================");


            for(Owner o : owners) {
                System.out.println("주인 이름: " + o.getName());
                System.out.println("고양이 수: " + o.getCats().size());
                List<Cat> catList = o.getCats();
                System.out.println("고양이 꺼내기");

                for(Cat cat : catList)
                    System.out.println("고양이 이름: " + cat.getName());
            }


        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime + "ms");
    }

}