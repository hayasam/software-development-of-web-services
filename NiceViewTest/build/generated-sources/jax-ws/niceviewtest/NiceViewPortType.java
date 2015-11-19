
package niceviewtest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NiceViewPortType", targetNamespace = "http://NiceView.ws")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NiceViewPortType {


    /**
     * 
     * @param part1
     * @return
     *     returns niceviewtest.GetHotelsResponse
     */
    @WebMethod
    @WebResult(name = "getHotelsResponse", targetNamespace = "http://NiceView.ws", partName = "part1")
    public GetHotelsResponse getHotels(
        @WebParam(name = "getHotelsRequest", targetNamespace = "http://NiceView.ws", partName = "part1")
        GetHotelRequestType part1);

    /**
     * 
     * @param part1
     * @return
     *     returns boolean
     * @throws BookHotelFault
     */
    @WebMethod
    @WebResult(name = "bookHotelResponse", targetNamespace = "http://NiceView.ws", partName = "part1")
    public boolean bookHotel(
        @WebParam(name = "bookHotelRequest", targetNamespace = "http://NiceView.ws", partName = "part1")
        BookHotelRequest part1)
        throws BookHotelFault
    ;

    /**
     * 
     * @param part1
     * @return
     *     returns boolean
     * @throws CancelHotelFault
     */
    @WebMethod
    @WebResult(name = "cancelHotelResponse", targetNamespace = "http://NiceView.ws", partName = "part1")
    public boolean cancelHotel(
        @WebParam(name = "cancelHotelRequest", targetNamespace = "http://NiceView.ws", partName = "part1")
        CancelHotelRequest part1)
        throws CancelHotelFault
    ;

}