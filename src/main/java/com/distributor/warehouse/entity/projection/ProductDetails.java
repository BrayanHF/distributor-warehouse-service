package com.distributor.warehouse.entity.projection;

import com.distributor.warehouse.entity.Measurement;
import com.distributor.warehouse.entity.Status;

public record ProductDetails(long id, String name, String description, double price, Measurement measurement, double stock, Status status) {}