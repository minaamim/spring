package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item){ //item은 JPA에 저장하기 전까지 id값이 없다. id 값이 없다 == 완전히 새로 생성하는 객체
        if(item.getId() == null){
            em.persist(item); //신규로 등록
        }else{ //이미 있다면 DB에 등록된 걸 가져온 것
            em.merge(item);
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
