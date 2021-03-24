package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter {   // все фильтры

    FlightFilter(List<Flight> flts) {
        Flights = flts;
    }

    private List<Flight> Flights;

    List<Flight> TwoHoursSummary(){                                        // общее время, проведённое на земле превышает два часа
        List<Flight> LstFltOut = new ArrayList<Flight>();
        for (Flight FLT: Flights
        ) {
            List<Segment> FltSeg = FLT.getSegments();
            int l = FltSeg.toArray().length;
            long stay = 0;
            for (int i =0; i < l-1; i++) {
                stay = stay + ChronoUnit.HOURS.between( FltSeg.get(i).getArrivalDate(), FltSeg.get(i+1).getDepartureDate());
            }
            if (stay <= 2) {
                LstFltOut.add(FLT);
            }
        }

        Flights =  LstFltOut;
        return Flights;
    }

    List<Flight> ArriveBeforeDep() {    // имеются сегменты с датой прилёта раньше даты вылета
        List<Flight> LstFltOut = new ArrayList<Flight>();

        for (Flight FLT: Flights
        ) {
            int FailFlag = 0;
           List<Segment> FltSeg = FLT.getSegments();
           for (Segment Seg: FltSeg) {
             if ( Seg.getArrivalDate().isBefore(Seg.getDepartureDate()) ){
                 FailFlag = 1;
             }
           }
           if (FailFlag == 0) {
               LstFltOut.add(FLT);
           }
        }

        Flights =  LstFltOut;
        return Flights;
    }






    List<Flight> EarlyDep() {   // вылет до текущего момента времени
        LocalDateTime Now = LocalDateTime.now();
        List<Flight> LstFltOut = new ArrayList<Flight>();

        for (Flight FLT: Flights
        ) {
            if ( Now.isBefore(FLT.getSegments().get(0).getDepartureDate()) ) {   // проверяется только начальный сегмент т.к. предполагаем, что в исходных данных не совсем мусор
                LstFltOut.add(FLT);
            }
        }

        Flights =  LstFltOut;
        return Flights;
    }




    List<Flight> getSegments() {
        return Flights;
    }


}
