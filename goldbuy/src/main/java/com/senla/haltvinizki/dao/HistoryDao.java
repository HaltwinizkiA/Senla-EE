package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.history.History;
import java.util.List;

public interface HistoryDao {
    History delete(History history);

    History create(History history);

    History update(History history);

    List<History> read();
}
