package dbConnnectionPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConnectionImpl implements Connection {
    @Override
    public void createStatement() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " createStatement");
    }

    @Override
    public void commit() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }T
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " commit");

    }
}
