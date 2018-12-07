/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callService;

/**
 *
 * @author Zockor
 */
public class ValidacionMedico {

    private boolean respuesta = false;

    public boolean validar(String rut) {
        for (int i = 0; i < listarMedico().size(); i++) {
            if (listarMedico().contains(rut)) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        }
        return respuesta;
    }

    private static java.util.List<java.lang.String> listarMedico() {
        com.empresa.safe.ws.MedicoWebService_Service service = new com.empresa.safe.ws.MedicoWebService_Service();
        com.empresa.safe.ws.MedicoWebService port = service.getMedicoWebServicePort();
        return port.listarMedico();
    }

}
