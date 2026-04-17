/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

/**
 * Clase que extiende a "Exception" y representa una excepción en las
 * operaciones de persistencia, tiene un código para los tres tipos de errores
 * que contemplamos y que hará que se muestre un mensaje de error u otro
 *
 * @author Araceli,Diego,Oscar
 */
public class PersistenceException extends Exception {

    private int code;
    private static int CONNECTION_ERROR = 0;
    private static int CANNOT_READ = 1;
    private static int CANNOT_WRITE = 2;

    /**
     * Obtiene el código del error producido
     *
     * @return El código en forma de int
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public static int getCONNECTION_ERROR() {
        return CONNECTION_ERROR;
    }

    /**
     *
     * @param CONNECTION_ERROR
     */
    public static void setCONNECTION_ERROR(int CONNECTION_ERROR) {
        PersistenceException.CONNECTION_ERROR = CONNECTION_ERROR;
    }

    /**
     *
     * @return
     */
    public static int getCANNOT_READ() {
        return CANNOT_READ;
    }

    /**
     *
     * @param CANNOT_READ
     */
    public static void setCANNOT_READ(int CANNOT_READ) {
        PersistenceException.CANNOT_READ = CANNOT_READ;
    }

    /**
     *
     * @return
     */
    public static int getCANNOT_WRITE() {
        return CANNOT_WRITE;
    }

    /**
     *
     * @param CANNOT_WRITE
     */
    public static void setCANNOT_WRITE(int CANNOT_WRITE) {
        PersistenceException.CANNOT_WRITE = CANNOT_WRITE;
    }

    /**
     *
     * @param code
     * @param message
     */
    public PersistenceException(int code, String message) {
        super(message);
        this.code = code;
    }

}
