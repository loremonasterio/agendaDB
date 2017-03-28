package com.telefonica.agenda.db;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by telefonica on 22/03/2017.
 */

public class General {

    public static boolean menu (Activity c, int id) {
        if (id == R.id.action_principal) {
            setActivity(c, Principal.class);
            return true;
        } else if (id == R.id.action_buscar) {
            setActivity(c, Buscar.class);
            return true;
        } else if (id == R.id.action_anadir) {
            setActivity(c, Anadir.class);
            return true;
        } else if (id == R.id.action_ver_todos) {
            setActivity(c, Todos.class);
            return true;
        }

        return false;
    }

    public static void setActivity(Activity c, Class c1) {
        Intent intent = new Intent(c, c1);
        c.startActivity(intent);

    }
}

