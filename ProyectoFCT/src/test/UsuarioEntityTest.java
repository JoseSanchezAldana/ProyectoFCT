package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import modelo.UsuarioEntity;

public class UsuarioEntityTest {

    private UsuarioEntity usuario;

    @Before
    public void setUp() {
        usuario = new UsuarioEntity(1, "Juan Perez", "juan.perez@example.com", "password123", "admin");
    }

    @Test
    public void testGetIdUsuario() {
        assertEquals(1, usuario.getIdUsuario());
    }

    @Test
    public void testSetIdUsuario() {
        usuario.setIdUsuario(2);
        assertEquals(2, usuario.getIdUsuario());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Juan Perez", usuario.getNombre());
    }

    @Test
    public void testSetNombre() {
        usuario.setNombre("Carlos Lopez");
        assertEquals("Carlos Lopez", usuario.getNombre());
    }

    @Test
    public void testGetEmail() {
        assertEquals("juan.perez@example.com", usuario.getEmail());
    }

    @Test
    public void testSetEmail() {
        usuario.setEmail("carlos.lopez@example.com");
        assertEquals("carlos.lopez@example.com", usuario.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", usuario.getPassword());
    }

    @Test
    public void testSetPassword() {
        usuario.setPassword("newpassword456");
        assertEquals("newpassword456", usuario.getPassword());
    }

    @Test
    public void testGetRol() {
        assertEquals("admin", usuario.getRol());
    }

    @Test
    public void testSetRol() {
        usuario.setRol("user");
        assertEquals("user", usuario.getRol());
    }
}
