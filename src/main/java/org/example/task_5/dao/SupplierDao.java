package org.example.task_5.dao;

import org.example.task_5.model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierDao {

    List<Supplier> findSuppliersThatSupplyCondiments();

    Supplier addNewSupplier();

    Supplier add(Supplier supplier);

    void addAll(List<Supplier> suppliers);

    Optional<Supplier> get(Long id);
}
