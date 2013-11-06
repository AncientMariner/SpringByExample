package org.xander.spring.springIdol.springMVC.service;

import org.xander.spring.springIdol.springMVC.domain.Reservation;
import org.xander.spring.springIdol.springMVC.domain.SportType;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courtName);
    public void make(Reservation reservation) throws ReservationNotAvailableException;
    public List<SportType> getAllSportTypes();
    public SportType getSportType(int sportTypeId);
}
