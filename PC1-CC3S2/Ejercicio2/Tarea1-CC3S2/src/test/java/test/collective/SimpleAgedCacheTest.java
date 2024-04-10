package test.collective;

import io.collective.SimpleAgedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleAgedCacheTest {
    SimpleAgedCache empty = new SimpleAgedCache();//sirve para probar el método isEmpty
    SimpleAgedCache nonempty = new SimpleAgedCache();//aqui se va a probar el método size

    @BeforeEach //se ejecuta antes de cada prueba
    public void before() { //se inicializa el cache vacío
        nonempty.put("aKey", "aValue", 2000);  //tiene como parametros "akey" que es la clave y "avalue" que es el valor
        nonempty.put("anotherKey", "anotherValue", 4000);
        //vemos que se añaden dos elementos
    }

    @Test //parte del testeo
    public void isEmpty() { // se prueba el metodo isEmpty
        assertTrue(empty.isEmpty());//se comprueba que el cache empty es vacío
        assertFalse(nonempty.isEmpty());//se comprueba que el cache nonempty no es vacío
    }

    @Test //parte del testeo
    public void size() { //se prueba el método size
        assertEquals(0, empty.size());//se comprueba que el cache empty tiene 0 elementos
        assertEquals(2, nonempty.size());//se comprueba que el cache nonempty tiene 2 elementos
    }

    @Test //parte del testeo
    public void get() { //se prueba el método get
        assertNull(empty.get("aKey")); //se comprueba que el cache empty no tiene la clave aKey
        assertEquals("aValue", nonempty.get("aKey"));//se comprueba que el cache nonempty tiene la clave aKey
        assertEquals("anotherValue", nonempty.get("anotherKey"));//se comprueba que el cache nonempty tiene la clave anotherKey
    }

    @Test //parte del testeo
    public void getExpired() { //se prueba el método getExpired
        TestClock clock = new TestClock(); //se crea el reloj para el cache expired

        SimpleAgedCache expired = new SimpleAgedCache(); //se crea el cache expired
        expired.put("aKey", "aValue", 2000); //tiempo de expiracion 2000ms
        expired.put("anotherKey", "anotherValue", 4000);//tiempo de expiracion 4000ms

        clock.offset(Duration.ofMillis(3000));

        assertEquals(1, expired.size());//se comprueba que el cache expired tiene 1 elemento porque el tiempo de expiración es de 3000ms y
        //el elemento aKey expiro en 2000ms
        assertEquals("anotherValue", expired.get("anotherKey"));//se comprueba que el cache expired vigente tiene la clave anotherKey
    }

    static class TestClock extends Clock {
        Duration offset = Duration.ZERO; //creacion del objeto offset de la clase duration

        @Override //método para el reloj
        public ZoneId getZone() {
            return Clock.systemDefaultZone().getZone();
        } //metodo para obtener el la hora del sistema

        @Override
        public Clock withZone(ZoneId zone) {
            return Clock.offset(Clock.system(zone), offset);
        } // metodo para obtener el reloj

        @Override
        public Instant instant() {
            return Clock.offset(Clock.systemDefaultZone(), offset).instant();
        } //metodo para obtener el instante del reloj

        public void offset(Duration offset) {
            this.offset = offset;
        } //metodo para cambiar el offset
    }
}
