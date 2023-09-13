package org.example.task_5.service;

import org.example.task_5.model.Supplier;
import java.util.List;

public interface SupplierService {
    List<Supplier> findSuppliersThatSupplyCondiments();

    Supplier addNewSupplier();

    Supplier add(Supplier supplier);

    void addAll(List<Supplier> suppliers);

    Supplier get(Long id);
}
