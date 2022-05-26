package ru.sk.millionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sk.millionaire.model.Result;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    default List<Result> findTop10() {
        return findAll()
                .stream()
                .sorted(Comparator.comparingInt(Result::getWin).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
