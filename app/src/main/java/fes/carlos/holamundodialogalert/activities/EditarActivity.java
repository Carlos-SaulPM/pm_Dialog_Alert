package fes.carlos.holamundodialogalert.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fes.carlos.holamundodialogalert.R;
import fes.carlos.holamundodialogalert.models.ProductoModel;
import fes.carlos.holamundodialogalert.services.ProductoService;

public class EditarActivity extends AppCompatActivity {
    ProductoService productoService = ProductoService.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();

        int productoId= bundle.getInt("ProductoId");
        ProductoModel productoModel = productoService.obtenerPorId(productoId);
        Toast.makeText(getBaseContext(),productoModel.getNombre(), Toast.LENGTH_SHORT).show();

    }
}