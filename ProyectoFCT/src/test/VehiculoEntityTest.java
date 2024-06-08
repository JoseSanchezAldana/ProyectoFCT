package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import modelo.VehiculoEntity;

public class VehiculoEntityTest {

    private VehiculoEntity vehiculo;

    @Before
    public void setUp() {
        vehiculo = new VehiculoEntity(1, "Toyota", "Corolla", "ABC-123", 2020);
    }

    @Test
    public void testGetIdVehiculos() {
        assertEquals(1, vehiculo.getIdVehiculos());
    }

    @Test
    public void testGetMarca() {
        assertEquals("Toyota", vehiculo.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Corolla", vehiculo.getModelo());
    }

    @Test
    public void testGetMatricula() {
        assertEquals("ABC-123", vehiculo.getMatricula());
    }

    @Test
    public void testGetAnoMatriculacion() {
        assertEquals(2020, vehiculo.getAnoMatriculacion());
    }
}

