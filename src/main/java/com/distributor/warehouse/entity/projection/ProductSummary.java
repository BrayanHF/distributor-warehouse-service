package com.distributor.warehouse.entity.projection;

import com.distributor.warehouse.entity.Status;

public record ProductSummary(long id, String name, double price, String imagePath, Status status) {}