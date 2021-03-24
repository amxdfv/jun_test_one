package com.gridnine.testing;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {


    @org.junit.jupiter.api.Test
    void twoHoursSummary() throws Exception {
        List<Flight> OgirListFlight = FlightBuilder.createFlights();
        FlightFilter FF = new FlightFilter(OgirListFlight);
        OgirListFlight = FF.TwoHoursSummary();
        if (OgirListFlight.toArray().length != 4) {
            throw new Exception();
        }
    }

    @org.junit.jupiter.api.Test
    void arriveBeforeDep() throws Exception {
        List<Flight> OgirListFlight = FlightBuilder.createFlights();
        FlightFilter FF = new FlightFilter(OgirListFlight);
        OgirListFlight = FF.ArriveBeforeDep();
        if (OgirListFlight.toArray().length != 5) {
            throw new Exception();
        }

    }

    @org.junit.jupiter.api.Test
    void earlyDep() throws Exception {
        List<Flight> OgirListFlight = FlightBuilder.createFlights();
        FlightFilter FF = new FlightFilter(OgirListFlight);
        OgirListFlight = FF.EarlyDep();
        if (OgirListFlight.toArray().length != 5) {
            throw new Exception();
        }
    }
}