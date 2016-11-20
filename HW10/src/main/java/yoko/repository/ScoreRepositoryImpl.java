package yoko.repository;

import org.springframework.stereotype.Repository;
import yoko.model.Score;
import yoko.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Yoko on 20.11.2016.
 */
@Repository
public class ScoreRepositoryImpl implements ScoreRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Score> findAll() {
        TypedQuery<Score> query = em.createQuery("select score from Score score", Score.class);
        return query.getResultList();
    }

    @Override
    public Score find(Long id) {
       Score score = em.find(Score.class, id);
        return score;
    }

    @Override
    public boolean add(Score score) {
        em.persist(score);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        em.remove(em.find(Score.class, id));
        return true;
    }
}
