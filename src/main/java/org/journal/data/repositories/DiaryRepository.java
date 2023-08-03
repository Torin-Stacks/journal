package org.journal.data.repositories;

import org.journal.data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends MongoRepository<Diary,String> {
    Diary findByName(String diaryName);

    List<Diary> findByUsername(String username);

    Diary findByUsernameAndName(String username, String diaryName);
}

