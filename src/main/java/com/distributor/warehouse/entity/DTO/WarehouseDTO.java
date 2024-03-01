package com.distributor.warehouse.entity.DTO;

import com.distributor.warehouse.entity.Status;

public record WarehouseDTO(long id, String name, String address, Status status) {}