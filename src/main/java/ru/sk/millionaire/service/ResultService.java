package ru.sk.millionaire.service;

import ru.sk.millionaire.model.Result;

import java.util.List;

public interface ResultService {

    List<Result> findTop10();
}
