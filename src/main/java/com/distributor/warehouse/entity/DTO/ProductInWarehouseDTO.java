package com.distributor.warehouse.entity.DTO;

import com.distributor.warehouse.entity.Status;

public record ProductInWarehouseDTO(long id, String warehouseName, String productName, double stock, Status status) {}