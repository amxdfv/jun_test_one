package com.gridnine.testing;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        FlightHandler FH = new FlightHandler();

        List<Flight> OgirListFlight = FlightBuilder.createFlights();

        FlightFilter FF = new FlightFilter(OgirListFlight);

       OgirListFlight = FH.FlightFilter(OgirListFlight,FF.EarlyDep(),FF.ArriveBeforeDep(),FF.TwoHoursSummary());

        FH.PrintFlightConsole(OgirListFlight);

    }

}
