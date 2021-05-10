package com.canertong.dao;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.canertong.model.Guest;
import org.hibernate.query.Query;


public class GuestDAOImp implements GuestDAO {

    private SessionFactory sf;

    public GuestDAOImp(SessionFactory sf){
        this.sf = sf;
    }
    List<Guest> listGuest = new ArrayList<Guest>();

    @Override
    public List<Guest> list() {

        try {
            Session session = this.sf.openSession();
            Query<Guest> q = session.createQuery("Select d.aboutYou, d.country from Guest d", Guest.class);
            List<Guest> listGuest = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listGuest;
    }

}
