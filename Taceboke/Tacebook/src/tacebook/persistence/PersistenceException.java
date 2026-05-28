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

    /**
     *Valor del error con la conexión con la base de datos
     */
    public static final int CONNECTION_ERROR = 0;

    /**
     *Valor del error con la lectura de algo
     */
    public static final int CANNOT_READ = 1;

    /**
     *Valor del error con la escritura de algo
     */
    public static final int CANNOT_WRITE = 2;

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
     * @return
     */
    public static int getCANNOT_READ() {
        return CANNOT_READ;
    }

    /**
     *
     * @return
     */
    public static int getCANNOT_WRITE() {
        return CANNOT_WRITE;
    }

    /**
     *Constructor de la clase que recibe el código del error que saltó y el mensaje que tiene que salir por pantalla
     * @param code
     * @param message
     */
    public PersistenceException(int code, String message) {
        super(message);
        this.code = code;
    }

}
