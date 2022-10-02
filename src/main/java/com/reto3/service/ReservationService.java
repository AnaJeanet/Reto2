package com.reto3.service;

import com.reto3.entities.Reservation;
import com.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else{
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(r.getIdReservation());
            if(q.isPresent()){
                if(r.getStartDate()!=null){
                    q.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getClient()!=null){
                    q.get().setClient(r.getClient());
                }
                if(r.getMotorbike()!=null){
                    q.get().setMotorbike(r.getMotorbike());
                }
           
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>r= reservationRepository.getReservation(id);
        if(r.isPresent()){
            reservationRepository.delete(r.get());
            flag=true;
        }
        return flag;

    }


}
