package org.xander.spring.springIdol.springMVC.service;

import org.xander.spring.springIdol.springMVC.domain.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courtName);
}
