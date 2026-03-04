package fes.carlos.holamundodialogalert.services;

import java.util.ArrayList;
import java.util.List;

import fes.carlos.holamundodialogalert.models.ProductoModel;

public class ProductoService {
    public static ProductoService productoService;

    private List<ProductoModel> productos;

    private ProductoService() {
        productos = new ArrayList<>();
        productos.add(new ProductoModel(1, "Hawaiana", "La mas polular del condado"));
        productos.add(new ProductoModel(2, "Mexicana", "Un mexicano no se puede resistir a ella"));
    }


    public static ProductoService getInstance(){
        if(productoService == null){
            productoService = new ProductoService();
        }
        return productoService;
    }

    public List<ProductoModel> obtenerTodos(){
        return productos;
    }

    public ProductoModel obtenerPorId(int productoId){
        ProductoModel producto = null;

        for (ProductoModel productoModel: productos) {
            if(productoModel.getId() == productoId){
                producto = productoModel;
                break;
            }
        }

        return  producto;
    }

    public void borrar(int productoId){
        int position = 0;
        for (int i=0; i < productos.size(); i++){
            if(productoId == productos.get(i).getId()){
                position = i;
            }
        }

        productos.remove(productos.get(position));
    }


    public  int agregar(ProductoModel productoModel){
        int id = this.productos.size() + 1;
        productoModel.setId(id);
        productos.add(productoModel);

        return  id;
    }
}
