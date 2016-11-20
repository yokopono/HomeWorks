package yoko.repository;

import yoko.model.Score;

import java.util.List;

/**
 * Created by Yoko on 20.11.2016.
 */
public interface ScoreRepository {
    List<Score> findAll();

    Score find(Long id);

    boolean add(Score score);

    boolean remove(Long id);
}
