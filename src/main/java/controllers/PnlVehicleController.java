/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import backend.dao.implementation.JsonVehicleDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import pojo.Vehicle;
import pojo.VehicleSubModel;
import view.views.panel.PnlVehicle;

/**
 *
 * @author Usuario
 *///model,exteriorColor,interiorColor,status,year
public class PnlVehicleController {

    private DefaultComboBoxModel<String> cmbModelMake;
    private DefaultComboBoxModel<String> cmbModelModel;
    private DefaultComboBoxModel<String> cmbModelExteriorColor;
    private DefaultComboBoxModel<String> cmbModelInteriorColor;
    private DefaultComboBoxModel<String> cmbModelStatus;
    private String status[] = new String[]{"Active", "Mantainace", "Not available"};
    private PnlVehicle pnlVehicle;
    private JsonVehicleDaoImpl jvdao;
    private List<VehicleSubModel> vSubModels;
    private Gson gson;

    public PnlVehicleController(PnlVehicle pnlVehicle) throws FileNotFoundException {
        this.pnlVehicle = this.pnlVehicle;
    }

    private void initComponent() throws FileNotFoundException {
        jvdao = new JsonVehicleDaoImpl();
        gson = new Gson();

        JsonReader jreader = new JsonReader(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/json/VehicleData.json"))));

        Type listType = new TypeToken<ArrayList<VehicleSubModel>>() {
        }.getType();

        vSubModels = gson.fromJson(jreader, listType); //model,exteriorColor,interiorColor,status,year
        List<String> makes = vSubModels.stream().map(v -> v.getMake()).collect(Collectors.toList());
        List<String> models = vSubModels.stream().map(v -> v.getModel()).collect(Collectors.toList());
        List<String> exteriorColor = vSubModels.stream().map(v -> v.getColor()).collect(Collectors.toList());
        List<String> interiorColor = vSubModels.stream().map(v -> v.getColor()).collect(Collectors.toList());
        List<String> status = vSubModels.stream().map(v -> v.getStatus()).collect(Collectors.toList());
        List<String> year = vSubModels.stream().map(v -> v.getYear()).collect(Collectors.toList());

        cmbModelMake = new DefaultComboBoxModel(makes.toArray());
        cmbModelModel = new DefaultComboBoxModel(models.toArray());
        cmbModelExteriorColor = new DefaultComboBoxModel(exteriorColor.toArray());
        cmbModelInteriorColor = new DefaultComboBoxModel(interiorColor.toArray());
        cmbModelStatus = new DefaultComboBoxModel(this.status);

        pnlVehicle.getCmbMake().setModel(cmbModelMake);
        pnlVehicle.getCmbModel().setModel(cmbModelModel);
        pnlVehicle.getCmbExteriorColor().setModel(cmbModelExteriorColor);
        pnlVehicle.getCmbInteriorColor().setModel(cmbModelInteriorColor);
        pnlVehicle.getCmbStatus().setModel(cmbModelStatus);

        pnlVehicle.getBtnSave().addActionListener((actionEvent) -> {
            btnSaveActionListener(actionEvent);
        });

    }

    private void btnSaveActionListener(ActionEvent e) {
        int stock, year;
        String make, model, style, vin, exteriorColor, interiorColor, engine, image, status;
        float price;
        Vehicle.Transmission transmission;

//            stock = Integer.parseInt(pnlVehicle.getTxtStockNumber.getText());
//            year = Integer.parseInt(pnlVehicle.getYear.getText());
//        Vehicle v = new Vehicle(stock,year,make,model,style,vin,exteriorColor,interiorColor,engine,image,status);

//        pnlVehicle.getBtnBrowser().addActionListener(((e) -> {
//        }));
    }
    
//    private void btnSaveActionListener(ActionEvent e){
//        filechooser = new JFileChooser();
//    }
}
