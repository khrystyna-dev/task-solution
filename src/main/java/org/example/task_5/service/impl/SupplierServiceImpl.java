package org.example.task_5.service.impl;

import org.example.task_5.dao.SupplierDao;
import org.example.task_5.model.Supplier;
import org.example.task_5.service.SupplierService;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;

    public SupplierServiceImpl(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public List<Supplier> findSuppliersThatSupplyCondiments() {
        return supplierDao.findSuppliersThatSupplyCondiments();
    }

    @Override
    public Supplier addNewSupplier() {
        return supplierDao.addNewSupplier();
    }

    @Override
    public Supplier add(Supplier supplier) {
        return supplierDao.add(supplier);
    }

    @Override
    public void addAll(List<Supplier> suppliers) {
        supplierDao.addAll(suppliers);
    }

    @Override
    public Supplier get(Long id) {
        return supplierDao.get(id).orElseThrow(() ->
                new RuntimeException("Couldn't get supplier by id " + id));
    }
}
