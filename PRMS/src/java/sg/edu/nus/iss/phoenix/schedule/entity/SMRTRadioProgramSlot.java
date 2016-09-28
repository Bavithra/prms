/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.entity;

import java.time.LocalDateTime;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Samrat
 */
public class SMRTRadioProgramSlot {
    
    /*****************************/
    // Instance Variables
    /*****************************/
    private int id;
    private RadioProgram radioProgram;
    private LocalDateTime startDateTime;
    private User presenter;
    private User producer;
    /*****************************/
    // Constructor
    /*****************************/
    public SMRTRadioProgramSlot() {
        
    }

    /*****************************/
    // Public Methods
    /*****************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RadioProgram getRadioProgram() {
        return radioProgram;
    }

    public void setRadioProgram(RadioProgram radioProgram) {
        this.radioProgram = radioProgram;
    }

    public LocalDateTime getStartDate() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public User getPresenter() {
        return presenter;
    }

    public void setPresenter(User presenter) {
        this.presenter = presenter;
    }

    public User getProducer() {
        return producer;
    }

    public void setProducer(User producer) {
        this.producer = producer;
    }
    
    /*****************************/
    // Private Methods
    /*****************************/
}
