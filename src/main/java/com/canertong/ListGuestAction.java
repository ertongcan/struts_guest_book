package com.canertong;

import java.util.List;
import java.util.Map;

import com.canertong.dao.GuestDAO;
import com.canertong.dao.GuestDAOImp;
import com.canertong.model.Guest;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public class ListGuestAction extends ActionSupport implements ModelDriven<Guest>, ServletContextAware {

    private List<Guest> guestList;

    @Override
    public String execute() {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        GuestDAO guestDAO = new GuestDAOImp(sf);
        guestList = guestDAO.list();

        return SUCCESS;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    @Override
    public Guest getModel() {
        return g;
    }
    private Guest g = new Guest();

    private ServletContext ctx;
    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }
}
