package io.collective;

public class ExpirableEntry {
    public ExpirableEntry(String key, String value, long expirationTime) {
        this.key = key;
        this.value = value;
        this.expirationTime = expirationTime;
    }

    public ExpirableEntry() {

    }

    public static void main(String[] args) {
        ExpirableEntry storage = new ExpirableEntry();

        // Agregar entradas expirables
        storage.addEntry("clave1", "valor1", 5000); // Expira en 5 segundos
        storage.addEntry("clave2", "valor2", 10000); // Expira en 10 segundos

        // Mostrar las entradas antes de que expiren
        System.out.println("Entradas activas:");
        storage.printEntries();

        // Esperar un tiempo para que algunas entradas expiren
        try {
            Thread.sleep(7000); // Espera 7 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\nEntradas activas después de la expiración:");
        storage.printEntries();
    }

    private void printEntries() {
    }

    private void addEntry(String clave1, String valor1, int i) {

    }

    static class ExpirableEntr {
        private String key;
        private String value;
        private long expirationTime;

        public ExpirableEntr(String key, String value, long expirationTime) {
            this.key = key;
            this.value = value;
            this.expirationTime = System.currentTimeMillis() + expirationTime;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() >= expirationTime;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    static class ExpirableEntryStorage {
        private ExpirableEntry[] entries = new ExpirableEntry[10];
        private int size = 0;

        public void addEntry(String key, String value, long expirationTime) {
            if (size < entries.length) {
                entries[size++] = new ExpirableEntry(key, value, expirationTime);
            } else {
                System.out.println("No se pueden agregar más entradas, límite alcanzado.");
            }
        }

        public void printEntries() {
            for (ExpirableEntry entry : entries) {
                if (entry != null && !entry.isExpired()) {
                    System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
                }
            }
        }
    }

    private String getValue() {
        return ExpirableEntr.class.getName();
    }

    private String getKey() {

    }

    private boolean isExpired() {
    }
}