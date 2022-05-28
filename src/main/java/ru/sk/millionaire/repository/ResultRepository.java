package ru.sk.millionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sk.millionaire.model.Result;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

}
