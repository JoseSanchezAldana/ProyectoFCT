package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import modelo.MantenimientoEntity;

public class MantenimientoEntityTest {

    private MantenimientoEntity mantenimiento;

    @Before
    public void setUp() {
        mantenimiento = new MantenimientoEntity(1, 101, "Cambio de aceite", "2024-07-01");
    }

    @Test
    public void testGetIdMantenimiento() {
        assertEquals(1, mantenimiento.getIdMantenimiento());
    }

    @Test
    public void testSetIdMantenimiento() {
        mantenimiento.setIdMantenimiento(2);
        assertEquals(2, mantenimiento.getIdMantenimiento());
    }

    @Test
    public void testGetIdVehiculo() {
        assertEquals(101, mantenimiento.getIdVehiculo());
    }

    @Test
    public void testSetIdVehiculo() {
        mantenimiento.setIdVehiculo(102);
        assertEquals(102, mantenimiento.getIdVehiculo());
    }

    @Test
    public void testGetTipoMantenimiento() {
        assertEquals("Cambio de aceite", mantenimiento.getTipoMantenimiento());
    }

    @Test
    public void testSetTipoMantenimiento() {
        mantenimiento.setTipoMantenimiento("Revisión de frenos");
        assertEquals("Revisión de frenos", mantenimiento.getTipoMantenimiento());
    }

    @Test
    public void testGetFechaProgramada() {
        assertEquals("2024-07-01", mantenimiento.getFechaProgramada());
    }

    @Test
    public void testSetFechaProgramada() {
        mantenimiento.setFechaProgramada("2024-08-01");
        assertEquals("2024-08-01", mantenimiento.getFechaProgramada());
    }
}

