
package com.empresa.safe.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.empresa.safe.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarMedico_QNAME = new QName("http://ws.safe.empresa.com/", "listarMedico");
    private final static QName _ListarMedicoResponse_QNAME = new QName("http://ws.safe.empresa.com/", "listarMedicoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.empresa.safe.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarMedico }
     * 
     */
    public ListarMedico createListarMedico() {
        return new ListarMedico();
    }

    /**
     * Create an instance of {@link ListarMedicoResponse }
     * 
     */
    public ListarMedicoResponse createListarMedicoResponse() {
        return new ListarMedicoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMedico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.safe.empresa.com/", name = "listarMedico")
    public JAXBElement<ListarMedico> createListarMedico(ListarMedico value) {
        return new JAXBElement<ListarMedico>(_ListarMedico_QNAME, ListarMedico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMedicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.safe.empresa.com/", name = "listarMedicoResponse")
    public JAXBElement<ListarMedicoResponse> createListarMedicoResponse(ListarMedicoResponse value) {
        return new JAXBElement<ListarMedicoResponse>(_ListarMedicoResponse_QNAME, ListarMedicoResponse.class, null, value);
    }

}
