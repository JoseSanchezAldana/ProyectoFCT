package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import modelo.AsignacionesEntity;

public class AsignacionesEntityTest {

    private AsignacionesEntity asignacion;

    @Before
    public void setUp() {
        asignacion = new AsignacionesEntity(1, 101, 202, "2024-07-01");
    }

    @Test
    public void testGetIdAsignacion() {
        assertEquals(1, asignacion.getIdAsignacion());
    }

    @Test
    public void testSetIdAsignacion() {
        asignacion.setIdAsignacion(2);
        assertEquals(2, asignacion.getIdAsignacion());
    }

    @Test
    public void testGetIdVehiculo() {
        assertEquals(101, asignacion.getIdVehiculo());
    }

    @Test
    public void testSetIdVehiculo() {
        asignacion.setIdVehiculo(102);
        assertEquals(102, asignacion.getIdVehiculo());
    }

    @Test
    public void testGetIdConductor() {
        assertEquals(202, asignacion.getIdConductor());
    }

    @Test
    public void testSetIdConductor() {
        asignacion.setIdConductor(203);
        assertEquals(203, asignacion.getIdConductor());
    }

    @Test
    public void testGetFechaAsignacion() {
        assertEquals("2024-07-01", asignacion.getFechaAsignacion());
    }

    @Test
    public void testSetFechaAsignacion() {
        asignacion.setFechaAsignacion("2024-08-01");
        assertEquals("2024-08-01", asignacion.getFechaAsignacion());
    }
}
