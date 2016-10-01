/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultExceptions;

/**
 *
 * @author Samrat
 */
public class ProgramSlotExistsException extends Exception {
    
    public ProgramSlotExistsException(String message) {
        super(message);
    }
}
