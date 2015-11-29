package rest.ws.test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import niceviewschema.HotelType;

public class ItineraryResourceTest {

    private static final Client client = ClientBuilder.newClient();
    private static final WebTarget r = client.target("http://localhost:8080/tg/api/itineraries");

    @Test
    public void testCreateItinerary() {
        Itinerary i = new Itinerary();
        Itinerary result = r.request().post(Entity.entity(i, MediaType.APPLICATION_XML),
                Itinerary.class);
        assertTrue(result.getId() > 0);
    }

    @Test
    public void testGetItinerary() {
        Itinerary result = r.path("1").request().get(Itinerary.class);
        assertEquals(result.getFlights().size(), 0);
    }

    @Test
    public void testAddHotel() {
        HotelType hotel = new HotelType();
        hotel.setName("Palacio");
        HotelType response = r.path("1/hotels")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .post(Entity.entity(hotel, MediaType.APPLICATION_XML),
                        hotel.getClass());
        assertEquals(hotel.getName(), response.getName());

    }

    @Test
    public void testGetHotel() {
        HotelType hotel = new HotelType();
        hotel.setName("Palacio");

        r.path("1/hotels")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .post(Entity.entity(hotel, MediaType.APPLICATION_XML),
                        HotelType.class);

        HotelType response = r.path("1/hotels/Palacio")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .get(HotelType.class);
        assertEquals("Palacio", response.getName());
    }

    @Test
    public void testChangeState() {
        String state = "book";
        String response = r.path("1/state")
                .request()
                .put(Entity.entity(state, MediaType.TEXT_PLAIN), String.class);
        assertEquals(state, response);
    }

}