package org.xander.spring.springIdol.springMVC.service;

import org.xander.spring.springIdol.springMVC.domain.PeriodicReservation;
import org.xander.spring.springIdol.springMVC.domain.Player;
import org.xander.spring.springIdol.springMVC.domain.Reservation;
import org.xander.spring.springIdol.springMVC.domain.SportType;

import java.util.*;

public class ReservationServiceImpl implements ReservationService {
    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");
    private List<Reservation> reservations;

    public ReservationServiceImpl() {
        reservations = new ArrayList<>();
        reservations.add(new Reservation("Tennis #1",
                         new GregorianCalendar(2008, 0, 14).getTime(),
                         16,
                         new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2",
                         new GregorianCalendar(2008, 0, 14).getTime(),
                         20,
                         new Player("James", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        List<Reservation> result = new ArrayList<Reservation>();
        for (Reservation reservation : reservations) {
            if (reservation.getCourtName().equals(courtName)) {
                result.add(reservation);
            }
        }
        return result;
    }

    @Override
    public void make(Reservation reservation) throws ReservationNotAvailableException {
        for (Reservation made : reservations) {
            if (made.getCourtName().equals(reservation.getCourtName())
                    && made.getDate().equals(reservation.getDate())
                    && made.getHour() == reservation.getHour()) {
                throw new ReservationNotAvailableException(reservation.getCourtName(), reservation.getDate(), reservation.getHour());
            }
        }
        reservations.add(reservation);
    }
    public List<SportType> getAllSportTypes() {
        return Arrays.asList(new SportType[]{TENNIS, SOCCER});
    }

    public SportType getSportType(int sportTypeId) {
        switch (sportTypeId) {
            case 1:
                return TENNIS;
            case 2:
                return SOCCER;
            default:
                return null;
        }
    }

    @Override
    public void makePeriodic(PeriodicReservation periodicReservation) throws ReservationNotAvailableException {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(periodicReservation.getFromDate());
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(periodicReservation.getToDate());

        while (fromCalendar.before(toCalendar)) {
            Reservation reservation = new Reservation();
            reservation.setCourtName(periodicReservation.getCourtName());
            reservation.setDate(fromCalendar.getTime());
            reservation.setHour(periodicReservation.getHour());
            reservation.setPlayer(periodicReservation.getPlayer());
            make(reservation);
            fromCalendar.add(Calendar.DATE, periodicReservation.getPeriod());
        }

    }
}
