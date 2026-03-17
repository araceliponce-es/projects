/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class PersistenceException extends Exception{
    private int code;
    private static int CONNECTION_ERROR=0;  
    private static int CANNOT_READ=1;
    private static int CANNOT_WRITE=2;

    public PersistenceException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    
    
    

    
    
    
}
