/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Samrat
 */
public class ProgramSlot {
    
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
    public ProgramSlot() {
        
    }

    /*****************************/
    // Getters & Setters
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

    public LocalDateTime getStartDateTime() {
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
    // Public Methods
    /*****************************/
    
    /**
     * Method to get the formatted start date from the startDateTime that is set.
     * @return Formatted start date in "dd-MM-yyyy" format.
     */
    public String getFormattedStartDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return startDateTime.format(formatter);
    }
    
    /**
     * Method to get formatted start time from the startDateTime that is set.
     * @return Formatted start time in "HH:mm" format.
     */
    public String getFormattedStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return startDateTime.format(formatter);
    }
    
    /**
     * Method to get the formatted end time from the startDateTime & duration of the program.
     * @return Formatted end time in "HH:mm" format.
     */
    public String getFormattedEndTime() {
        // Add the duration of Radio Program to the `startDateTime`
        LocalDateTime endDateTime = startDateTime.plusHours(radioProgram.getTypicalDuration().getHours());
        endDateTime = startDateTime.plusMinutes(radioProgram.getTypicalDuration().getMinutes());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return endDateTime.format(formatter);
    }
    /*****************************/
    // Private Methods
    /*****************************/
}
