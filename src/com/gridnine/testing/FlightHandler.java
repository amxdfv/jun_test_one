package com.gridnine.testing;

import java.util.List;

public class FlightHandler {     //  все операции со списком перелетов


    public void PrintFlightConsole(List<Flight> LstFlt) {    // выводим в консоль список полетов

        for (Flight Flt: LstFlt
        ) {
            List<Segment> LstSeg = Flt.getSegments();
            String ConsoleLine = "";
            for (Segment Seg : LstSeg) {
                ConsoleLine = ConsoleLine + "[" + Seg.getDepartureDate().toString() + "|" + Seg.getArrivalDate().toString() + "] ";    // формат вывода как в debug-режиме
            }
            System.out.println(ConsoleLine);
        }


    }


    public List<Flight> FlightFilter(List<Flight> LstFltOrig,List<Flight>... LstFilter) {             // применение списка фильтров

        for (List<Flight> LstFil: LstFilter
             ) {
            LstFltOrig = LstFil;
        }
        return LstFltOrig;
    }





}
